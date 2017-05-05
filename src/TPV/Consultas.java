package TPV;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Consultas {
    private static Connection conexion;
    
    private static void abrir() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String cadenaconexion, usuario, pass;
            usuario = "tpvadmin";
            pass = "tpvadmin";
            cadenaconexion = "jdbc:mysql://localhost/tpv";
            conexion = (Connection) DriverManager.getConnection(cadenaconexion,usuario,pass);
        } catch (ClassNotFoundException ex) {
             System.out.println("Driver no cargado");           
        } catch (SQLException ex) {
            System.out.println("Instruccion SQL no ejecutada");
        }
    }
    
    public static void cerrar() {
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
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
        return id;
    }
    
    public static float consultaPrecio(String nombre) {
        float precio = 0;
        abrir();
        
        try {
            String sql = "SELECT precio FROM producto WHERE nombre='"+nombre+"'";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                precio = rs.getFloat("precio");
            }
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
        return precio;
    }
    
    public static void rellenarTabla(DefaultTableModel modelo) {
        abrir();
        try {
            String sql = "SELECT * FROM producto";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Object[] producto = new Object[3];
                producto[0] = rs.getInt("idPRODUCTO");
                producto[1] = rs.getString("nombre");
                producto[2] = rs.getFloat("precio");
                modelo.addRow(producto);
            }
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
    }
    
    public static void addProducto(String nombre, float precio) {
        abrir();
        try {
            String sql = "INSERT INTO producto (nombre,precio) VALUES"
                    + "('"+nombre+"',"+precio+");";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Datos insertados.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos.");
        }
    }
    
    public static void delProducto(int id) {
        abrir();
        try {
            String sql = "DELETE FROM producto WHERE idPRODUCTO="+id+";";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Datos borrados.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos.");
        }
    }
    
    public static void modProducto(int id,String nombre,float precio) {
        abrir();
        try {
            String sql = "UPDATE producto SET nombre='"+nombre+"',precio="+precio+" WHERE idPRODUCTO="+id+";";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Datos modificados.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos.");
        }
    }
    
    public static int consultaIdTicket() {
        int id=0;
        abrir();
        
        try {
            String sql = "SELECT ifnull(max(idTICKET),0) FROM ticket;";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                id = rs.getInt("idTICKET");
            }
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
        id++;
        return id;
    }
}