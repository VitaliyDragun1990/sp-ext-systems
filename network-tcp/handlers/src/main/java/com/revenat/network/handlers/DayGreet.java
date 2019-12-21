package com.revenat.network.handlers;

import com.revenat.network.api.Greetable;

/**
 * @author Vitaliy Dragun
 */
public class DayGreet implements Greetable {

    @Override
    public String buildResponse(String username) {
        return "Good day, " + username;
    }
}
