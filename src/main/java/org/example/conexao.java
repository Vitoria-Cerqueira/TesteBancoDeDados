package org.example;

import java.sql.*;
import java.sql.ResultSet;

public class conexao {
    public static void main(String[] args) throws SQLException{
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testeDatabase","postgres","58235718");
            ResultSet rsClient = connection.createStatement().executeQuery("SELECT * FROM client");
            while(rsClient.next()){
                System.out.println("Name: " + rsClient.getString("clientName") + " Id: " + rsClient.getInt("idClient"));
            }
        }catch (ClassNotFoundException ex){
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco" + e.getMessage());
        } finally {
            if (connection != null){
                connection.close();
            }
        }


    }
}
