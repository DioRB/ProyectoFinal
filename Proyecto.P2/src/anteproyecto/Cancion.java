package anteproyecto;

import java.util.List;
import java.util.ArrayList;

public class Cancion {
    int id;
    String titulo;
    String descripcion;
    Album album;
    List<Genero> generosSecundarios;
    List<Puntuacion> puntuaciones;

    public Cancion(int id, String titulo, String descripcion, Album album) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.album = album;
        this.generosSecundarios = new ArrayList<>();
        this.puntuaciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Genero> getGenerosSecundarios() {
        return generosSecundarios;
    }

    public void setGenerosSecundarios(List<Genero> generosSecundarios) {
        this.generosSecundarios = generosSecundarios;
    }

    public List<Puntuacion> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(List<Puntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }
    
    
    public double getPromedioPuntuaciones() {
        double suma = 0;
        int cantidad = 0;

        for (Puntuacion p : puntuaciones) {
            suma += p.getPromedio();
            cantidad++;
        }

        return cantidad > 0 ? suma / cantidad : 0;
    }
    
    public void agregarPuntuacion(Puntuacion puntuacion) {
        puntuaciones.add(puntuacion);
    }
    
    public void eliminarPuntuacion(Puntuacion puntuacion){
        puntuaciones.remove(puntuacion);  
    }
    
    public void agregarGenero(Genero genero) {
        generosSecundarios.add(genero);
    }
    
    public void eliminarGenero(Genero genero){
        generosSecundarios.remove(genero);  
    }
}
