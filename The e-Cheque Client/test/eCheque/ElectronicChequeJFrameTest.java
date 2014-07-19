/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eCheque;

import java.lang.Void;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author morgan
 */
public class ElectronicChequeJFrameTest extends ReflectClass{
    
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
        ElectronicChequeJFrame frame = new ElectronicChequeJFrame();		  
        setDefaultObject(frame);
        try {
//            runMethod(getMethod(c, "loadUserInfo"), frame);
            
            assertFalse("Password field should not be enabled.", 
                    ((JPasswordField)getAttrDef("jTPassword")).isEnabled());
            
            assertFalse("Username field should not be enabled.", 
                    ((JTextField)getAttrDef("jTUserName")).isEnabled());
                        
            assertFalse("Login Button should not be enabled.",
                    ((JButton)getAttrDef("jBActivation")).isEnabled());
            
            assertTrue("Configure button should be enabled.",
                    ((JButton)getAttrDef("jBConfigure")).isEnabled());
            
            assertFalse("Send Cheque button should not be enabled.",
                    ((JButton)getAttrDef("jBSendCheque")).isEnabled());
            
            assertFalse("E-Banking button should not be enabled.",
                    ((JButton)getAttrDef("jBEBanking")).isEnabled());
            
            assertFalse("Received Cheque button should not be enabled.",
                    ((JButton)getAttrDef("jBReceivedCheque")).isEnabled());
            
            assertFalse("Draw Cheque button should not be enabled.",
                    ((JButton)getAttrDef("jBDrawCheque")).isEnabled());
            
            assertNull("Registration information should not be null.",
                    getAttrDef("registeredUser"));
            
            assertFalse("ActivationNeed should be true.", 
                    (Boolean)getAttrDef("isActivated"));

        } catch (NoSuchFieldException e) {
            fail("Field not found: "+e.getMessage());
        } catch (IllegalAccessException e) {
            fail(e.getLocalizedMessage());
        }

    }
    
    @Test
    public void testLoadUserInfo() {
        ElectronicChequeJFrame frame = new ElectronicChequeJFrame();
        Class c = ElectronicChequeJFrame.class;
        Field f;
        
        try {
            Method method = c.getDeclaredMethod("loadUserInfo");				
            method.setAccessible(true);
            method.invoke(frame);
            
            f = c.getDeclaredField("registeredUser");
            f.setAccessible(true);
            EChequeRegistration reg = (EChequeRegistration) f.get(frame);
            assertNotNull("Registration information should not be null.",reg);
            
            f = c.getDeclaredField("jBActivation");
            f.setAccessible(true);
            JButton b = (JButton) f.get(frame);
            assertTrue("Login Button should be enabled", b.isEnabled()); 
            
            f = c.getDeclaredField("jTPassword");
            f.setAccessible(true);
            JPasswordField pf = (JPasswordField) f.get(frame);
            assertTrue("ePassword field should be enabled", pf.isEnabled());
            
            f = c.getDeclaredField("jTUserName");
            f.setAccessible(true);
            JTextField un = (JTextField) f.get(frame);
            assertTrue("Username field should be enabled", un.isEnabled());
            
            f = c.getDeclaredField("jBConfigure");
            f.setAccessible(true);
            b = (JButton) f.get(frame);
            assertFalse("Configure button should not be enabled", b.isEnabled());
                    
            f = c.getDeclaredField("isActivated");
            f.setAccessible(false);
            boolean ac = (Boolean) f.get(frame);
            assertFalse("Activation need should be false", ac);
            
        } catch (NoSuchMethodException e) {
            fail("Method not found: "+e.getMessage());
        } catch (NoSuchFieldException e) {
            fail("Field not found: "+e.getMessage());
        } catch (IllegalAccessException e) {
            fail("Illegal Access Exception");
        } catch (InvocationTargetException e) {
            fail("InvocationTargetException");
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
        // TODO review the generated test code and remove the default call to fail.		  
        //fail("The test case is a prototype.");        
    }
    
}
