package com.seo.app.AdminAuthentication.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ConnectionService {

    @Value("${spring.datasource.url}")
    String datasourceUrl = "jdbc:mysql://localhost/seo_optimization?autoReconnect=true&useSSL=false";

    public Connection createConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(datasourceUrl, "root", "1234");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return connection;
    }
}