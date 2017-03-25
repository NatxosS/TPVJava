
package Acciones.pedido;

/**
 *
 * @author NatxosS
 */
import Principal.ventanasSubProductos.SubComidas;
import java.util.Vector;

public class AccionesPedidoComidas {
    
    private SubComidas subComidas;
    
    public AccionesPedidoComidas(SubComidas subComidas) {
        
        this.subComidas = subComidas;
    }
    
    public void meterProducto(Integer codigo, String descripcion, Double precio, Integer descuento, Integer cantidad) {
        
        //Integer descuento = 10;
        //Double precio = Double.parseDouble(precio1);
        Double subTotal = (precio * cantidad) - (((precio * cantidad)/100) * descuento);
        
        int numFilas = subComidas.getVentanaPrincipal().numerodeFilas();
        Boolean noHabiaRepetidos = true;
        
        if (numFilas > 0) {                                                                               // Si la lista ya no esta vacia comprobamos que no este el pedido
            for (int i=0; i<numFilas; i++) {                                                              // bucle para recorrer las filas
                if (subComidas.getVentanaPrincipal().getTblPedido().getValueAt(i, 1).equals(descripcion)) { // Si la descripcion se repite en alguna fila estaremos ante un 
                    subComidas.getVentanaPrincipal().getTblPedido().setValueAt(cantidad, i, 2);             //      producto ya introducido con lo que modificamos esta fila
                    subComidas.getVentanaPrincipal().getTblPedido().setValueAt(subTotal, i, 5);             //      introduciendo nueva cantidad y nuevo subTotal.
                    subComidas.getVentanaPrincipal().getPanelTabla().setViewportView(subComidas.getVentanaPrincipal().getTblPedido());
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
        
                subComidas.getVentanaPrincipal().getTabla().addRow(filaTabla);
                subComidas.getVentanaPrincipal().getTblPedido().setModel(subComidas.getVentanaPrincipal().getTabla());
                subComidas.getVentanaPrincipal().getPanelTabla().setViewportView(subComidas.getVentanaPrincipal().getTblPedido());  
                subComidas.getVentanaPrincipal().calcularTotal();
            }
        } else {                                                                                         // si la lista aún esta vacia directamente lo metemos
            Vector filaTabla = new Vector();
            filaTabla.add(codigo);
            filaTabla.add(descripcion);
            filaTabla.add(cantidad);
            filaTabla.add(descuento);
            filaTabla.add(precio);
            filaTabla.add(subTotal);
        
            subComidas.getVentanaPrincipal().getTabla().addRow(filaTabla);
            subComidas.getVentanaPrincipal().getTblPedido().setModel(subComidas.getVentanaPrincipal().getTabla());
            subComidas.getVentanaPrincipal().getPanelTabla().setViewportView(subComidas.getVentanaPrincipal().getTblPedido());  
            subComidas.getVentanaPrincipal().calcularTotal();
        }
    }
}
