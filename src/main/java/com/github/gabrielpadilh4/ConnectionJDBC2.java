package com.github.gabrielpadilh4;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJDBC2 {
    public static void main(String[] args) {
        String urlConnection = "jdbc:mysql://localhost:3306/digital_innovation_one?useTimezone=true&serverTimezone=UTC";

        // try with resources
        try(Connection connection = DriverManager.getConnection(urlConnection, "root", "my-secure-password")) {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
