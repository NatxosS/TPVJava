
package Principal;

import Principal.ventanasSubProductos.*;
import Vista.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NatxosS
 */
public class VentanaPrincipal extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form VentanaPrincipal
     */
    private SubBebidas subBebidas;
    private SubComidas subComidas;
    private SubPostre subPostres;
    private SubCafes subCafes;
    private SubOtros subOtros;
    
    private VentanaProductos ventanaProductos;
    private VentanaVerificacionCajero ventanaVerificacionCajero;
    
    public DefaultTableModel tabla;
    
    private Boolean chivatoDecimal = false;
    private Boolean cancelar = false;
    
    public int ventanaActual = 0;                                // si vale 1 esta variable, estamos en la ventanaProductos. si vale 2 en la ventanaVerificacion y si es 3 en la ventanaPedidos
    public Integer cant = 0;
    
    String hora,minutos,segundos,ampm;
    Calendar calendario;
    Thread h1;
    
    private String password = "";
    private Boolean habitual = false;

    public int filasTotales = 0;
    public int filaSeleccionada = -1;
    
    public VentanaPrincipal() {
        
        this.ventanaVerificacionCajero = new VentanaVerificacionCajero(this);
        this.ventanaProductos = new VentanaProductos(this);
        
        this.subBebidas = new SubBebidas(this, ventanaProductos);
        this.subComidas = new SubComidas(this, ventanaProductos);
        this.subPostres = new SubPostre(this, ventanaProductos);
        this.subCafes = new SubCafes(this, ventanaProductos);
        this.subOtros = new SubOtros(this, ventanaProductos);

        initComponents();
        configuracionVentana();
        construirTabla();
        panelMixto.removeAll();
        txtFecha.setText(fechaActual());
        h1 = new Thread(this);
        h1.start();
    }

