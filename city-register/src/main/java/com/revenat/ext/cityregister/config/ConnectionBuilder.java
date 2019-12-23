package com.revenat.ext.cityregister.config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Vitaliy Dragun
 */
public interface ConnectionBuilder {

    Connection getConnection() throws SQLException;
}
