/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anteproyecto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MetodoPagoDAO {

    public static List<MetodoPago> obtenerTodos() {
        List<MetodoPago> metodos = new ArrayList<>();
        String sql = "SELECT Id, Tipo FROM MetodoPago";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("Id");
                String tipo = rs.getString("Tipo");

                MetodoPago metodo = new MetodoPago(id, tipo);
                metodos.add(metodo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return metodos;
    }
}

