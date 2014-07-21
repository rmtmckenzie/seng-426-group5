/*
 * EBankingJFrame.java
 *
 * Created on June 11, 2007, 6:52 PM
 */
package eCheque;

/**
 *
 * @author Saad
 */
//import com.Trendy.swing.plaf.TrendyLookAndFeel;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EBankingJFrame extends javax.swing.JFrame {

    private String chequePath;
    private boolean selectChequeFlag;
    private final EChequeRegistration registerData;
    private ECheque depositCheque;
    
    private static final int CLIENTPORT = 8189;

    /**
     * Creates new form EBankingJFrame
     * @param registerdUser
     */
    public EBankingJFrame(EChequeRegistration registerdUser) {
        try {
            //TrendyLookAndFeel tlf = new TrendyLookAndFeel();
            //tlf.setCurrentTheme( new com.Trendy.swing.plaf.Themes.TrendyOrangeTheme());
            //UIManager.setLookAndFeel(tlf);
        } catch (Exception e) {

            //JOptionPane.showMessageDialog(null,"System Error", "can not found themes", JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
        registerData = registerdUser;
        selectChequeFlag = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPChequeInfo = new javax.swing.JPanel();
        jLBankUrl = new javax.swing.JLabel();
        jTBankIP = new javax.swing.JTextField();
        jLChequeSelection = new javax.swing.JLabel();
        jBLoadCheque = new javax.swing.JButton();
        jLCurrentCheque = new javax.swing.JLabel();
        jLChequeName = new javax.swing.JLabel();
        jBDepositCheque = new javax.swing.JButton();
        jBCancelCheque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("e-Banking");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPChequeInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter e-Cheque Info."));

        jLBankUrl.setText("Bank  URL / IP");

        jTBankIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTBankIPKeyTyped(evt);
            }
        });

        jLChequeSelection.setText("Select e-Cheque");

        jBLoadCheque.setText("Load ");
        jBLoadCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoadChequeActionPerformed(evt);
            }
        });

        jLCurrentCheque.setText("Currently Loaded:");

        jLChequeName.setText("N/A");

        org.jdesktop.layout.GroupLayout jPChequeInfoLayout = new org.jdesktop.layout.GroupLayout(jPChequeInfo);
        jPChequeInfo.setLayout(jPChequeInfoLayout);
        jPChequeInfoLayout.setHorizontalGroup(
            jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPChequeInfoLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPChequeInfoLayout.createSequentialGroup()
                        .add(jLCurrentCheque)
                        .add(39, 39, 39)
                        .add(jLChequeName)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jPChequeInfoLayout.createSequentialGroup()
                        .add(jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLBankUrl)
                            .add(jLChequeSelection))
                        .add(jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPChequeInfoLayout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTBankIP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                            .add(jPChequeInfoLayout.createSequentialGroup()
                                .add(46, 46, 46)
                                .add(jBLoadCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE))))))
        );
        jPChequeInfoLayout.setVerticalGroup(
            jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPChequeInfoLayout.createSequentialGroup()
                .add(jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLBankUrl)
                    .add(jTBankIP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(16, 16, 16)
                .add(jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLChequeSelection)
                    .add(jBLoadCheque))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPChequeInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLCurrentCheque)
                    .add(jLChequeName))
                .add(0, 21, Short.MAX_VALUE))
        );

        jBDepositCheque.setText("Deposit Cheque");
        jBDepositCheque.setEnabled(false);
        jBDepositCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDepositChequeActionPerformed(evt);
            }
        });

        jBCancelCheque.setText("Cancel Cheque");
        jBCancelCheque.setEnabled(false);
        jBCancelCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelChequeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(jPChequeInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(48, 48, 48)
                        .add(jBDepositCheque)
                        .add(30, 30, 30)
                        .add(jBCancelCheque)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(jPChequeInfo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jBDepositCheque)
                    .add(jBCancelCheque))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(392, 263));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Checks whether buttons are ready to be enabled;
     * IP address field must have something entered and
     * a valid cheque must have been selected.
     * @return 
     */
    private boolean checkSubmitReady() {
        if (jTBankIP.getText().length() != 0 && selectChequeFlag) {
            jBCancelCheque.setEnabled(true);
            jBDepositCheque.setEnabled(true);
            return true;
        } else {
            jBCancelCheque.setEnabled(false);
            jBDepositCheque.setEnabled(false);
            return false;
        }
    }

    /**
     * Get a folder path the user selects
     * @param dialogTitle - Title to show for the box
     * @return Path of folder
     */
    private String SelectFilePath(String dialogTitle) {

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
        
        return fileName.getPath();
        
    }

    /**
     * Performs an action using an EchequeClient
     * @param action - number of the action
     */
    private void PerformAction(int action) {
        String hostName = jTBankIP.getText();
        Runnable client = new EchequeClient(CLIENTPORT, action, hostName, registerData, depositCheque);
        Thread clientThread = new Thread(client);
        clientThread.start();
    }

    /**
     * Load a cheque and validate that it is a cheque
     * @param evt 
     */
    private void jBLoadChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoadChequeActionPerformed
       chequePath = SelectFilePath("Open Saved Cheque");
       selectChequeFlag = false;
       String chequeNumber = "N/A";
        if (chequePath.length() != 0) {
            try {
                EChequeIO loadCheq = new EChequeIO();
                depositCheque = loadCheq.readcheque(chequePath);
                selectChequeFlag = true;
                
                chequeNumber = depositCheque.getchequeNumber();
            } catch (IOException exp) {
                JOptionPane.showMessageDialog(null, "Cannot load the cheque", "System Error", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException exp) {
                JOptionPane.showMessageDialog(null, "Invalid e-Cheque", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        jLChequeName.setText(chequeNumber);
        checkSubmitReady();
    }//GEN-LAST:event_jBLoadChequeActionPerformed

    private void jTBankIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTBankIPKeyTyped
        checkSubmitReady();
    }//GEN-LAST:event_jTBankIPKeyTyped

    private void jBDepositChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDepositChequeActionPerformed
        PerformAction(EchequeClient.MODE_DEPOSIT);
    }//GEN-LAST:event_jBDepositChequeActionPerformed

    private void jBCancelChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelChequeActionPerformed
        PerformAction(EchequeClient.MODE_CANCEL);
    }//GEN-LAST:event_jBCancelChequeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelCheque;
    private javax.swing.JButton jBDepositCheque;
    private javax.swing.JButton jBLoadCheque;
    private javax.swing.JLabel jLBankUrl;
    private javax.swing.JLabel jLChequeName;
    private javax.swing.JLabel jLChequeSelection;
    private javax.swing.JLabel jLCurrentCheque;
    private javax.swing.JPanel jPChequeInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTBankIP;
    // End of variables declaration//GEN-END:variables

}
