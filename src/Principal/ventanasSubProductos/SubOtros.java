
package Principal.ventanasSubProductos;

/**
 *
 * @author NatxosS
 */
import Principal.VentanaPrincipal;
import Vista.*;
import Acciones.pedido.AccionesPedidoOtros;

public class SubOtros extends javax.swing.JPanel {

    /**
     * Creates new form SubOtros
     */
    public int botonSeleccionado = 0;
    
    public String des1 = "cOTROSDA";
    public String precio1 = "0.75";
    
    public String des2 = "Cola";
    public String precio2 = "69";
    
    public String des3 = "FcOOTROSDA";
    public String precio3 = "4";
    
    public String des4 = "OTROS";
    public String precio4 = "12";
    
    public String des5 = "cOTROSIDA";
    public String precio5 = "32";
    
    public String des6 = "cOTROSez";
    public String precio6 = "52";
    
    public String des7 = "tiOTROSoo";
    public String precio7 = "3";
    
    public String des8 = "OTROS";
    public String precio8 = "3";
    
    public String des9 = "";
    public String precio9 = "";
    
    public VentanaPrincipal ventanaPrincipal;
    public VentanaProductos ventanaProductos;
    public AccionesPedidoOtros accionesOtros;
    
    static Integer cantidad1 = 0;
    static Integer cantidad2 = 0;
    static Integer cantidad3 = 0;
    static Integer cantidad4 = 0;
    static Integer cantidad5 = 0;
    static Integer cantidad6 = 0;
    static Integer cantidad7 = 0;
    static Integer cantidad8 = 0;
    static Integer cantidad9 = 0;
    
    public SubOtros() {
        
        initComponents();
    }
    
    public SubOtros(VentanaPrincipal ventanaPrin, VentanaProductos ventanaProd) {
       
        this.setVentanaPrincipal(ventanaPrin);
        this.ventanaProductos = ventanaProd;
        this.accionesOtros = new AccionesPedidoOtros(this);
        initComponents();
    }

    public VentanaPrincipal getVentanaPrincipal() {
        
        return ventanaPrincipal;
    }
    
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
     //////////////////////////////////////// METODOS ///////////////////////////////////
    
