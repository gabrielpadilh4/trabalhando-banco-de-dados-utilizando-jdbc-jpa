package com.github.gabrielpadilh4.exercicio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static Connection connection;
    private static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/digital_innovation_one?useTimezone=true&serverTimezone=UTC";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "my-secure-password";

    public static Connection getConnection() {

        try {

            System.out.println("Acessando o banco de dados...");

            if (connection != null) {
                if (connection.isClosed()) {
                    connection = DriverManager.getConnection(URL_CONNECTION, DATABASE_USER, DATABASE_PASSWORD);

                    return connection;
                }

                return connection;
            }

            return connection = DriverManager.getConnection(URL_CONNECTION, DATABASE_USER, DATABASE_PASSWORD);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
