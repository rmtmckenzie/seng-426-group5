/*
 * BankServer.java
 *
 * Created on June 10, 2007, 1:06 AM
 *
 */
package eCheque;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saad
 */
public class BankServer implements Runnable {

	private ServerSocket serverSocket;
	private volatile boolean continueRunning = true;

	/**
	 * Creates a new instance of BankServer
	 *
	 * @throws java.io.IOException
	 */
	public BankServer() throws IOException {		
	}

	/**
	 * Starts new instance which waits for socket connections and creates threads
	 * to deal with them.
	 *
	 * Runs until continueRunning has been set.
	 */
	public void run() {
		try {
			serverSocket = new ServerSocket(8189);
			while (continueRunning) {				
				Runnable chequeServer = new EChequeServer(serverSocket.accept());
				new Thread(chequeServer).start();
			}
		} catch (SocketException exp){
			// do nothing, this is the expected way we are closing the thread.
		} catch (IOException exp) {
			JOptionPane.showMessageDialog(null, exp.getMessage(), "Network Error", JOptionPane.ERROR_MESSAGE);
		} 
	}

	/**
	 * Tells the server to stop accepting sockets.
	 */
	public void shutdown() {
		continueRunning = false;
		try {
			serverSocket.close();			
		} catch (IOException ex) {
			//Logger.getLogger(BankServer.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
