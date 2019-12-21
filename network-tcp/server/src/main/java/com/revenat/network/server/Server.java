package com.revenat.network.server;

import com.revenat.network.api.Greetable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * @author Vitaliy Dragun
 */
public class Server {

    private static final int PORT = 25225;

    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    private static final int INCOMING_CONNECTIONS_QUEUE_MAX_SIZE = 4000;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT, INCOMING_CONNECTIONS_QUEUE_MAX_SIZE)) {
            LOGGER.info("Server is started");

            Map<String, Greetable> requestHandlers = RequestHandlersProvider.getRequestHandlers();

            int count = 1;
            while (true) {
                new SimpleServerWorker(server.accept(), requestHandlers, "worker-" + count++).start();
            }
        }
    }

    private static class SimpleServerWorker extends Thread {
        private final Socket clientSocket;
        private final String workerName;
        private Map<String, Greetable> requestHandlers;

        private SimpleServerWorker(Socket socket, Map<String, Greetable> requestHandlers, String workerName) {
            this.clientSocket = socket;
            this.setName(workerName);
            this.workerName = workerName;
            this.requestHandlers = requestHandlers;
        }

        @Override
        public void run() {
            handleRequest();
        }

        private void handleRequest() {
            try (Socket socket = clientSocket;
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                LOGGER.debug("{} started execution", workerName);

                String request = br.readLine();
                final String[] lines = request.split("\\s+");
                String command = lines[0];
                String userName = lines[1];
                LOGGER.debug("{} got command:{}", workerName, command);
                LOGGER.debug("{} got username:{}", workerName, userName);

                String response = buildResponse(command, userName);
                bw.write(response);

                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                LOGGER.error("Error while handling client request:", e);
            } finally {
                LOGGER.debug("{} finished execution", workerName);
            }
        }

        private String buildResponse(String command, String username) {
            return requestHandlers.getOrDefault(command, DEFAULT_HANDLER).buildResponse(username);
        }
    }

    private static final Greetable DEFAULT_HANDLER = username -> "Hello, " + username;
}
