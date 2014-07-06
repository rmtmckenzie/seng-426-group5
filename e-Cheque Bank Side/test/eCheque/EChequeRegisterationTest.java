/**
 * 
 */
package eCheque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ubunteus
 *
 */
public class EChequeRegisterationTest {

	static EChequeRegisteration eChequeRegisteration;

	final String nullString = null;
	final String emptyString = "";
	final String somethingString = "Just Whatever";

	final int zeroInteger = 0;
	final int minusOneInteger = -1;
	final int oneInteger = 1;
	final int maxInteger = 1073741824;
	final int minInteger = -1073741824;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		eChequeRegisteration = new EChequeRegisteration();
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#EChequeRegisteration()}.
	 */
	@Test
	public void testEChequeRegisteration() {
		assertNotNull(eChequeRegisteration);
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#getBankName()}.
	 * Test method for {@link eCheque.EChequeRegisteration#setBankName(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetBankName() {
		assertNull(eChequeRegisteration.getBankName());
		
		eChequeRegisteration.setBankName(emptyString);
		assertEquals(emptyString, eChequeRegisteration.getBankName());

		eChequeRegisteration.setBankName(somethingString);
		assertEquals(somethingString, eChequeRegisteration.getBankName());
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#getBankAddress()}.
	 * Test method for {@link eCheque.EChequeRegisteration#setBankAddress(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetBankAddress() {
		assertNull(eChequeRegisteration.getBankAddress());
		
		eChequeRegisteration.setBankAddress(emptyString);
		assertEquals(emptyString, eChequeRegisteration.getBankAddress());

		eChequeRegisteration.setBankAddress(somethingString);
		assertEquals(somethingString, eChequeRegisteration.getBankAddress());
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#getAccountNumber()}.
	 * Test method for {@link eCheque.EChequeRegisteration#setAccountNumber(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetAccountNumber() {
		assertNull(eChequeRegisteration.getAccountNumber());
		
		eChequeRegisteration.setAccountNumber(emptyString);
		assertEquals(emptyString, eChequeRegisteration.getAccountNumber());

		eChequeRegisteration.setAccountNumber(somethingString);
		assertEquals(somethingString, eChequeRegisteration.getAccountNumber());
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#getClientName()}.
	 * Test method for {@link eCheque.EChequeRegisteration#setClientName(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetClientName() {
		assertNull(eChequeRegisteration.getClientName());
		
		eChequeRegisteration.setClientName(emptyString);
		assertEquals(emptyString, eChequeRegisteration.getClientName());

		eChequeRegisteration.setClientName(somethingString);
		assertEquals(somethingString, eChequeRegisteration.getClientName());
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#getEWalletLoaction()}.
	 * Test method for {@link eCheque.EChequeRegisteration#setEWalletLoaction(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetEWalletLoaction() {
		assertNull(eChequeRegisteration.getEWalletLoaction());
		
		eChequeRegisteration.setEWalletLoaction(emptyString);
		assertEquals(emptyString, eChequeRegisteration.getEWalletLoaction());

		eChequeRegisteration.setEWalletLoaction(somethingString);
		assertEquals(somethingString, eChequeRegisteration.getEWalletLoaction());
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#getUsername()}.
	 * Test method for {@link eCheque.EChequeRegisteration#setUsername(int)}.
	 */
	@Test
	public void testGetAndSetUsername() {
		assertEquals(zeroInteger, eChequeRegisteration.getUsername());
		
		eChequeRegisteration.setUsername(zeroInteger);
		assertEquals(zeroInteger, eChequeRegisteration.getUsername());

		eChequeRegisteration.setUsername(minusOneInteger);
		assertEquals(minusOneInteger, eChequeRegisteration.getUsername());

		eChequeRegisteration.setUsername(oneInteger);
		assertEquals(oneInteger, eChequeRegisteration.getUsername());

		eChequeRegisteration.setUsername(maxInteger);
		assertEquals(maxInteger, eChequeRegisteration.getUsername());

		eChequeRegisteration.setUsername(minInteger);
		assertEquals(minInteger, eChequeRegisteration.getUsername());
	}

	/**
	 * Test method for {@link eCheque.EChequeRegisteration#getPasword()}.
	 * Test method for {@link eCheque.EChequeRegisteration#setPasword(int)}.
	 */
	@Test
	public void testGetAndSetPasword() {
		assertEquals(zeroInteger, eChequeRegisteration.getPasword());
		
		eChequeRegisteration.setPasword(zeroInteger);
		assertEquals(zeroInteger, eChequeRegisteration.getPasword());

		eChequeRegisteration.setPasword(minusOneInteger);
		assertEquals(minusOneInteger, eChequeRegisteration.getPasword());

		eChequeRegisteration.setPasword(oneInteger);
		assertEquals(oneInteger, eChequeRegisteration.getPasword());

		eChequeRegisteration.setPasword(maxInteger);
		assertEquals(maxInteger, eChequeRegisteration.getPasword());

		eChequeRegisteration.setPasword(minInteger);
		assertEquals(minInteger, eChequeRegisteration.getPasword());
	}
}