//////////////////////////////// MÉTODOS ///////////////////////////////////////
    
    public void construirTabla() {
        
        tabla = new DefaultTableModel(new String[]  {"Código","Descripción","Cant.", "Desc.%", "Precio", "SubTotal"},0);        
        this.getTblPedido().setModel(tabla);
        this.getPanelTabla().setViewportView(this.getTblPedido());
    }
    
    public int sacarFila() {
        
        filaSeleccionada = tblPedido.getSelectedRow();
        return filaSeleccionada;                              // llamaremos a este método cuando sea necesario saber que fila esta seleccionada
    }
    
    public int numerodeFilas() {
        
        int numFilas = tabla.getRowCount();
        
        return numFilas;
    }
    
    public void configuracionVentana() {
        
        //this.setSize(800, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        
    }
    
    public void limpiarSubproductos() {
        
        panelSubProductos.removeAll();
    }
    
    public void usarCalculadora(Integer boton) {
        
        String numero = Integer.toString(boton);
        
        if (chivatoDecimal == true) {
            usarCalculadoraDouble(numero);
        } else {
            int num = Integer.parseInt(getTxtPantallaCalculadora());
            if (numero.length() <= 4) {
                if (boton == 0) {
                    if (num != 0) {
                        String cadena = getTxtPantallaCalculadora();
                        cadena = cadena + "0";
                        setTxtPantallaCalculadora(cadena);
                    }
                } else {
                    if (num == 0) {
                        setTxtPantallaCalculadora(numero);
                    } else {
                        String cadena = Integer.toString(num);
                        cadena = cadena + numero;
                        setTxtPantallaCalculadora(cadena);
                    }
                }
            }
        }
    }
    
    public void usarCalculadoraDouble(String num) {
        
        String numero = getTxtPantallaCalculadora();
        numero = numero + num;
        setTxtPantallaCalculadora(numero);
    }
    
    public void refrescarPedido() {
        
        ventanaActual = 3;
        panelMixto.removeAll();
        panelMixto.add(panelPedido);
        pack();
    }
    
    public void verificarTrabajador(String caja, String cajero) {
        
        int cajeroNum = Integer.parseInt(cajero);
        setTxtPantallaCalculadora("0");
        if (cajeroNum == 15) {                                                  // codigo de cajero
            setTxtMarcadorCaja(caja);
            setTxtNombre("Pepito");
            setTxtApellido("Perez");
            refrescarPedido();
        } else {
            JOptionPane.showMessageDialog(null, "No existe ningún trabajador con ese código");
        }
    }
    
    public void construirTablaCliente() {
        
        tabla = new DefaultTableModel(new String[]  {"Código","Descripción","Cant.", "Desc.%", "Precio", "SubTotal"},0);        
        tblPedido.setModel(tabla);
        this.getPanelTabla().setViewportView(tblPedido);
    }
    
    public void calcularTotal() {
        
        filasTotales = tabla.getRowCount();
        Double total = 0.0;
        for (int i=0; i<filasTotales; i++) {
            Double subTotal = (double)tabla.getValueAt(i, 5);
            total = total + subTotal;
        }
        txtTotal.setText(Double.toString(total));
    }
    
    /////////////////// PONEMOS LA FECHA Y HORA ////////////////////////////////////////
    
    public static String fechaActual() {
        
        Date fechaActual = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fechaActual);
    }
    
    public void run() {
        
        Thread ct = Thread.currentThread();
        while(ct == h1) { 
            calcula();
            lblHora.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {}
        }
    }
    
    public void calcula () {   
        
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        } else {
             hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
    }     
    
    public void mostrarPanelProductos() {
        
        ventanaActual = 1;
        panelMixto.removeAll();
        panelMixto.add(ventanaProductos);
        pack();
        panelMixto.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS"));
    }

    //////////////////////// ACCESOS A VARIABLES ///////////////////////////////
    
    public void setPanelFormulario(javax.swing.JPanel panelFormulario) {
        
        this.panelFormulario = panelFormulario;
    }
    
    public javax.swing.JPanel getPanelFormulario() {
        
        return panelFormulario;
    }
    
    public void setPanelMixto(javax.swing.JPanel panelMixto) {
        
        this.panelMixto = panelMixto;
    }
    
    public javax.swing.JPanel getPanelMixto() {
        
        return panelMixto;
    }
    
    public void setPanelSubProductos(javax.swing.JPanel panelSubProductos) {
        
        this.panelSubProductos = panelSubProductos;
    }
    
    public javax.swing.JPanel getPanelSubProductos() {
        
        return panelSubProductos;
    }
    
    public void setPanelTecladoNumerico(javax.swing.JPanel panelTecladoNumerico) {
        
        this.panelTecladoNumerico = panelTecladoNumerico;
    }
    
    public javax.swing.JPanel getPanelTecladoNumerico() {
        
        return panelTecladoNumerico;
    }
    
    public int getVentanaActual() {
        
        return ventanaActual;
    }
    
    public void setTxtMarcadorCaja(String caja) {
        
        this.txtMarcadorCaja.setText(caja);
    }
    
    public String getTxtMarcadorCaja() {
        
        return txtMarcadorCaja.getText();
    }
    
    public void setTxtNombre(String nombre) {
        
        this.txtNombre.setText(nombre);
    }
    
    public String getTxtNombre() {
        
        return txtNombre.getText();
    }
    
    public void setTxtApellido(String apellido) {
        
        this.txtApellido.setText(apellido);
    }
    
    public String getTxtApellido() {
        
        return txtApellido.getText();
    }
    
    public javax.swing.JScrollPane getPanelTabla() {
        
        return panelTabla;
    }
    
    public void setPanelTabla(javax.swing.JScrollPane panelTabla) {
        
        this.panelTabla = panelTabla;
    }
    
    public javax.swing.JTable getTblPedido() {
        
        return tblPedido;
    }
    
    public void setTblPedido(javax.swing.JTable tblPedido) {
        
        this.tblPedido = tblPedido;
    }
    
    public DefaultTableModel getTabla() {
        
        return tabla;
    }
    
    public void setTabla(DefaultTableModel tabla) {
        
        this.tabla = tabla;
    }
    
    //////////////////////// ACCESOS A VARIABLES DE CALCULADORA ////////////////
    
    public String getTxtPantallaCalculadora() {
        
        return txtPantallacalculadora.getText();
    }
    
    public void setTxtPantallaCalculadora(String num) {
        
        this.txtPantallacalculadora.setText(num);
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogoVentas = new javax.swing.JDialog();
        panelTablasDeVentas = new javax.swing.JPanel();
        btnVentasHoy = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        btnVentasFecha = new javax.swing.JButton();
        btnVentasPorCliente = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnSalirVentas = new javax.swing.JButton();
        dialogoClientes = new javax.swing.JDialog();
        panelTablaCliente = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        chkHabitual = new javax.swing.JCheckBox();
        btnVentasCliente = new javax.swing.JButton();
        btnCancelarClientes = new javax.swing.JButton();
        btnAceptarClientes = new javax.swing.JButton();
        btnModificarClave = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        dialogoModificarClave = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNueva = new javax.swing.JTextField();
        txtAntigua = new javax.swing.JTextField();
        txtRepetir = new javax.swing.JTextField();
        btnAceptarModificarClave = new javax.swing.JButton();
        btnCandelarModificarClave = new javax.swing.JButton();
        dialogoClaveDescuento = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtClaveDescuento = new javax.swing.JTextField();
        txtClienteDescuento = new javax.swing.JTextField();
        btnAceptarDescuento = new javax.swing.JButton();
        btnCancelarDescuento = new javax.swing.JButton();
        txtDescDescuento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        txtMarcadorCaja = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblHora = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        btnVentas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnEnterCodigo = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        panelMixto = new javax.swing.JPanel();
        panelPedido = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        txtNumeroTicket = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        panelTabla = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        btnAplicarDes = new javax.swing.JButton();
        panelSubProductos = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        panelTecladoNumerico = new javax.swing.JPanel();
        panelCalculadora = new javax.swing.JPanel();
        btnRetroceso = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnComa = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        txtPantallacalculadora = new javax.swing.JTextField();
        panelProductos = new javax.swing.JPanel();
        btnBebidas = new javax.swing.JButton();
        btnComidas = new javax.swing.JButton();
        btnPostres = new javax.swing.JButton();
        btnCafes = new javax.swing.JButton();
        btnOtros = new javax.swing.JButton();
        panelBotones = new javax.swing.JPanel();
        btnPedido = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptarEImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();
        menuProductos = new javax.swing.JMenuItem();
        menuClientes = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        menuVentasPorFecha = new javax.swing.JMenuItem();
        menuPorCliente = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        menuPedido = new javax.swing.JMenu();
        MenuAceptarPedido = new javax.swing.JMenuItem();
        menuCancelarPedido = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuAplicarDescuento = new javax.swing.JMenuItem();
        menuQuitarDescuento = new javax.swing.JMenuItem();
        menuNuevoPedido = new javax.swing.JMenuItem();

        dialogoVentas.setTitle("Ventas");

        panelTablasDeVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Ventas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        javax.swing.GroupLayout panelTablasDeVentasLayout = new javax.swing.GroupLayout(panelTablasDeVentas);
        panelTablasDeVentas.setLayout(panelTablasDeVentasLayout);
        panelTablasDeVentasLayout.setHorizontalGroup(
            panelTablasDeVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );
        panelTablasDeVentasLayout.setVerticalGroup(
            panelTablasDeVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnVentasHoy.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVentasHoy.setForeground(new java.awt.Color(0, 51, 255));
        btnVentasHoy.setText("Ventas de hoy");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText("Ventas por fecha:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 51, 255));
        jTextField1.setText("00");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setText("/");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 51, 255));
        jTextField2.setText("00");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("/");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 51, 255));
        jTextField3.setText("0000");

        btnVentasFecha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVentasFecha.setForeground(new java.awt.Color(0, 51, 255));
        btnVentasFecha.setText("Mostrar");

        btnVentasPorCliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVentasPorCliente.setForeground(new java.awt.Color(0, 51, 255));
        btnVentasPorCliente.setText("Ventas por cliente");
        btnVentasPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasPorClienteActionPerformed(evt);
            }
        });

        btnSalirVentas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSalirVentas.setForeground(new java.awt.Color(0, 51, 255));
        btnSalirVentas.setText("Salir");
        btnSalirVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoVentasLayout = new javax.swing.GroupLayout(dialogoVentas.getContentPane());
        dialogoVentas.getContentPane().setLayout(dialogoVentasLayout);
        dialogoVentasLayout.setHorizontalGroup(
            dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTablasDeVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoVentasLayout.createSequentialGroup()
                        .addGroup(dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogoVentasLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnVentasPorCliente)
                                    .addGroup(dialogoVentasLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(btnVentasFecha))))
                            .addGroup(dialogoVentasLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(dialogoVentasLayout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnVentasHoy)))
                            .addGroup(dialogoVentasLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)))
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoVentasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(jSeparator5)
                                .addComponent(jSeparator6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoVentasLayout.createSequentialGroup()
                                .addComponent(btnSalirVentas)
                                .addGap(30, 30, 30))))))
        );
        dialogoVentasLayout.setVerticalGroup(
            dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTablasDeVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(dialogoVentasLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnVentasHoy)
                .addGap(16, 16, 16)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(dialogoVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnVentasFecha)
                .addGap(15, 15, 15)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnVentasPorCliente)
                .addGap(19, 19, 19)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnSalirVentas)
                .addGap(55, 55, 55))
        );

        dialogoClientes.setTitle("Lista clientes");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        panelTablaCliente.setViewportView(tblClientes);

        chkHabitual.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chkHabitual.setForeground(new java.awt.Color(0, 51, 255));
        chkHabitual.setText("Cliente habitual");
        chkHabitual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkHabitualStateChanged(evt);
            }
        });

        btnVentasCliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVentasCliente.setForeground(new java.awt.Color(0, 51, 255));
        btnVentasCliente.setText("SusPedidos");
        btnVentasCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasClienteActionPerformed(evt);
            }
        });

        btnCancelarClientes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCancelarClientes.setForeground(new java.awt.Color(0, 51, 255));
        btnCancelarClientes.setText("Cancelar");
        btnCancelarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClientesActionPerformed(evt);
            }
        });

        btnAceptarClientes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAceptarClientes.setForeground(new java.awt.Color(0, 0, 255));
        btnAceptarClientes.setText("Aceptar");

        btnModificarClave.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnModificarClave.setForeground(new java.awt.Color(0, 0, 255));
        btnModificarClave.setText("Modificar Clave");
        btnModificarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClaveActionPerformed(evt);
            }
        });

        jLabel21.setText("Clave por defecto: 1");

        javax.swing.GroupLayout dialogoClientesLayout = new javax.swing.GroupLayout(dialogoClientes.getContentPane());
        dialogoClientes.getContentPane().setLayout(dialogoClientesLayout);
        dialogoClientesLayout.setHorizontalGroup(
            dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoClientesLayout.createSequentialGroup()
                .addGroup(dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTablaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogoClientesLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoClientesLayout.createSequentialGroup()
                        .addGroup(dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificarClave, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkHabitual, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoClientesLayout.createSequentialGroup()
                        .addGroup(dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAceptarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(btnVentasCliente)
                            .addComponent(btnCancelarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))))
        );
        dialogoClientesLayout.setVerticalGroup(
            dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoClientesLayout.createSequentialGroup()
                .addGroup(dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogoClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelTablaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dialogoClientesLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnModificarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkHabitual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVentasCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnAceptarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(dialogoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        dialogoModificarClave.setTitle("Modificar clave");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("Antigua clave:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText("Clave nueva:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 255));
        jLabel12.setText("Repetir clave nueva:");

        txtNueva.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNueva.setForeground(new java.awt.Color(0, 51, 255));

        txtAntigua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAntigua.setForeground(new java.awt.Color(0, 51, 255));

        txtRepetir.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRepetir.setForeground(new java.awt.Color(0, 51, 255));

        btnAceptarModificarClave.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAceptarModificarClave.setForeground(new java.awt.Color(0, 0, 255));
        btnAceptarModificarClave.setText("Aceptar");
        btnAceptarModificarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarModificarClaveActionPerformed(evt);
            }
        });

        btnCandelarModificarClave.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCandelarModificarClave.setForeground(new java.awt.Color(0, 0, 255));
        btnCandelarModificarClave.setText("Cancelar");
        btnCandelarModificarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandelarModificarClaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogoModificarClaveLayout = new javax.swing.GroupLayout(dialogoModificarClave.getContentPane());
        dialogoModificarClave.getContentPane().setLayout(dialogoModificarClaveLayout);
        dialogoModificarClaveLayout.setHorizontalGroup(
            dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoModificarClaveLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(btnAceptarModificarClave))
                .addGap(18, 18, 18)
                .addGroup(dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCandelarModificarClave)
                    .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAntigua, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        dialogoModificarClaveLayout.setVerticalGroup(
            dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoModificarClaveLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAntigua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtNueva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(dialogoModificarClaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarModificarClave)
                    .addComponent(btnCandelarModificarClave))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 255));
        jLabel17.setText("Cliente:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 255));
        jLabel18.setText("Clave:");

        txtClaveDescuento.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtClaveDescuento.setForeground(new java.awt.Color(0, 51, 255));
        txtClaveDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtClienteDescuento.setEditable(false);
        txtClienteDescuento.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtClienteDescuento.setForeground(new java.awt.Color(0, 51, 255));
        txtClienteDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnAceptarDescuento.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAceptarDescuento.setForeground(new java.awt.Color(0, 0, 255));
        btnAceptarDescuento.setText("Aceptar");

        btnCancelarDescuento.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCancelarDescuento.setForeground(new java.awt.Color(0, 0, 255));
        btnCancelarDescuento.setText("Cancelar");
        btnCancelarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDescuentoActionPerformed(evt);
            }
        });

        txtDescDescuento.setEditable(false);
        txtDescDescuento.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDescDescuento.setForeground(new java.awt.Color(0, 51, 255));
        txtDescDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 255));
        jLabel19.setText("Descuento del:");

        javax.swing.GroupLayout dialogoClaveDescuentoLayout = new javax.swing.GroupLayout(dialogoClaveDescuento.getContentPane());
        dialogoClaveDescuento.getContentPane().setLayout(dialogoClaveDescuentoLayout);
        dialogoClaveDescuentoLayout.setHorizontalGroup(
            dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoClaveDescuentoLayout.createSequentialGroup()
                .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dialogoClaveDescuentoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAceptarDescuento))
                    .addGroup(dialogoClaveDescuentoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogoClaveDescuentoLayout.createSequentialGroup()
                                .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(dialogoClaveDescuentoLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDescDescuento))
                                    .addGroup(dialogoClaveDescuentoLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtClienteDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(51, 51, 51))
                            .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCancelarDescuento)
                                .addGroup(dialogoClaveDescuentoLayout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtClaveDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dialogoClaveDescuentoLayout.setVerticalGroup(
            dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogoClaveDescuentoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtClienteDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDescDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClaveDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(28, 28, 28)
                .addGroup(dialogoClaveDescuentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarDescuento)
                    .addComponent(btnAceptarDescuento))
                .addGap(46, 46, 46))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PanYChicha");
        setForeground(new java.awt.Color(204, 204, 255));
        setResizable(false);

        panelContenedor.setForeground(new java.awt.Color(0, 0, 204));

        panelFormulario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(0, 153, 255), new java.awt.Color(0, 204, 204)));
        panelFormulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMarcadorCaja.setEditable(false);
        txtMarcadorCaja.setBackground(new java.awt.Color(255, 255, 255));
        txtMarcadorCaja.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtMarcadorCaja.setForeground(new java.awt.Color(255, 0, 0));
        txtMarcadorCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMarcadorCaja.setText("0");
        txtMarcadorCaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 102, 102), null, new java.awt.Color(51, 51, 51)));
        panelFormulario.add(txtMarcadorCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(1275, 39, 57, 47));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("CAJA:");
        panelFormulario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1284, 13, 57, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelFormulario.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 50, 104));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("EMPLEADO:");
        panelFormulario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Nombre:");
        panelFormulario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Apellido:");
        panelFormulario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, -1, -1));

        txtApellido.setEditable(false);
        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        panelFormulario.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, 230, -1));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        panelFormulario.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("EMPRESA:");
        panelFormulario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtEmpresa.setEditable(false);
        txtEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        txtEmpresa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEmpresa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEmpresa.setText("Pan&Chicha ");
        panelFormulario.add(txtEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 210, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Fecha:");
        panelFormulario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        panelFormulario.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 100, -1));

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblHora.setText("jLabel9");
        panelFormulario.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelFormulario.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 10, 100));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Código Cliente:");
        panelFormulario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        txtCodigoCliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        panelFormulario.add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 100, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelFormulario.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 20, 100));

        btnVentas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(204, 0, 255));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_ventas.jpg"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        panelFormulario.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 70));

        btnClientes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(204, 51, 255));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_clientes.jpg"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        panelFormulario.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 160, 70));

        btnEnterCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_enter.jpg"))); // NOI18N
        btnEnterCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterCodigoActionPerformed(evt);
            }
        });
        panelFormulario.add(btnEnterCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 20, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("Cliente:");
        panelFormulario.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        panelFormulario.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 180, -1));

        panelMixto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        panelMixto.setLayout(new java.awt.BorderLayout());

        panelPedido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 102, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNumeroTicket.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Nº de Ticket:");

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        panelTabla.setViewportView(tblPedido);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("%");

        txtDescuento.setEditable(false);
        txtDescuento.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setText("5");

        btnAplicarDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAplicarDes.setForeground(new java.awt.Color(51, 51, 255));
        btnAplicarDes.setText("Aplicar Descuento");
        btnAplicarDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarDesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPedidoLayout = new javax.swing.GroupLayout(panelPedido);
        panelPedido.setLayout(panelPedidoLayout);
        panelPedidoLayout.setHorizontalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(txtNumeroTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAplicarDes, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPedidoLayout.createSequentialGroup()
                    .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelPedidoLayout.setVerticalGroup(
            panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidoLayout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtNumeroTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAplicarDes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(29, 29, 29))
            .addGroup(panelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPedidoLayout.createSequentialGroup()
                    .addContainerGap(13, Short.MAX_VALUE)
                    .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(96, Short.MAX_VALUE)))
        );

        panelMixto.add(panelPedido, java.awt.BorderLayout.CENTER);

        panelSubProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N
        panelSubProductos.setLayout(new java.awt.BorderLayout());

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 0, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("TOTAL:");

        panelCalculadora.setLayout(new java.awt.GridLayout(3, 4, 2, 2));

        btnRetroceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_retroceso.jpg"))); // NOI18N
        btnRetroceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocesoActionPerformed(evt);
            }
        });
        panelCalculadora.add(btnRetroceso);

        btn7.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn7.setForeground(new java.awt.Color(0, 0, 204));
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn7);

        btn8.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn8.setForeground(new java.awt.Color(0, 0, 204));
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn8);

        btn9.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn9.setForeground(new java.awt.Color(0, 0, 204));
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn9);

        btnComa.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btnComa.setForeground(new java.awt.Color(0, 0, 204));
        btnComa.setText(",");
        btnComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComaActionPerformed(evt);
            }
        });
        panelCalculadora.add(btnComa);

        btn4.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn4.setForeground(new java.awt.Color(0, 0, 204));
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn4);

        btn5.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn5.setForeground(new java.awt.Color(0, 0, 204));
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn5);

        btn6.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn6.setForeground(new java.awt.Color(0, 0, 204));
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn6);

        btn0.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn0.setForeground(new java.awt.Color(0, 0, 204));
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn0);

        btn1.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn1.setForeground(new java.awt.Color(0, 0, 204));
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn1);

        btn2.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn2.setForeground(new java.awt.Color(0, 0, 204));
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn2);

        btn3.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btn3.setForeground(new java.awt.Color(0, 0, 204));
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        panelCalculadora.add(btn3);

        btnEnter.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btnEnter.setForeground(new java.awt.Color(0, 51, 255));
        btnEnter.setText("ENTER / X");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        txtPantallacalculadora.setEditable(false);
        txtPantallacalculadora.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPantallacalculadora.setForeground(new java.awt.Color(255, 0, 0));
        txtPantallacalculadora.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPantallacalculadora.setText("0");

        panelProductos.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        panelProductos.setLayout(new java.awt.GridLayout(2, 4));

        btnBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_bebidas.jpg"))); // NOI18N
        btnBebidas.setText("   Bebidas");
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });
        panelProductos.add(btnBebidas);

        btnComidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_comidas.jpg"))); // NOI18N
        btnComidas.setText(" Comidas");
        btnComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComidasActionPerformed(evt);
            }
        });
        panelProductos.add(btnComidas);

        btnPostres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_postres.jpg"))); // NOI18N
        btnPostres.setText("  Postres");
        btnPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostresActionPerformed(evt);
            }
        });
        panelProductos.add(btnPostres);

        btnCafes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_cafe.jpg"))); // NOI18N
        btnCafes.setText("  Cafés");
        btnCafes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafesActionPerformed(evt);
            }
        });
        panelProductos.add(btnCafes);

        btnOtros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_extras.jpg"))); // NOI18N
        btnOtros.setText(" Otros");
        btnOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtrosActionPerformed(evt);
            }
        });
        panelProductos.add(btnOtros);

        btnPedido.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnPedido.setForeground(new java.awt.Color(102, 0, 102));
        btnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_pedido.jpg"))); // NOI18N
        btnPedido.setText("PEDIDO");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        panelBotones.add(btnPedido);

        btnProductos.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(0, 0, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_productos.jpg"))); // NOI18N
        btnProductos.setText("PRODUCTOS");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        panelBotones.add(btnProductos);

        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 0, 0));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_cancelar.jpg"))); // NOI18N
        btnCancelar.setText("BORRAR PEDIDO");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 0, 0), new java.awt.Color(255, 0, 0)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelBotones.add(btnCancelar);

        btnAceptarEImprimir.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnAceptarEImprimir.setForeground(new java.awt.Color(0, 204, 0));
        btnAceptarEImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_aceptar.jpg"))); // NOI18N
        btnAceptarEImprimir.setText("ACEPTAR E IMPRIMIR TICKET");
        btnAceptarEImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 153, 0), null, new java.awt.Color(0, 204, 0)));
        btnAceptarEImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEImprimirActionPerformed(evt);
            }
        });
        panelBotones.add(btnAceptarEImprimir);

        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_salir.jpg"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelBotones.add(btnSalir);

        btnLimpiar.setFont(new java.awt.Font("Tunga", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 255));
        btnLimpiar.setText("C");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTecladoNumericoLayout = new javax.swing.GroupLayout(panelTecladoNumerico);
        panelTecladoNumerico.setLayout(panelTecladoNumericoLayout);
        panelTecladoNumericoLayout.setHorizontalGroup(
            panelTecladoNumericoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTecladoNumericoLayout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addGroup(panelTecladoNumericoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEnter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(panelTecladoNumericoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTecladoNumericoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(165, 165, 165))
            .addGroup(panelTecladoNumericoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTecladoNumericoLayout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(panelCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17)
                    .addComponent(txtPantallacalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(894, Short.MAX_VALUE)))
        );
        panelTecladoNumericoLayout.setVerticalGroup(
            panelTecladoNumericoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTecladoNumericoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTecladoNumericoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(panelTecladoNumericoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTecladoNumericoLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(panelTecladoNumericoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPantallacalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1219, 1219, 1219))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMixto, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSubProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panelTecladoNumerico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContenedorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContenedorLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSubProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMixto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTecladoNumerico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuMenu.setText("Menu");

        menuProductos.setText("Productos");
        menuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosActionPerformed(evt);
            }
        });
        menuMenu.add(menuProductos);

        menuClientes.setText("Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });
        menuMenu.add(menuClientes);

        menuVentas.setText("Ventas");

        menuVentasPorFecha.setText("Por Fecha");
        menuVentasPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVentasPorFechaActionPerformed(evt);
            }
        });
        menuVentas.add(menuVentasPorFecha);

        menuPorCliente.setText("Por Cliente");
        menuPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPorClienteActionPerformed(evt);
            }
        });
        menuVentas.add(menuPorCliente);

        menuMenu.add(menuVentas);
        menuMenu.add(jSeparator7);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuMenu.add(menuSalir);

        jMenuBar1.add(menuMenu);

        menuPedido.setText("Pedido");

        MenuAceptarPedido.setText("Aceptar e Imprimir");
        menuPedido.add(MenuAceptarPedido);

        menuCancelarPedido.setText("Cancelar y Limpiar");
        menuPedido.add(menuCancelarPedido);
        menuPedido.add(jSeparator8);

        menuAplicarDescuento.setText("Aplicar Descuento");
        menuPedido.add(menuAplicarDescuento);

        menuQuitarDescuento.setText("Quitar Descuento");
        menuPedido.add(menuQuitarDescuento);

        menuNuevoPedido.setText("NuevoPedido");
        menuNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoPedidoActionPerformed(evt);
            }
        });
        menuPedido.add(menuNuevoPedido);

        jMenuBar1.add(menuPedido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ///////////////////////// EVENTOS QUE NOS MUESTRAN LOS DIFERENTES SUBPRODUCTOS /////////////////////////////////
    
    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        
        this.limpiarSubproductos();
        SubBebidas subBebidas = new SubBebidas(this, ventanaProductos);
        panelSubProductos.add(subBebidas);
        pack();
        panelSubProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("BEBIDAS"));
    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComidasActionPerformed
        
        this.limpiarSubproductos();
        SubComidas subComidas = new SubComidas(this, ventanaProductos);
        panelSubProductos.add(subComidas);
        pack();
        panelSubProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("COMIDAS"));
    }//GEN-LAST:event_btnComidasActionPerformed

    private void btnPostresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostresActionPerformed
        
        this.limpiarSubproductos();
        SubPostre subPostres = new SubPostre(this, ventanaProductos);
        panelSubProductos.add(subPostres);
        pack();
        panelSubProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("POSTRES"));
    }//GEN-LAST:event_btnPostresActionPerformed

    private void btnCafesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafesActionPerformed
        
        this.limpiarSubproductos();
        SubCafes subCafes = new SubCafes(this, ventanaProductos);
        panelSubProductos.add(subCafes);
        pack();
        panelSubProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("CAFES"));
    }//GEN-LAST:event_btnCafesActionPerformed

    private void btnOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtrosActionPerformed
        
        this.limpiarSubproductos();
        SubOtros subOtros = new SubOtros(this, ventanaProductos);
        panelSubProductos.add(subOtros);
        pack();
        panelSubProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("OTROS"));
    }//GEN-LAST:event_btnOtrosActionPerformed
                        ///////////////////////////////
    
    ///////////////////// EVENTOS BOTONES CALCULADORA ////////////////////////////////
    
                         //////////////////////////////
    
    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(0);
        }
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(1);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(2);
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(3);
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(4);
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(5);
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(6);
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(7);
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(8);
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        
        if (getTxtPantallaCalculadora().length() < 5) {
            usarCalculadora(9);
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnRetrocesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocesoActionPerformed
        
        String cadena = getTxtPantallaCalculadora();
        if (chivatoDecimal == false) {
            int num = Integer.parseInt(cadena);
            if (num != 0) {
                if (num <= 9) {
                    setTxtPantallaCalculadora("0");
                } else {
                    cadena = cadena.substring(0, cadena.length()-1);
                    setTxtPantallaCalculadora(cadena);
                }
            }
        } else {
            if ('.' == cadena.charAt(cadena.length()-1)) {
                cadena = cadena.substring(0, cadena.length()-1);
                setTxtPantallaCalculadora(cadena);
                chivatoDecimal = false;
            } else {
                cadena = cadena.substring(0, cadena.length()-1);
                setTxtPantallaCalculadora(cadena);
            }
        }
    }//GEN-LAST:event_btnRetrocesoActionPerformed

    private void btnComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComaActionPerformed
        
        if (chivatoDecimal == false && Integer.parseInt(getTxtPantallaCalculadora()) < 999) {
            String cadena = getTxtPantallaCalculadora();
            cadena = cadena + ".";
            setTxtPantallaCalculadora(cadena);
            chivatoDecimal = true;
        }
    }//GEN-LAST:event_btnComaActionPerformed
                          ////////////////////
    
    //////////////////////// EVENTOS BOTONES ///////////////////////////////////
    
                         /////////////////////
    
    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        
        ventanaActual = 1;
        panelMixto.removeAll();
        panelMixto.add(ventanaProductos);
        pack();
        panelMixto.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS"));
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        
        ventanaActual = 2;
        panelMixto.removeAll();
        panelMixto.add(ventanaVerificacionCajero);
        pack();
        panelMixto.setBorder(javax.swing.BorderFactory.createTitledBorder("PEDIDO"));
        
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        
        if (!getTxtPantallaCalculadora().isEmpty()) {
            String cadena = getTxtPantallaCalculadora();
            if (ventanaActual == 1) {                                            // es que estamos en la ventana productos
                if (ventanaProductos.txtSeleccionado == 2) {
                    ventanaProductos.setTxtPrecio(cadena);
                    ventanaProductos.txtSeleccionado = 1;
                }
            } else {
                if (ventanaActual == 2) {                                        // es que estamos en la ventana de verificacion de cajero
                    if (ventanaVerificacionCajero.txtSeleccionado == 1) {
                        ventanaVerificacionCajero.setTxtCaja(cadena);
                        ventanaVerificacionCajero.txtSeleccionado = 2;
                    } else {
                        if(ventanaVerificacionCajero.txtSeleccionado == 2) {
                            ventanaVerificacionCajero.setTxtCajero(cadena);
                            ventanaVerificacionCajero.txtSeleccionado = 1;
                        }
                    }
                } else {                                                        // es que estamos en la ventanaPedidos
                    cant = Integer.parseInt(cadena);
                }
            }
        }
        setTxtPantallaCalculadora("0");
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnAceptarEImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEImprimirActionPerformed
        
        cant = 0;

        subBebidas.limpiarCantidades();
        subCafes.limpiarCantidades();
        subComidas.limpiarCantidades();
        subOtros.limpiarCantidades();
        subPostres.limpiarCantidades();
        
        if (numerodeFilas() != 0) {
            for (int i=numerodeFilas()-1; i>=0; i--) {
                tabla.removeRow(i);
            }
        }
    }//GEN-LAST:event_btnAceptarEImprimirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        cant = 0;
        
        subBebidas.limpiarCantidades();
        subCafes.limpiarCantidades();
        subComidas.limpiarCantidades();
        subOtros.limpiarCantidades();
        subPostres.limpiarCantidades();
        
        if (numerodeFilas() != 0) {
            for (int i=numerodeFilas()-1; i>=0; i--) {
                tabla.removeRow(i);
            }
        }
        txtTotal.setText("0");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
        setTxtPantallaCalculadora("0");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClientesActionPerformed
        
        dialogoClientes.dispose();
    }//GEN-LAST:event_btnCancelarClientesActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        
        construirTablaCliente();
        
        dialogoClientes.setSize(700,350);
        dialogoClientes.setLocation(100,100);
        dialogoClientes.setResizable(false);
        dialogoClientes.setVisible(true);

    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnModificarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClaveActionPerformed
        
        dialogoModificarClave.setSize(400,250);
        dialogoModificarClave.setLocation(100,100);
        dialogoModificarClave.setResizable(false);
        dialogoModificarClave.setVisible(true);
        
    }//GEN-LAST:event_btnModificarClaveActionPerformed
                                 ////////////////////////////
    
