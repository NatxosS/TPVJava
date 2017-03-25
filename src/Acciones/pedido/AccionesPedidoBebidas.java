

package Acciones.pedido;

/**
 *
 * @author NatxosS
 */
import Principal.ventanasSubProductos.SubBebidas;
import java.util.Vector;

public class AccionesPedidoBebidas {
    
    private SubBebidas subBebidas;
    
    public AccionesPedidoBebidas(SubBebidas subBebidas) {
        
        this.subBebidas = subBebidas;
    }
    
    public void meterProducto(Integer codigo, String descripcion, Double precio, Integer descuento, Integer cantidad) {
        
        //Integer descuento = 10;
        //Double precio = Double.parseDouble(precio1);
        Double subTotal = (precio * cantidad) - (((precio * cantidad)/100) * descuento);
        
        int numFilas = subBebidas.getVentanaPrincipal().numerodeFilas();
        Boolean noHabiaRepetidos = true;
        
        if (numFilas > 0) {                                                                               // Si la lista ya no esta vacia comprobamos que no este el pedido
            for (int i=0; i<numFilas; i++) {                                                              // bucle para recorrer las filas
                if (subBebidas.getVentanaPrincipal().getTblPedido().getValueAt(i, 1).equals(descripcion)) { // Si la descripcion se repite en alguna fila estaremos ante un 
                    subBebidas.getVentanaPrincipal().getTblPedido().setValueAt(cantidad, i, 2);             //      producto ya introducido con lo que modificamos esta fila
                    subBebidas.getVentanaPrincipal().getTblPedido().setValueAt(subTotal, i, 5);             //      introduciendo nueva cantidad y nuevo subTotal.
                    subBebidas.getVentanaPrincipal().getPanelTabla().setViewportView(subBebidas.getVentanaPrincipal().getTblPedido());
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
        
                subBebidas.getVentanaPrincipal().getTabla().addRow(filaTabla);
                subBebidas.getVentanaPrincipal().getTblPedido().setModel(subBebidas.getVentanaPrincipal().getTabla());
                subBebidas.getVentanaPrincipal().getPanelTabla().setViewportView(subBebidas.getVentanaPrincipal().getTblPedido());  
                subBebidas.getVentanaPrincipal().calcularTotal();
            }
        } else {                                                                                         // si la lista aún esta vacia directamente lo metemos
            Vector filaTabla = new Vector();
            filaTabla.add(codigo);
            filaTabla.add(descripcion);
            filaTabla.add(cantidad);
            filaTabla.add(descuento);
            filaTabla.add(precio);
            filaTabla.add(subTotal);
        
            subBebidas.getVentanaPrincipal().getTabla().addRow(filaTabla);
            subBebidas.getVentanaPrincipal().getTblPedido().setModel(subBebidas.getVentanaPrincipal().getTabla());
            subBebidas.getVentanaPrincipal().getPanelTabla().setViewportView(subBebidas.getVentanaPrincipal().getTblPedido());  
            subBebidas.getVentanaPrincipal().calcularTotal();
        }
    }
}
