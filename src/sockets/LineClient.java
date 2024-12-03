package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LineClient {

    private String ip;
    private int port;

    public LineClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startClient() throws IOException {
        Socket socket = new Socket(this.ip, this.port);
        System.out.println("Connection established");

        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner stdin = new Scanner(System.in);

        try {
            while (true) {
                String msg = stdin.nextLine();
                out.println(msg);
                out.flush();
                String socketLine = in.nextLine();
                System.out.println(socketLine);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Connection closed.");
        }

        in.close();
        out.close();
        socket.close();

    }


}
