package anteproyecto;

public class Administrador extends Usuario {

    public Administrador() {
        super();
    }

    public Administrador(int id, String nombre, String correo, String contraseña, String telefono, Rol rol) {
        super(id, nombre, correo, contraseña, telefono, rol);
    }

}
