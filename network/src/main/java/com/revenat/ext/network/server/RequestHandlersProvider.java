package com.revenat.ext.network.server;

import com.revenat.ext.network.server.config.Config;

import java.util.Map;
import java.util.Properties;

import static java.lang.String.format;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

/**
 * @author Vitaliy Dragun
 */
public class RequestHandlersProvider {

    private static Map<String, GreetableRequestHandler> handlers;

    private RequestHandlersProvider() {
    }

    public static synchronized Map<String, GreetableRequestHandler> getRequestHandlers() {
        if (handlers == null) {
            handlers = loadHandlers();
        }
        return handlers;
    }

    private static Map<String, GreetableRequestHandler> loadHandlers() {
        final Properties properties = Config.getConfigProperties();

        return properties.keySet()
                .stream()
                .map(String::valueOf)
                .collect(toUnmodifiableMap(identity(), key -> buildHandler(properties.getProperty(key))));
    }

    @SuppressWarnings("unchecked")
    private static GreetableRequestHandler buildHandler(final String className) {
        try {
            final Class<? extends GreetableRequestHandler> handler = (Class<? extends GreetableRequestHandler>) Class.forName(className);
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
