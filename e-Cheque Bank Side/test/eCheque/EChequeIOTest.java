package eCheque;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class EChequeIOTest {

	static EChequeIO eChequeIO;
	static ECheque eChequeToSave;
	static String eChequeFileName;

	static String accountholderVariable	= "Account Holder String";
	static String accountNumberVariable	= "Account Number String";
	static String banknameVariable		= "Bank Name String";
	static String payToOrderOfVariable	= "Pay to Order of String";
	static String amountofMonyVariable	= "Ammount Of Money String";
	static String currencytypeVariable	= "Currency Type String";
	static String chequeNumberVariable	= "Cheque Number String";
	static boolean guaranteedVariable	= true;
	static String earndayVariable		= "Earn Day String";
	static byte[] banksignatureVariable	= {0x00, 0x7f};
	static byte[] drawersiganureVariable= {0x00, 0x7f};

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		eChequeIO = new EChequeIO();
		eChequeFileName = "fileName";

		eChequeToSave = new ECheque();

		eChequeToSave.setaccountholder(accountholderVariable);
		eChequeToSave.setaccountNumber(accountNumberVariable);
		eChequeToSave.setbankname(banknameVariable);
		eChequeToSave.setpayToOrderOf(payToOrderOfVariable);
		eChequeToSave.setamountofMony(amountofMonyVariable);
		eChequeToSave.setcurrencytype(currencytypeVariable);
		eChequeToSave.setchequeNumber(chequeNumberVariable);
		eChequeToSave.setguaranteed(guaranteedVariable);
		eChequeToSave.setearnday(earndayVariable);
		eChequeToSave.setbanksignature(banksignatureVariable);
		eChequeToSave.setdrawersiganure(drawersiganureVariable);
	}

	@Test
	public void testEChequeIO() {
		assertNotNull(eChequeIO);
	}

	@Test
	public void testSavecheque() throws IOException {
		eChequeIO.savecheque(eChequeToSave, eChequeFileName);
	}

	@Test
	public void testReadcheque() throws ClassNotFoundException, IOException {
		ECheque eChequeToLoad;
		eChequeToLoad = eChequeIO.readcheque(eChequeFileName);
		
		if(eChequeToLoad != null)
		{
			assertEquals(accountholderVariable, eChequeToLoad.getaccountholder());
			assertEquals(accountNumberVariable, eChequeToLoad.getaccountNumber());
			assertEquals(banknameVariable, eChequeToLoad.getbankname());
			assertEquals(payToOrderOfVariable, eChequeToLoad.getpayToOrderOf());
			assertEquals(amountofMonyVariable, eChequeToLoad.getMoney());
			assertEquals(currencytypeVariable, eChequeToLoad.getcurrencytype());
			assertEquals(chequeNumberVariable, eChequeToLoad.getchequeNumber());
			assertEquals(guaranteedVariable, eChequeToLoad.getguaranteed());
			assertEquals(earndayVariable, eChequeToLoad.getearnday());
			assertArrayEquals(banksignatureVariable, eChequeToLoad.getbanksignature());
			assertArrayEquals(drawersiganureVariable, eChequeToLoad.getdrawersiganure());
		}
	}

}
