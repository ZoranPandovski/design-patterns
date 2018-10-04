package ConcurrentServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A concurrent server thread that processes the requests sent by the clients.
 */
public class ServerThread extends Thread {

    /**
     * Socket where the client is connected
     */
    private Socket clientSocket;

    /**
     * Thread id
     */
    private int id;

    /**
     * Creates a new server thread that communicates with socket pSocket
     * @param pSocket socket that the thread is using to communicate with the server
     * @param pId thread id
     */
    public ServerThread(Socket pSocket, int pId) {
        this.clientSocket = pSocket;
        this.id = pId;
    }

    public void run() {
        System.out.println("New thread start: " + id);
        try {
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true); //Print writer for respones
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //Buffered reader for client messages
            process(br,pw);
            pw.close();
            br.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void process(BufferedReader pIn, PrintWriter pOut) throws IOException {
        String inputLine;
        String outputLine;
        int state = 0;

        //As the client follows the communication protocol, the server advances to the next state, until it finishes it execution
        while (state < 3 && (inputLine = pIn.readLine()) != null) {
            System.out.println("Process entry: " + inputLine);
            switch (state) {
                case 0:
                    if (inputLine.equalsIgnoreCase("Hello")) {
                        outputLine = "Hey there";
                        state++;
                    } else {
                        outputLine = "ERROR. Expected 'Hello'";
                        state = 0;
                    }
                    break;
                case 1:
                    try {
                        int val = Integer.parseInt(inputLine);
                        val--;
                        outputLine = "" + val;
                        state++;
                    } catch (Exception e) {
                        outputLine = "ERROR int the expected value";
                        state = 0;
                    }
                    break;
                case 2:
                    if (inputLine.equalsIgnoreCase("Goodbye")) {
                        outputLine = "See you later!";
                        state++;
                    } else {
                        outputLine = "ERROR. Expected 'Goodbye'";
                        state = 0;
                    }
                    break;
                default:
                    outputLine = "ERROR";
                    state = 0;
            }
            pOut.println(outputLine); //The server sends each response via the print writer
        }
    }
}