////////////////////////////////// EVENTOS MODIFICAR CLAVE  /////////////////////////////////////////
             
                                /////////////////////////////
    
    private void btnCandelarModificarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandelarModificarClaveActionPerformed
        
        txtAntigua.setText("");
        txtNueva.setText("");
        txtRepetir.setText("");
        dialogoModificarClave.dispose();
    }//GEN-LAST:event_btnCandelarModificarClaveActionPerformed

    
    private void btnAceptarModificarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarModificarClaveActionPerformed
        
        if (txtAntigua.getText().equals(password)) {
            if (txtNueva.getText().equals(txtRepetir.getText())) {
                password = txtNueva.getText();
                txtAntigua.setText("");
                txtNueva.setText("");
                txtRepetir.setText("");
                dialogoModificarClave.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al escribir la nueva contraseña");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Antigua contraseña incorrecta");
            txtAntigua.setText("");
            txtNueva.setText("");
            txtRepetir.setText("");
        }
        
    }//GEN-LAST:event_btnAceptarModificarClaveActionPerformed
                     ///////////////////
    
//////////////////////  EVENTOS VENTAS ////////////////////////////////////////
                 
                     //////////////////
    
    private void chkHabitualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkHabitualStateChanged
        
        if (chkHabitual.isSelected()) {
            habitual = true;
        }
    }//GEN-LAST:event_chkHabitualStateChanged

    private void btnSalirVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirVentasActionPerformed
        
        dialogoVentas.dispose();
    }//GEN-LAST:event_btnSalirVentasActionPerformed

    private void btnVentasPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasPorClienteActionPerformed
        
        dialogoClientes.setSize(850,550);
        dialogoClientes.setLocation(100,100);
        dialogoClientes.setResizable(false);
        dialogoVentas.dispose();
        dialogoClientes.setVisible(true);
    }//GEN-LAST:event_btnVentasPorClienteActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        
        dialogoVentas.setSize(850,550);
        dialogoVentas.setLocation(100,100);
        dialogoVentas.setResizable(false);
        dialogoVentas.setVisible(true);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnVentasClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasClienteActionPerformed
        
        dialogoVentas.setSize(850,550);
        dialogoVentas.setLocation(100,100);
        dialogoVentas.setResizable(false);
        dialogoClientes.dispose();
        dialogoVentas.setVisible(true);
    }//GEN-LAST:event_btnVentasClienteActionPerformed

