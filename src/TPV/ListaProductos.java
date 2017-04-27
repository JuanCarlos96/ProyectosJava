package TPV;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaProductos extends ArrayList{
    private ArrayList<Producto> lista;
    private Producto producto;
    private Connection conexion;

    public ListaProductos() {
        lista = new ArrayList();
        this.removeAll(this);
        this.conectar();
        this.llenarLista();
    }
    
    public void conectar() {
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
    
    public void llenarLista(){
        try {
            String sql = "SELECT * FROM producto";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                producto = new Producto(rs.getInt("idPRODUCTO"),rs.getString("nombre"),rs.getFloat("precio"));
                lista.add(producto);
            }
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
    }
    
    public ArrayList nombres() {
        ArrayList nombres = new ArrayList();
        
        for(Producto p:lista) {
            nombres.add(p.getNombre());
        }
        
        return nombres;
    }
}