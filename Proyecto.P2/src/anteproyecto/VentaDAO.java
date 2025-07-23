/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anteproyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Statement;

public class VentaDAO {

    public static int guardarVenta(Venta venta) throws SQLException {
        Connection conn = ConexionDB.obtenerConexion();
        String sql = "INSERT INTO Ventas (IdCliente, IdMetodoPago, Fecha, Total) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, venta.getCliente().getId());
        stmt.setInt(2, venta.getMetodoPago().getId());
        stmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
        stmt.setDouble(4, venta.calcularTotal());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // ID generado de la venta
        }
        throw new SQLException("No se generó ID de venta.");
    }

    public static void guardarItemVenta(ItemVenta item, int idVenta) throws SQLException {
        Connection conn = ConexionDB.obtenerConexion();
        String sql = "INSERT INTO ItemVenta (IdVenta, IdProducto, Cantidad, Subtotal) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idVenta);
        stmt.setInt(2, item.getProducto().getIdProducto());
        stmt.setInt(3, item.getCantidad());
        stmt.setDouble(4, item.getSubtotal());
        stmt.executeUpdate();
    }
}
