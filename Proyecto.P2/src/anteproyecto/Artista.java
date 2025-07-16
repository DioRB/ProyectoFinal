package anteproyecto;
import java.util.List;
import java.util.ArrayList;

public class Artista {
    int id;
    String nombre;
    String descripcion;
    List<Album> albumes;

    public Artista(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.albumes = new ArrayList<>();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }
    
    public void agregarAlbum(Album album) {
        albumes.add(album);
    }
    
    public void eliminarAlbum(Album album){
        albumes.remove(album);  
    }

}
