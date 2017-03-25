
package Acciones.pedido;

/**
 *
 * @author NatxosS
 */
import Principal.ventanasSubProductos.SubCafes;
import java.util.Vector;

public class AccionesPedidoCafes {
    
    private SubCafes subCafes;
    
    public AccionesPedidoCafes(SubCafes subCafes) {
        
        this.subCafes = subCafes;
    }
    
    public void meterProducto(Integer codigo, String descripcion, Double precio, Integer descuento, Integer cantidad) {
        
        //Integer descuento = 10;
        //Double precio = Double.parseDouble(precio1);
        Double subTotal = (precio * cantidad) - (((precio * cantidad)/100) * descuento);
        
        int numFilas = subCafes.getVentanaPrincipal().numerodeFilas();
        Boolean noHabiaRepetidos = true;
        
        if (numFilas > 0) {                                                                               // Si la lista ya no esta vacia comprobamos que no este el pedido
            for (int i=0; i<numFilas; i++) {                                                              // bucle para recorrer las filas
                if (subCafes.getVentanaPrincipal().getTblPedido().getValueAt(i, 1).equals(descripcion)) { // Si la descripcion se repite en alguna fila estaremos ante un 
                    subCafes.getVentanaPrincipal().getTblPedido().setValueAt(cantidad, i, 2);             //      producto ya introducido con lo que modificamos esta fila
                    subCafes.getVentanaPrincipal().getTblPedido().setValueAt(subTotal, i, 5);             //      introduciendo nueva cantidad y nuevo subTotal.
                    subCafes.getVentanaPrincipal().getPanelTabla().setViewportView(subCafes.getVentanaPrincipal().getTblPedido());
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
        
                subCafes.getVentanaPrincipal().getTabla().addRow(filaTabla);
                subCafes.getVentanaPrincipal().getTblPedido().setModel(subCafes.getVentanaPrincipal().getTabla());
                subCafes.getVentanaPrincipal().getPanelTabla().setViewportView(subCafes.getVentanaPrincipal().getTblPedido());  
                subCafes.getVentanaPrincipal().calcularTotal();
            }
        } else {                                                                                         // si la lista aún esta vacia directamente lo metemos
            Vector filaTabla = new Vector();
            filaTabla.add(codigo);
            filaTabla.add(descripcion);
            filaTabla.add(cantidad);
            filaTabla.add(descuento);
            filaTabla.add(precio);
            filaTabla.add(subTotal);
        
            subCafes.getVentanaPrincipal().getTabla().addRow(filaTabla);
            subCafes.getVentanaPrincipal().getTblPedido().setModel(subCafes.getVentanaPrincipal().getTabla());
            subCafes.getVentanaPrincipal().getPanelTabla().setViewportView(subCafes.getVentanaPrincipal().getTblPedido());  
            subCafes.getVentanaPrincipal().calcularTotal();
        }
    }
}
