package sockets;

import java.io.IOException;

public class MainClient {

    public static void main(String[] args) {
        LineClient client = new LineClient("127.0.0.1", 7687);

        try {
            client.startClient();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
