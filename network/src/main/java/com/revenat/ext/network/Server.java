package com.revenat.ext.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.String.format;

/**
 * @author Vitaliy Dragun
 */
public class Server {

    public static final int PORT = 25225;

    public static final String HOST = "127.0.0.1";
    public static final int INCOMING_CONNECTIONS_QUEUE_MAX_SIZE = 4000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT, INCOMING_CONNECTIONS_QUEUE_MAX_SIZE);

        System.out.println("Server is started");
        int count = 1;
        while (true) {
            new SimpleClientHandler(server.accept(), "handler-" + count++).start();
        }
    }

    private static class SimpleClientHandler extends Thread {
        private final Socket clientSocket;
        private final String handlerName;

        private SimpleClientHandler(Socket socket, String handlerName) {
            this.clientSocket = socket;
            this.setName(handlerName);
            this.handlerName = handlerName;
        }

        @Override
        public void run() {
            handleRequest();
        }

        private void handleRequest() {
            try (Socket socket = clientSocket;
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                System.out.println(format("%s started execution", handlerName));

                StringBuilder response = new StringBuilder("Hello, ");
                String userName = br.readLine();
                System.out.println(format("%s got string:%s", handlerName, userName));
                Thread.sleep(2000);

                response.append(userName);
                bw.write(response.toString());
                bw.newLine();
                bw.flush();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace(System.out);
            } finally {
                System.out.println(format("%s finished execution", handlerName));
            }
        }
    }
}
