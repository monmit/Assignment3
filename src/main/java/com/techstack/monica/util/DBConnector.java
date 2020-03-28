package com.techstack.monica.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    private Connection connect;

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SchoolManagement?serverTimezone=UTC", "root", "Passw0rd");
        return connect;
    }
}


