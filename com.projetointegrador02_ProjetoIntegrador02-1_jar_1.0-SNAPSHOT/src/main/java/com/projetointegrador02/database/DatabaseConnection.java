/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetointegrador02.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class DatabaseConnection {
    private Connection connection;

    private final String baseUrl = "jdbc:mysql://";
    private String user;
    private String password;
    private String database;
    private String server;
    private int port;

    public DatabaseConnection(
        String user, String password, String database, String server, int port
    ) throws SQLException {
        this.user = user;
        this.password = password;
        this.database = database;
        this.server = server;
        this.port = port;

        StringBuilder urlTemp = new StringBuilder(baseUrl);
        urlTemp.append(server).append(":").append(port).append("/").append(database);

        this.connection = DriverManager.getConnection(urlTemp.toString(), user, password);
    }

    public Connection getConnection() {
        return connection;
    }
    
}
