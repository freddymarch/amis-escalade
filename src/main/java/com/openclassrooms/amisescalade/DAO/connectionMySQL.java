package com.openclassrooms.amisescalade.DAO;

import java.sql.*;

public class connectionMySQL {

    public static void connexionDB(String[]args){

         String URL = "jdbc:mysql://localhost:3306/amis-escalade";
         String userName = "amis-escalade";
         String passworld = "amis-escalade";

         try {
             Connection con = DriverManager.getConnection(URL, userName, passworld);

             Statement statement = con.createStatement();

             statement.execute("insert into products (name) values('clavier')");

             ResultSet result = statement.executeQuery("Select * from products where id =1");
             while (result.next()){
             }
         }catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
