/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos_coffeeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pongo
 */
public class Koneksi {
   public static Connection getConnection(){
       try {
           String url = "jdbc:mysql://localhost:3306/db_kasir_kopi";
           String user = "root";
           String pass = "";
           
           return DriverManager.getConnection(url, user, pass);
       } catch (Exception e) {
           System.out.println("Koneksi gagal"+ e.getMessage());
       }
       return null;
}
}
