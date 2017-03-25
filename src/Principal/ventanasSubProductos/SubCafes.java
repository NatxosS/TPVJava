
package Principal.ventanasSubProductos;

/**
 *
 * @author NatxosS
 */
import Acciones.pedido.AccionesPedidoCafes;
import Principal.VentanaPrincipal;
import Vista.*;

public class SubCafes extends javax.swing.JPanel {

    /**
     * Creates new form SubCafes
     */
    public int botonSeleccionado = 0;
    
    public String des1 = "cOMIDA";
    public String precio1 = "0.75";
    
    public String des2 = "Cola";
    public String precio2 = "2";
    
    public String des3 = "FcOMIDA";
    public String precio3 = "1";
    
    public String des4 = "FantaL";
    public String precio4 = "8";
    
    public String des5 = "cOMIDA";
    public String precio5 = "3";
    
    public String des6 = "cervez";
    public String precio6 = "6.2";
    
    public String des7 = "tintoo";
    public String precio7 = "7.21";
    
    public String des8 = "acucOMIDA1";
    public String precio8 = "12";
    
    public String des9 = "";
    public String precio9 = "";
    
    public VentanaPrincipal ventanaPrincipal;
    public VentanaProductos ventanaProductos;
    public AccionesPedidoCafes accionesCafes;
    
    static Integer cantidad1 = 0;
    static Integer cantidad2 = 0;
    static Integer cantidad3 = 0;
    static Integer cantidad4 = 0;
    static Integer cantidad5 = 0;
    static Integer cantidad6 = 0;
    static Integer cantidad7 = 0;
    static Integer cantidad8 = 0;
    static Integer cantidad9 = 0;
    
    public SubCafes() {
        
        initComponents();
    }
    
