/*
 * RSAGenerator.java
 *
 * Created on March 28, 2007, 4:44 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author SaaD
 */
package eCheque;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

// This class generates PKI keys using Rsa with key size 1024
public class RSAGenerator {

	/**
	 * Creates a new instance of RSAGenerator
	 */
	public RSAGenerator() {
	}

	// Generate RSA keys
	public static KeyPair GenerateRSAKeys() throws NoSuchAlgorithmException {
		SecureRandom SecRandom = new SecureRandom();
		KeyPairGenerator KeyGenerator = KeyPairGenerator.getInstance("RSA");
		KeyGenerator.initialize(1024, SecRandom);
		return KeyGenerator.generateKeyPair();
	}
}
