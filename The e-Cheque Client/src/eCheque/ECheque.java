/*
 * cheque.java
 *
 * Created on March 27, 2007, 10:33 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author Basel
 */
package eCheque;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.*;

//this class  for inter data cheque form user
public class ECheque implements Serializable {

    private String accountholder;
    private String accountNumber;
    private String bankname;
    private String payToOrderOf;
    private String amountOfMoney;
    private String currencytype;
    private String chequeNumber;
    private boolean guaranteed;
    private String earnday;
    private byte[] bankSignature;
    private byte[] drawerSignature;

    //to ener data we use set function 
    /**
     * Creates a new instance of ECheque
     */
    public ECheque() {

    }

    public void setaccountholder(String x) {
        accountholder = x;

    }

    public void setaccountNumber(String y) {
        accountNumber = y;
    }

    public void setbankname(String z) {
        bankname = z;

    }

    public void setpayToOrderOf(String m) {
        payToOrderOf = m;

    }

    public void setamountofMony(String s) {
        amountOfMoney = s;
    }

    public void setcurrencytype(String n) {
        currencytype = n;

    }

    public void setchequeNumber(String c) {
        chequeNumber = c;
    }

    public void setguaranteed(boolean s) {
        guaranteed = s;

    }

    public void setearnday(String u) {
        earnday = u;

    }

    public void setbanksignature(byte[] y) {
        bankSignature = y;

    }

    public void setdrawersiganure(byte[] y) {
        drawerSignature = y;

    }

    //to extracting data we use get function;
    public String getMoney() {
        return amountOfMoney;
    }

    public String getaccountholder() {
        return accountholder;
    }

    public String getaccountNumber() {
        return accountNumber;
    }

    public String getbankname() {
        return bankname;
    }

    public String getpayToOrderOf() {
        return payToOrderOf;
    }

    public String getcurrencytype() {
        return currencytype;
    }

    public String getchequeNumber() {
        return chequeNumber;
    }

    public boolean getguaranteed() {

        return guaranteed;
    }

    public String getearnday() {
        return earnday;
    }

    public byte[] getbanksignature() {
        return bankSignature;
    }

    public byte[] getdrawersiganure() {
        return drawerSignature;
    }

    public void saveCheque(String filename) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filename)));
        out.writeObject(this);
        out.close();
    }

    public ECheque readCheque(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(filename)));
        ECheque cheq;
        cheq = (ECheque) in.readObject();
        in.close();
        return cheq;
    }

}
