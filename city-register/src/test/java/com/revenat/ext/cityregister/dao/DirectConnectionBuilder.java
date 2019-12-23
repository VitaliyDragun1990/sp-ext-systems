package com.revenat.ext.cityregister.dao;

import com.revenat.ext.cityregister.config.ConnectionBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vitaliy Dragun
 */
public class DirectConnectionBuilder implements ConnectionBuilder {

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/city_register", "postgres", "19900225");
    }
}
