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

// This class stores data from an echeque and does file operations
public class ECheque implements Serializable {

    private String accountHolder;
    private String accountNumber;
    private String bankName;
    private String payToOrderOf;
    private String amountOfMoney;
    private String currencyType;
    private String chequeNumber;
    private boolean guaranteed;
    private String earnday;
    private byte[] bankSignature;
    private byte[] drawerSignature;

    /**
     * Creates a new instance of ECheque
     */
    public ECheque() {

    }

    public void setAccountHolder(String x) {
        accountHolder = x;

    }

    public void setAccountNumber(String y) {
        accountNumber = y;
    }

    public void setBankName(String z) {
        bankName = z;

    }

    public void setPayToOrderOf(String m) {
        payToOrderOf = m;

    }

    public void setAmountOfMony(String s) {
        amountOfMoney = s;
    }

    public void setCurrencyType(String n) {
        currencyType = n;

    }

    public void setChequeNumber(String c) {
        chequeNumber = c;
    }

    public void setGuaranteed(boolean s) {
        guaranteed = s;

    }

    public void setEarnday(String u) {
        earnday = u;

    }

    public void setBankSignature(byte[] y) {
        bankSignature = y;

    }

    public void setDrawerSignature(byte[] y) {
        drawerSignature = y;

    }

    public String getMoney() {
        return amountOfMoney;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getPayToOrderOf() {
        return payToOrderOf;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public String getChequeNumber() {
        return chequeNumber;
    }

    public boolean getGuaranteed() {
        return guaranteed;
    }

    public String getEarnday() {
        return earnday;
    }

    public byte[] getBankSignature() {
        return bankSignature;
    }

    public byte[] getDrawerSignature() {
        return drawerSignature;
    }

    // Save cheque to a file
    public void saveCheque(String filename) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filename)));
        out.writeObject(this);
        out.close();
    }

    // Read cheque from a file
    static public ECheque readCheque(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(filename)));
        ECheque cheq;
        cheq = (ECheque) in.readObject();
        in.close();
        return cheq;
    }

}
