/*
 * EChequeServer.java
 *
 * Created on April 27, 2007, 8:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author Basel
 */
package eCheque;

//import com.sun.crypto.provider.AESCipher;
import java.net.*;
import java.io.*;

public class EChequeServer implements Runnable {

	/**
	 * Creates a new instance of EChequeServer
	 */
	public static final int MODE_REGISTER = 0;
	public static final int MODE_DEPOSIT = 1;
	public static final int MODE_CANCEL = 2;
	public static final String REGISTRATION_SUCCESS = "registration complete";
	public static final String REGISTRATION_FAILURE = "registration failed";
	private final Socket serverConnection;
	private ObjectInputStream socketInputObject;
	private ObjectOutputStream socketOutputObject;
	private InputStream socketInput;
	private OutputStream socketOutput;

	public EChequeServer(Socket socket) {
		serverConnection = socket;
	}

	/**
	 * Gets the input and output stream objects
	 *
	 * @throws IOException
	 */
	private void getSocketStream() throws IOException {
		socketOutput = serverConnection.getOutputStream();
		socketOutput.flush();
		socketInput = serverConnection.getInputStream();

		socketOutputObject = new ObjectOutputStream(serverConnection.getOutputStream());
		socketOutputObject.flush();
		socketInputObject = new ObjectInputStream(serverConnection.getInputStream());
	}

	/**
	 * Process an incoming connection
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void processConnection() throws IOException, ClassNotFoundException {
		int code;

		socketInputObject.readObject();
		code = socketInputObject.readInt();

		switch (code) {
			case MODE_REGISTER:
				registerClientInfo();
				break;
			case MODE_DEPOSIT:
				depositCheque();
				break;
			case MODE_CANCEL:
				cancelCheque();
		}
	}

	/**
	 * Perform the registration of a new user.
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void registerClientInfo() throws IOException, ClassNotFoundException {
		EChequeRegistration registerClient;
		registerClient = (EChequeRegistration) socketInputObject.readObject();

		DigitalCertificate registDC = (DigitalCertificate) socketInputObject.readObject();

		// starting database
		EChequeDB chqDB = new EChequeDB();

		if (chqDB.runUpdate("insert into accounts(accountID,clientName,dcPath,balance) values( ? , ? , ? , ? );",
				  registerClient.getAccountNumber(), registerClient.getClientName(),
				  registerClient.getClientName() + "DC.edc", 0)) {
			//store client digital certificate
			registDC.SaveDigitalCertificate("Bank" + File.separator + registerClient.getClientName() + "DC.edc");
			socketOutputObject.writeObject(REGISTRATION_SUCCESS);
			socketOutputObject.flush();
		} else {
			socketOutputObject.writeObject(REGISTRATION_FAILURE);
			socketOutputObject.flush();
		}

	}

	/**
	 * Perform the depositing of a cheque into a user's account.
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void depositCheque() throws IOException, ClassNotFoundException {

		String depositResult = "";
		//read cheque from socket
		ECheque receivedCheque = (ECheque) socketInputObject.readObject();
		//read deposit Account number.
		String depositAccount = (String) socketInputObject.readObject();

		//check the withdraw account. 
		EChequeDB chqDB = new EChequeDB();

		try {
			Double balance = (Double) chqDB.runReturnQuery(
					  "Select balance from accounts where accountID = ?;",
					  receivedCheque.getAccountNumber());

			double chequeMoney = Double.parseDouble(receivedCheque.getMoney());

			//check if sufficient balance
			if (chequeMoney > balance) {
				//report the deposit result
				depositResult = "Drawer's account balance is not sufficient.";
			} else if (chqDB.runQuery("Select * from cancelledCheque where accountID = ? and chequeID = ?;",
					  receivedCheque.getAccountNumber(), receivedCheque.getChequeNumber())) {
				//report the deposit result
				depositResult = "This cheque has been cancelled by the drawer.";
			} else if (chqDB.runQuery("Select * from eChequeOut where chequeID = ? and accountID = ?;",
					  receivedCheque.getChequeNumber(), receivedCheque.getAccountNumber())) {
				//report the deposit result
				depositResult = "This cheque has already been deposited.";
			} else {
				chqDB.runUpdate("Update accounts set balance = balance - ? where accountID = ?",
						  chequeMoney, receivedCheque.getAccountNumber());
				chqDB.runUpdate("Update accounts set balance = balance + ? where accountID = ?",
						  chequeMoney, depositAccount);

				chqDB.runUpdate("Insert into eChequeOut(chequeID, accountID, balance) values( ? , ? , ? );",
						  receivedCheque.getChequeNumber(), receivedCheque.getAccountNumber(), chequeMoney);

				chqDB.runUpdate("Insert into eChequeIn(chequeID, accountID, balance) values( ? , ? , ? );",
						  receivedCheque.getChequeNumber(), receivedCheque.getAccountNumber(), chequeMoney);

				//report the deposit result
				depositResult = "The cheque has been deposited in your account.\n"
						  + "Your balance was incremented by" + receivedCheque.getMoney();
			}

		} catch (ClassCastException e) {
			depositResult = "Error reading balance.";
		} finally {
			socketOutputObject.writeObject(depositResult);
			socketOutputObject.flush();
		}
	}

	/**
	 * Performs the cancelling of a cheque.
	 *
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void cancelCheque() throws IOException, ClassNotFoundException {
		ECheque receivedCheque = (ECheque) socketInputObject.readObject();
		EChequeDB chqDB = new EChequeDB();

		if (chqDB.runUpdate("insert into cancelledCheque (accountID,chequeID) values( ? , ? );",
				  receivedCheque.getAccountNumber(), receivedCheque.getChequeNumber())) {
			socketOutputObject.writeObject("The cheque has been cancelled.");
			socketOutputObject.flush();
		} else {
			socketOutputObject.writeObject("Error, cheque was not cancelled.");
			socketOutputObject.flush();
		}

	}

	/**
	 * Closes the connection.
	 */
	private void closeConnection() {
		try {
			socketInput.close();
			socketOutput.close();
			socketInputObject.close();
			socketOutputObject.close();
			serverConnection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			getSocketStream();
			processConnection();
		} catch (IOException error) {
			error.printStackTrace();
		} catch (ClassNotFoundException error) {
			error.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
