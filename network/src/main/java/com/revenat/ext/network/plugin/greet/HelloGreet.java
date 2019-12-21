package com.revenat.ext.network.plugin.greet;

import com.revenat.ext.network.server.GreetableRequestHandler;

/**
 * @author Vitaliy Dragun
 */
public class HelloGreet implements GreetableRequestHandler {

    @Override
    public String buildResponse(String username) {
        return "Hello, " + username;
    }
}
