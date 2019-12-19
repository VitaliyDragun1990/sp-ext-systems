package com.revenat.ext.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Vitaliy Dragun
 */
public class Server {

    public static final int PORT = 25225;

    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is started");
        while (true) {
            final Socket client = server.accept();
            handleRequest(client);
        }
    }

    private static void handleRequest(Socket client) throws IOException {
        try (Socket socket = client;
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            StringBuilder response = new StringBuilder("Hello, ");
            String userName = br.readLine();
            System.out.println("Server got string:" + userName);

            response.append(userName);
            bw.write(response.toString());
            bw.newLine();
            bw.flush();
        }
    }
}
