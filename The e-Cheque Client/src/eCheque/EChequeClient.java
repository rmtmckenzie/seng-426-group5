/*
 * EchequeClient.java
 *
 * Created on April 27, 2007, 8:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author SAAD
 */
package eCheque;

import java.net.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class EChequeClient implements Runnable {

	public static final int MODE_REGISTER = 0;
	public static final int MODE_DEPOSIT = 1;
	public static final int MODE_CANCEL = 2;
	/**
	 * Creates a new instance of EchequeClient
	 */
	private volatile boolean registrationState;
	private Socket ClientConnection;
	private ObjectInputStream SocketInputObject;
	private ObjectOutputStream SocketOutputObject;
	private InputStream SocketInput;
	private OutputStream SocketOutput;
	private DigitalCertificate clientCerit;
	private EChequeRegistration registrationData;
	private ECheque depositCheque;
	private JTextArea screenShell;
	private Key sessionKey;
	private String chequePath;
	private String hostname;
	private int portID;
	private int bankMode;
	private boolean getServerConnection;
	private boolean getSocketConnection;
	private boolean bankConnection;

	public EChequeClient(JTextArea screen, DigitalCertificate DC, Key aesKey, String wPath, String cPath, String host, int port) {
		screenShell = screen;
		clientCerit = DC;
		sessionKey = aesKey;
		chequePath = cPath;
		hostname = host;
		portID = port;
		getServerConnection = false;
		getSocketConnection = false;
		bankConnection = false;
	}

	public EChequeClient(int port, int mode, String host, EChequeRegistration register, DigitalCertificate DC) {
		portID = port;
		bankMode = mode;
		hostname = host;
		registrationData = register;
		clientCerit = DC;
		bankConnection = true;
	}

	public EChequeClient(int port, int mode, String host, EChequeRegistration register, ECheque chq) {
		portID = port;
		bankMode = mode;
		hostname = host;
		registrationData = register;
		depositCheque = chq;
		bankConnection = true;
	}

	private void connectToClient() throws Exception {
		ClientConnection = new Socket(InetAddress.getByName(hostname), portID);
		getServerConnection = true;
	}

	private void getSocketStream() throws Exception {
		SocketInput = ClientConnection.getInputStream();
		SocketOutput = ClientConnection.getOutputStream();
		SocketOutput.flush();
		SocketInputObject = new ObjectInputStream(ClientConnection.getInputStream());
		SocketOutputObject = new ObjectOutputStream(ClientConnection.getOutputStream());
		SocketOutputObject.flush();
		getServerConnection = true;
	}

	/**
	 * Process a connection between this client, and another client.
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidKeyException
	 */
	private void processConnection() throws IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
		DigitalCertificate certificate;

		//exchange the Digital Ceritificates
		SocketOutputObject.writeObject(clientCerit);
		SocketOutputObject.flush();

		certificate = (DigitalCertificate) SocketInputObject.readObject();
		//send session key
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.WRAP_MODE, certificate.getpublicKey());
		byte[] wrappedKey = cipher.wrap(sessionKey);

		SocketOutputObject.writeInt(wrappedKey.length);
		SocketOutputObject.flush();

		SocketOutput.write(wrappedKey);
		SocketOutput.flush();

		//send encrypted cheque.
		FileInputStream chequeOut = new FileInputStream(chequePath);
		byte[] buffer = new byte[1024];
		for (int numRead = 0; ((numRead = chequeOut.read(buffer)) >= 0); SocketOutput.write(buffer, 0, numRead)) {
			chequeOut.close();
		}
	}

	private void closeConnection() {
		try {
			if (getSocketConnection) {
				SocketInput.close();
				SocketOutput.close();
				SocketInputObject.close();
				SocketOutputObject.close();
			}
			if (getServerConnection) {
				ClientConnection.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Illegal close for communication channel", "Connection Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Process a connection between this client, and a bank server
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void processBankConnection() throws IOException, ClassNotFoundException {
		SocketOutputObject.writeObject("Hello");
		SocketOutputObject.flush();
		SocketOutputObject.writeInt(bankMode);
		SocketOutputObject.flush();

		if (bankMode == MODE_REGISTER) {
			SocketOutputObject.writeObject(registrationData);
			SocketOutputObject.flush();
			SocketOutputObject.writeObject(clientCerit);
			SocketOutputObject.flush();
			// save registration data.
			ObjectOutputStream outObj = new ObjectOutputStream(new FileOutputStream("Config.epc"));
			outObj.writeObject(registrationData);
			outObj.close();

			String confirm = (String) SocketInputObject.readObject();
			registrationState = confirm.equals("registration complete");
			if (registrationState == false) {
				// If the registration failed, then delete the config.epc file
				try {
					File file = new File("Config.epc");
					file.delete();
				} catch (Exception exp) {
					exp.printStackTrace();
				}
			}
			return;
		} else if (bankMode == MODE_DEPOSIT) {
			SocketOutputObject.writeObject(depositCheque);
			SocketOutputObject.flush();
			SocketOutputObject.writeObject(registrationData.getAccountNumber());
			SocketOutputObject.flush();
			JOptionPane.showMessageDialog(null, "Deposit information has been sent.");
		} else if (bankMode == MODE_CANCEL) {
			SocketOutputObject.writeObject(depositCheque);
			SocketOutputObject.flush();
		}

		String confirm = (String) SocketInputObject.readObject();
		JOptionPane.showMessageDialog(null, confirm);
	}

	public boolean getRegistrationState() {
		return registrationState;
	}

	private void runClient() {
		try {
			if (bankConnection) {
				connectToClient();
				getSocketStream();
				processBankConnection();
			} else {
				screenShell.append("\n\n>> Connecting to echeque host.");
				connectToClient();
				screenShell.append("\n\n>> You are connected.");
				getSocketStream();
				screenShell.append("\n\n>> Starting cheque transfer.");
				processConnection();
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			closeConnection();
		}
	}

	@Override
	public void run() {
		runClient();
		//System.exit(0);
	}
}