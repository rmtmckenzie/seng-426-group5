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
	 * Test method for {@link eCheque.ECheque#getaccountholder()}.
	 * Test method for {@link eCheque.ECheque#setaccountholder(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetaccountholder() {
		assertNull(eCheque.getaccountholder());
		
		eCheque.setaccountholder(emptyString);
		assertEquals(emptyString, eCheque.getaccountholder());

		eCheque.setaccountholder(somethingString);
		assertEquals(somethingString, eCheque.getaccountholder());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getaccountNumber()}.
	 * Test method for {@link eCheque.ECheque#setaccountNumber(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetaccountNumber() {
		assertNull(eCheque.getaccountNumber());
		
		eCheque.setaccountNumber(emptyString);
		assertEquals(emptyString, eCheque.getaccountNumber());

		eCheque.setaccountNumber(somethingString);
		assertEquals(somethingString, eCheque.getaccountNumber());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getbankname()}.
	 * Test method for {@link eCheque.ECheque#setbankname(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetbankname() {
		assertNull(eCheque.getbankname());
		
		eCheque.setbankname(emptyString);
		assertEquals(emptyString, eCheque.getbankname());

		eCheque.setbankname(somethingString);
		assertEquals(somethingString, eCheque.getbankname());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getpayToOrderOf()}.
	 * Test method for {@link eCheque.ECheque#setpayToOrderOf(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetpayToOrderOf() {
		assertNull(eCheque.getpayToOrderOf());
		
		eCheque.setpayToOrderOf(emptyString);
		assertEquals(emptyString, eCheque.getpayToOrderOf());

		eCheque.setpayToOrderOf(somethingString);
		assertEquals(somethingString, eCheque.getpayToOrderOf());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getMoney()}.
	 * Test method for {@link eCheque.ECheque#setamountofMony(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetamountofMony() {
		assertNull(eCheque.getMoney());
		
		eCheque.setamountofMony(emptyString);
		assertEquals(emptyString, eCheque.getMoney());

		eCheque.setamountofMony(somethingString);
		assertEquals(somethingString, eCheque.getMoney());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getcurrencytype()}.
	 * Test method for {@link eCheque.ECheque#setcurrencytype(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetcurrencytype() {
		assertNull(eCheque.getcurrencytype());
		
		eCheque.setcurrencytype(emptyString);
		assertEquals(emptyString, eCheque.getcurrencytype());

		eCheque.setcurrencytype(somethingString);
		assertEquals(somethingString, eCheque.getcurrencytype());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getchequeNumber()}.
	 * Test method for {@link eCheque.ECheque#setchequeNumber(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetchequeNumber() {
		assertNull(eCheque.getchequeNumber());
		
		eCheque.setchequeNumber(emptyString);
		assertEquals(emptyString, eCheque.getchequeNumber());

		eCheque.setchequeNumber(somethingString);
		assertEquals(somethingString, eCheque.getchequeNumber());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getguaranteed()}.
	 * Test method for {@link eCheque.ECheque#setguaranteed(boolean)}.
	 */
	@Test
	public void testGetAndSetguaranteed() {
		assertFalse(eCheque.getguaranteed());
		
		eCheque.setguaranteed(false);
		assertEquals(false, eCheque.getguaranteed());

		eCheque.setguaranteed(true);
		assertEquals(true, eCheque.getguaranteed());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getearnday()}.
	 * Test method for {@link eCheque.ECheque#setearnday(java.lang.String)}.
	 */
	@Test
	public void testGetAndSetearnday() {
		assertNull(eCheque.getearnday());
		
		eCheque.setearnday(emptyString);
		assertEquals(emptyString, eCheque.getearnday());

		eCheque.setearnday(somethingString);
		assertEquals(somethingString, eCheque.getearnday());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getbanksignature()}.
	 * Test method for {@link eCheque.ECheque#setbanksignature(byte[])}.
	 */
	@Test
	public void testGetAndSetbanksignature() {
		assertNull(eCheque.getbanksignature());
		
		eCheque.setbanksignature(nullByte);
		assertArrayEquals(nullByte, eCheque.getbanksignature());

		eCheque.setbanksignature(zeroByte);
		assertArrayEquals(zeroByte, eCheque.getbanksignature());
		
		eCheque.setbanksignature(maxByte);
		assertArrayEquals(maxByte, eCheque.getbanksignature());

		eCheque.setbanksignature(zeroAndMaxBytes);
		assertArrayEquals(zeroAndMaxBytes, eCheque.getbanksignature());
	}

	/**
	 * Test method for {@link eCheque.ECheque#getdrawersiganure()}.
	 * Test method for {@link eCheque.ECheque#setdrawersiganure(byte[])}.
	 */
	@Test
	public void testGetAndSetdrawersiganure() {
		assertNull(eCheque.getdrawersiganure());
		
		eCheque.setdrawersiganure(nullByte);
		assertArrayEquals(nullByte, eCheque.getdrawersiganure());

		eCheque.setdrawersiganure(zeroByte);
		assertArrayEquals(zeroByte, eCheque.getdrawersiganure());
		
		eCheque.setdrawersiganure(maxByte);
		assertArrayEquals(maxByte, eCheque.getdrawersiganure());

		eCheque.setdrawersiganure(zeroAndMaxBytes);
		assertArrayEquals(zeroAndMaxBytes, eCheque.getdrawersiganure());
	}
}
