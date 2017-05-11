package TPV;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class ModeloListaTicket extends AbstractListModel{
    private ArrayList<Ticket> lista;
    private Connection conexion;

    public ModeloListaTicket() {
        lista = new ArrayList<>();
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
        this.rellenar();
    }
    
    public void rellenar() {
        lista.clear();
        try {
            String sql = "SELECT * FROM ticket WHERE precio_total!=0";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                Ticket t = new Ticket(rs.getInt("idTICKET"),rs.getDate("fecha"),rs.getFloat("precio_total"));
                lista.add(t);
            }
            fireIntervalAdded(null, 0, lista.size());
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }
    
    
}