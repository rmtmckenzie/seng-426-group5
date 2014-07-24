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

public class EChequeServer implements Runnable {

    /**
     * Creates a new instance of EChequeServer
     */
    private Socket ServerConnection;
    private ObjectInputStream socketInputObject;
    private ObjectOutputStream socketOutputObject;
    private InputStream socketInput;
    private OutputStream socketOutput;
    private final JTextArea screenShell;
    private final ServerSocket server;
    private final DigitalCertificate serverCertificate;
    private final PrivateKey privKey;
    private final String walletPath;

    public EChequeServer(JTextArea screen, DigitalCertificate DC, String wPath, PrivateKey privateKey, ServerSocket serverSocket) {
        screenShell = screen;
        serverCertificate = DC;
        walletPath = wPath;
        privKey = privateKey;
        server = serverSocket;
    }

    /**
     * Accept a connection from the server
     *
     * @throws IOException
     */
    private void acceptConnection() throws IOException {
        ServerConnection = server.accept();
    }

    /**
     * Get a socket stream and save to socket input and output objects
     *
     * @throws IOException
     */
    private void getSocketStream() throws IOException {
        socketOutput = ServerConnection.getOutputStream();
        socketOutput.flush();
        socketInput = ServerConnection.getInputStream();

        socketOutputObject = new ObjectOutputStream(ServerConnection.getOutputStream());
        socketOutputObject.flush();
        socketInputObject = new ObjectInputStream(ServerConnection.getInputStream());
    }

    /**
     * Do the processing on a connection which has been established. Gets a
     * socket key and decrypts using private key. Decrypts cheque using session
     * key.
     *
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws Exception
     */
    private void processConnection()
            throws Exception {
        //exchange digital certificates
        DigitalCertificate clientCertificate
                = (DigitalCertificate) socketInputObject.readObject();
        socketOutputObject.writeObject(serverCertificate);
        socketOutputObject.flush();

        //get the wrapped key and unwrap it
        //read the session key from the socket
        int keyLength = socketInputObject.readInt();
        byte[] wrappedKey = new byte[keyLength];

        //noinspection ResultOfMethodCallIgnored
        socketInput.read(wrappedKey);

        //decrypt the session key with the user private key.
        String chequeName = getChequeName();
        readCheque(chequeName);
        decryptCheque(getSessionKey(wrappedKey), chequeName);
        if (verifySignature(clientCertificate, chequeName)) {
            JOptionPane.showMessageDialog(
                    null, "The signature is valid", "e-Cheque Cleared",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null, "The signature is not valid", "e-Cheque not Cleared",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Performs the decryption of an encrypted session key.
     *
     * @param wrappedKey - an encrypted key
     * @return decrypted key
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    private Key getSessionKey(byte[] wrappedKey)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.UNWRAP_MODE, privKey);
        return cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);
    }

    /**
     * Verifies the signature on a cheque.
     *
     * @param clientCertificate
     * @param chequeName
     * @return
     * @throws Exception
     */
    private boolean verifySignature(DigitalCertificate clientCertificate, String chequeName) throws Exception {
        // verify the cheque signature using the sender public key.
        DigitalSignature digitalSign = new DigitalSignature();
        // load decrypted chequeObject.

        ECheque receivedCheque = ECheque.readCheque(
                walletPath + File.separator + "My Cheques"
                        + File.separator + chequeName + ".sec");
        return digitalSign.verifySignature(
                receivedCheque.getDrawerSignature(),
                receivedCheque.getReferenceString(),
                clientCertificate.getpublicKey());
    }

    private void decryptCheque(Key sessionKey, String chequeName)
            throws IOException, GeneralSecurityException {
        //try-with-resources - auto closes upon failure
        try (InputStream in = new FileInputStream(
                walletPath + File.separator + "In Coming"
                        + File.separator + chequeName + ".cry");
             OutputStream out = new FileOutputStream(
                     walletPath + File.separator + "My Cheques"
                             + File.separator + chequeName + ".sec")) {
            //Decrypt using AES
            Cipher aesCipher = AESCrypt.initializeCipher(sessionKey, AESCrypt.cypherType.DECRYPT);
            AESCrypt.crypt(in, out, aesCipher);
        }
    }

    private void readCheque(String chequeName) throws IOException {
        //read the cheque from the socket
        try (FileOutputStream chqIn = new FileOutputStream(
                walletPath + File.separator + "In Coming"
                        + File.separator + chequeName + ".cry")) {

            byte[] buffer = new byte[1024];
            int numRead;
            while ((numRead = socketInput.read(buffer)) >= 0) {
                chqIn.write(buffer, 0, numRead);
            }
        }
    }

    private String getChequeName() {
        Calendar currTime = new GregorianCalendar();
        return Integer.toString(currTime.get(GregorianCalendar.YEAR)) + Integer.toString(currTime.get(GregorianCalendar.MONTH)) + Integer.toString(currTime.get(GregorianCalendar.DAY_OF_MONTH)) + Integer.toString(currTime.get(GregorianCalendar.HOUR_OF_DAY)) + Integer.toString(currTime.get(GregorianCalendar.MILLISECOND));
    }

    private void closeConnection() {
        try {
            socketInput.close();
            socketOutput.close();
            socketInputObject.close();
            socketOutputObject.close();
            ServerConnection.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            screenShell.append("\n>>Status: Starting The Server");
            screenShell.append("\n>>Status: Waiting for connection");
            acceptConnection();
            screenShell.append("\n>>Status: Connection accepted");
            getSocketStream();
            screenShell.append("\n>>Status: Socket I/O complete");
            screenShell.append("\n>>Status: Processing started");
            processConnection();
            screenShell.append("\n>>Status: Process complete");
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            error.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