    public SubCafes(VentanaPrincipal ventanaPrin, VentanaProductos ventanaProd) {
        
        this.setVentanaPrincipal(ventanaPrin);
        this.ventanaProductos = ventanaProd;
        this.accionesCafes = new AccionesPedidoCafes(this);
        initComponents();
    }
    
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
        panelCafe1 = new javax.swing.JPanel();
        btnCafe1 = new javax.swing.JButton();
        panelCafe2 = new javax.swing.JPanel();
        btnCafe2 = new javax.swing.JButton();
        panelCafe3 = new javax.swing.JPanel();
        btnCafe3 = new javax.swing.JButton();
        panelCafe4 = new javax.swing.JPanel();
        btnCafe4 = new javax.swing.JButton();
        panelCafe5 = new javax.swing.JPanel();
        btnCafe5 = new javax.swing.JButton();
        panelCafe6 = new javax.swing.JPanel();
        btnCafe6 = new javax.swing.JButton();
        panelCafe7 = new javax.swing.JPanel();
        btnCafe7 = new javax.swing.JButton();
        panelCafe8 = new javax.swing.JPanel();
        btnCafe8 = new javax.swing.JButton();
        panelCafe9 = new javax.swing.JPanel();
        btnCafe9 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(690, 245));

        panelSubProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        panelSubProductos.setMinimumSize(new java.awt.Dimension(337, 245));
        panelSubProductos.setPreferredSize(new java.awt.Dimension(377, 245));
        panelSubProductos.setLayout(new java.awt.GridLayout(3, 5, 2, 2));

        panelCafe1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe1.setLayout(new java.awt.BorderLayout());

        btnCafe1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCafe1.setForeground(new java.awt.Color(255, 0, 0));
        btnCafe1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_solo.jpg"))); // NOI18N
        btnCafe1.setText("Solo");
        btnCafe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe1ActionPerformed(evt);
            }
        });
        panelCafe1.add(btnCafe1, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe1);

        panelCafe2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe2.setLayout(new java.awt.BorderLayout());

        btnCafe2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCafe2.setForeground(new java.awt.Color(255, 0, 0));
        btnCafe2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_conLeche.jpg"))); // NOI18N
        btnCafe2.setText("Con Leche");
        btnCafe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe2ActionPerformed(evt);
            }
        });
        panelCafe2.add(btnCafe2, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe2);

        panelCafe3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe3.setLayout(new java.awt.BorderLayout());

        btnCafe3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCafe3.setForeground(new java.awt.Color(255, 0, 0));
        btnCafe3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_capuccino.jpg"))); // NOI18N
        btnCafe3.setText("Capuccino");
        btnCafe3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe3ActionPerformed(evt);
            }
        });
        panelCafe3.add(btnCafe3, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe3);

        panelCafe4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe4.setLayout(new java.awt.BorderLayout());

        btnCafe4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCafe4.setForeground(new java.awt.Color(255, 0, 0));
        btnCafe4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_cortado.jpg"))); // NOI18N
        btnCafe4.setText("Cortado");
        btnCafe4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe4ActionPerformed(evt);
            }
        });
        panelCafe4.add(btnCafe4, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe4);

        panelCafe5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe5.setLayout(new java.awt.BorderLayout());

        btnCafe5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCafe5.setForeground(new java.awt.Color(255, 0, 0));
        btnCafe5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_carajillo.jpg"))); // NOI18N
        btnCafe5.setText("Carajillo");
        btnCafe5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe5ActionPerformed(evt);
            }
        });
        panelCafe5.add(btnCafe5, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe5);

        panelCafe6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe6.setLayout(new java.awt.BorderLayout());

        btnCafe6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCafe6.setForeground(new java.awt.Color(255, 0, 0));
        btnCafe6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/subProductos/icon_bombon.jpg"))); // NOI18N
        btnCafe6.setText("Bombon");
        btnCafe6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe6ActionPerformed(evt);
            }
        });
        panelCafe6.add(btnCafe6, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe6);

        panelCafe7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe7.setLayout(new java.awt.BorderLayout());

        btnCafe7.setText("Vacio");
        btnCafe7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe7ActionPerformed(evt);
            }
        });
        panelCafe7.add(btnCafe7, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe7);

        panelCafe8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe8.setLayout(new java.awt.BorderLayout());

        btnCafe8.setText("Vacio");
        btnCafe8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe8ActionPerformed(evt);
            }
        });
        panelCafe8.add(btnCafe8, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe8);

        panelCafe9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 2, true));
        panelCafe9.setLayout(new java.awt.BorderLayout());

        btnCafe9.setText("Vacio");
        btnCafe9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafe9ActionPerformed(evt);
            }
        });
        panelCafe9.add(btnCafe9, java.awt.BorderLayout.CENTER);

        panelSubProductos.add(panelCafe9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelSubProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSubProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCafe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe1ActionPerformed
        
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

        if (!btnCafe1.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des1);
                ventanaProductos.setTxtPrecio(precio1);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des1, precio, descuento, cantidad1);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe1ActionPerformed

    private void btnCafe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe2ActionPerformed
        
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

        if (!btnCafe2.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des2);
                ventanaProductos.setTxtPrecio(precio2);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des2, precio, descuento, cantidad2);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe2ActionPerformed

    private void btnCafe3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe3ActionPerformed
        
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

        if (!btnCafe3.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des3);
                ventanaProductos.setTxtPrecio(precio3);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des3, precio, descuento, cantidad3);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe3ActionPerformed

    private void btnCafe4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe4ActionPerformed
        
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

        if (!btnCafe4.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des4);
                ventanaProductos.setTxtPrecio(precio4);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des4, precio, descuento, cantidad4);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe4ActionPerformed

    private void btnCafe5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe5ActionPerformed
        
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

        if (!btnCafe5.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des5);
                ventanaProductos.setTxtPrecio(precio5);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des5, precio, descuento, cantidad5);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe5ActionPerformed

    private void btnCafe6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe6ActionPerformed
        
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

        if (!btnCafe6.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des6);
                ventanaProductos.setTxtPrecio(precio6);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des6, precio, descuento, cantidad6);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe6ActionPerformed

    private void btnCafe7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe7ActionPerformed
        
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

        if (!btnCafe7.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des7);
                ventanaProductos.setTxtPrecio(precio7);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des7, precio, descuento, cantidad7);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe7ActionPerformed

    private void btnCafe8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe8ActionPerformed
        
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

        if (!btnCafe8.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des8);
                ventanaProductos.setTxtPrecio(precio8);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des8, precio, descuento, cantidad8);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe8ActionPerformed

    private void btnCafe9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafe9ActionPerformed
        
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

        if (!btnCafe9.getText().equals("Vacio")) {
            int estado = ventanaPrincipal.getVentanaActual();
            if (estado == 1) {
                ventanaProductos.setTxtDescripcion(des9);
                ventanaProductos.setTxtPrecio(precio9);
            } else {
                if (estado == 3) {
                    
                    accionesCafes.meterProducto(codigo, des9, precio, descuento, cantidad9);
                }
            }
        } else {
            ventanaProductos.getBtnCrear().setEnabled(true);
            ventanaPrincipal.mostrarPanelProductos();
        }
    }//GEN-LAST:event_btnCafe9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCafe1;
    private javax.swing.JButton btnCafe2;
    private javax.swing.JButton btnCafe3;
    private javax.swing.JButton btnCafe4;
    private javax.swing.JButton btnCafe5;
    private javax.swing.JButton btnCafe6;
    private javax.swing.JButton btnCafe7;
    private javax.swing.JButton btnCafe8;
    private javax.swing.JButton btnCafe9;
    private javax.swing.JPanel panelCafe1;
    private javax.swing.JPanel panelCafe2;
    private javax.swing.JPanel panelCafe3;
    private javax.swing.JPanel panelCafe4;
    private javax.swing.JPanel panelCafe5;
    private javax.swing.JPanel panelCafe6;
    private javax.swing.JPanel panelCafe7;
    private javax.swing.JPanel panelCafe8;
    private javax.swing.JPanel panelCafe9;
    private javax.swing.JPanel panelSubProductos;
    // End of variables declaration//GEN-END:variables
}
