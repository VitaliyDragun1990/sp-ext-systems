package com.revenat.net;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Vitaliy Dragun
 */
public class SimpleSocket {

    @Test
    void simpleSocketTest() throws IOException {
        Socket socket = new Socket("localhost", 8080);

        final InputStream is = socket.getInputStream();
        final OutputStream os = socket.getOutputStream();

        String command = "GET / HTTP/1.1\r\nHost:java-course.ru\r\n\r\n";
        os.write(command.getBytes());
        os.flush();

        int c = 0;
        while ((c = is.read()) != -1) {
            System.out.print((char)c);
        }

        socket.close();
    }
}
