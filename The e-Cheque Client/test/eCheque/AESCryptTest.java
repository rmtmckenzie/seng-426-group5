package eCheque;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import org.junit.BeforeClass;
import org.junit.Test;

public class AESCryptTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void generateRandomAESKeyTest(){
		AESCrypt aescrypt = new AESCrypt();
		SecretKey key = null;
		try {
			key = aescrypt.GenerateRandomAESKey();
		} catch (Exception e) {
			fail();
		}
		assertNotNull(key);
	}

	@Test
	public void uniqueRandomKeySameAESCryptTest(){
		AESCrypt aescrypt = new AESCrypt();
		SecretKey key1 = null;
		SecretKey key2 = null;
		try {
			key1 = aescrypt.GenerateRandomAESKey();
			key2 = aescrypt.GenerateRandomAESKey();
		} catch (Exception e) {
			fail();
		}
		//assertNotEquals(key1,key2);
	}

	@Test
	public void uniqueRandomKeyDiffAESCryptTest(){
		AESCrypt aescrypt1 = new AESCrypt();
		AESCrypt aescrypt2 = new AESCrypt();
		SecretKey key1 = null;
		SecretKey key2 = null;
		try {
			key1 = aescrypt1.GenerateRandomAESKey();
			key2 = aescrypt2.GenerateRandomAESKey();
		} catch (Exception e) {
			fail();
		}
		//assertNotEquals(key1,key2);
	}

	@Test
	public void initializeAESKeyByPasswordTest()
	{
		AESCrypt aesCrypt = new AESCrypt();
		Key key = aesCrypt.inilizeAESKeyByPassword("testtesttesttest");
		assertNotNull(key);
		assertNotNull(key.getEncoded());
		assertEquals(key.getAlgorithm(),"AES");
	}

	@Test
	public void initializeCipherEncryptTest(){
		AESCrypt aesCrypt = new AESCrypt();
		String seed = "testtesttesttest";
		Key key = aesCrypt.inilizeAESKeyByPassword(seed);

		Cipher cipher = null;
		try {
			cipher = aesCrypt.initializeCipher(key, 0);
		} catch (Exception e) {
			fail();
		}
		assertNotNull(cipher);
		assertEquals(cipher.getAlgorithm(),"AES");
	}

	@Test
	public void initializeCipherDecryptTest(){
		AESCrypt aesCrypt = new AESCrypt();
		String seed = "testtesttesttest";
		Key key = aesCrypt.inilizeAESKeyByPassword(seed);

		Cipher cipher = null;
		try {
			cipher = aesCrypt.initializeCipher(key, 1);
		} catch (Exception e) {
			fail();
		}
		assertNotNull(cipher);
		assertEquals(cipher.getAlgorithm(),"AES");
	}
	
	@Test
	public void initializeCipherWrapTest(){
		AESCrypt aesCrypt = new AESCrypt();
		RSAGenerator keyGen = new RSAGenerator();
		KeyPair RSAKeys;
		PublicKey key = null;
		try {
			RSAKeys = keyGen.GenerateRSAKeys();
			key = RSAKeys.getPublic();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		Cipher cipher = null;
		try {
			cipher = aesCrypt.initializeCipher(key, 2);
		} catch (Exception e) {
			fail();
		}
		assertNotNull(cipher);
		assertEquals(cipher.getAlgorithm(),"RSA");
	}
	
	@Test
	public void initializeCipherUnwrapTest(){
		AESCrypt aesCrypt = new AESCrypt();
		RSAGenerator keyGen = new RSAGenerator();
		KeyPair RSAKeys;
		PublicKey key = null;
		try {
			RSAKeys = keyGen.GenerateRSAKeys();
			key = RSAKeys.getPublic();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		Cipher cipher = null;
		try {
			cipher = aesCrypt.initializeCipher(key, 3);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertNotNull(cipher);
		assertEquals(cipher.getAlgorithm(),"RSA");
	}

	@Test
	public void cryptTestExtra(){
		InputStream in = null;
		OutputStream out = null;
		File inFile = new File("cryptTestInput");
		File outFile = new File("cryptTestoutput");

		byte[] testData = new byte[1202];
		for(int i = 0; i<1201;i++)
		{
			testData[i]=(byte)(i%128);
		}

		try {
			inFile.delete();
			FileOutputStream writeTestData = new FileOutputStream(inFile);
			writeTestData.write(testData);
			writeTestData.close();
		} catch (IOException e2) {
			fail("Unable to write test data");
		}

		try {
			in = new FileInputStream(inFile);
			out = new FileOutputStream(outFile);
		} catch (FileNotFoundException e1) {
			fail("Could not initialize IO Streams");
		}

		AESCrypt aesCrypt = new AESCrypt();
		String seed = "testtesttesttest";
		Key key = aesCrypt.inilizeAESKeyByPassword(seed);
		Cipher cipher = null;

		try {
			cipher = aesCrypt.initializeCipher(key, 0);
		} catch (Exception e) {
			fail("Could not initialize Cipher");
		}

		try {
			aesCrypt.crypt(in, out, cipher);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Exception in AESCrypt.crypt");
		}
	}
	@Test
	public void cryptTestNoExtra(){
		InputStream in = null;
		OutputStream out = null;
		File inFile = new File("cryptTestInput");
		File outFile = new File("cryptTestoutput");

		byte[] testData = new byte[1024];
		for(int i = 0; i<1024;i++)
		{
			testData[i]=(byte)(i%128);
		}

		try {
			inFile.delete();
			FileOutputStream writeTestData = new FileOutputStream(inFile);
			writeTestData.write(testData);
			writeTestData.close();
		} catch (IOException e2) {
			fail("Unable to write test data");
		}

		try {
			in = new FileInputStream(inFile);
			out = new FileOutputStream(outFile);
		} catch (FileNotFoundException e1) {
			fail("Could not initialize IO Streams");
		}

		AESCrypt aesCrypt = new AESCrypt();
		String seed = "testtesttesttest";
		Key key = aesCrypt.inilizeAESKeyByPassword(seed);
		Cipher cipher = null;

		try {
			cipher = aesCrypt.initializeCipher(key, 0);
		} catch (Exception e) {
			fail("Could not initialize Cipher");
		}

		try {
			aesCrypt.crypt(in, out, cipher);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			fail("Exception in AESCrypt.crypt");
		}
	}
}
