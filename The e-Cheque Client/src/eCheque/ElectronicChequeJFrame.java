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
import java.awt.CardLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.crypto.Cipher;
import java.security.Key;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.security.PrivateKey;
import javax.swing.UnsupportedLookAndFeelException;

public class ElectronicChequeJFrame extends javax.swing.JFrame {

	// JFrames
	private RegistrationJFrame eChqueConfigureWindow;
	private EBankingJFrame eBankingWindow;
	private ChequeJFrame eChequeWindow;
	private SendChequeJFrame sendChequeWindow;
	private ReceiveChequeJFrame receiveChequeWindow;
	// private variables
	private EChequeRegisteration registeredUser;
	private String userName;
	private String passTemp;
	//private key
	private PrivateKey privKey;
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
      jPanel4 = new javax.swing.JPanel();
      jTUserName = new javax.swing.JTextField();
      jTPassword = new javax.swing.JPasswordField();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jBActivaton = new javax.swing.JButton();
      jBConfigure = new javax.swing.JButton();
      jPanel3 = new javax.swing.JPanel();
      jBReceivedCheque = new javax.swing.JButton();
      jBEBanking = new javax.swing.JButton();
      jBSendCheque = new javax.swing.JButton();
      jBDrawCheque = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("e-Cheque Client");
      setResizable(false);

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "e-Cheque Payment ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));
      jPanel1.setLayout(new java.awt.CardLayout());

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome e-Cheque Client", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

      jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

      jLabel1.setText("User Name");

      jLabel2.setText("Password");

