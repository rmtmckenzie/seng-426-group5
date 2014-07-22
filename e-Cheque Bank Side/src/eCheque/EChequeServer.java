/*
 * EChequeServer.java
 *
 * Created on April 27, 2007, 8:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author Basel
 */
package eCheque;

//import com.sun.crypto.provider.AESCipher;
import java.net.*;
import java.io.*;

public class EChequeServer implements Runnable {

    /**
     * Creates a new instance of EChequeServer
     */
    private ServerSocket server;
    private final Socket serverConnection;
    private ObjectInputStream socketInputObject;
    private ObjectOutputStream socketOutputObject;
    private InputStream socketInput;
    private OutputStream socketOutput;

    public EChequeServer(Socket socket) {
        serverConnection = socket;
    }

 //private void startServer() throws Exception{
    // server = new ServerSocket(portID);
//}
// private void acceptConnection()throws IOException{
    //   ServerConnection = server.accept();
//} 
    private void getSocketStream() throws Exception {
        socketOutput = serverConnection.getOutputStream();
        socketOutput.flush();
        socketInput = serverConnection.getInputStream();

        socketOutputObject = new ObjectOutputStream(serverConnection.getOutputStream());
        socketOutputObject.flush();
        socketInputObject = new ObjectInputStream(serverConnection.getInputStream());
    }

    private void processConnection() throws IOException, ClassNotFoundException {
        boolean sessionDone = false;
        String line;
        int code;
        if (!sessionDone) {

            line = (String) socketInputObject.readObject();
            code = socketInputObject.readInt();
            if (code == 0) {
                registerClientInfo();
            }
            if (code == 1) {
                depositCheque();
            }
            if (code == 2) {
                cancelCheque();
            }
        }

    }

    private void registerClientInfo() throws IOException, ClassNotFoundException {
        EChequeRegistration registerClient;
        registerClient = (EChequeRegistration) socketInputObject.readObject();
        // get user account ID
        String accountID = "'" + registerClient.getAccountNumber() + "',";
        String cerit = "'" + registerClient.getClientName() + "DC.edc" + "',";
        String clientName = "'" + registerClient.getClientName() + "',";

        DigitalCertificate registDC = (DigitalCertificate) socketInputObject.readObject();

        String registerStat = "insert into accounts(accountID,clientName,dcPath,balance) values("
                + accountID + clientName + cerit + 100000 + ")";

        // starting database
        EChequeDB chqDB = new EChequeDB();
        chqDB.runDB(1, registerStat);

        //store client digital certificate
        DigitalCertificate dcIO = new DigitalCertificate();
        dcIO.SaveDigitalCertificate("Bank" + File.separator + registerClient.getClientName() + "DC.edc");

        socketOutputObject.writeObject("registration complete");
        socketOutputObject.flush();
        //JOptionPane.showMessageDialog(null,"Register Done");

    }

    private void depositCheque() throws IOException, ClassNotFoundException {

        String depositResult = "";
        //read cheque from socket
        ECheque recievedCheque = (ECheque) socketInputObject.readObject();
        //read deposit Account number.
        String depositAccount = (String) socketInputObject.readObject();

        //check the withdraw account. 
        String withdrawStat = "Select balance from accounts where accountID =" + recievedCheque.getAccountNumber();
        String cheqUpdate = "";
        double[] balanceValue = new double[1];

        EChequeDB chqDB = new EChequeDB();
        if (chqDB.runDB(0, withdrawStat, balanceValue)) {
            //check if the balance sufficient
            double chequeMoney = Double.parseDouble(recievedCheque.getMoney());
            if (chequeMoney <= balanceValue[0]) {
                // cheque that the cheque is not canceld
                withdrawStat = "Select * from cancelledCheque where accountID ='" + recievedCheque.getAccountNumber() + "'and chequeID ='" + recievedCheque.getChequeNumber() + "'";
                if (!chqDB.runDB(withdrawStat, 0)) {
                    withdrawStat = "Select * from eChequeOut where chequeID='" + recievedCheque.getChequeNumber() + "'and accountID='" + recievedCheque.getAccountNumber() + "'";
                    if (!chqDB.runDB(withdrawStat, 0)) {
                        withdrawStat = "Update accounts set balance = balance -" + chequeMoney + "where accountID =" + recievedCheque.getAccountNumber();
                        chqDB.runDB(1, withdrawStat);
                        withdrawStat = "Update accounts set balance = balance +" + chequeMoney + "where accountID =" + depositAccount;
                        chqDB.runDB(1, withdrawStat);

                        // update cheque out and in table
                        cheqUpdate = "Insert into eChequeOut(chequeID, accountID, balance) values(" + "'" + recievedCheque.getChequeNumber()
                                + "','" + recievedCheque.getAccountNumber() + "'," + chequeMoney + ")";
                        chqDB.runDB(1, cheqUpdate);

                        cheqUpdate = "Insert into eChequeIN(chequeID, accountID, balance) values(" + "'" + recievedCheque.getChequeNumber()
                                + "','" + recievedCheque.getAccountNumber() + "'," + chequeMoney + ")";
                        chqDB.runDB(1, cheqUpdate);

                        //report the deposit result
                        depositResult = "Your acoount recieves the deposit cheque\nyour balance incremented by" + recievedCheque.getMoney();
                    } else {
                        //report the deposit result
                        depositResult = "This cheque is already deposit, sorry we can not deposit it twice";

                    }
                } else {
                    //report the deposit result
                    depositResult = "This cheque is canceled by the drawer\nSorry we can not deposit it";
                }
            } else {
                //report the deposit result
                depositResult = "Drawer Balance is not sufficient for withdrawing\n";
            }
        } else {
            depositResult = "This cheque is not belong to one of our customers\nyou have to connect to the drawer bank server";
        }
        socketOutputObject.writeObject(depositResult);
        socketOutputObject.flush();
    }

    private void cancelCheque() throws IOException, ClassNotFoundException {
        ECheque recivedCehq = (ECheque) socketInputObject.readObject();
        String cancelChequeStat;
        cancelChequeStat = "insert into cancelledCheque (accountID,chequeID) values('"
                + recivedCehq.getAccountNumber() + "','" + recivedCehq.getChequeNumber() + "')";
        EChequeDB chqDB = new EChequeDB();
        if (chqDB.runDB(1, cancelChequeStat)) {
            socketOutputObject.writeObject("cheque canceld done");
            socketOutputObject.flush();

        } else {
            socketOutputObject.writeObject("sorry cheque not canceled");
            socketOutputObject.flush();
        }

    }

    private void closeConnection() {
        try {

            socketInput.close();
            socketOutput.close();
            socketInputObject.close();
            socketOutputObject.close();
            serverConnection.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }

    }

    public void runServer() {
        try {

            getSocketStream();
            processConnection();
        } catch (Exception error) {
            //JOptionPane.showMessageDialog(null,error.getMessage());
            error.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private String getChequeReferenceString(ECheque chq) {

        String ref = "";
        ref += chq.getAccountNumber() + chq.getAccountHolder() + chq.getBankName() + chq.getChequeNumber()
                + chq.getMoney() + chq.getCurrencyType() + chq.getEarnday() + chq.getGuaranteed() + chq.getPayToOrderOf();

        return ref;
    }

    public void run() {

        runServer();
    }

}
