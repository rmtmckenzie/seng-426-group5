/*
 * Echqueserver.java
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
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.crypto.Cipher;
import java.security.*;

public class EchequeServer implements Runnable {

    /**
     * Creates a new instance of EchequeServer
     */
    private ServerSocket server;
    private Socket ServerConnection;
    private ObjectInputStream socketInputObject;
    private ObjectOutputStream socketOutputObject;
    private InputStream socketInput;
    private OutputStream socketOutput;
    private JTextArea screenShell;
    private DigitalCertificate serverCertificate;
    private String walletPath;
    private PrivateKey privKey;

    public EchequeServer(JTextArea screen, DigitalCertificate DC, String wPath, PrivateKey privateKey, ServerSocket serverSocket) {
        screenShell = screen;
        serverCertificate = DC;
        walletPath = wPath;
        privKey = privateKey;
        server = serverSocket;
    }

    private void acceptConnection() throws IOException {
        ServerConnection = server.accept();
    }

    private void getSocketStream() throws Exception {
        socketOutput = ServerConnection.getOutputStream();
        socketOutput.flush();
        socketInput = ServerConnection.getInputStream();

        socketOutputObject = new ObjectOutputStream(ServerConnection.getOutputStream());
        socketOutputObject.flush();
        socketInputObject = new ObjectInputStream(ServerConnection.getInputStream());
    }

    private void processConnection() throws Exception {
        //exchange digital certificates
        DigitalCertificate clientCertificate = (DigitalCertificate) socketInputObject.readObject();
        socketOutputObject.writeObject(serverCertificate);
        socketOutputObject.flush();

        //get the wraped key and unwraped it
        //read the session key form the socket
        int keyLength = socketInputObject.readInt();
        byte[] wrappedKey = new byte[keyLength];

        //noinspection ResultOfMethodCallIgnored
        socketInput.read(wrappedKey);

        //decrypt the session key with the user private key.
        String chequeName = getChequeName();
        readCheque(chequeName);
        decryptCheque(getSessionKey(wrappedKey), chequeName);
        if (verifySignature(clientCertificate, chequeName))
            JOptionPane.showMessageDialog(null, "The signature is valid", "e-Cheque Cleared", JOptionPane.INFORMATION_MESSAGE);
        else {
            JOptionPane.showMessageDialog(null, "The signature is not valid", "e-Cheque not Cleared", JOptionPane.WARNING_MESSAGE);
        }
    }

    private Key getSessionKey(byte[] wrappedKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.UNWRAP_MODE, privKey);
        return cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);
    }

    private boolean verifySignature(DigitalCertificate clientCertificate, String chequeName) throws Exception {
        // verify the cheque signature using the sender public key.
        DigitalSignature digitalSign = new DigitalSignature();
        // load decrypted chequeObject.
        EChequeIO readChq = new EChequeIO();
        ECheque receivedCheque = readChq.readcheque(walletPath + File.separator +
                "My Cheques" + File.separator + chequeName + ".sec");
        return digitalSign.verifySignature(receivedCheque.getdrawersiganure(), chequeReferenceString(receivedCheque), clientCertificate.getpublicKey());
    }

    private void decryptCheque(Key sessionKey, String chequeName) throws Exception {
        InputStream in = new FileInputStream(walletPath + File.separator + "In Coming" + File.separator + chequeName + ".cry");
        OutputStream out = new FileOutputStream(walletPath + File.separator + "My Cheques" + File.separator + chequeName + ".sec");

        //create AES object to decrypt the received cheque
        AESCrypt aesObj = new AESCrypt();
        Cipher aesCipher = aesObj.initializeCipher(sessionKey, 1);
        aesObj.crypt(in, out, aesCipher);
        in.close();
        out.close();
    }

    private void readCheque(String chequeName) throws IOException {
        //read the cheque from the socket
        FileOutputStream chqIn = new FileOutputStream(walletPath + File.separator + "In Coming" + File.separator + chequeName + ".cry");
        byte[] buffer = new byte[1024];
        int numRead;
        while ((numRead = socketInput.read(buffer)) >= 0) chqIn.write(buffer, 0, numRead);
        chqIn.close();
    }

    private String getChequeName() {
        Calendar currTime = new GregorianCalendar();
        return Integer.toString(currTime.get(GregorianCalendar.YEAR))
                + Integer.toString(currTime.get(GregorianCalendar.MONTH))
                + Integer.toString(currTime.get(GregorianCalendar.DAY_OF_MONTH))
                + Integer.toString(currTime.get(GregorianCalendar.HOUR_OF_DAY))
                + Integer.toString(currTime.get(GregorianCalendar.MILLISECOND));
    }

    private void closeConnection() {
        try {
            socketInput.close();
            socketOutput.close();
            socketInputObject.close();
            socketOutputObject.close();
            ServerConnection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    private void runServer() {
        try {
            screenShell.append("\n>>Status: Starting The Server");
            screenShell.append("\n>>Status: Waiting for connection");
            acceptConnection();
            screenShell.append("\n>>Status: connection accepted");
            getSocketStream();
            screenShell.append("\n>>Status: Socket I/O complete");
            screenShell.append("\n>>Status: processing started");
            processConnection();
            screenShell.append("\n>>Status: process complete");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            error.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private String chequeReferenceString(ECheque chq) {
        return chq.getaccountNumber() + chq.getaccountholder() + chq.getbankname() + chq.getchequeNumber() +
                chq.getMoney() + chq.getcurrencytype() + chq.getearnday() + chq.getguaranteed() + chq.getpayToOrderOf();
    }

    public void run() {
        runServer();
    }
}