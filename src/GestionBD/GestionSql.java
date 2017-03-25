
package GestionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author NatxosS
 */
public class GestionSql {
    
    public Connection conexion;
    public Statement sentencia;
    
    public GestionSql() {
        
        try {
            String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName(controlador).newInstance();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el controlador");
        }
    }
    
    public void openConnection() {
        
        try {
            /*String DNS = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+ "Base de datos\\TrabajoObligatorioBD.accdb";
            String user = "";
            String password = "";*/
            conexion = DriverManager.getConnection("jdbc:odbc:trabajoObligatorio");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la conexión");
        }
        try {
            sentencia = conexion.createStatement();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el objeto sentencia");
        }
    }
    
    public void closeConnection() {
        
        
    }
    
    public void executeSql(String proceso) {
        
        
    }
}