      jBActivaton.setText("Log in");
      jBActivaton.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            jBActivatonMouseClicked(evt);
         }
      });

      jBConfigure.setText("Configure");
      jBConfigure.setToolTipText("System Configuration");
      jBConfigure.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jBConfigureActionPerformed(evt);
         }
      });

      org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
      jPanel4.setLayout(jPanel4Layout);
      jPanel4Layout.setHorizontalGroup(
         jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(jPanel4Layout.createSequentialGroup()
                  .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                     .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                  .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                     .add(jTUserName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                     .add(jTPassword)))
               .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                  .add(0, 89, Short.MAX_VALUE)
                  .add(jBConfigure, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(18, 18, 18)
                  .add(jBActivaton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );
      jPanel4Layout.setVerticalGroup(
         jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(jTUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
               .add(jLabel2)
               .add(jTPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(jBActivaton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .add(jBConfigure, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
      );

      org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel2Layout.createSequentialGroup()
            .add(25, 25, 25)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(24, Short.MAX_VALUE))
      );

      jPanel1.add(jPanel2, "card2");

      jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GO TO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

      jBReceivedCheque.setText("Receive Cheques");
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

      jBDrawCheque.setText("Create an E-Cheque");
      jBDrawCheque.setToolTipText("e-Cheque Tools");
      jBDrawCheque.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            jBDrawChequeMouseClicked(evt);
         }
      });

      org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
      jPanel3.setLayout(jPanel3Layout);
      jPanel3Layout.setHorizontalGroup(
         jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel3Layout.createSequentialGroup()
            .add(25, 25, 25)
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(jBReceivedCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(jBDrawCheque))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 53, Short.MAX_VALUE)
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
               .add(jBEBanking, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
               .add(jBSendCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(20, 20, 20))
      );
      jPanel3Layout.setVerticalGroup(
         jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel3Layout.createSequentialGroup()
            .addContainerGap(24, Short.MAX_VALUE)
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
               .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                  .add(jBDrawCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                  .add(jBReceivedCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(26, 26, 26))
               .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                  .add(jBEBanking, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                  .add(jBSendCheque, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                  .add(27, 27, 27))))
      );

      jPanel1.add(jPanel3, "card3");
      jPanel3.getAccessibleContext().setAccessibleName("");

      org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
         .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
      );

      setSize(new java.awt.Dimension(400, 248));
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

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

    private void jBSendChequeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBSendChequeMouseClicked
		 if (!jBSendCheque.isEnabled()) {
			 return;
		 }
		 if (isActivated) {
			 sendChequeWindow.setVisible(true);
		 }
    }//GEN-LAST:event_jBSendChequeMouseClicked

    private void jBDrawChequeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDrawChequeMouseClicked
		 if (!jBDrawCheque.isEnabled()) {
			 return;
		 }
		 if (isActivated) {
			 eChequeWindow.setVisible(true);
		 }
    }//GEN-LAST:event_jBDrawChequeMouseClicked

   private void jBConfigureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfigureActionPerformed
      eChqueConfigureWindow.setVisible(true);
   }//GEN-LAST:event_jBConfigureActionPerformed

   private void jBActivatonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBActivatonMouseClicked
      if(!jBActivaton.isEnabled()){return;}

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
            privKey = createPrivateKey(passTemp);
            privateKeyFlag = true;

            // Create the last window.
            receiveChequeWindow = new ReceiveChequeJFrame(registeredUser, privKey);

            // Set the status as activated, and display a message to the user.
            isActivated = true;
            JOptionPane.showMessageDialog(null, "Welcome " + registeredUser.getClientName(), "Welcome Message", JOptionPane.INFORMATION_MESSAGE);

            // You have logged-in, therefore disable the configure? and login pages?
            enableLoginSection(false);
            // go to the other layout
            CardLayout card = (CardLayout)(jPanel1.getLayout());
            card.next(jPanel1);
            //card.show(jPanel1,"jPanel");

         }

      } catch (Exception exp) {
         JOptionPane.showMessageDialog(null, "One of your security key is invaild");
      }
   }//GEN-LAST:event_jBActivatonMouseClicked

	/**
	 * Private method used to attempt login. This will mutate the passTemp and
	 * userName variables.
	 *
	 * @return true for successful login, false otherwise.
	 */
	private boolean tryToLogin() {
		passTemp = "";
		userName = jTUserName.getText();
		char password[];

		password = jTPassword.getPassword();
		if (password.length >= 8 && password.length < 16) {

			for (int i = 0; i < password.length; i++) {
				passTemp += password[i];
			}

			if (password.length < 16) {
				int pad = 16 - password.length;
				for (int i = 0; i < pad; i++) {
					passTemp += password[i];
				}
			}
		}

		// Check for the validity of the password and username.
		if ((userName.hashCode() != registeredUser.getUsername() || userName.length() == 0)
				  || (passTemp.hashCode() != registeredUser.getPasword() || passTemp.length() == 0)) {
			//invaild user name or invalid password.
			JOptionPane.showMessageDialog(null, "Invaild user name or password", "Access Denied", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	private PrivateKey createPrivateKey(String userPassword) throws Exception {
		//create AES Key with user password and cipher
		AESCrypt aesCrypt = new AESCrypt();
		Key AES128 = aesCrypt.inilizeAESKeyByPassword(userPassword);
		Cipher cipher = aesCrypt.initializeCipher(AES128, 1);
		InputStream in = new FileInputStream(registeredUser.getEWalletLoaction() + File.separator + "Security Tools" + File.separator + "Private Key.key");
		OutputStream out = new FileOutputStream(registeredUser.getEWalletLoaction() + File.separator + "Security Tools" + File.separator + "PrivateKey.key");

		// decrypt the private key with the AES key and delete the plain key
		aesCrypt.crypt(in, out, cipher);
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
		jBActivaton.setEnabled(value);
		jTPassword.setEnabled(value);
		jTUserName.setEnabled(value);
	}

	/**
	 * Try to load the User info from disk. It will look for the file
	 * "Config.epc" in the current working directory. If it does not find it,this
	 * wall throw an exception, and give a message prompting the user to
	 * configure/register an account with the system.
	 */
	private void loadUserInfo() {
		try {
			// Set a default blank user, so that when we create the othe JFrames
			// we still have a user to pass to them.
			registeredUser = new EChequeRegisteration();

			// Try to read in the registeredUser from "Config.epc"
			ObjectInputStream readObj = new ObjectInputStream(new FileInputStream("Config.epc"));
			registeredUser = (EChequeRegisteration) readObj.readObject();

			// If all goes well, then enable the login section.			
			enableLoginSection(true);
			
		} catch (IOException exp) {
			//JOptionPane.showMessageDialog(null, "Your e-Cheque System is not Configured Yet\nYou have to configure it first", "Please Register.",JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, "Please configure an account before using the e-cheque client.", "Please configure the system.", JOptionPane.INFORMATION_MESSAGE);
			// diable the login section, until 						
			enableLoginSection(false);						
			//jBConfigure.setEnabled(true);			
			//jTPassword.setEnabled(false);
			//jBActivaton.setEnabled(true);
			//jTUserName.setEnabled(false);			
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
   private javax.swing.JButton jBActivaton;
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
   private javax.swing.JPanel jPanel4;
   private javax.swing.JPasswordField jTPassword;
   private javax.swing.JTextField jTUserName;
   // End of variables declaration//GEN-END:variables
}