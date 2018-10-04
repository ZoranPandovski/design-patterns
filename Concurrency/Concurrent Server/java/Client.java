package ConcurrentServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Class that represents a client that sends requests to a server.
 */
public class Client {

    /**
     * Client's IP address
     */
    public final static String CLIENT_IP = "localhost";

    public static void main(String args[]) {
        boolean execute = true;
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;

        try {
            //A socket for client-server communication is created
            socket = new Socket(CLIENT_IP, 80);
            pw = new PrintWriter(socket.getOutputStream(), true); //Print Writer that sends the message to the server
            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Server response BufferedReader
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); //Console input BufferedReader
        String fromServer;
        String fromUser;

        while (execute) {
            System.out.println("Write a message: ");
            try {
                fromUser = stdIn.readLine(); //Recieves the message from the user
                if (fromUser != null) {
                    System.out.println("ConcurrentServer.Client: " + fromUser);
                    //When the client sends the last message in the protocol, it ends the execution
                    if (fromUser.equalsIgnoreCase("Goodbye")) {
                        execute = false;
                    }
                    pw.println(fromUser); //Sends the message to the server
                }

                if ((fromServer = br.readLine()) != null) {
                    System.out.println("Server: " + fromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            pw.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
