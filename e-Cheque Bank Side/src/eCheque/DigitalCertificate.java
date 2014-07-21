/*
 * certificate.java
 *
 * Created on March 28, 2007, 3:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
/**
 *
 * @author Abu^S3ooD
 */
package eCheque;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.*;
import java.security.*;

// This class holds digital certificate data and file operations
public class DigitalCertificate implements Serializable {

    private String holderName;
    private String subject;
    private String issuer;
    private String serialNumber;
    private String validFrom;
    private String validTo;
    private PublicKey publicKey;
    private byte[] issuerSignature;

    /**
     * Creates a new instance of a certificate
     */
    public DigitalCertificate() 
    {
    }

    public void setHolderName(String x) {
        holderName = x;
    }

    public void setSubject(String x) {
        subject = x;
    }

    public void setIssuer(String x) {
        issuer = x;
    }

    public void setSerialNumber(String x) {
        serialNumber = x;
    }

    public void setValidFrom(String x) {
        validFrom = x;
    }

    public void setValidTo(String x) {
        validTo = x;
    }

    public void setPublicKey(PublicKey x) {
        publicKey = x;
    }

    public void setIssuerSignature(byte[] x) {
        issuerSignature = x;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getSubject() {
        return subject;
    }

    public String getIssuer() {
        return issuer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public PublicKey getpublicKey() {
        return publicKey;
    }

    public byte[] getIssuerSignature() {
        return issuerSignature;
    }

    // Read a certificate from a file
    static public DigitalCertificate readDigitalCertificate(String filePath) throws IOException, ClassNotFoundException, ClassCastException {
        ObjectInputStream In = new ObjectInputStream(new FileInputStream(filePath));
        DigitalCertificate DC;
        DC = (DigitalCertificate) In.readObject();
        In.close();
        return DC;
    }

    // Write a certificate to a file
    public void SaveDigitalCertificate(String filePath) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
        out.writeObject(this);
        out.close();
    }

}
