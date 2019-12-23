package com.revenat.ext.cityregister.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Vitaliy Dragun
 */
public class PoolConnectionBuilder implements ConnectionBuilder {

    private final DataSource dataSource;

    public PoolConnectionBuilder() {
        try {
            final Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister");

        } catch (final NamingException e) {
            throw new ConfigException("Can not get dataSource", e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
