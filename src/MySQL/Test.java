/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author almc
 */
public class Test {
    Connection conexion = null;
    
    public Test() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Cargado...");
            String cadenaconexion, usuario, pass;
            usuario = "java";
            pass = "juanca5121996";
            cadenaconexion = "jdbc:mysql://localhost/javadb";
            conexion = (Connection) DriverManager.getConnection(cadenaconexion,usuario,pass);
            System.out.println("Base de datos conectada.");
        } catch (ClassNotFoundException ex) {
             System.out.println("Driver no cargado");           
        } catch (SQLException ex) {
            System.out.println("Instruccion SQL no ejecutada");
        }
    }
    
    public void insertar() {
        try {
            String sql = "INSERT INTO departamento VALUES"
                    + "(null,'Informática',1),"
                    + "(null,'Cocina',1),"
                    + "(null,'Matemáticas',0),"
                    + "(null,'Lengua',0),"
                    + "(null,'Inglés',1);";
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            System.out.println("Datos insertados.");
        } catch (SQLException ex) {
            System.out.println("Error al insertar datos.");
        }
    }

    public void consultar() {
        System.out.println("------------------------------------");
        
        try {
            String sql = "SELECT * FROM departamento";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(
                        rs.getInt("idDep") + ", " +
                        rs.getString("nombre") + ", " +
                        rs.getBoolean("tieneCiclos")
                );
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en consulta");
        }
        
        System.out.println("------------------------------------");
    }
    
    public void cerrar() {
        if (conexion!=null) {
            try {
                conexion.close();
                System.out.println("Conexion cerrada.");
            } catch (Exception e) {
                System.out.println("No se pudo cerrar la conexión.");
            }
        }       
    }
    
    public static void main(String[] args) {
        Test sql = new Test();
        //sql.insertar();
        sql.consultar();
        sql.cerrar();
    }
}