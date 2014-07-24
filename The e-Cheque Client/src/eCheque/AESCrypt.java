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
        SecureRandom random = new SecureRandom();
        KeyGen.init(random);
        return KeyGen.generateKey();
    }

    // Initializes the cypher mode
    static public Cipher initializeCipher(Key key, eCheque.AESCrypt.cypherType mode) throws GeneralSecurityException {

        int CipherMode;

        // Get cipher mode
        if (mode == cypherType.ENCRYPT) {
            CipherMode = Cipher.ENCRYPT_MODE;
        } else if (mode == cypherType.DECRYPT) {
            CipherMode = Cipher.DECRYPT_MODE;
        } else if (mode == cypherType.WRAP) {
            CipherMode = Cipher.WRAP_MODE;
        } else if (mode == cypherType.UNWRAP) {
            CipherMode = Cipher.UNWRAP_MODE;
        } else {
            throw new IllegalArgumentException();
        }

        Cipher cipherObj;

        // Get type of encryption
        cipherObj = (((mode == cypherType.ENCRYPT) || (mode == cypherType.DECRYPT)) ? Cipher.getInstance("AES") : Cipher.getInstance("RSA"));

        // Init the object
        cipherObj.init(CipherMode, key);
        return cipherObj;
    }

    //  Encrypt or decrypt the inputstream based on the initialized cypher
    static public void crypt(InputStream in, OutputStream out, Cipher cipherObj) throws GeneralSecurityException, IOException {

        int blockSize = cipherObj.getBlockSize();
        int outputSize = cipherObj.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];
        int inLength = 0;
        boolean more = true;

        while (more) {
            inLength = in.read(inBytes);
            if (inLength == blockSize) {
                int outLength = cipherObj.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            } else {
                more = false;
            }
        }
        if (inLength > 0) {
            outBytes = cipherObj.doFinal(inBytes, 0, inLength);
        } else {
            outBytes = cipherObj.doFinal();
        }
        out.write(outBytes);
    }

    // Create a AES key from a password
    static public SecretKeySpec initializeAESKeyByPassword(String pass) {

        byte[] KeyData = pass.getBytes();
        SecretKeySpec aesKey;
        aesKey = new SecretKeySpec(KeyData, "AES");
        return aesKey;
    }

}
