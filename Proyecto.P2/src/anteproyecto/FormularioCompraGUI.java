/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package anteproyecto;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.util.List;
/**
 *
 * @author ASUS
 */


public class FormularioCompraGUI extends javax.swing.JFrame {

    
    private Cliente cliente; // Cliente logueado
    private List<Producto> productosDisponibles;
    private List<MetodoPago> metodosPago;
    private String nombreUsuario;

    public FormularioCompraGUI() {
    }

    
public FormularioCompraGUI(Cliente cliente, List<Producto> productos, List<MetodoPago> metodos, String nombreUsuario) {
    setTitle("Compras");
    
    initComponents(); 
    
    // Estilo de etiquetas y campos
Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 20);
Font fuenteTexto = new Font("Segoe UI", Font.PLAIN, 14);

jLabel1.setFont(fuenteTitulo);
jLabel1.setForeground(new Color(44, 62, 80)); // Azul oscuro suave

jLabel2.setFont(fuenteTexto);
jLabel2.setForeground(new Color(52, 73, 94)); // Gris oscuro

comboProductos.setFont(fuenteTexto);
comboMetodoPago.setFont(fuenteTexto);
txtCantidad.setFont(fuenteTexto);

resumen.setFont(new Font("Monospaced", Font.PLAIN, 13));
resumen.setBackground(new Color(248, 249, 250)); // Gris muy claro
resumen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

// Botones
btnAgregarAlCarrito.setFont(fuenteTexto);
btnAgregarAlCarrito.setBackground(new Color(39, 174, 96)); // Verde
btnAgregarAlCarrito.setForeground(Color.WHITE);
btnAgregarAlCarrito.setFocusPainted(false);

btnComprar.setFont(fuenteTexto);
btnComprar.setBackground(new Color(41, 128, 185)); // Azul
btnComprar.setForeground(Color.WHITE);
btnComprar.setFocusPainted(false);

vaciarCarro.setFont(fuenteTexto);
vaciarCarro.setBackground(new Color(192, 57, 43)); // Rojo
vaciarCarro.setForeground(Color.WHITE);
vaciarCarro.setFocusPainted(false);

regresarBtn.setFont(fuenteTexto);
regresarBtn.setBackground(new Color(192, 57, 43)); // Gris
regresarBtn.setForeground(Color.WHITE);
regresarBtn.setFocusPainted(false);

// Fondo del formulario
getContentPane().setBackground(new Color(236, 240, 241)); // Gris claro

    
    this.nombreUsuario = nombreUsuario;
    this.cliente = cliente;
    this.productosDisponibles = productos;
    this.metodosPago = metodos;
    
    this.productosDisponibles = ProductoDAO.obtenerTodos();

    comboProductos.removeAllItems();
    for (Producto p : productosDisponibles) {
        comboProductos.addItem(p);
    }


    this.metodosPago = MetodoPagoDAO.obtenerTodos();

    comboMetodoPago.removeAllItems();
    for (MetodoPago m : metodosPago) {
        comboMetodoPago.addItem(m);
}

    btnAgregarAlCarrito.addActionListener(e -> agregarProductoAlCarrito());
    btnComprar.addActionListener(e -> realizarCompra());

    setSize(1000, 700);
    setLocationRelativeTo(null);
    actualizarResumenCarrito(); 
    setVisible(true);


}
    
private void agregarProductoAlCarrito() {
    try {
        Producto producto = (Producto) comboProductos.getSelectedItem();
        int cantidad = Integer.parseInt(txtCantidad.getText());

        if (!producto.hayStockSuficiente(cantidad)) {
            JOptionPane.showMessageDialog(this,
            "Stock insuficiente. Solo quedan " + producto.getStock() + " unidades disponibles.",
            "Stock insuficiente",
            JOptionPane.WARNING_MESSAGE);

            return;
        }

            if (producto.hayStockSuficiente(cantidad)) {
        ItemVenta item = new ItemVenta(producto, cantidad);
        cliente.getCarrito().agregarProducto(producto, cantidad);


        actualizarResumenCarrito();
    } else {
        JOptionPane.showMessageDialog(this, "Stock insuficiente.");
    }   

        JOptionPane.showMessageDialog(this,
        "Producto agregado exitosamente al carrito.",
        "Éxito",
        JOptionPane.INFORMATION_MESSAGE);


        actualizarResumenCarrito(); 

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Cantidad inválida");

    }
}


