/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anteproyecto;

/**
 *
 * @author ASUS
 */
import java.sql.*;

public class TestConexion {
public static void main(String[] args) {
    try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection con = ConexionDB.obtenerConexion();
        System.out.println("Conexión exitosa a Access");
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
