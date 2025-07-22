
package anteproyecto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexionDB {
    private static final String RUTA = "C:/Users/ASUS/Desktop/Programacion/JAVA/POO/Proyecto.P2/ProyectoFinal.accdb";
    private static final String URL = "jdbc:ucanaccess://" + RUTA;

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
