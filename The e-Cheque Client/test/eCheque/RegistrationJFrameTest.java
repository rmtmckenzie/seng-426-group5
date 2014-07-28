package eCheque;

import java.util.concurrent.TimeUnit;

import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.timing.Timeout;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegistrationJFrameTest {

    private FrameFixture window;
    private Robot robot;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

	@Before
	public void setUp() throws Exception {
		robot = BasicRobot.robotWithNewAwtHierarchy();
		robot.settings().delayBetweenEvents(1);
		
	    window = new FrameFixture(robot, new RegistrationJFrame());
	    window.show();
	}

	@After
	public void tearDown() throws Exception {
	    window.cleanUp();
	}

	@Test
	public void testRegistrationComplete() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText(String.valueOf((int)(Math.floor(Math.random() * 100000))));
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Registration complete");
		window.optionPane().okButton().click();
	}

	@Test
	public void testMissingEWallet() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("You have to create your e-wallet");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingBankName() {

		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Bank Name can not be empty");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingBankURLIP() {
		window.textBox("jTBankName").enterText("ScotiaBank");

		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Bank URL or IP address can not be empty");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingClientName() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");

		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Client name can not be empty");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingAccountNumber() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");

		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Account number can not be empty");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingIssuerName() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");

		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Certificate issuer can not be empty");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingDigitalCertificateURLIP() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");

		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Certificate issuer URl or IP can not be empty");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingUserName() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");

		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("User name can not be empty");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingPassword() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");

		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Password cannot be empty ");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testMissingPassword2() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Passwords not match ");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testWrongBankName() {
		window.textBox("jTBankName").enterText("ScotiaBank1");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Bank Name cannot contain numbers");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testWrongBankURLIP() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localh0st");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Bank URL cannot contain letters");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testWrongClientName() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim 147");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Client Name cannot contain numbers");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testWrongAccountNumber() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123abc");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Account Number cannot contain letters");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testWrongIssuerName() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer 159");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Digital Certificate Issuer cannot contain numbers");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testWrongDigitalCertificateURLIP() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.o.o.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Certificate issuer URl or IP cannot contain letters");
		window.optionPane().okButton().click();
	}
	
	@Test
	public void testWrongUserName() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim123");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Client Name cannot contain numbers");
		window.optionPane().okButton().click();
	}
/*	
	@Test
	public void testWrongPassword() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Passw0rd");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("You have to create your e-wallet");
		window.optionPane().okButton().click();
	}
*/
	@Test
	public void testMissmatchPassword() {
		window.textBox("jTBankName").enterText("ScotiaBank");
		window.textBox("jTBankURLIP").enterText("localhost");
		window.textBox("jTClientName").enterText("Mateus Furquim");
		window.textBox("jTAccountNo").enterText("123");
		window.textBox("jTIssuerName").enterText("Issuer");
		window.textBox("jTDCURLIP").enterText("127.0.0.1");
		window.textBox("jTUserName").enterText("mfurquim");
		window.textBox("jTPassword").enterText("Passw0rd");
		window.textBox("jTPassword2").enterText("Password");
		
		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Passwords not match ");
		window.optionPane().okButton().click();
	}

    @Test
    public void testPasswordSmallerThanSeven() {
        window.textBox("jTBankName").enterText("ScotiaBank");
        window.textBox("jTBankURLIP").enterText("localhost");
        window.textBox("jTClientName").enterText("Mateus Furquim");
        window.textBox("jTAccountNo").enterText("123");
        window.textBox("jTIssuerName").enterText("Issuer");
        window.textBox("jTDCURLIP").enterText("127.0.0.1");
        window.textBox("jTUserName").enterText("mfurquim");
        window.textBox("jTPassword").enterText("123456");
        window.textBox("jTPassword2").enterText("123456");

		window.button("jBeWallet").click();
		window.fileChooser("fileChooser").approveButton().click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("E-Wallet already exists!\nDo you want to overwrite it?");
		window.optionPane().yesButton().click();

		window.button("jBRFRegister").click();
		window.optionPane(Timeout.timeout(10, TimeUnit.SECONDS)).requireMessage("Your password should be greater than 7 characters");
		window.optionPane().okButton().click();
	}
}
