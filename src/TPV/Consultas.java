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
            System.out.println("Error al consultar id del producto.");
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
            System.out.println("Error al consultar precio.");
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
            System.out.println("Error al rellenar la tabla.");
        }
    }
    
    public static void addProducto(String nombre, float precio) {
        abrir();
        try {
            String sql = "INSERT INTO producto (nombre,precio) VALUES"
                    + "('"+nombre+"',"+precio+");";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Producto añadido.");
        } catch (SQLException ex) {
            System.out.println("Error al añadir producto.");
        }
    }
    
    public static void delProducto(int id) {
        abrir();
        try {
            String sql = "DELETE FROM producto WHERE idPRODUCTO="+id+";";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Producto borrado.");
        } catch (SQLException ex) {
            System.out.println("Error al borrar el producto.");
        }
    }
    
    public static void modProducto(int id,String nombre,float precio) {
        abrir();
        try {
            String sql = "UPDATE producto SET nombre='"+nombre+"',precio="+precio+" WHERE idPRODUCTO="+id+";";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Producto modificado.");
        } catch (SQLException ex) {
            System.out.println("Error al modificar el producto.");
        }
    }
    
    public static int consultaIdTicket() {
        int id=0;
        abrir();
        
        try {
            String sql = "SELECT max(idTICKET) FROM ticket;";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                id = rs.getInt("max(idTICKET)");
            }
        } catch (SQLException ex) {
            System.out.println("Error en consulta: No existe ningún ID de ticket.");
        }
        id++;
        return id;
    }
    
    public static void addTicket(int idTicket,String fecha) {
        abrir();
        try {
            String sql = "INSERT INTO ticket VALUES"
                    + "("+idTicket+",'"+fecha+"',"+0+");";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Ticket insertado.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos del nuevo ticket.");
        }
    }
    
    public static void modTicket(int id,float precio_total) {
        abrir();
        try {
            String sql = "UPDATE ticket SET precio_total="+precio_total+" WHERE idTICKET="+id+";";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Ticket guardado.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar el ticket.");
        }
    }
    
    public static void delTicket(int idTicket) {
        float precio=-1;
        abrir();
        
        try {
            String sql = "SELECT precio_total FROM ticket WHERE idTICKET="+idTicket+";";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                precio = rs.getFloat("precio_total");
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar precio del ticket.");
        }
        
        if(precio==0) {
            try {
                String sql = "DELETE FROM ticket WHERE idTicket="+idTicket+";";
                Statement st = conexion.createStatement();
                st.executeUpdate(sql);
                System.out.println("Ticket vacío borrado.");
                removeAllCompras(idTicket);
            } catch (SQLException ex) {
                System.out.println("Error al borrar ticket.");
            }
        }
    }
    
    public static void addCompra(int idProd, int idTicket, int cantidad) {
        abrir();
        try {
            String sql = "INSERT INTO compra VALUES"
                    + "("+idProd+","+idTicket+","+cantidad+");";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Compra insertada.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar compra.");
        }
    }
    
    public static void delCompra(int idProd, int idTicket) {
        abrir();
        try {
            String sql = "DELETE FROM compra WHERE PRODUCTO_idPRODUCTO="+idProd+" AND TICKET_idTICKET="+idTicket+";";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Compra borrada.");
        } catch (SQLException ex) {
            System.out.println("Error al borrar compra.");
        }
    }
    
    public static void removeAllCompras(int idTicket) {
        abrir();
        try {
            String sql = "DELETE FROM compra WHERE TICKET_idTICKET="+idTicket+";";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Compras pertenecientes al ticket "+idTicket+" borradas.");
        } catch (SQLException ex) {
            System.out.println("Error al borrar compras del ticket "+idTicket+".");
        }
    }
}