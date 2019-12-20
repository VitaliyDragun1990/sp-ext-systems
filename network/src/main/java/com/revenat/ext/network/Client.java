package com.revenat.ext.network;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * @author Vitaliy Dragun
 */
public class Client {

    public static void main(String[] args) throws IOException {
        sendRequest();
    }

    private static void sendRequest() throws IOException {
        for (int i = 0; i < 1000; i++) {
            new SimpleClient().start();
        }
    }

    private static class SimpleClient extends Thread {

        @Override
        public void run() {
            System.out.println("Started:" + LocalDateTime.now());
            try (Socket socket = new Socket(Server.HOST, Server.PORT);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                String request = "Vitaliy";

                bw.write(request);
                bw.newLine();
                bw.flush();

                final String response = br.readLine();
                System.out.println("Client got string:" + response);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            } finally {
                System.out.println("Finished:" + LocalDateTime.now());
            }
        }
    }
}
