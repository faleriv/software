/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
        

public class Procedimientos {
    
    static ResultSet res;
    
    public boolean consultarSiExiste(String campo, String tabla,String valorConsulta)
    {
        int cont = 0; 
        boolean band = false;
        String query = "Select COUNT ("+campo+") from "+tabla+" where "+campo+"='"+valorConsulta+"'";
        try
            {
                res = conexion.Conexion.consulta(query);
                while(res.next())
                {
                    cont = res.getInt(1);
                }
            }
        catch(SQLException e)
            {
            
            }
        if(cont>=1)
            band = true;
        return band;
            
    }
    public int consultarCuantos(String campo, String tabla)
    {
        int cont = 0; 
        boolean band = false;
        String query = "Select COUNT ("+campo+") from "+tabla;
        try
            {
                res = conexion.Conexion.consulta(query);
                while(res.next())
                {
                    cont = res.getInt(1);
                }
            }
        catch(SQLException e)
            {
            
            }
        
        return cont;
            
    }    
    
    public static String generaIncog(int num)
    {
        String cadena= "?";
        for (int i=0; i < num -1 ; i++)
        {
            cadena +=",?";
        }
        return cadena;
    }
      public static void registro(String a [], String procedimiento) throws SQLException
    {
        //El tamaño del string representa  el número de campos
        String cadena = "{call "+procedimiento+"("+generaIncog(a.length)+")}";        
        CallableStatement entrada = Conexion.getConexion().prepareCall(cadena);
        
        for (int i =0; i< a.length; i++)
        {
            entrada.setString(i+1,a[i]);
        }
        entrada.execute();
     
        
    }
      
      public static void actualizarEquipo(String codigo,String estado, String ruc) throws SQLException
      {
        String cadena = "{call ActualizarEquipo (?,?,?)}";        
        CallableStatement entrada = Conexion.getConexion().prepareCall(cadena);
        entrada.setString(1, codigo);
        entrada.setString(2, estado);
        entrada.setString(3, ruc);
        entrada.execute();
      }
      
      public static void actArrDisp(String cod) throws SQLException
      {
        String cadena = "{call ActArrDis (?)}";        
        CallableStatement entrada = Conexion.getConexion().prepareCall(cadena);
        entrada.setString(1, cod);
        entrada.execute();
      }
      public static void anularContrato(String cod, String ruc) throws  SQLException
      {
        String cadena = "{call AnularContrato (?)}";        
        CallableStatement entrada = Conexion.getConexion().prepareCall(cadena);
        entrada.setString(1, ruc);
        entrada.setString(2, cod);
        entrada.execute();
      }
      public static void eliminar(String procedimiento, String condicion) throws SQLException{
         String cadena = "{call "+procedimiento+"("+condicion+")}"; 
         CallableStatement entrada = Conexion.getConexion().prepareCall(cadena);
         entrada.execute();
     }
      

}
