/*
 * ElectronicChequeJFrame.java
 *
 * Created on May 4, 2007, 5:29 PM
 */
package eCheque;

/**
 *
 * @author Sherif Saad
 */
//import com.Trendy.swing.plaf.TrendyLookAndFeel;
import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.security.Key;
import java.security.PrivateKey;

public class ElectronicChequeJFrame extends javax.swing.JFrame {

    // JFrames
    private RegistrationJFrame eChqueConfigureWindow;
    private EBankingJFrame eBankingWindow;
    private ChequeJFrame eChequeWindow;
    private SendChequeJFrame sendChequeWindow;
    private ReceiveChequeJFrame receiveChequeWindow;
    // private variables
    private EChequeRegistration registeredUser;
    private String passTemp;
    private boolean privateKeyFlag;
    // flags to keep track is the user has been configured.
    private boolean isActivated;

    /**
     * Creates new form ElectronicChequeJFrame
     */
    public ElectronicChequeJFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            //JOptionPane.showMessageDialog(null,"System Error", "can not found themes", JOptionPane.ERROR_MESSAGE);
        }

        initComponents();

        jBConfigure.setEnabled(true);
        // have all the buttons disabled
        jBEBanking.setEnabled(false);
        jBDrawCheque.setEnabled(false);
        jBSendCheque.setEnabled(false);
        jBReceivedCheque.setEnabled(false);

        isActivated = false;
        loadUserInfo();

        eChqueConfigureWindow = new RegistrationJFrame();
        eBankingWindow = new EBankingJFrame(registeredUser);
        eChequeWindow = new ChequeJFrame(registeredUser);
        sendChequeWindow = new SendChequeJFrame(registeredUser);

        eChqueConfigureWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (eChqueConfigureWindow.getRegistrationState()) {
                    enableLoginSection(true);
                    jBConfigure.setEnabled(false);
                    loadUserInfo();

                    // reload the windows with the new RegistaritionData
                    eChqueConfigureWindow = new RegistrationJFrame();
                    eBankingWindow = new EBankingJFrame(registeredUser);
                    eChequeWindow = new ChequeJFrame(registeredUser);
                    sendChequeWindow = new SendChequeJFrame(registeredUser);
                }
            }
        });

        privateKeyFlag = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTUserName = new javax.swing.JTextField();
        jTPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBActivation = new javax.swing.JButton();
        jBConfigure = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBReceivedCheque = new javax.swing.JButton();
        jBEBanking = new javax.swing.JButton();
        jBSendCheque = new javax.swing.JButton();
        jBDrawCheque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("e-Cheque Client");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Welcome e-Cheque Client"));

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        jBActivation.setText("Log in");
        jBActivation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBActivationMouseClicked(evt);
            }
        });
        jBActivation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActivationActionPerformed(evt);
            }
        });
        jBActivation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBActivationKeyPressed(evt);
            }
        });

        jBConfigure.setText("Configure");
        jBConfigure.setToolTipText("System Configuration");
        jBConfigure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfigureActionPerformed(evt);
            }
        });
        jBConfigure.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jBConfigureKeyPressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jBConfigure, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jBActivation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel2)
                                .add(18, 18, 18))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTPassword)
                            .add(jTUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 199, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBConfigure, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBActivation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, "card2");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBReceivedCheque.setText("Receive Cheque");
        jBReceivedCheque.setToolTipText("Receive Cheque");
        jBReceivedCheque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBReceivedChequeMouseClicked(evt);
            }
        });

        jBEBanking.setText("E-Banking");
        jBEBanking.setToolTipText("E-Banking");
        jBEBanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEBankingActionPerformed(evt);
            }
        });

        jBSendCheque.setText("Send Cheque");
        jBSendCheque.setToolTipText("Send Cheque");
        jBSendCheque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBSendChequeMouseClicked(evt);
            }
        });

        jBDrawCheque.setText("Create Cheque");
        jBDrawCheque.setToolTipText("e-Cheque Tools");
        jBDrawCheque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBDrawChequeMouseClicked(evt);
            }
        });
        jBDrawCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDrawChequeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jBSendCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBEBanking, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 59, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jBReceivedCheque)
                    .add(jBDrawCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(0, 26, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBReceivedCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBSendCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(27, 27, 27)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBDrawCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBEBanking, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(29, 29, 29))
        );

        jPanel1.add(jPanel3, "card3");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 184, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(393, 244));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBConfigureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfigureActionPerformed
        eChqueConfigureWindow.setVisible(true);
    }//GEN-LAST:event_jBConfigureActionPerformed

    private void login() {
        if (!jBActivation.isEnabled()) {
            return;
        }
        if (!tryToLogin()) {
            return;
        }

        jBConfigure.setEnabled(true);
        jBEBanking.setEnabled(true);
        jBDrawCheque.setEnabled(true);
        jBSendCheque.setEnabled(true);
        jBReceivedCheque.setEnabled(true);

        try {
            if (!privateKeyFlag) {
                // This method will throw and exception is anything goes wrong during the process.
                PrivateKey privKey = createPrivateKey(passTemp);
                privateKeyFlag = true;

                // Create the last window.
                receiveChequeWindow = new ReceiveChequeJFrame(registeredUser, privKey);

                // Set the status as activated, and display a message to the user.
                isActivated = true;
                JOptionPane.showMessageDialog(null, "Welcome " + registeredUser.getClientName() + ".", "Welcome Message", JOptionPane.PLAIN_MESSAGE);

                // You have logged-in, therefore disable the configure? and login pages?
                jBConfigure.setEnabled(false);
                enableLoginSection(false);

                // go to the other panel
                CardLayout card = (CardLayout) (jPanel1.getLayout());
                card.next(jPanel1);
            }
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "One of your security key is invalid");
        }
    }

    private void jBActivationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBActivationMouseClicked
        login();
    }//GEN-LAST:event_jBActivationMouseClicked

    private void jBDrawChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDrawChequeActionPerformed
    }//GEN-LAST:event_jBDrawChequeActionPerformed

    private void jBDrawChequeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDrawChequeMouseClicked
        if (!jBDrawCheque.isEnabled()) {
            return;
        }
        if (isActivated) {
            eChequeWindow.setVisible(true);
        }
    }//GEN-LAST:event_jBDrawChequeMouseClicked

    private void jBSendChequeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSendChequeMouseClicked
        if (!jBSendCheque.isEnabled()) {
            return;
        }
        if (isActivated) {
            sendChequeWindow.setVisible(true);
        }
    }//GEN-LAST:event_jBSendChequeMouseClicked

    private void jBEBankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEBankingActionPerformed
        if (!jBEBanking.isEnabled()) {
            return;
        }
        if (isActivated) {
            eBankingWindow.setVisible(true);
        }
    }//GEN-LAST:event_jBEBankingActionPerformed

    private void jBReceivedChequeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBReceivedChequeMouseClicked
        if (!jBReceivedCheque.isEnabled()) {
            return;
        }
        if (isActivated) {
            receiveChequeWindow.setVisible(true);
        }
    }//GEN-LAST:event_jBReceivedChequeMouseClicked

    private void jBActivationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBActivationKeyPressed
        if (!jBActivation.isEnabled()) {
            return;
        }
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_jBActivationKeyPressed

   private void jBConfigureKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBConfigureKeyPressed
       if (!jBConfigure.isEnabled()) {
           eChqueConfigureWindow.setVisible(true);
       }
   }//GEN-LAST:event_jBConfigureKeyPressed

    private void jBActivationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActivationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBActivationActionPerformed

    /**
     * Private method used to attempt login. This will mutate the passTemp and
     * userName variables.
     *
     * @return true for successful login, false otherwise.
     */
    private boolean tryToLogin() {
        String p = new String(jTPassword.getPassword());
        if(p.length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters.","Invalid Password",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        passTemp = AESCrypt.padPassword(new String(jTPassword.getPassword()));
        String userName = jTUserName.getText();

        // Check for the validity of the password and username.
        if ((userName.hashCode() != registeredUser.getUsername() || userName.length() == 0)
                || (passTemp.hashCode() != registeredUser.getPasword() || passTemp.length() == 0)) {
            //invaild user name or invalid password.
            JOptionPane.showMessageDialog(null, "Invalid user name or password", "Access Denied", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private PrivateKey createPrivateKey(String userPassword) throws Exception {
        //create AES Key with user password and cipher
        Key AES128 = AESCrypt.initializeAESKeyByPassword(userPassword);
        Cipher cipher = AESCrypt.initializeCipher(AES128, AESCrypt.cypherType.DECRYPT);
        InputStream in = new FileInputStream(registeredUser.getEWalletLoaction() + File.separator + "Security Tools" + File.separator + "Private Key.key");
        OutputStream out = new FileOutputStream(registeredUser.getEWalletLoaction() + File.separator + "Security Tools" + File.separator + "PrivateKey.key");

        // decrypt the private key with the AES key and delete the plain key
        AESCrypt.crypt(in, out, cipher);
        in.close();
        out.close();
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(registeredUser.getEWalletLoaction() + File.separator + "Security Tools" + File.separator + "PrivateKey.key"));

        //load the user private key.
        PrivateKey loadedKey = (PrivateKey) objIn.readObject();
        objIn.close();

        // delete the un secure key.
        File control = new File(registeredUser.getEWalletLoaction() + File.separator + "Security Tools" + File.separator + "PrivateKey.key");
        control.delete();

        return loadedKey;
    }

    private void enableLoginSection(boolean value) {
        jBActivation.setEnabled(value);
        jTPassword.setEnabled(value);
        jTUserName.setEnabled(value);
    }

    /**
     * Try to load the User info from disk. It will look for the file
     * "Config.epc" in the current working directory. If it does not find
     * it,this wall throw an exception, and give a message prompting the user to
     * configure/register an account with the system.
     */
    private void loadUserInfo() {
        try {
			// Set a default blank user, so that when we create the othe JFrames
            // we still have a user to pass to them.
            //registeredUser = new EChequeRegistration();
            registeredUser = null;

            // Try to read in the registeredUser from "Config.epc"
            ObjectInputStream readObj = new ObjectInputStream(new FileInputStream("Config.epc"));
            registeredUser = (EChequeRegistration) readObj.readObject();

            // If all goes well, then enable the login section.
            enableLoginSection(true);
            jBConfigure.setEnabled(false);

        } catch (IOException exp) {
            //JOptionPane.showMessageDialog(null, "Your e-Cheque System is not Configured Yet\nYou have to configure it first", "Please Register.",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Please configure an account before using the e-cheque client.", "Please configure the system.", JOptionPane.INFORMATION_MESSAGE);
            // diable the login section, until
            enableLoginSection(false);
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElectronicChequeJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActivation;
    private javax.swing.JButton jBConfigure;
    private javax.swing.JButton jBDrawCheque;
    private javax.swing.JButton jBEBanking;
    private javax.swing.JButton jBReceivedCheque;
    private javax.swing.JButton jBSendCheque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jTPassword;
    private javax.swing.JTextField jTUserName;
    // End of variables declaration//GEN-END:variables
}
