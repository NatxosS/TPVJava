
package Principal.ventanasSubProductos;

/**
 *
 * @author NatxosS
 */
import Principal.VentanaPrincipal;
import Acciones.pedido.AccionesPedidoBebidas;
import Vista.VentanaProductos;

public class SubBebidas extends javax.swing.JPanel {

    /**
     * Creates new form SubBebidas
     */
    public VentanaPrincipal ventanaPrincipal;
    public VentanaProductos ventanaProductos;
    public AccionesPedidoBebidas accionesBebidas;
    
    public int botonSeleccionado = 0;
    
    public String des1 = "Agua 1.5 L";
    public String precio1 = "0.75";
    
    public String des2 = "Cola";
    public String precio2 = "1";
    
    public String des3 = "FantaN";
    public String precio3 = "2";
    
    public String des4 = "FantaL";
    public String precio4 = "3";
    
    public String des5 = "Neste";
    public String precio5 = "4";
    
    public String des6 = "cervez";
    public String precio6 = "6";
    
    public String des7 = "tintoo";
    public String precio7 = "3";
    
    public String des8 = "acuarios1";
    public String precio8 = "7";
    
    public String des9 = "";
    public String precio9 = "";
    
    static Integer cantidad1 = 0;
    static Integer cantidad2 = 0;
    static Integer cantidad3 = 0;
    static Integer cantidad4 = 0;
    static Integer cantidad5 = 0;
    static Integer cantidad6 = 0;
    static Integer cantidad7 = 0;
    static Integer cantidad8 = 0;
    static Integer cantidad9 = 0;
    
    public SubBebidas() {
        
        initComponents();
    }
    
    public SubBebidas(VentanaPrincipal ventanaPrin, VentanaProductos ventanaProd) {
        
        this.setVentanaPrincipal(ventanaPrin);
        this.ventanaProductos = ventanaProd;
        this.accionesBebidas = new AccionesPedidoBebidas(this);
        initComponents();
    }

////////////////////////////////////  ACCESO A VARIABLES  ////////////////////////////////////////
    
    public VentanaPrincipal getVentanaPrincipal() {
        
        return ventanaPrincipal;
    }
    
    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
    public String getDesc1() {
        
        return des1;
    }
    
    public void setDes1(String des1) {
        
        this.des1 = des1;
    }
    
    public String getPrecio1() {
        
        return precio1;
    }
    
    public void setPrecio1(String precio1) {
        
        this.precio1 = precio1;
    }
    
    public String getDesc2() {
        
        return des2;
    }
    
    public void setDes2(String des2) {
        
        this.des2 = des2;
    }
    
    public String getPrecio2() {
        
        return precio2;
    }
    
    public void setPrecio2(String precio2) {
        
        this.precio2 = precio2;
    }
    public String getDesc3() {
        
        return des3;
    }
    
    public void setDes3(String des3) {
        
        this.des3 = des3;
    }
    
    public String getPrecio3() {
        
        return precio3;
    }
    
    public void setPrecio3(String precio3) {
        
        this.precio3 = precio3;
    }
    public String getDesc4() {
        
        return des4;
    }
    
    public void setDes4(String des4) {
        
        this.des4 = des4;
    }
    
    public String getPrecio4() {
        
        return precio4;
    }
    
    public void setPrecio4(String precio4) {
        
        this.precio4 = precio4;
    }
    public String getDesc5() {
        
        return des5;
    }
    
    public void setDes5(String des5) {
        
        this.des5 = des5;
    }
    
    public String getPrecio5() {
        
        return precio5;
    }
    
    public void setPrecio5(String precio5) {
        
        this.precio5 = precio5;
    }
    public String getDesc6() {
        
        return des6;
    }
    
    public void setDes6(String des6) {
        
        this.des6 = des6;
    }
    
    public String getPrecio6() {
        
        return precio6;
    }
    
    public void setPrecio6(String precio6) {
        
        this.precio6 = precio6;
    }
    public String getDesc7() {
        
        return des7;
    }
    
    public void setDes7(String des7) {
        
        this.des7 = des7;
    }
    
    public String getPrecio7() {
        
        return precio7;
    }
    
    public void setPrecio7(String precio7) {
        
        this.precio7 = precio7;
    }
    public String getDesc8() {
        
        return des8;
    }
    
    public void setDes8(String des8) {
        
        this.des8 = des8;
    }
    
    public String getPrecio8() {
        
        return precio8;
    }
    
    public void setPrecio8(String precio8) {
        
        this.precio8 = precio8;
    }
    public String getDesc9() {
        
        return des9;
    }
    
    public void setDes9(String des9) {
        
        this.des9 = des9;
    }
    
    public String getPrecio9() {
        
        return precio9;
    }
    
