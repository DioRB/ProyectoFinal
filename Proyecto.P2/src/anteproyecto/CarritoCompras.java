package anteproyecto;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {

    private List<ItemVenta> items;
    private Cliente cliente;
    
    public CarritoCompras() {
        this.items = new ArrayList<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemVenta item : items) {
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemVenta(producto, cantidad));
    }

    public void eliminarProducto(int productoId) {
        items.removeIf(item -> item.getProducto().getIdProducto() == productoId);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemVenta item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void vaciar() {
        items.clear();
    }

    public List<ItemVenta> getItems() {
        return items;
    }
    
    public void mostrarContenido() {
    if (items.isEmpty()) {
        System.out.println("El carrito está vacío.\n");
        return;
    }
    
    System.out.println("Contenido del carrito:");
    for (ItemVenta item : items) {
        System.out.println("- " + item.getProducto().getDescripcion()
                           + " x" + item.getCantidad()
                           + " = $" + item.getSubtotal());
    }
    System.out.println("Total: $" + calcularTotal());
    System.out.println("----------------------------------");
}

}
