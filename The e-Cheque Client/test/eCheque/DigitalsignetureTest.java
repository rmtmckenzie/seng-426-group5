package eCheque;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import org.junit.Test;

public class DigitalsignetureTest {
	@Test
	public void signetureSuccessTest()
	{
		KeyPair keyp = null;
		try {
			keyp = new RSAGenerator().GenerateRSAKeys();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		Digitalsigneture ds = new Digitalsigneture();
		byte[] crypt = null;
		try {
			crypt = ds.signeture("Hello World", keyp.getPrivate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(crypt);
		
		boolean result=false;
		try {
			result = ds.verifySignature(crypt, "Hello World", keyp.getPublic());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(result);
	}
	
	@Test
	public void verifySignatureFailTest()
	{
		KeyPair keyp = null;
		try {
			keyp = new RSAGenerator().GenerateRSAKeys();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		
		Digitalsigneture ds = new Digitalsigneture();
		byte[] crypt = null;
		try {
			crypt = ds.signeture("Hello", keyp.getPrivate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(crypt);
		
		boolean result=false;
		try {
			result = ds.verifySignature(crypt, "Hello World", keyp.getPublic());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(result);
	}
}
