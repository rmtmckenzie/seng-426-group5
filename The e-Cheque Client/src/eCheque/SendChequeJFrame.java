/*
 * SendChequeJFrame.java
 *
 * Created on May 4, 2007, 4:29 AM
 */
package eCheque;

/**
 *
 * @author Saad
 */
import javax.crypto.Cipher;
import javax.swing.*;
import java.io.*;
import java.security.Key;

public class SendChequeJFrame extends javax.swing.JFrame {

    private String chequePath;
    private String cipherChequePath;
    private boolean selectChequeFlag;
    private final EChequeRegistration eChequeRegisterdUser;

    /**
     * Creates new form SendChequeJFrame
     * @param registeredUser
     */
    public SendChequeJFrame(EChequeRegistration registeredUser) {
        initComponents();
        eChequeRegisterdUser = registeredUser;
    }

    private String getFileLocation(String dialogTitle) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

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
        }
        cipherChequePath = fileName.getName();
        return fileName.getPath();

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
        jLabel1 = new javax.swing.JLabel();
        jTReciverIP = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jBselectChqPTP = new javax.swing.JButton();
        jBSendPTPCheque = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTReciverMail = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jBAttachZip = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTShellWindow = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Send e-Cheque");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PTP Transfer"));

        jLabel1.setText("Receiver URL / IP");

        jTReciverIP.setToolTipText("Please enter a FQDN or an IP address.");

        jCheckBox1.setText("Time out  enable");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        jBselectChqPTP.setText("select cheque");
        jBselectChqPTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBselectChqPTPMouseClicked(evt);
            }
        });

        jBSendPTPCheque.setText("Send");
        jBSendPTPCheque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBSendPTPChequeMouseClicked(evt);
            }
        });
        jBSendPTPCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSendPTPChequeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jCheckBox1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTReciverIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 204, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jBselectChqPTP)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jBSendPTPCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jTReciverIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jCheckBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jBselectChqPTP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jBSendPTPCheque))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("E-mail Transfer"));

        jLabel2.setText("Receiver e-mail address");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eCheque/resources/icon-zip.gif"))); // NOI18N
        jButton3.setText("ZIP Cheque");

        jBAttachZip.setText("attach cheque");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jBAttachZip, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton3))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTReciverMail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 191, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTReciverMail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBAttachZip)
                    .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTShellWindow.setColumns(20);
        jTShellWindow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTShellWindow.setRows(5);
        jTShellWindow.setText(">>Status: disconnected");
        jScrollPane1.setViewportView(jTShellWindow);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(389, 275));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSendPTPChequeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSendPTPChequeMouseClicked
        if (selectChequeFlag) {
            String hostName = jTReciverIP.getText();
            if (hostName.length() != 0) {
                try {
                    // generate a session key.
                    Key sessionKey;
                    sessionKey = AESCrypt.GenerateRandomAESKey();
                    Cipher aesCipher = AESCrypt.initializeCipher(sessionKey, AESCrypt.cypherType.ENCRYPT);

                    InputStream in = new FileInputStream(chequePath);
                    OutputStream out = new FileOutputStream(eChequeRegisterdUser.getEWalletLoaction()
                            + File.separator + "Out going" + File.separator + cipherChequePath);
                    AESCrypt.crypt(in, out, aesCipher);
                    in.close();
                    out.close();
                    chequePath = eChequeRegisterdUser.getEWalletLoaction()
                            + File.separator + "Out going" + File.separator + cipherChequePath;
                    //Get the sever side digital certificate.
                    DigitalCertificate clientDC = DigitalCertificate.readDigitalCertificate(
                            eChequeRegisterdUser.getEWalletLoaction()
                            + File.separator + "Security Tools" + File.separator
                            + eChequeRegisterdUser.getClientName() + "DigCert.edc");
                    //Start Server Thread.
                    Runnable threadingClient = new EChequeClient(jTShellWindow, clientDC, sessionKey, eChequeRegisterdUser.getEWalletLoaction(),
                            chequePath, hostName, ReceiveChequeJFrame.SENDRECEIVEPORT);
                    Thread client = new Thread(threadingClient);
                    client.start();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have to select a cheque first");
        }
    }//GEN-LAST:event_jBSendPTPChequeMouseClicked

    private void jBselectChqPTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBselectChqPTPMouseClicked
        chequePath = getFileLocation("Open Saved Cheque");
        if (chequePath.length() != 0) {
            selectChequeFlag = true;
        }

    }//GEN-LAST:event_jBselectChqPTPMouseClicked

    private void jBSendPTPChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSendPTPChequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSendPTPChequeActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAttachZip;
    private javax.swing.JButton jBSendPTPCheque;
    private javax.swing.JButton jBselectChqPTP;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTReciverIP;
    private javax.swing.JTextField jTReciverMail;
    private javax.swing.JTextArea jTShellWindow;
    // End of variables declaration//GEN-END:variables
}
