package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Conexion
 * Retorna variable conexion: con
 */
public class Conexion {
    
    private final String base= "navesEspaciales"; //Nombre Bd
    private final String user="root";//Usuario
    private final String password="";//Clave Bd
    private final String url = "jdbc:mysql://localhost:3306/"+base; //Direccion de la bd
    
    private Connection con = null; //Declaro variable conexion

    /*Funcion Conseguir Conexion */
    public Connection getConexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Controlador mysql y java
            //Establecemos la conexion con las propiedes declaradas para la base de datos
            con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
            System.out.println("conexion establecida con exito "); // Conexion Exitosa
        }catch(SQLException e){
            System.err.println(e);
        
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con; // Valor de los datos obtenidos retornando
    }

}
