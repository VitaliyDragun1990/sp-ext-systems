package com.revenat.ext.network.client;

import com.revenat.ext.network.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * @author Vitaliy Dragun
 */
public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {
        for (int i = 0; i < 5; i++) {
            new SimpleClient(i).start();
        }
    }

    private static class SimpleClient extends Thread {

        private static final String[] COMMANDS = {
                "HELLO", "MORNING", "DAY", "EVENING"
        };

        private final int cmdIdx;

        private SimpleClient(int cmdIdx) {
            this.cmdIdx = cmdIdx;
            setName("client-" + (cmdIdx + 1));
        }

        @Override
        public void run() {
            LOGGER.debug("Started:{}", LocalDateTime.now());
            try (Socket socket = new Socket(Server.HOST, Server.PORT);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

                String command = COMMANDS[cmdIdx % COMMANDS.length];
                String request = String.format("%s %s", command, "Vitaliy");

                bw.write(request);
                bw.newLine();
                bw.flush();

                final String response = br.readLine();
                LOGGER.info("Client got string:{}", response);
            } catch (IOException e) {
                LOGGER.error("Error while talking with server:", e);
            } finally {
                LOGGER.debug("Finished:{}", LocalDateTime.now());
            }
        }
    }
}
