/*
 * BankServer.java
 *
 * Created on June 10, 2007, 1:06 AM
 *
 */
package eCheque;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author Saad
 */
public class BankServer implements Runnable {

    private final ServerSocket serverSocket;
    private volatile boolean done = false;

    /**
     * Creates a new instance of BankServer
     * @throws java.io.IOException
     */
    public BankServer() throws IOException {
        serverSocket = new ServerSocket(8189);
    }

    /**
     * Starts new instance which waits for socket connections and
     * creates threads to deal with them.
     * 
     * Runs until done has been set.
     */
    public void run() {
        try {
            while (!done) {
                Runnable chequeServer = new EChequeServer(serverSocket.accept());
                new Thread(chequeServer).start();
            }
        } catch (IOException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "Network Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Tells the server to stop accepting sockets.
     */
    public void shutdown() {
        done = true;
    }
}
