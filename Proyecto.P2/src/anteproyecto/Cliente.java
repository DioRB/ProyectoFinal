package anteproyecto;
import java.util.List;
import java.util.ArrayList;

public class Cliente extends Usuario {
    
    private List<Venta> historialVentas = new ArrayList<>();
    private CarritoCompras carrito; 
    public Cliente() {
        super();
        this.carrito = new CarritoCompras();
    }

    public Cliente(int id, String nombre, String correo, String contraseña, String telefono, Rol rol) {
        super(id, nombre, correo, contraseña, telefono, rol);
        this.carrito = new CarritoCompras();
}

    public CarritoCompras getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompras carrito) {
        this.carrito = carrito;
    }
    
    public void agregarVenta(Venta venta) {
    historialVentas.add(venta);
    }
    
    public void mostrarHistorialVentas() {
        if (historialVentas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        for (Venta venta : historialVentas) {
            System.out.println("ID Venta: " + venta.getId());
            System.out.println("Fecha: " + venta.getFecha());
            System.out.println("Método de Pago: " + venta.getMetodoPago().getTipo());

            System.out.println("Productos comprados:");
            for (ItemVenta item : venta.getItems()) {
                System.out.println("- " + item.getProducto().getDescripcion() + " x" + item.getCantidad());
            }
            
            System.out.println("Total: $" + venta.calcularTotal());
            System.out.println("----------------------------------");
        }
        
        
}

    public Venta realizarVenta(MetodoPago metodoPago) {
    List<ItemVenta> items = carrito.getItems();

    if (items.isEmpty()) {
        throw new IllegalStateException("El carrito está vacío. No se puede realizar la venta.");
    }
    
    for (ItemVenta item : items) {
        if (!item.getProducto().hayStockSuficiente(item.getCantidad())) {
            throw new IllegalArgumentException("Stock insuficiente para el producto: " + item.getProducto().getDescripcion());
        }
    }

    for (ItemVenta item : items) {
        item.getProducto().disminuirStock(item.getCantidad());
    }
    
    Venta venta = new Venta(
        historialVentas.size() + 1,
        java.time.LocalDate.now(),
        metodoPago,
        new ArrayList<>(items),
        this
    );
 
    historialVentas.add(venta);
    
    carrito.vaciarCarrito();

    return venta;
}

}
