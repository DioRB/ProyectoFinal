package anteproyecto;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Album {
    int id;
    String titulo;
    LocalDate fechaLanzamiento;
    String descripcion;
    Artista artista;
    List<Genero> generos;

    public Album(int id, String titulo, LocalDate fechaLanzamiento, String descripcion, Artista artista) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
        this.artista = artista;
        this.generos = new ArrayList<>();
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

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
/*
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    public double getPuntuacionPromedio() {
        double suma = 0;
        int cantidad = 0;

        for (Cancion cancion : canciones) {
            double promedioCancion = cancion.getPromedioPuntuaciones();
            suma += promedioCancion;
            cantidad++;
        }

        return cantidad > 0 ? suma / cantidad : 0;
    }
    
    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }
    
    public void eliminarCancion(Cancion cancion){
        canciones.remove(cancion);  
    }*/
}
