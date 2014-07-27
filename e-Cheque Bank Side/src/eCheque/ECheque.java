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

import java.io.*;

//this class is for storing cheque data and file operations
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

	public String getReferenceString() {
		return accountNumber + accountHolder + bankName + chequeNumber
				  + amountOfMoney + currencyType + earnday + guaranteed + payToOrderOf;
	}

	public byte[] getBankSignature() {
		return bankSignature;
	}

	public byte[] getDrawerSignature() {
		return drawerSignature;
	}

	public void saveCheque(String filename) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		out.writeObject(this);
		out.close();
	}

	static public ECheque readCheque(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		ECheque cheq;
		cheq = (ECheque) in.readObject();
		in.close();
		return cheq;
	}
}
