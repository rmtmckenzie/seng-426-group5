/*
 * SecretKeyGenerateRandomAESKey.java
 *
 * Created on May 6, 2007, 2:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author SAAD
 */
package eCheque;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;

/**
 * Creates a new instance of AESCrypt
 */
public class AESCrypt {

    public enum cypherType {

        ENCRYPT,
        DECRYPT,
        WRAP,
        UNWRAP
    }

    // Returns a randomly generated secret key
    static public SecretKey GenerateRandomAESKey() throws Exception {
        KeyGenerator KeyGen = KeyGenerator.getInstance("AES");
        KeyGen.init(new SecureRandom());
        return KeyGen.generateKey();
    }

    // Initializes the cypher mode
    static public Cipher initializeCipher(Key key, eCheque.AESCrypt.cypherType mode) throws GeneralSecurityException {
        Cipher cipherObj = (((mode == cypherType.ENCRYPT) || (mode == cypherType.DECRYPT)) ? Cipher.getInstance("AES") : Cipher.getInstance("RSA"));
        cipherObj.init(getCipherMode(mode), key);
        return cipherObj;
    }

    private static int getCipherMode(cypherType mode) {
        switch (mode) {
            case ENCRYPT:
                return Cipher.ENCRYPT_MODE;
            case DECRYPT:
                return Cipher.DECRYPT_MODE;
            case WRAP:
                return Cipher.WRAP_MODE;
            case UNWRAP:
                return Cipher.UNWRAP_MODE;
            default:
                throw new IllegalArgumentException();
        }
    }

    //  Encrypt or decrypt the inputstream based on the initialized cypher
    static public void crypt(InputStream in, OutputStream out, Cipher cipherObj) throws GeneralSecurityException, IOException {
        int blockSize = cipherObj.getBlockSize();
        int outputSize = cipherObj.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];
        int inLength;
        boolean more;

        do {
            inLength = in.read(inBytes);
            more = inLength == blockSize;
            if (more) {
                int outLength = cipherObj.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            }
        } while (more);

        outBytes = inLength > 0 ? cipherObj.doFinal(inBytes, 0, inLength) : cipherObj.doFinal();
        out.write(outBytes);
    }

    static public String padPassword(String pass) {
        char password[] = pass.toCharArray();
        if (password.length == 0) {
            return "";
        }
        String strPassword = new String(password);
        for (int i = 0; i < 16 - password.length; i++) {
            strPassword += password[i];
        }
        if (strPassword.length() > 16) {
            return strPassword.substring(0, 16);
        }
        return strPassword;
    }

    // Create a AES key from a password
    static public SecretKeySpec initializeAESKeyByPassword(String pass) {
        return new SecretKeySpec(pass.getBytes(), "AES");
    }
}
