package anteproyecto;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.SwingUtilities;

public class Anteproyecto {

    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> new InicioRegistro());
        
        
        /**    
    Rol rolCliente = new Rol(2, "Cliente", true);
    Cliente cliente = new Cliente(1, "Diego", "correo@correo", "contrasena", "123410", rolCliente);

    Producto vinilo1 = new Producto(1, "Vinilo - OK Computer", 120.0, true, 10);
    Producto vinilo2 = new Producto(2, "Vinilo - To Pimp a Butterfly", 150.0, true, 5);
    Producto cuadro = new Producto(3, "Cuadro Currents", 60.0, true, 3);

    MetodoPago pago1 = new MetodoPago(1, "Tarjeta débito");
    MetodoPago pago2 = new MetodoPago(2, "Tarjeta crédito");

        List<Producto> productos = Arrays.asList(vinilo1, vinilo2, cuadro);
        List<MetodoPago> metodos = Arrays.asList(pago1, pago2);

    SwingUtilities.invokeLater(() -> new FormularioCompraGUI(cliente, productos, metodos));
        
        Artista Radiohead = new Artista(1,"Radiohead", "Banda británica de rock");
        
        Album OKComputer = new Album(1,"OK Computer",LocalDate.of(1997, 5, 28), "Su mejor album", Radiohead);  
        
        Cancion LetDown = new Cancion(1, "Let Down", "Descripción: Let Down", OKComputer);
        Cancion ExitMusic = new Cancion(2, "Exit Music (For a film)", "Descripción: Exit Music", OKComputer);

        Genero RockAlternativo = new Genero(1, "Rock Alternativo", "Subgénero del rock que tiene sus orígenes e influencias musicales en estilos musicales tan variados como el punk rock, el post-punk, el new wave, el hardcore punk, el folk rock y el pop rock.");

        Usuario Diego = new Usuario(1, "Persona", "yo@yo", "contraseña");
        
        Puntuacion puntuacion1 = new Puntuacion(1, LetDown, Diego, "Mi puntuación para let down", 8, 8, 8);
        Puntuacion puntuacion2 = new Puntuacion(2, ExitMusic, Diego, "Mi puntuación para ExitMusic", 10, 10, 10);
        
        
        LetDown.agregarGenero(RockAlternativo);
        
        Radiohead.agregarAlbum(OKComputer);
        OKComputer.agregarCancion(LetDown);
        OKComputer.agregarCancion(ExitMusic);

        LetDown.agregarPuntuacion(puntuacion1);
        ExitMusic.agregarPuntuacion(puntuacion2);
        
        System.out.println("Artista: " + Radiohead.getNombre());
        System.out.println("Álbum: " + OKComputer.getTitulo());
        System.out.println("Canción: " + ExitMusic.getTitulo());
        System.out.println("Puntuación promedio: " + puntuacion1.getPromedio());
        System.out.println("Albumes de " + Radiohead.getNombre()+ ": " + Radiohead.getAlbumes().get(0).getTitulo());
        System.out.println("Hay 2 canciones en el album " + Radiohead.getNombre() + " y son: " + Radiohead.getAlbumes().get(0).getCanciones().get(0).getTitulo() +", "+ Radiohead.getAlbumes().get(0).getCanciones().get(1).getTitulo());
        
        System.out.println("La cancion " + LetDown.getTitulo() +" tiene una puntuación de " + LetDown.getPuntuaciones().get(0).getPromedio() + " dada por el usuario " + LetDown.getPuntuaciones().get(0).getUsuario().getNombre());
        System.out.println("La cancion " + LetDown.getTitulo() + " es del género: " + LetDown.getGenerosSecundarios().get(0).getNombre() + ". Descripción:" + LetDown.getGenerosSecundarios().get(0).getDescripcion());
        
        System.out.println("El album " + OKComputer.getTitulo() + "tiene una puntuación promedio de: " + OKComputer.getPuntuacionPromedio());
        
               
        Rol rolAdmin = new Rol(1, "Administrador", true);
        Rol rolCliente = new Rol(2, "Cliente", true);
        
        Cliente cliente = new Cliente(1, "Diego", "correo@correo", "contrasena", "123410", rolCliente);
        Cliente cliente2 = new Cliente(2, "Gabriela", "coorea@co", "contraseña", "9876", rolCliente);
        
        Usuario admin = new Administrador();

        
        
        Producto vinilo1 = new Producto(1, "Vinilo - OK Computer", 120.0, true, 10);
        Producto vinilo2 = new Producto(2, "Vinilo - To Pimp a Butterfly", 150.0, true, 5);
        Producto cuadro = new Producto(3, "Cuadro Currents", 60.0, true, 3);
              
        MetodoPago Metodopago1 = new MetodoPago(1, "Tarjeta débito");
        MetodoPago Metodopago2 = new MetodoPago(2, "Tarjeta crédito");
        MetodoPago Metodopago3 = new MetodoPago(3, "Efectivo");
        MetodoPago Metodopago4 = new MetodoPago(4, "Transferencia");
        

        
        CarritoCompras carro = new CarritoCompras();
        CarritoCompras carro2 = new CarritoCompras();

        cliente.getCarrito().agregarProducto(vinilo1, 1);
        cliente.getCarrito().agregarProducto(vinilo2, 3);
        
        
        try {
            Venta venta = cliente.realizarVenta(Metodopago1);
            System.out.println("¡Venta realizada con éxito!\n\n");
            cliente.mostrarHistorialVentas();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
      
        
        cliente.getCarrito().agregarProducto(cuadro, 10);
        
        try {
            Venta venta = cliente.realizarVenta(Metodopago1);
            System.out.println("¡Venta realizada con éxito!\n\n");
            cliente.mostrarHistorialVentas();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
        
        Venta venta = new Venta(1, LocalDate.now(), Metodopago1, new ArrayList<>(cliente.getCarrito().getItems()),cliente);
        
        cliente.agregarVenta(venta);

        cliente.getCarrito().mostrarContenido();
        
        cliente.getCarrito().vaciarCarrito();
        
        cliente.getCarrito().mostrarContenido();
        
        cliente.getCarrito().agregarProducto(cuadro, 5);
        
        Venta venta2 = new Venta(2, LocalDate.now(), Metodopago3, new ArrayList<>(cliente.getCarrito().getItems()),cliente);

        cliente.agregarVenta(venta2);
        
        cliente.mostrarHistorialVentas();
        
        
        cliente2.getCarrito().agregarProducto(vinilo2, 2);
        cliente2.getCarrito().agregarProducto(cuadro, 5);
        
        
        

        
        
        
        System.out.println("Total del carrito de " + cliente.getNombre() + ": $" + cliente.getCarrito().calcularTotal());
        System.out.println("Total del carrito de " + cliente2.getNombre() + ": $" + cliente2.getCarrito().calcularTotal());**/
    }
    
}
