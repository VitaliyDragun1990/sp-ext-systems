package com.revenat.network.server;

import com.revenat.network.api.Greetable;
import com.revenat.network.server.config.Config;

import java.util.Map;
import java.util.Properties;

import static java.lang.String.format;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

/**
 * @author Vitaliy Dragun
 */
public class RequestHandlersProvider {

    private static Map<String, Greetable> handlers;

    private RequestHandlersProvider() {
    }

    public static synchronized Map<String, Greetable> getRequestHandlers() {
        if (handlers == null) {
            handlers = loadHandlers();
        }
        return handlers;
    }

    private static Map<String, Greetable> loadHandlers() {
        final Properties properties = Config.getConfigProperties();

        return properties.keySet()
                .stream()
                .map(String::valueOf)
                .collect(toUnmodifiableMap(identity(), key -> buildHandler(properties.getProperty(key))));
    }

    @SuppressWarnings("unchecked")
    private static Greetable buildHandler(final String className) {
        try {
            final Class<? extends Greetable> handler = (Class<? extends Greetable>) Class.forName(className);
            return handler.getConstructor().newInstance();
        } catch (final Exception e) {
            throw new HandlersProviderException(format("Can't build handler for class:[%s]",className), e);
        }
    }

    public static class HandlersProviderException extends RuntimeException {

        public HandlersProviderException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
