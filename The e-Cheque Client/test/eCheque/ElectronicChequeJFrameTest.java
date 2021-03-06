/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eCheque;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author morgan
 */
public class ElectronicChequeJFrameTest extends ReflectClass {

    public ElectronicChequeJFrameTest() {
        setDefaultClass(ElectronicChequeJFrame.class);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInitNoConf() {
    }

    @Test
    public void testNoLoadUserInfo() {
        boolean configexisted = false;
        File conf = new File("Config.epc");
        File conftesting = new File("Config.testing.epc");
        if(conf.exists() == true) {
            conf.renameTo(conftesting);
            configexisted = true;
        }
        ElectronicChequeJFrame frame = new ElectronicChequeJFrame();
        setDefaultObject(frame);
        try {
//            runMethod(getMethod(c, "loadUserInfo"), frame);

            assertFalse("Password field should not be enabled.",
                    ((JPasswordField) getAttrDef("jTPassword")).isEnabled());

            assertFalse("Username field should not be enabled.",
                    ((JTextField) getAttrDef("jTUserName")).isEnabled());

            assertFalse("Login Button should not be enabled.",
                    ((JButton) getAttrDef("jBActivation")).isEnabled());

            assertTrue("Configure button should be enabled.",
                    ((JButton) getAttrDef("jBConfigure")).isEnabled());

            assertFalse("Send Cheque button should not be enabled.",
                    ((JButton) getAttrDef("jBSendCheque")).isEnabled());

            assertFalse("E-Banking button should not be enabled.",
                    ((JButton) getAttrDef("jBEBanking")).isEnabled());

            assertFalse("Received Cheque button should not be enabled.",
                    ((JButton) getAttrDef("jBReceivedCheque")).isEnabled());

            assertFalse("Draw Cheque button should not be enabled.",
                    ((JButton) getAttrDef("jBDrawCheque")).isEnabled());

            assertNull("Registration information should not be null.",
                    getAttrDef("registeredUser"));

            assertFalse("ActivationNeed should be true.",
                    (Boolean) getAttrDef("isActivated"));

        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (IllegalAccessException e) {
            fail(e.getLocalizedMessage());
        } finally {
            if (configexisted && conftesting.exists()) {
                conftesting.renameTo(conf);
            }
        }

    }

    @Test
    public void testLoadUserInfo() {
        if (new File("Config.epc").exists() == false) {
            fail("Please register a user and re-run this test");
        }
        ElectronicChequeJFrame frame = new ElectronicChequeJFrame();
        setDefaultObject(frame);
        try {
//            runMethod(getMethod(c, "loadUserInfo"), frame);

            assertTrue("Password field should be enabled.",
                    ((JPasswordField) getAttrDef("jTPassword")).isEnabled());

            assertTrue("Username field should not enabled.",
                    ((JTextField) getAttrDef("jTUserName")).isEnabled());

            assertTrue("Login Button should be enabled.",
                    ((JButton) getAttrDef("jBActivation")).isEnabled());

            assertFalse("Configure button should not be enabled.",
                    ((JButton) getAttrDef("jBConfigure")).isEnabled());

            assertFalse("Send Cheque button should not be enabled.",
                    ((JButton) getAttrDef("jBSendCheque")).isEnabled());

            assertFalse("E-Banking button should not be enabled.",
                    ((JButton) getAttrDef("jBEBanking")).isEnabled());

            assertFalse("Received Cheque button should not be enabled.",
                    ((JButton) getAttrDef("jBReceivedCheque")).isEnabled());

            assertFalse("Draw Cheque button should not be enabled.",
                    ((JButton) getAttrDef("jBDrawCheque")).isEnabled());

            assertNotNull("Registration information should not be null.",
                    getAttrDef("registeredUser"));

            assertFalse("ActivationNeed should be false.",
                    (Boolean) getAttrDef("isActivated"));

        } catch (NoSuchFieldException e) {
            fail("Field not found: " + e.getMessage());
        } catch (IllegalAccessException e) {
            fail(e.getLocalizedMessage());
        }
    }

    /**
     * Test of main method, of class ElectronicChequeJFrame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ElectronicChequeJFrame.main(args);
    }
}
