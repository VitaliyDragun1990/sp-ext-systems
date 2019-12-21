package com.revenat.ext.network.plugin.greet;

import com.revenat.ext.network.server.GreetableRequestHandler;

/**
 * @author Vitaliy Dragun
 */
public class DayGreet implements GreetableRequestHandler {

    @Override
    public String buildResponse(String username) {
        return "Good day, " + username;
    }
}
