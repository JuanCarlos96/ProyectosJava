package TPV;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    private static Connection conexion;
    
    private static void abrir() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Cargado...");
            String cadenaconexion, usuario, pass;
            usuario = "tpvadmin";
            pass = "tpvadmin";
            cadenaconexion = "jdbc:mysql://localhost/tpv";
            conexion = (Connection) DriverManager.getConnection(cadenaconexion,usuario,pass);
            System.out.println("Base de datos conectada.");
        } catch (ClassNotFoundException ex) {
             System.out.println("Driver no cargado");           
        } catch (SQLException ex) {
            System.out.println("Instruccion SQL no ejecutada");
        }
    }
    
    private static void cerrar() {
        if (conexion!=null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada.");
            } catch (Exception e) {
                System.out.println("No se pudo cerrar la conexión.");
            }
        }
    }
    
    public static int consultaID(String nombre) {
        int id = 0;
        abrir();
        
        try {
            String sql = "SELECT idPRODUCTO FROM producto WHERE nombre='"+nombre+"'";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                id = rs.getInt("idPRODUCTO");
            }
            System.out.println("Lista llena");
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
        
        cerrar();
        return id;
    }
}