////////////////////////// EVENTOS MENU ////////////////////////////////////////////////////
    
    private void menuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosActionPerformed
        
        ventanaActual = 1;
        panelMixto.removeAll();
        panelMixto.add(ventanaProductos);
        pack();
        panelMixto.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUCTOS"));
    }//GEN-LAST:event_menuProductosActionPerformed

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        
        dialogoClientes.setSize(700,350);
        dialogoClientes.setLocation(100,100);
        dialogoClientes.setResizable(false);
        dialogoClientes.setVisible(true);
    }//GEN-LAST:event_menuClientesActionPerformed

    private void menuVentasPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVentasPorFechaActionPerformed
        
        dialogoVentas.setSize(850,550);
        dialogoVentas.setLocation(100,100);
        dialogoVentas.setResizable(false);
        dialogoVentas.setVisible(true);
    }//GEN-LAST:event_menuVentasPorFechaActionPerformed

    private void menuPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPorClienteActionPerformed
        
        dialogoClientes.setSize(700,350);
        dialogoClientes.setLocation(100,100);
        dialogoClientes.setResizable(false);
        dialogoClientes.setVisible(true);
    }//GEN-LAST:event_menuPorClienteActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        filaSeleccionada = sacarFila();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún producto");
        } else {
            subBebidas.limpiarCantidades();
            subCafes.limpiarCantidades();
            subComidas.limpiarCantidades();
            subOtros.limpiarCantidades();
            subPostres.limpiarCantidades();
            
            Double total = Double.parseDouble(txtTotal.getText());              // Calculamos nuevo total
            Double resta = (Double)tblPedido.getValueAt(filaSeleccionada, 5);
            total = total - resta;
            txtTotal.setText(total.toString());
            
            tabla.removeRow(filaSeleccionada);                                  // eliminamos fila
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void menuNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoPedidoActionPerformed
        
        ventanaActual = 2;
        panelMixto.removeAll();
        panelMixto.add(ventanaVerificacionCajero);
        pack();
        panelMixto.setBorder(javax.swing.BorderFactory.createTitledBorder("PEDIDO"));
    }//GEN-LAST:event_menuNuevoPedidoActionPerformed

    private void btnAplicarDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarDesActionPerformed
        
        dialogoClaveDescuento.setSize(300,270);
        dialogoClaveDescuento.setLocation(100,100);
        dialogoClaveDescuento.setResizable(false);
        dialogoClaveDescuento.setVisible(true);
    }//GEN-LAST:event_btnAplicarDesActionPerformed

