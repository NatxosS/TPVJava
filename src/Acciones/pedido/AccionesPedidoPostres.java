
package Acciones.pedido;

/**
 *
 * @author NatxosS
 */
import Principal.ventanasSubProductos.SubPostre;
import java.util.Vector;

public class AccionesPedidoPostres {
    
    private SubPostre subPostre;
    
    public AccionesPedidoPostres(SubPostre subPostre) {
        
        this.subPostre = subPostre;
    }
    
    public void meterProducto(Integer codigo, String descripcion, Double precio, Integer descuento, Integer cantidad) {
        
        //Integer descuento = 10;
        //Double precio = Double.parseDouble(precio1);
        Double subTotal = (precio * cantidad) - (((precio * cantidad)/100) * descuento);
        
        int numFilas = subPostre.getVentanaPrincipal().numerodeFilas();
        Boolean noHabiaRepetidos = true;
        
        if (numFilas > 0) {                                                                               // Si la lista ya no esta vacia comprobamos que no este el pedido
            for (int i=0; i<numFilas; i++) {                                                              // bucle para recorrer las filas
                if (subPostre.getVentanaPrincipal().getTblPedido().getValueAt(i, 1).equals(descripcion)) { // Si la descripcion se repite en alguna fila estaremos ante un 
                    subPostre.getVentanaPrincipal().getTblPedido().setValueAt(cantidad, i, 2);             //      producto ya introducido con lo que modificamos esta fila
                    subPostre.getVentanaPrincipal().getTblPedido().setValueAt(subTotal, i, 5);             //      introduciendo nueva cantidad y nuevo subTotal.
                    subPostre.getVentanaPrincipal().getPanelTabla().setViewportView(subPostre.getVentanaPrincipal().getTblPedido());
                    noHabiaRepetidos = false;
                }
            }
            if (noHabiaRepetidos == true) {
                Vector filaTabla = new Vector();
                filaTabla.add(codigo);
                filaTabla.add(descripcion);
                filaTabla.add(cantidad);
                filaTabla.add(descuento);
                filaTabla.add(precio);
                filaTabla.add(subTotal);
        
                subPostre.getVentanaPrincipal().getTabla().addRow(filaTabla);
                subPostre.getVentanaPrincipal().getTblPedido().setModel(subPostre.getVentanaPrincipal().getTabla());
                subPostre.getVentanaPrincipal().getPanelTabla().setViewportView(subPostre.getVentanaPrincipal().getTblPedido());  
                subPostre.getVentanaPrincipal().calcularTotal();
            }
        } else {                                                                                         // si la lista aún esta vacia directamente lo metemos
            Vector filaTabla = new Vector();
            filaTabla.add(codigo);
            filaTabla.add(descripcion);
            filaTabla.add(cantidad);
            filaTabla.add(descuento);
            filaTabla.add(precio);
            filaTabla.add(subTotal);
        
            subPostre.getVentanaPrincipal().getTabla().addRow(filaTabla);
            subPostre.getVentanaPrincipal().getTblPedido().setModel(subPostre.getVentanaPrincipal().getTabla());
            subPostre.getVentanaPrincipal().getPanelTabla().setViewportView(subPostre.getVentanaPrincipal().getTblPedido());  
            subPostre.getVentanaPrincipal().calcularTotal();
        }
    }
}
