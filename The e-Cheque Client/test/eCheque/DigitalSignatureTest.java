package eCheque;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;

public class DigitalSignatureTest {
	@Test
	public void signatureSuccessTest()
	{
		KeyPair keyp = null;
		try {
			keyp = new RSAGenerator().GenerateRSAKeys();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		DigitalSignature ds = new DigitalSignature();
		byte[] crypt = null;
		try {
			crypt = ds.signature("Hello World", keyp.getPrivate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull("Crypt is null",crypt);
		
		boolean result=false;
		try {
			result = ds.verifySignature(crypt, "Hello World", keyp.getPublic());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue("Result is not true",result);
	}
	
	@Test
	public void verifySignatureFailTest()
	{
		KeyPair keyp = null;
		try {
			keyp = RSAGenerator.GenerateRSAKeys();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		DigitalSignature ds = new DigitalSignature();
		byte[] crypt = null;
		try {
			crypt = ds.signature("Hello", keyp.getPrivate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull("Crypt is null",crypt);
		
		boolean result=false;
		try {
			result = ds.verifySignature(crypt, "Hello World", keyp.getPublic());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertFalse("Result is true",result);
	}
}