/////////////////////  EVENTOS DE DIALOGO CLAVE DE DESCUENTO  //////////////////////////////////////
    
    private void btnCancelarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDescuentoActionPerformed
        
        dialogoClaveDescuento.dispose();
    }//GEN-LAST:event_btnCancelarDescuentoActionPerformed

    private void btnEnterCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterCodigoActionPerformed
        
        
        String codigoCliente = txtCodigoCliente.getText();
    }//GEN-LAST:event_btnEnterCodigoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAceptarPedido;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnAceptarClientes;
    private javax.swing.JButton btnAceptarDescuento;
    private javax.swing.JButton btnAceptarEImprimir;
    private javax.swing.JButton btnAceptarModificarClave;
    private javax.swing.JButton btnAplicarDes;
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnCafes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarClientes;
    private javax.swing.JButton btnCancelarDescuento;
    private javax.swing.JButton btnCandelarModificarClave;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnComa;
    private javax.swing.JButton btnComidas;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnEnterCodigo;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificarClave;
    private javax.swing.JButton btnOtros;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnPostres;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnRetroceso;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirVentas;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVentasCliente;
    private javax.swing.JButton btnVentasFecha;
    private javax.swing.JButton btnVentasHoy;
    private javax.swing.JButton btnVentasPorCliente;
    private javax.swing.JCheckBox chkHabitual;
    private javax.swing.JDialog dialogoClaveDescuento;
    private javax.swing.JDialog dialogoClientes;
    private javax.swing.JDialog dialogoModificarClave;
    private javax.swing.JDialog dialogoVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblHora;
    private javax.swing.JMenuItem menuAplicarDescuento;
    private javax.swing.JMenuItem menuCancelarPedido;
    private javax.swing.JMenuItem menuClientes;
    private javax.swing.JMenu menuMenu;
    private javax.swing.JMenuItem menuNuevoPedido;
    private javax.swing.JMenu menuPedido;
    private javax.swing.JMenuItem menuPorCliente;
    private javax.swing.JMenuItem menuProductos;
    private javax.swing.JMenuItem menuQuitarDescuento;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenu menuVentas;
    private javax.swing.JMenuItem menuVentasPorFecha;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCalculadora;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelMixto;
    private javax.swing.JPanel panelPedido;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JPanel panelSubProductos;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JScrollPane panelTablaCliente;
    private javax.swing.JPanel panelTablasDeVentas;
    private javax.swing.JPanel panelTecladoNumerico;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtAntigua;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtClaveDescuento;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtClienteDescuento;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtDescDescuento;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMarcadorCaja;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNueva;
    private javax.swing.JTextField txtNumeroTicket;
    private javax.swing.JTextField txtPantallacalculadora;
    private javax.swing.JTextField txtRepetir;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
