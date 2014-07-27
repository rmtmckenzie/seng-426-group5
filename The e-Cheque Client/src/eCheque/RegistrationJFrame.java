/*
 * RegistrationFrame.java
 *
 * Created on May 3, 2007, 6:01 PM
 */
package eCheque;

/**
 *
 * @author Saad
 */
//import com.Trendy.swing.plaf.TrendyLookAndFeel;
//import com.sun.crypto.provider.AESCipher;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.security.*;
import java.io.File;

public class RegistrationJFrame extends javax.swing.JFrame {

    private boolean pathFlag;
    private String eWalletPath;
    private boolean registrationState;

    /**
     * Creates new form RegistrationFrame
     */
    public RegistrationJFrame() {
        pathFlag = false;
        registrationState = false;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTBankName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTBankURLIP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTClientName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTAccountNo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTIssuerName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTDCURLIP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCValidation = new javax.swing.JComboBox();
        jCSubject = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTUserName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTPassword = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jTPassword2 = new javax.swing.JPasswordField();
        jBeWallet = new javax.swing.JButton();
        jBRFRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Client Form"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Financial Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(51, 51, 51)));

        jLabel1.setText("Bank Name");

        jLabel2.setText("URL/IP");

        jTBankURLIP.setToolTipText("Please enter a Fully Qualified Domain Name, or an IP address.");

        jLabel3.setText("Client Name");

        jLabel4.setText("Account no.");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(jLabel1)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(jTBankName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(jLabel3)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 5, Short.MAX_VALUE)
                                                .add(jTClientName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(16, 16, 16)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(jLabel2)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 6, Short.MAX_VALUE)
                                                .add(jTBankURLIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 119, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(jLabel4)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(jTAccountNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jTBankName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jTBankURLIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(14, 14, 14)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jTAccountNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jTClientName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Digital Certificate Info"));

        jLabel5.setText("Issuer");

        jLabel6.setText("URL/IP");

        jTDCURLIP.setToolTipText("Please enter FQDN or an IP address.");

        jLabel7.setText("Subject");

        jLabel8.setText("Validation");

        jCValidation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3 months", "6 months", "9 months", "12 months" }));

        jCSubject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "e-cheque services", "e-stocks", "other e-banking" }));

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel5)
                                        .add(jLabel7))
                                .add(24, 24, 24)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jCSubject, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jTIssuerName))
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel3Layout.createSequentialGroup()
                                                .add(25, 25, 25)
                                                .add(jLabel6))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .add(12, 12, 12)
                                                .add(jLabel8)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jCValidation, 0, 119, Short.MAX_VALUE)
                                        .add(jTDCURLIP))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jTIssuerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jTDCURLIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel7)
                                        .add(jLabel8)
                                        .add(jCValidation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jCSubject, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Security Sittings"));

        jLabel9.setText("User Name");

        jLabel10.setText("Password");

        jLabel11.setText("re-Password");

        jBeWallet.setText("Create E-Wallet");
        jBeWallet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBeWalletMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel9)
                                        .add(jLabel10)
                                        .add(jLabel11))
                                .add(14, 14, 14)
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(jTUserName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                        .add(jTPassword)
                                        .add(jTPassword2))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jBeWallet)
                                .add(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel4Layout.createSequentialGroup()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel4Layout.createSequentialGroup()
                                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(jLabel9)
                                                        .add(jTUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .add(9, 9, 9)
                                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(jLabel10)
                                                        .add(jTPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                        .add(jTPassword2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(jLabel11)))
                                        .add(jPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(jBeWallet, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        jBRFRegister.setText("Register");
        jBRFRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBRFRegisterMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jBRFRegister, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jBRFRegister, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        setSize(new java.awt.Dimension(436, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String getWalletLocation(String dialogTitle) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        fileChooser.setDialogTitle(dialogTitle);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.CANCEL_OPTION) {
            return "";
        }

        File fileName = fileChooser.getSelectedFile();

        // display error if invalid
        if ((fileName == null) || (fileName.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Invalid File Name",
                    "Invalid File Name", JOptionPane.ERROR_MESSAGE);
            return "";
        } // end if

        return fileName.getPath();

    }

    private void jBeWalletMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBeWalletMouseClicked
        // TODO add your handling code here:

        eWalletPath = getWalletLocation("Set e-Wallet Location");
        if (eWalletPath == "") {
            pathFlag = false;
            return;
        }

        pathFlag = new File(eWalletPath + File.separator + "In Coming").mkdirs();
        if (pathFlag) {
            pathFlag = new File(eWalletPath + File.separator + "Out going").mkdirs();
        }
        if (pathFlag) {
            pathFlag = new File(eWalletPath + File.separator + "Security Tools").mkdirs();
        }
        if (pathFlag) {
            pathFlag = new File(eWalletPath + File.separator + "My Cheques").mkdirs();
        }
        if (pathFlag) {
            pathFlag = new File(eWalletPath + File.separator + "History").mkdirs();
        }

        if (!pathFlag) {
            int option = JOptionPane.showConfirmDialog(null, "E-Wallet already exists!\nDo you want to overwrite it?", "E-Wallet already exists", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.NO_OPTION) {
                pathFlag = true;
            } else {
                File eWalletFile = new File(eWalletPath);
                String[] entries = eWalletFile.list();
                for (String s : entries) {
                    File currentFile = new File(eWalletFile.getPath(), s);
                    //currentFile.delete();
                }
                new File(eWalletPath + File.separator + "In Coming").mkdirs();
                new File(eWalletPath + File.separator + "Out going").mkdirs();
                new File(eWalletPath + File.separator + "Security Tools").mkdirs();
                new File(eWalletPath + File.separator + "My Cheques").mkdirs();
                new File(eWalletPath + File.separator + "History").mkdirs();
                pathFlag = true;
            }
        }
    }// GEN-LAST:event_jBeWalletMouseClicked

    private void jBRFRegisterMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jBRFRegisterMouseClicked
        // TODO add your handling code here:

        String bankName;
        String bankURL;
        String clientName;
        String accountNumber;
        String digitalCIssuer;
        String digitalCURL;
        String userName;
        char[] password;
        char[] password2;
        int userNameCode;
        int passwordCode;

        bankName = jTBankName.getText();
        bankURL = jTBankURLIP.getText();
        clientName = jTClientName.getText();
        accountNumber = jTAccountNo.getText();
        digitalCIssuer = jTIssuerName.getText();
        digitalCURL = jTDCURLIP.getText();
        userName = jTUserName.getText();
        password = jTPassword.getPassword();
        password2 = jTPassword2.getPassword();

        if (bankName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Bank Name can not be empty",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (bankName.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Bank Name cannot contain numbers",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (bankURL.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Bank URL or IP address can not be empty", "User Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (bankURL.matches("[a-zA-Z]+") && !bankURL.equals("localhost")) {
            JOptionPane.showMessageDialog(null, "Bank URL cannot contain letters",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (clientName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Client name can not be empty",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (clientName.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Client Name cannot contain numbers",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (accountNumber.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Account number can not be empty", "User Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (accountNumber.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Account Number cannot contain letters",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (digitalCIssuer.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Certificate issuer can not be empty", "User Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (digitalCIssuer.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Digital Certificate Issuer cannot contain numbers",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (digitalCURL.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "Certificate issuer URl or IP can not be empty",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (userName.length() == 0) {
            JOptionPane.showMessageDialog(null, "User name can not be empty",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (password.length == 0) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty ",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

		/* Checking if both passwords are the same */
        String strPassword = new String(password);

        if (strPassword.compareTo(new String(password2)) != 0) {
            JOptionPane.showMessageDialog(null, "Passwords not match ",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (password.length < 8) {
            JOptionPane.showMessageDialog(null,
                    "Your password should be greater than 7 characters",
                    "User Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!pathFlag) {
            JOptionPane.showMessageDialog(null,
                    "You have to create your e-wallet", "User Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        // prepare the user name and password
        userNameCode = userName.hashCode();

        //pad the password
        strPassword = AESCrypt.padPassword(new String(password));
        passwordCode = strPassword.hashCode();

        // For Test:
        // JOptionPane.showMessageDialog(null,passTemp);
        // create a registration object
        // to save user registration data
        EChequeRegistration registrationObj = new EChequeRegistration();
        registrationObj.setBankName(bankName);
        registrationObj.setBankAddress(bankURL);
        registrationObj.setClientName(clientName);
        registrationObj.setAccountNumber(accountNumber);
        registrationObj.setEWalletLoaction(eWalletPath);
        registrationObj.setUsername(userNameCode);
        registrationObj.setPasword(passwordCode);

        try {
            ObjectOutputStream outObj;
            // create the user digital certificate (digital identity)
            KeyPair RSAKeys = RSAGenerator.GenerateRSAKeys();

            // encrypt private key with user password.
            outObj = new ObjectOutputStream(new FileOutputStream(eWalletPath
                    + File.separator + "Security Tools"
                    + File.separator + "privateKey.key"));

            outObj.writeObject(RSAKeys.getPrivate());
            outObj.close();

            // create AES Key with user password and cipher
            Key AES128 = AESCrypt.initializeAESKeyByPassword(strPassword);
            Cipher cipher = AESCrypt.initializeCipher(AES128, AESCrypt.cypherType.ENCRYPT);
            InputStream in = new FileInputStream(eWalletPath
                    + File.separator + "Security Tools"
                    + File.separator + "privateKey.key");
            OutputStream out = new FileOutputStream(eWalletPath
                    + File.separator + "Security Tools"
                    + File.separator + "Private Key.key");

            // encrypt the private key with the AES key and delete the plain key
            AESCrypt.crypt(in, out, cipher);
            in.close();
            out.close();
            File control = new File(eWalletPath + File.separator
                    + "Security Tools" + File.separator
                    + "privateKey.key");
            control.delete();

            // create Digital certificate object.
            DigitalCertificate dcObj = new DigitalCertificate();
            dcObj.setHolderName(clientName);
            dcObj.setIssuer(digitalCIssuer);
            dcObj.setSubject(jCSubject.getSelectedItem().toString());
            dcObj.setValidFrom(jCValidation.getSelectedItem().toString());
            dcObj.setValidTo(jCValidation.getSelectedItem().toString());
            dcObj.setPublicKey(RSAKeys.getPublic());

            // save the user digital certificate
            dcObj.SaveDigitalCertificate(eWalletPath + File.separator
                    + "Security Tools" + File.separator
                    + registrationObj.getClientName() + "DigCert.edc");

            // Connect to the bank server to activate the e-cheque account.
            EChequeClient client = new EChequeClient(8189, EChequeClient.MODE_REGISTER,
                    registrationObj.getBankAddress(), registrationObj, dcObj);
            Thread t = new Thread(client);
            t.start();
            t.join();

            registrationState = client.getRegistrationState();
            if (registrationState) {
                JOptionPane.showMessageDialog(null, "Registration complete", "Registration", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registration failed", "Registration", JOptionPane.INFORMATION_MESSAGE);
            }

            // JOptionPane.showMessageDialog(null,"Registeration Done\n\tYou have to restart your system","Confirm",
            // JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException exp) {
            JOptionPane.showMessageDialog(null,
                    "Access to Disk Media is not allowed", "System Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchAlgorithmException exp) {
            JOptionPane.showMessageDialog(null,
                    "One of your Java Securiy Features are not available",
                    "Platform Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "Sorry, something went wrong: " + exp.getMessage(),
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_jBRFRegisterMouseClicked

    public boolean getRegistrationState() {
        return registrationState;
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRFRegister;
    private javax.swing.JButton jBeWallet;
    private javax.swing.JComboBox jCSubject;
    private javax.swing.JComboBox jCValidation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTAccountNo;
    private javax.swing.JTextField jTBankName;
    private javax.swing.JTextField jTBankURLIP;
    private javax.swing.JTextField jTClientName;
    private javax.swing.JTextField jTDCURLIP;
    private javax.swing.JTextField jTIssuerName;
    private javax.swing.JPasswordField jTPassword;
    private javax.swing.JPasswordField jTPassword2;
    private javax.swing.JTextField jTUserName;
    // End of variables declaration//GEN-END:variables
}
