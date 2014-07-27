/*
 * certificate.java
 *
 * Created on March 28, 2007, 3:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author Abu^S3ooD
 */
package eCheque;

import java.io.*;
import java.security.PublicKey;

// This class holds digital certificate data and file operations
public class DigitalCertificate implements Serializable {

	private String holderName;
	private String subject;
	private String issuer;
	private String serialNumber;
	private String validFrom;
	private String validTo;
	private PublicKey publicKey;
	private byte[] issuerSignature;

	/**
	 * Creates a new instance of certificate
	 */
	public DigitalCertificate() {
	}

	// Save a digital certificate to a file
	public void SaveDigitalCertificate(String filePath) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
		out.writeObject(this);
		out.close();
	}
}
