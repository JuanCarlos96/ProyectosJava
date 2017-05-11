package TPV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaTicket extends AbstractTableModel{
    ArrayList<Compra> compras;

    String nombresColumnas[] = { 
        "Producto", "Precio", "Cantidad", "Subtotal"
    };

    public ModeloTablaTicket() {
        compras = new ArrayList<>();            
    }

    @Override
    public int getRowCount() {
        return compras.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra c = compras.get(rowIndex);
        switch (columnIndex) {
            case 0: return c.getNombre_producto();
            case 1: return c.getPrecio();
            case 2: return c.getCantidad();
            default: return c.getSubtotal();
        }
    }
    
    @Override
    public Class<?> getColumnClass(int i) {
        return getValueAt(0,i).getClass();
    }
    
    @Override
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    public void llenar(int id) {
        Connection conexion;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String cadenaconexion, usuario, pass;
            usuario = "tpvadmin";
            pass = "tpvadmin";
            cadenaconexion = "jdbc:mysql://localhost/tpv";
            conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection(cadenaconexion,usuario,pass);
            
            String sql = "SELECT p.nombre,p.precio,c.cantidad,ROUND(p.precio*c.cantidad,2) FROM producto p,compra c,ticket t WHERE p.idPRODUCTO=c.PRODUCTO_idPRODUCTO AND c.TICKET_idTICKET=t.idTICKET AND t.idTICKET="+id+";";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            compras.clear();
            
            while (rs.next()) {
                compras.add(
                        new Compra(
                            rs.getString("p.nombre"),
                            rs.getFloat("p.precio"),
                            rs.getInt("c.cantidad"),
                            rs.getFloat("ROUND(p.precio*c.cantidad,2)")
                        )
                );
            }
            
            fireTableDataChanged();
        } catch (ClassNotFoundException ex) {
             System.out.println("Driver no cargado");           
        } catch (SQLException ex) {
            System.out.println("Instruccion SQL no ejecutada");
        }
    }
    
}