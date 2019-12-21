package com.revenat.network.handlers;

import com.revenat.network.api.Greetable;

/**
 * @author Vitaliy Dragun
 */
public class EveningGreet implements Greetable {

    @Override
    public String buildResponse(String username) {
        return "Good evening, " + username;
    }
}
