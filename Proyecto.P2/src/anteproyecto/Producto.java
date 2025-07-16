package anteproyecto;

public class Producto {
    private int idProducto;
    private String descripcion;
    private double valorUnitario;
    private boolean estado;
    private int stock;

    public Producto() {
    }

    public Producto(int idProducto, String descripcion, double valorUnitario, boolean estado, int stock) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.estado = estado;
        this.stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return valorUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setPrecio(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    public boolean hayStockSuficiente(int cantidadSolicitada) {
        return this.stock >= cantidadSolicitada;
    }

    
    public void disminuirStock(int cantidadVendida) {
        if (hayStockSuficiente(cantidadVendida)) {
            this.stock -= cantidadVendida;
        } else {
            throw new IllegalArgumentException("Stock insuficiente para el producto: " + descripcion);
        }
    }
}


