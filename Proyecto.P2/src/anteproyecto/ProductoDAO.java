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

public class ProductoDAO {

    public static List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT Id, Descripcion, Precio, Stock, Estado FROM Producto";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("Id");
                String descripcion = rs.getString("Descripcion");
                double valorUnitario = rs.getDouble("Precio");
                int stock = rs.getInt("Stock");
                boolean estado = rs.getBoolean("Estado");

                Producto producto = new Producto(id, descripcion, valorUnitario, estado, stock);
                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }
}


