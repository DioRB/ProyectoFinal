package anteproyecto;

public class Puntuacion {
    int id;
    Cancion cancion;
    Usuario usuario;
    String descripcion;
    int instrumental;
    int letra;
    int impacto;

    public Puntuacion(int id, Cancion cancion, Usuario usuario, String descripcion, int instrumental, int letra, int impacto) {
        this.id = id;
        this.cancion = cancion;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.instrumental = instrumental;
        this.letra = letra;
        this.impacto = impacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getInstrumental() {
        return instrumental;
    }

    public void setInstrumental(int instrumental) {
        this.instrumental = instrumental;
    }

    public int getLetra() {
        return letra;
    }

    public void setLetra(int letra) {
        this.letra = letra;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }
    
    double getPromedio(){
        return (instrumental + letra + impacto)/3;
    }
        
}
