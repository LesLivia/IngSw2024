package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    private int port;
    private ServerSocket serverSocket;

    public EchoServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("Server listening on port: " + this.port);

        Socket socket = serverSocket.accept();
        System.out.println("Received client connection.");

        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        while (true) {
            String newMsg = in.nextLine();
            if (newMsg.equals("quit")) break;
            else out.println(newMsg);
            out.flush();
        }

        System.out.println("Closing all sockets.");
        in.close();
        out.close();
        socket.close();
        serverSocket.close();

    }

}
