package com.revenat.network.server.config;

import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.requireNonNull;

/**
 * @author Vitaliy Dragun
 */
public class Config {

    private static final String CONFIG_FILE_NAME = "server.properties";

    private static Properties properties;

    private Config() {
    }

    public static synchronized Properties getConfigProperties() {
        if (properties == null) {
            properties = loadFromFile(CONFIG_FILE_NAME);
        }
        return properties;
    }

    private static Properties loadFromFile(final String configFileName) {
        final Properties props = new Properties();
        try {
            props.load(requireNonNull(Config.class.getClassLoader().getResourceAsStream(configFileName)));
        } catch (final IOException e) {
            throw new ConfigException("Error while loading config file from " + configFileName, e);
        }
        return props;
    }

    public static class ConfigException extends RuntimeException {

        public ConfigException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
