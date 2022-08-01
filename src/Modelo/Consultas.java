
package Modelo;
//Librerias
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Consultas extends Conexion{
    
 /*
 * CRUD producto
 * Recibe: modelo >  Producto
 * Retorna: Boolean y se utilizaza en CtrlNave
 */
    
    //Metodo para reealizar los registros en la base de datos
    public boolean registrar(NaveEspacial pro){
        
        PreparedStatement ps = null; // Esta variable prepara una consulta a traves de "ps"
        Connection con = getConexion(); //Obtenemos nuestra conexion
        
        //Realizamos nuestra consulta
        String sql = "INSERT INTO nave (nombreNave,tipoNave,fechaLanzamiento,pesoTonelada) VALUES (?,?,?,?)";
        
        try{
            
            ps = con.prepareStatement(sql); //Envia la consulta que se realiza en la linea 22
            ps.setString(1, pro.getNombreNave()); //envia a la posicion 1 el objeto que se atrae de Nombre Nave y asi para los demas
            ps.setString(2, pro.getTipoNave());
            ps.setString(3, pro.getFechaLanzamiento());
            ps.setDouble(4, pro.getPesoToneladas());
            ps.execute();//Se termina la ejecucion de la consulta
            
            return true; // retorna true si todo fue digitado de forma correcta
            //Si hay algun error retorna falso
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion registrar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  
//Metodo para modificar los datos de la bd
    public boolean modificar(NaveEspacial pro){
        
        PreparedStatement ps = null; // Esta variable prepara una consulta a traves de "ps"
        Connection con = getConexion();
       //Consulta Update
        String sql = "UPDATE nave SET nombreNave=?,tipoNave=?,fechaLanzamiento=?,pesoTonelada=? WHERE id=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            //Enviamos 
            ps.setString(1, pro.getNombreNave());
            ps.setString(2, pro.getTipoNave());
            ps.setString(3, pro.getFechaLanzamiento());
            ps.setDouble(4, pro.getPesoToneladas());
            ps.setInt(5, pro.getId());
            ps.execute();
            
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion modificar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  

    public boolean eliminar(NaveEspacial pro){
        
        PreparedStatement ps = null; // Esta variable prepara una consulta a traves de "ps"
        Connection con = getConexion();
        
        String sql = "DELETE FROM nave WHERE id=?";
        
        try{
            
            ps = con.prepareStatement(sql);  
            ps.setInt(1, pro.getId());
            ps.execute();
            
            return true;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion eliminar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  

    public boolean buscar(NaveEspacial pro){
        
        PreparedStatement ps = null; // Esta variable prepara una consulta a traves de "ps"
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM nave WHERE nombreNave=?";
        
        try{
            
            ps = con.prepareStatement(sql);  
            ps.setString(1, pro.getNombreNave());
            rs = ps.executeQuery();
            
            if(rs.next()){

                pro.setId( Integer.parseInt(rs.getString("id")));
                pro.setNombreNave(rs.getString("nombreNave"));
                pro.setTipoNave(rs.getString("tipoNave"));
                pro.setFechaLanzamiento(rs.getString("fechaLanzamiento"));
                pro.setPesoToneladas(Double.parseDouble(rs.getString("pesoTonelada")));

                return true;
            }

            return false;
            
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
                System.out.println("Cerrar conexion buscar");
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }  
}
