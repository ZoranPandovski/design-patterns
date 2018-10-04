package ConcurrentServer;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {

    /**
     * Port where the server will recieve the requests
     */
    public final static int PORT = 80;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        boolean continueOperating = true;
        int currentThreadId = 0;

        try {
            ss = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Socket could not be created in port:" + PORT);
            System.exit(-1);
        }

        //When there's a new connection in the socket, it starts a new ServerThread instance
        //A more resource-efficient alternative to this for higher demand servers to this is creating a predefined number of
        //threads when the server starts running, and assigning this threads to clients or requests when they arrive
        //This alternative is called thread pool.
        while (continueOperating) {
            new ServerThread(ss.accept(),currentThreadId).start();
            currentThreadId++;
        }
        ss.close();
    }
}