private void actualizarResumenCarrito() {
    StringBuilder resumenTexto = new StringBuilder("Resumen del carrito:\n");

    double total = 0;

    for (ItemVenta item : cliente.getCarrito().getItems()) {
        Producto producto = item.getProducto();
        int cantidad = item.getCantidad();
        double subtotal = item.getSubtotal();

        resumenTexto.append(producto.getDescripcion())
                    .append(" | Cantidad: ").append(cantidad)
                    .append(" | Subtotal: $").append(String.format("%.2f", subtotal))
                    .append("\n");

        total += subtotal;
    }

    resumenTexto.append("\nTOTAL: $").append(String.format("%.2f", total));

    resumen.setText(resumenTexto.toString());
}


        
private void realizarCompra() {
    MetodoPago metodo = (MetodoPago) comboMetodoPago.getSelectedItem();
    try {
        Venta venta = cliente.realizarVenta(metodo);
        
        int idVenta = VentaDAO.guardarVenta(venta);
        
        for (ItemVenta item : venta.getItems()) {
            VentaDAO.guardarItemVenta(item, idVenta);
        }
        
        
        JOptionPane.showMessageDialog(this,
            "¡Compra realizada con éxito!\nTotal: $" + venta.calcularTotal(),
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE);

        vaciarCarrito();
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Ocurrió un error durante la compra:\n" + ex.getMessage(),
            "Error de compra",
            JOptionPane.ERROR_MESSAGE);
    }
}


    private void vaciarCarrito() {
        cliente.getCarrito().vaciar(); 
        actualizarResumenCarrito();    
        JOptionPane.showMessageDialog(this,
        "El carrito ha sido vaciado exitosamente.",
        "Carrito limpio",
        JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regresarBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboProductos = new javax.swing.JComboBox();
        txtCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboMetodoPago = new javax.swing.JComboBox();
        btnAgregarAlCarrito = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumen = new javax.swing.JTextArea();
        vaciarCarro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regresarBtn.setText("Regresar");
        regresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(regresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Artifakt Element Book", 1, 12)); // NOI18N
        jLabel1.setText("¿Que deseas comprar?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductosActionPerformed(evt);
            }
        });
        getContentPane().add(comboProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 130, 30));

        jLabel2.setText("Cantidad:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        comboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        btnAgregarAlCarrito.setText("Agregar al carrito");
        btnAgregarAlCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlCarritoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarAlCarrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, -1, -1));

        btnComprar.setFont(new java.awt.Font("Artifakt Element Book", 1, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        getContentPane().add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 520, -1, -1));

        resumen.setColumns(20);
        resumen.setRows(5);
        jScrollPane1.setViewportView(resumen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 330, -1));

        vaciarCarro.setText("Vaciar carrito");
        vaciarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaciarCarroActionPerformed(evt);
            }
        });
        getContentPane().add(vaciarCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarBtnActionPerformed
    this.dispose();
    SwingUtilities.invokeLater(() -> new VentanaInicioGUI(nombreUsuario).setVisible(true));
    }//GEN-LAST:event_regresarBtnActionPerformed

    private void comboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductosActionPerformed

    }//GEN-LAST:event_comboProductosActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarAlCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlCarritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarAlCarritoActionPerformed

    private void vaciarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarCarroActionPerformed
        vaciarCarrito();
    }//GEN-LAST:event_vaciarCarroActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioCalificacionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCalificacionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCalificacionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCalificacionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioCalificacionGUI().setVisible(true);
            }
        }); 
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAlCarrito;
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox comboMetodoPago;
    private javax.swing.JComboBox comboProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JTextArea resumen;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JButton vaciarCarro;
    // End of variables declaration//GEN-END:variables
}
