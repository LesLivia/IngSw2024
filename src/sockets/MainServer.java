package sockets;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) {
        EchoServer server = new EchoServer(7687);

        try {
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
