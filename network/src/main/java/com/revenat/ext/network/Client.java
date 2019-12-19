package com.revenat.ext.network;

import java.io.*;
import java.net.Socket;

/**
 * @author Vitaliy Dragun
 */
public class Client {

    public static void main(String[] args) throws IOException {
        sendRequest();
    }

    private static void sendRequest() throws IOException {
        try (Socket socket = new Socket(Server.HOST, Server.PORT);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            String request = "Vitaliy";

            bw.write(request);
            bw.newLine();
            bw.flush();

            final String response = br.readLine();
            System.out.println("Client got string:" + response);
        }
    }
}
