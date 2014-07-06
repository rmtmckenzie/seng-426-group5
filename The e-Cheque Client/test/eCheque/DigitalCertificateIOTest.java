package eCheque;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PublicKey;

import org.junit.BeforeClass;
import org.junit.Test;

public class DigitalCertificateIOTest {

	static DigitalCertificate instanceCert;
	static String filePath;
	static PublicKey key;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		byte[] bytea = {4,8,15,16,23,42};
		RSAGenerator keyGen = new RSAGenerator();
		KeyPair RSAKeys = keyGen.GenerateRSAKeys();
		
		key = RSAKeys.getPublic();
		instanceCert = new DigitalCertificate();
		filePath = new String("local.cer");
		instanceCert.setHolderName("holder");
		instanceCert.setSubject("subject");
		instanceCert.setIssuer("issuer");
		instanceCert.setValidFrom("validFrom");
		instanceCert.setSerialNumber("serial");
		instanceCert.setValidTo("validTo");
		instanceCert.setPublicKey(key);
		instanceCert.setIssuerSignature(bytea);
	}

	@Test
	public void saveDCWithoutErrorTest() {
		DigitalCertificateIO dcio = new DigitalCertificateIO();
		try {
			dcio.SaveDC(instanceCert, filePath);
		} catch (IOException e) {
			fail();
		}
		
		File f = new File(filePath);
		assertTrue(f.exists());
		
	}
	
	@Test
	public void readDigitalCertificateCertExistsTest() {
		DigitalCertificateIO dcio = new DigitalCertificateIO();
		DigitalCertificate localCert;
		try {
			dcio.SaveDC(instanceCert, filePath);
		} catch (IOException e) {
			fail("Error creating certificate");
		}
		
		try {
			localCert = dcio.readDigitalCertificate(filePath);
		} catch (ClassNotFoundException | IOException e) {
			fail();
			return;
		}
		
		assertEquals(localCert.getHolderName(), instanceCert.getHolderName());
		assertEquals(localCert.getSubject(), instanceCert.getSubject());
		assertEquals(localCert.getIssuer(), instanceCert.getIssuer());
		assertEquals(localCert.getValidFrom(), instanceCert.getValidFrom());
		assertEquals(localCert.getValidTo(), instanceCert.getValidTo());
		assertEquals(localCert.getSerialNumber(), instanceCert.getSerialNumber());
		assertEquals(localCert.getpublicKey(), instanceCert.getpublicKey());
		assertArrayEquals(localCert.getIssuerSignature(), instanceCert.getIssuerSignature());
	}
	
	@Test
	public void readNonExistantCertificateTest() {
		File f = new File(filePath);
		f.delete();
		
		DigitalCertificateIO dcio = new DigitalCertificateIO();
		try {
			dcio.readDigitalCertificate(filePath);
		} catch ( IOException e) {
			return;
		} catch (ClassNotFoundException e){
			fail();
			return;
		}
		fail();
		
	}

}
