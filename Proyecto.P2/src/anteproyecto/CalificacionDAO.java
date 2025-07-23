package anteproyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// En CalificacionDAO.java
public class CalificacionDAO {

    public void insertarCalificacion(String album, String usuario, double calificacion, String comentario) throws SQLException {
        String sql = "INSERT INTO Calificaciones (Album, Usuario, Calificacion, Comentario) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, album);
            ps.setString(2, usuario);
            ps.setDouble(3, calificacion);
            ps.setString(4, comentario);

            ps.executeUpdate();
            System.out.println("✅ Calificación insertada correctamente");
        }
    }
}


