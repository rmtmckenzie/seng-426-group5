/**
 * 
 */
package eCheque;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ubunteus
 *
 */
public class EChequeTest {

	// The class instance and the variables to be used on every test
	static ECheque eCheque;

	final String nullString = null;
	final String emptyString = "";
	final String somethingString = "Just Whatever";

	final byte[] nullByte = null;
	final byte[] zeroByte = {0x00};
	final byte[] maxByte = {0x7f};
	final byte[] zeroAndMaxBytes = {0x00, 0x7f};
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		eCheque = new ECheque();
	}

	/**
	 * Test method for {@link eCheque.ECheque#ECheque()}.
	 */
	@Test
	public void testECheque() {
		assertNotNull(eCheque);
	}

	/**
	 * Test method for {@link eCheque.ECheque#getAccountHolder()}.
	 * Test method for {@link eCheque.ECheque#setAccountHolder(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetaccountholder() {
		assertNull(eCheque.getAccountHolder());
		
		eCheque.setAccountHolder(emptyString);
		assertEquals(emptyString, eCheque.getAccountHolder());

		eCheque.setAccountHolder(somethingString);
		assertEquals(somethingString, eCheque.getAccountHolder());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getAccountNumber()}.
	 * Test method for {@link eCheque.ECheque#setAccountNumber(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetaccountNumber() {
		assertNull(eCheque.getAccountNumber());
		
		eCheque.setAccountNumber(emptyString);
		assertEquals(emptyString, eCheque.getAccountNumber());

		eCheque.setAccountNumber(somethingString);
		assertEquals(somethingString, eCheque.getAccountNumber());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getBankName()}.
	 * Test method for {@link eCheque.ECheque#setBankName(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetbankname() {
		assertNull(eCheque.getBankName());
		
		eCheque.setBankName(emptyString);
		assertEquals(emptyString, eCheque.getBankName());

		eCheque.setBankName(somethingString);
		assertEquals(somethingString, eCheque.getBankName());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getPayToOrderOf()}.
	 * Test method for {@link eCheque.ECheque#setPayToOrderOf(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetpayToOrderOf() {
		assertNull(eCheque.getPayToOrderOf());
		
		eCheque.setPayToOrderOf(emptyString);
		assertEquals(emptyString, eCheque.getPayToOrderOf());

		eCheque.setPayToOrderOf(somethingString);
		assertEquals(somethingString, eCheque.getPayToOrderOf());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getMoney()}.
	 * Test method for {@link eCheque.ECheque#setAmountOfMony(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetamountofMony() {
		assertNull(eCheque.getMoney());
		
		eCheque.setAmountOfMony(emptyString);
		assertEquals(emptyString, eCheque.getMoney());

		eCheque.setAmountOfMony(somethingString);
		assertEquals(somethingString, eCheque.getMoney());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getCurrencyType()}.
	 * Test method for {@link eCheque.ECheque#setCurrencyType(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetcurrencytype() {
		assertNull(eCheque.getCurrencyType());
		
		eCheque.setCurrencyType(emptyString);
		assertEquals(emptyString, eCheque.getCurrencyType());

		eCheque.setCurrencyType(somethingString);
		assertEquals(somethingString, eCheque.getCurrencyType());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getChequeNumber()}.
	 * Test method for {@link eCheque.ECheque#setChequeNumber(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetchequeNumber() {
		assertNull(eCheque.getChequeNumber());
		
		eCheque.setChequeNumber(emptyString);
		assertEquals(emptyString, eCheque.getChequeNumber());

		eCheque.setChequeNumber(somethingString);
		assertEquals(somethingString, eCheque.getChequeNumber());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getGuaranteed()}.
	 * Test method for {@link eCheque.ECheque#setGuaranteed(boolean)}.
	 */
	@Test
	public void testGetAndSetguaranteed() {
		assertFalse(eCheque.getGuaranteed());
		
		eCheque.setGuaranteed(false);
		assertEquals(false, eCheque.getGuaranteed());

		eCheque.setGuaranteed(true);
		assertEquals(true, eCheque.getGuaranteed());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getEarnday()}.
	 * Test method for {@link eCheque.ECheque#setEarnday(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetearnday() {
		assertNull(eCheque.getEarnday());
		
		eCheque.setEarnday(emptyString);
		assertEquals(emptyString, eCheque.getEarnday());

		eCheque.setEarnday(somethingString);
		assertEquals(somethingString, eCheque.getEarnday());
	}


	/**
	 * Test method for {@link eCheque.ECheque#getDrawerSignature()}.
	 * Test method for {@link eCheque.ECheque#setDrawerSignature(byte[])}.
	 */
	@Test
	public void testGetAndSetdrawersiganure() {
		assertNull(eCheque.getDrawerSignature());
		
		eCheque.setDrawerSignature(nullByte);
		assertArrayEquals(nullByte, eCheque.getDrawerSignature());

		eCheque.setDrawerSignature(zeroByte);
		assertArrayEquals(zeroByte, eCheque.getDrawerSignature());
		
		eCheque.setDrawerSignature(maxByte);
		assertArrayEquals(maxByte, eCheque.getDrawerSignature());

		eCheque.setDrawerSignature(zeroAndMaxBytes);
		assertArrayEquals(zeroAndMaxBytes, eCheque.getDrawerSignature());
	}
}
