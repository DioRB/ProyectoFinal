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

public class UsuarioDAO {

        public boolean existeUsuarioPorDocumento(String numDoc) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Usuarios WHERE NumeroDoc = ?";

        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, numDoc);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }

        return false;
    }
    
    public void insertarUsuario(String nombre, String numDoc, String telefono, String correo) throws SQLException {
        String sql = "INSERT INTO Usuarios (Nombre, NumeroDoc, NumeroTel, Correo) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, numDoc);
            ps.setString(3, telefono);
            ps.setString(4, correo);

            ps.executeUpdate();
            System.out.println("✅ Usuario insertado correctamente");
        }
    }
}

