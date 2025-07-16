package anteproyecto;

import java.time.LocalDate;
import java.util.List;

public class Venta {
    private int id;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private List<ItemVenta> items;
    private Cliente cliente;

    public Venta() {
    }

    public Venta(int id, LocalDate fecha, MetodoPago metodoPago, List<ItemVenta> items, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.items = items;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<ItemVenta> getItems() {
        return items;
    }

    public void setItems(List<ItemVenta> items) {
        this.items = items;
    }

    public double calcularTotal() {
        return items.stream()
                    .mapToDouble(ItemVenta::getSubtotal)
                    .sum();
    }
}
