/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopolilacolonia;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySql {
    
    private static final String URL = "jdbc:mysql://localhost:3306/proyectolacolonia";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (Exception e) {
            System.out.println("Error de conexión:"+e.toString());
        }
        return conn;
    }
    
}