    public void limpiarCantidades() {
        
        cantidad1 = 0;
        cantidad2 = 0;
        cantidad3 = 0;
        cantidad4 = 0;
        cantidad5 = 0;
        cantidad6 = 0;
        cantidad7 = 0;
        cantidad8 = 0;
        cantidad9 = 0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSubProductos = new javax.swing.JPanel();
        panelOtro1 = new javax.swing.JPanel();
        btnOtro1 = new javax.swing.JButton();
        panelOtro2 = new javax.swing.JPanel();
        btnOtro2 = new javax.swing.JButton();
        panelOtro3 = new javax.swing.JPanel();
        btnOtro3 = new javax.swing.JButton();
        panelOtro4 = new javax.swing.JPanel();
        btnOtro4 = new javax.swing.JButton();
        panelOtro5 = new javax.swing.JPanel();
        btnOtro5 = new javax.swing.JButton();
        panelOtro6 = new javax.swing.JPanel();
        btnOtro6 = new javax.swing.JButton();
        panelOtro7 = new javax.swing.JPanel();
        btnOtro7 = new javax.swing.JButton();
        panelOtro8 = new javax.swing.JPanel();
        btnOtro8 = new javax.swing.JButton();
        panelOtro9 = new javax.swing.JPanel();
        btnOtro9 = new javax.swing.JButton();

        panelSubProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        panelSubProductos.setLayout(new java.awt.GridLayout(3, 5, 2, 2));

        panelOtro1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro1.setLayout(new java.awt.BorderLayout());

        btnOtro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_pan.jpg"))); // NOI18N
        btnOtro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro1ActionPerformed(evt);
            }
        });
        panelOtro1.add(btnOtro1, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro1);

        panelOtro2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro2.setLayout(new java.awt.BorderLayout());

        btnOtro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_patatas.jpg"))); // NOI18N
        btnOtro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro2ActionPerformed(evt);
            }
        });
        panelOtro2.add(btnOtro2, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro2);

        panelOtro3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro3.setLayout(new java.awt.BorderLayout());

        btnOtro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_ensalada.jpg"))); // NOI18N
        btnOtro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro3ActionPerformed(evt);
            }
        });
        panelOtro3.add(btnOtro3, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro3);

        panelOtro4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro4.setLayout(new java.awt.BorderLayout());

        btnOtro4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_fruta.jpg"))); // NOI18N
        btnOtro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro4ActionPerformed(evt);
            }
        });
        panelOtro4.add(btnOtro4, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro4);

        panelOtro5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro5.setLayout(new java.awt.BorderLayout());

        btnOtro5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_mahonesaOtros.jpg"))); // NOI18N
        btnOtro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro5ActionPerformed(evt);
            }
        });
        panelOtro5.add(btnOtro5, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro5);

        panelOtro6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro6.setLayout(new java.awt.BorderLayout());

        btnOtro6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnOtro6.setForeground(new java.awt.Color(255, 0, 0));
        btnOtro6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_ingredientes.jpg"))); // NOI18N
        btnOtro6.setText("Ingrediente extra");
        btnOtro6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro6ActionPerformed(evt);
            }
        });
        panelOtro6.add(btnOtro6, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro6);

        panelOtro7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro7.setLayout(new java.awt.BorderLayout());

        btnOtro7.setText("Vacio");
        btnOtro7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro7ActionPerformed(evt);
            }
        });
        panelOtro7.add(btnOtro7, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro7);

        panelOtro8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro8.setLayout(new java.awt.BorderLayout());

        btnOtro8.setText("Vacio");
        btnOtro8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro8ActionPerformed(evt);
            }
        });
        panelOtro8.add(btnOtro8, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro8);

        panelOtro9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelOtro9.setLayout(new java.awt.BorderLayout());

        btnOtro9.setText("Vacio");
        btnOtro9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtro9ActionPerformed(evt);
            }
        });
        panelOtro9.add(btnOtro9, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelOtro9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSubProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelSubProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

////////////////////// EVENTOS SUBPRODUCTOS  /////////////////////////////////////////
    
    private void btnOtro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro1ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad1 != 0) {
            if (cant == 0) {                                                    
                cantidad1 = cantidad1 + 1;
            } else {
                cantidad1 = cantidad1 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad1 = 1;
            } else {
                cantidad1 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio1);
        Double subTotal = (precio * cantidad1) - (((precio * cantidad1)/100) * descuento);

        if (!btnOtro1.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des1);
                ventanaProductos.setTxtPrecio(precio1);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des1, precio, descuento, cantidad1);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro1ActionPerformed

    private void btnOtro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro2ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad2 != 0) {
            if (cant == 0) {                                                    
                cantidad2 = cantidad2 + 1;
            } else {
                cantidad2 = cantidad2 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad2 = 1;
            } else {
                cantidad2 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio2);
        Double subTotal = (precio * cantidad2) - (((precio * cantidad2)/100) * descuento);

        if (!btnOtro2.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des2);
                ventanaProductos.setTxtPrecio(precio2);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des2, precio, descuento, cantidad2);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro2ActionPerformed

    private void btnOtro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro3ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad3 != 0) {
            if (cant == 0) {                                                    
                cantidad3 = cantidad3 + 1;
            } else {
                cantidad3 = cantidad3 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad3 = 1;
            } else {
                cantidad3 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio3);
        Double subTotal = (precio * cantidad3) - (((precio * cantidad3)/100) * descuento);

        if (!btnOtro3.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des3);
                ventanaProductos.setTxtPrecio(precio3);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des3, precio, descuento, cantidad3);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro3ActionPerformed

    private void btnOtro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro4ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad4 != 0) {
            if (cant == 0) {                                                    
                cantidad4 = cantidad4 + 1;
            } else {
                cantidad4 = cantidad4 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad4 = 1;
            } else {
                cantidad4 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio4);
        Double subTotal = (precio * cantidad4) - (((precio * cantidad4)/100) * descuento);

        if (!btnOtro4.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des4);
                ventanaProductos.setTxtPrecio(precio4);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des4, precio, descuento, cantidad4);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro4ActionPerformed

    private void btnOtro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro5ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad5 != 0) {
            if (cant == 0) {                                                    
                cantidad5 = cantidad5 + 1;
            } else {
                cantidad5 = cantidad5 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad5 = 1;
            } else {
                cantidad5 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio5);
        Double subTotal = (precio * cantidad5) - (((precio * cantidad5)/100) * descuento);

        if (!btnOtro5.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des5);
                ventanaProductos.setTxtPrecio(precio5);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des5, precio, descuento, cantidad5);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro5ActionPerformed

    private void btnOtro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro6ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad6 != 0) {
            if (cant == 0) {                                                    
                cantidad6 = cantidad6 + 1;
            } else {
                cantidad6 = cantidad6 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad6 = 1;
            } else {
                cantidad6 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio6);
        Double subTotal = (precio * cantidad6) - (((precio * cantidad6)/100) * descuento);

        if (!btnOtro6.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des6);
                ventanaProductos.setTxtPrecio(precio6);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des6, precio, descuento, cantidad6);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro6ActionPerformed

    private void btnOtro7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro7ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad7 != 0) {
            if (cant == 0) {                                                    
                cantidad7 = cantidad7 + 1;
            } else {
                cantidad7 = cantidad7 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad7 = 1;
            } else {
                cantidad7 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio7);
        Double subTotal = (precio * cantidad7) - (((precio * cantidad7)/100) * descuento);

        if (!btnOtro7.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des7);
                ventanaProductos.setTxtPrecio(precio7);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des7, precio, descuento, cantidad7);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro7ActionPerformed

    private void btnOtro8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro8ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad8 != 0) {
            if (cant == 0) {                                                    
                cantidad8 = cantidad8 + 1;
            } else {
                cantidad8 = cantidad8 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad8 = 1;
            } else {
                cantidad8 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio8);
        Double subTotal = (precio * cantidad8) - (((precio * cantidad8)/100) * descuento);

        if (!btnOtro8.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des8);
                ventanaProductos.setTxtPrecio(precio8);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des8, precio, descuento, cantidad8);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro8ActionPerformed

    private void btnOtro9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtro9ActionPerformed
        
        Integer cant = ventanaPrincipal.cant;
        if (cantidad9 != 0) {
            if (cant == 0) {                                                    
                cantidad9 = cantidad9 + 1;
            } else {
                cantidad9 = cantidad9 + cant;
                ventanaPrincipal.cant = 0;
            }
        } else {
            if (cant == 0) {                                                    
                cantidad9 = 1;
            } else {
                cantidad9 = cant;
                ventanaPrincipal.cant = 0;
            }
        }
        Integer codigo = 0001;
        Integer descuento = 10;
        Double precio = Double.parseDouble(precio9);
        Double subTotal = (precio * cantidad9) - (((precio * cantidad9)/100) * descuento);

        if (!btnOtro9.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des9);
                ventanaProductos.setTxtPrecio(precio9);
            } else {
                if (estado == 3) {
                    
                    accionesOtros.meterProducto(codigo, des9, precio, descuento, cantidad9);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnOtro9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtro1;
    private javax.swing.JButton btnOtro2;
    private javax.swing.JButton btnOtro3;
    private javax.swing.JButton btnOtro4;
    private javax.swing.JButton btnOtro5;
    private javax.swing.JButton btnOtro6;
    private javax.swing.JButton btnOtro7;
    private javax.swing.JButton btnOtro8;
    private javax.swing.JButton btnOtro9;
    private javax.swing.JPanel panelOtro1;
    private javax.swing.JPanel panelOtro2;
    private javax.swing.JPanel panelOtro3;
    private javax.swing.JPanel panelOtro4;
    private javax.swing.JPanel panelOtro5;
    private javax.swing.JPanel panelOtro6;
    private javax.swing.JPanel panelOtro7;
    private javax.swing.JPanel panelOtro8;
    private javax.swing.JPanel panelOtro9;
    private javax.swing.JPanel panelSubProductos;
    // End of variables declaration//GEN-END:variables
}
