
package Acciones.pedido;

/**
 *
 * @author NatxosS
 */
import Principal.ventanasSubProductos.SubOtros;
import java.util.Vector;

public class AccionesPedidoOtros {
    
    private SubOtros subOtros;
    
    public AccionesPedidoOtros(SubOtros subOtros) {
        
        this.subOtros = subOtros;
    }
    
    public void meterProducto(Integer codigo, String descripcion, Double precio, Integer descuento, Integer cantidad) {
        
        //Integer descuento = 10;
        //Double precio = Double.parseDouble(precio1);
        Double subTotal = (precio * cantidad) - (((precio * cantidad)/100) * descuento);
        
        int numFilas = subOtros.getVentanaPrincipal().numerodeFilas();
        Boolean noHabiaRepetidos = true;
        
        if (numFilas > 0) {                                                                               // Si la lista ya no esta vacia comprobamos que no este el pedido
            for (int i=0; i<numFilas; i++) {                                                              // bucle para recorrer las filas
                if (subOtros.getVentanaPrincipal().getTblPedido().getValueAt(i, 1).equals(descripcion)) { // Si la descripcion se repite en alguna fila estaremos ante un 
                    subOtros.getVentanaPrincipal().getTblPedido().setValueAt(cantidad, i, 2);             //      producto ya introducido con lo que modificamos esta fila
                    subOtros.getVentanaPrincipal().getTblPedido().setValueAt(subTotal, i, 5);             //      introduciendo nueva cantidad y nuevo subTotal.
                    subOtros.getVentanaPrincipal().getPanelTabla().setViewportView(subOtros.getVentanaPrincipal().getTblPedido());
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
        
                subOtros.getVentanaPrincipal().getTabla().addRow(filaTabla);
                subOtros.getVentanaPrincipal().getTblPedido().setModel(subOtros.getVentanaPrincipal().getTabla());
                subOtros.getVentanaPrincipal().getPanelTabla().setViewportView(subOtros.getVentanaPrincipal().getTblPedido());  
                subOtros.getVentanaPrincipal().calcularTotal();
            }
        } else {                                                                                         // si la lista aún esta vacia directamente lo metemos
            Vector filaTabla = new Vector();
            filaTabla.add(codigo);
            filaTabla.add(descripcion);
            filaTabla.add(cantidad);
            filaTabla.add(descuento);
            filaTabla.add(precio);
            filaTabla.add(subTotal);
        
            subOtros.getVentanaPrincipal().getTabla().addRow(filaTabla);
            subOtros.getVentanaPrincipal().getTblPedido().setModel(subOtros.getVentanaPrincipal().getTabla());
            subOtros.getVentanaPrincipal().getPanelTabla().setViewportView(subOtros.getVentanaPrincipal().getTblPedido());  
            subOtros.getVentanaPrincipal().calcularTotal();
        }
    }
}
