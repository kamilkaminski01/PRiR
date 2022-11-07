package lab3_4.Serwer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Main {
    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(8000)) {
            while (true) {
                Socket socket = server.accept();
                new Serwer(socket);
            }
        }

    }
}
