package eCheque;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class EChequeIOTest {

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
		eChequeFileName = "fileName";

		eChequeToSave = new ECheque();

		eChequeToSave.setAccountHolder(accountholderVariable);
		eChequeToSave.setAccountNumber(accountNumberVariable);
		eChequeToSave.setBankName(banknameVariable);
		eChequeToSave.setPayToOrderOf(payToOrderOfVariable);
		eChequeToSave.setAmountOfMony(amountofMonyVariable);
		eChequeToSave.setCurrencyType(currencytypeVariable);
		eChequeToSave.setChequeNumber(chequeNumberVariable);
		eChequeToSave.setGuaranteed(guaranteedVariable);
		eChequeToSave.setEarnday(earndayVariable);
		eChequeToSave.setBankSignature(banksignatureVariable);
		eChequeToSave.setDrawerSignature(drawersiganureVariable);

		eChequeToSave.saveCheque(eChequeFileName);
	}

	@Test
	public void testSavecheque() throws IOException {
		eChequeToSave.saveCheque(eChequeFileName);
	}

	@Test
	public void testReadcheque() throws ClassNotFoundException, IOException {
		ECheque eChequeToLoad;
		eChequeToLoad = ECheque.readCheque(eChequeFileName);
		
		if(eChequeToLoad != null)
		{
			assertEquals(accountholderVariable, eChequeToLoad.getAccountHolder());
			assertEquals(accountNumberVariable, eChequeToLoad.getAccountNumber());
			assertEquals(banknameVariable, eChequeToLoad.getBankName());
			assertEquals(payToOrderOfVariable, eChequeToLoad.getPayToOrderOf());
			assertEquals(amountofMonyVariable, eChequeToLoad.getMoney());
			assertEquals(currencytypeVariable, eChequeToLoad.getCurrencyType());
			assertEquals(chequeNumberVariable, eChequeToLoad.getChequeNumber());
			assertEquals(guaranteedVariable, eChequeToLoad.getGuaranteed());
			assertEquals(earndayVariable, eChequeToLoad.getEarnday());
			assertArrayEquals(banksignatureVariable, eChequeToLoad.getBankSignature());
			assertArrayEquals(drawersiganureVariable, eChequeToLoad.getDrawerSignature());
		}
	}

}
