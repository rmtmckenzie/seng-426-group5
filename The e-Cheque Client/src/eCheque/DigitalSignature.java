/*
 * DigitalSignature.java
 *
 * Created on March 28, 2007, 4:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Basel
 */

package eCheque;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignature {
	public DigitalSignature() {
	}

	// this function is used to sign cheque data by RSA algorithm
	public byte[] signature(String message, PrivateKey privKey) throws Exception {
		Signature signmessage = Signature.getInstance("SHA1withRSA");
		signmessage.initSign(privKey);
		signmessage.update(message.getBytes());
		byte[] signature = signmessage.sign();
		return signature;
	}

	// this function is used to verify the signature to cheque data by RSA algorithm
	public boolean verifySignature(byte[] messagesign, String message, PublicKey pubKey) throws Exception {
		Signature verifyMessage = Signature.getInstance("SHA1withRSA");
		verifyMessage.initVerify(pubKey);
		verifyMessage.update(message.getBytes());
		return (!verifyMessage.verify(messagesign));
	}
}
