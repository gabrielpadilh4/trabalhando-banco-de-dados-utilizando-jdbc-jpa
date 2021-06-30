package com.github.gabrielpadilh4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static void main(String[] args) {

        String urlConnection = "jdbc:mysql://localhost:3306/digital_innovation_one?useTimezone=true&serverTimezone=UTC";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(urlConnection, "root", "my-secure-password");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                connection.close();
                System.out.println("Conectado com sucesso!");
            } catch (SQLException sqlException) {
                // do nothing
            }
        }
    }
}