    public void setPrecio9(String precio9) {
        
        this.precio9 = precio9;
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
        panelBebida1 = new javax.swing.JPanel();
        btnBebida1 = new javax.swing.JButton();
        panelBebida2 = new javax.swing.JPanel();
        btnBebida2 = new javax.swing.JButton();
        panelBebida3 = new javax.swing.JPanel();
        btnBebida3 = new javax.swing.JButton();
        panelBebida4 = new javax.swing.JPanel();
        btnBebida4 = new javax.swing.JButton();
        panelBebida5 = new javax.swing.JPanel();
        btnBebida5 = new javax.swing.JButton();
        panelBebida6 = new javax.swing.JPanel();
        btnBebida6 = new javax.swing.JButton();
        panelBebida7 = new javax.swing.JPanel();
        btnBebida7 = new javax.swing.JButton();
        panelBebida8 = new javax.swing.JPanel();
        btnBebida8 = new javax.swing.JButton();
        panelBebida9 = new javax.swing.JPanel();
        btnBebida9 = new javax.swing.JButton();

        panelSubProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        panelSubProductos.setLayout(new java.awt.GridLayout(3, 5, 2, 2));

        panelBebida1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida1.setLayout(new java.awt.BorderLayout());

        btnBebida1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBebida1.setForeground(new java.awt.Color(255, 0, 0));
        btnBebida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_agua.jpg"))); // NOI18N
        btnBebida1.setText("1,5 L");
        btnBebida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida1ActionPerformed(evt);
            }
        });
        panelBebida1.add(btnBebida1, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida1);

        panelBebida2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida2.setLayout(new java.awt.BorderLayout());

        btnBebida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_Cocacola.jpg"))); // NOI18N
        btnBebida2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida2ActionPerformed(evt);
            }
        });
        panelBebida2.add(btnBebida2, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida2);

        panelBebida3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida3.setLayout(new java.awt.BorderLayout());

        btnBebida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_FNaranja.jpg"))); // NOI18N
        btnBebida3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida3ActionPerformed(evt);
            }
        });
        panelBebida3.add(btnBebida3, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida3);

        panelBebida4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida4.setLayout(new java.awt.BorderLayout());

        btnBebida4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_FLimon.jpg"))); // NOI18N
        btnBebida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida4ActionPerformed(evt);
            }
        });
        panelBebida4.add(btnBebida4, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida4);

        panelBebida5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida5.setLayout(new java.awt.BorderLayout());

        btnBebida5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_nestea.jpg"))); // NOI18N
        btnBebida5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida5ActionPerformed(evt);
            }
        });
        panelBebida5.add(btnBebida5, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida5);

        panelBebida6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida6.setLayout(new java.awt.BorderLayout());

        btnBebida6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_cerveza.jpg"))); // NOI18N
        btnBebida6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida6ActionPerformed(evt);
            }
        });
        panelBebida6.add(btnBebida6, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida6);

        panelBebida7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida7.setLayout(new java.awt.BorderLayout());

        btnBebida7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_tintoverano.jpg"))); // NOI18N
        btnBebida7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida7ActionPerformed(evt);
            }
        });
        panelBebida7.add(btnBebida7, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida7);

        panelBebida8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida8.setLayout(new java.awt.BorderLayout());

        btnBebida8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_aquarius.jpg"))); // NOI18N
        btnBebida8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida8ActionPerformed(evt);
            }
        });
        panelBebida8.add(btnBebida8, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida8);

        panelBebida9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelBebida9.setLayout(new java.awt.BorderLayout());

        btnBebida9.setText("Vacio");
        btnBebida9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebida9ActionPerformed(evt);
            }
        });
        panelBebida9.add(btnBebida9, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelBebida9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSubProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panelSubProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBebida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida1ActionPerformed
        
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

        if (!btnBebida1.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des1);
                ventanaProductos.setTxtPrecio(precio1);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des1, precio, descuento, cantidad1);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida1ActionPerformed

    private void btnBebida2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida2ActionPerformed
        
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

        if (!btnBebida2.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des2);
                ventanaProductos.setTxtPrecio(precio2);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des2, precio, descuento, cantidad2);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida2ActionPerformed

    private void btnBebida3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida3ActionPerformed
        
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

        if (!btnBebida3.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des3);
                ventanaProductos.setTxtPrecio(precio3);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des3, precio, descuento, cantidad3);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida3ActionPerformed

    private void btnBebida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida4ActionPerformed
        
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

        if (!btnBebida4.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des4);
                ventanaProductos.setTxtPrecio(precio4);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des4, precio, descuento, cantidad4);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida4ActionPerformed

    private void btnBebida5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida5ActionPerformed
        
        
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

        if (!btnBebida5.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des5);
                ventanaProductos.setTxtPrecio(precio5);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des5, precio, descuento, cantidad5);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida5ActionPerformed

    private void btnBebida6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida6ActionPerformed
        
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

        if (!btnBebida6.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des6);
                ventanaProductos.setTxtPrecio(precio6);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des6, precio, descuento, cantidad6);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida6ActionPerformed

    private void btnBebida7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida7ActionPerformed
        
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

        if (!btnBebida7.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des7);
                ventanaProductos.setTxtPrecio(precio7);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des7, precio, descuento, cantidad7);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida7ActionPerformed

    private void btnBebida8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida8ActionPerformed
        
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

        if (!btnBebida8.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des8);
                ventanaProductos.setTxtPrecio(precio8);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des8, precio, descuento, cantidad8);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida8ActionPerformed

    private void btnBebida9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebida9ActionPerformed
        
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

        if (!btnBebida9.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des9);
                ventanaProductos.setTxtPrecio(precio9);
            } else {
                if (estado == 3) {
                    
                    accionesBebidas.meterProducto(codigo, des9, precio, descuento, cantidad9);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnBebida9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBebida1;
    private javax.swing.JButton btnBebida2;
    private javax.swing.JButton btnBebida3;
    private javax.swing.JButton btnBebida4;
    private javax.swing.JButton btnBebida5;
    private javax.swing.JButton btnBebida6;
    private javax.swing.JButton btnBebida7;
    private javax.swing.JButton btnBebida8;
    private javax.swing.JButton btnBebida9;
    private javax.swing.JPanel panelBebida1;
    private javax.swing.JPanel panelBebida2;
    private javax.swing.JPanel panelBebida3;
    private javax.swing.JPanel panelBebida4;
    private javax.swing.JPanel panelBebida5;
    private javax.swing.JPanel panelBebida6;
    private javax.swing.JPanel panelBebida7;
    private javax.swing.JPanel panelBebida8;
    private javax.swing.JPanel panelBebida9;
    private javax.swing.JPanel panelSubProductos;
    // End of variables declaration//GEN-END:variables
}
