package eCheque;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.security.PublicKey;

import org.junit.Test;

public class DigitalCertificateTest {

	@Test
	public void holderNameTest() {
		DigitalCertificate cert = new DigitalCertificate();
		String result = new String();
		cert.setHolderName(result);
		assertTrue(result == cert.getHolderName());
	}
	
	@Test
	public void subjectTest() {
		DigitalCertificate cert = new DigitalCertificate();
		String result = new String();
		cert.setSubject(result);
		assertTrue(result == cert.getSubject());
	}
	
	@Test
	public void issuerTest() {
		DigitalCertificate cert = new DigitalCertificate();
		String result = new String();
		cert.setIssuer(result);
		assertTrue(result == cert.getIssuer());
	}
	
	@Test
	public void serialNumberTest() {
		DigitalCertificate cert = new DigitalCertificate();
		String result = new String();
		cert.setSerialNumber(result);
		assertTrue(result == cert.getSerialNumber());
	}

	@Test
	public void validFromTest() {
		DigitalCertificate cert = new DigitalCertificate();
		String result = new String();
		cert.setValidFrom(result);
		assertTrue(result == cert.getValidFrom());
	}
	
	@Test
	public void validToTest() {
		DigitalCertificate cert = new DigitalCertificate();
		String result = new String();
		cert.setValidTo(result);
		assertTrue(result == cert.getValidTo());
	}
	
	@Test
	public void publicKeyTest() {
		try {
			DigitalCertificate cert = new DigitalCertificate();
			RSAGenerator keyGen = new RSAGenerator();
			KeyPair RSAKeys = keyGen.GenerateRSAKeys();
			PublicKey key = RSAKeys.getPublic();
			cert.setPublicKey(key);
			assertTrue(key == cert.getpublicKey());
		}catch (Exception e){
			fail();
		}
	}
	
	
	@Test
	public void issuerSignatureTest() {
		DigitalCertificate cert = new DigitalCertificate();
		byte[] barray = {4,8,15,16,23,42};
		
		cert.setIssuerSignature(barray);
		assertTrue(cert.getIssuerSignature().equals(barray));
	}
	
	
	
}
