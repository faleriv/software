package conexion;

/**
 *
 * @author valer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

    
public class Conexion {
    
    static Connection contacto = null;
    
    
    public static Connection getConexion()
    {
        String url ="jdbc:sqlserver://DESKTOP-KL50MP5:1433;databaseName=sf_si";//Diego
         //String url ="jdbc:sqlserver://DESKTOP-MR4QM66:1433;databaseName=sf_si";//Vale
         //String url ="jdbc:sqlserver://DESKTOP-4S9GK79:1433;databaseName=sf_si";//jose
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión, revisar Driver"+e.getMessage(),"Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
        try
        {
            contacto = DriverManager.getConnection(url,"sa","Diego2420347");//Diego
            //contacto = DriverManager.getConnection(url,"sa","fielEsJesus");//Vale
            //contacto = DriverManager.getConnection(url,"sa","12345");//Jose
        }
       catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage(),"Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    public static ResultSet consulta(String consulta)
    {
        Connection con = getConexion();
        Statement declara;
        try
        {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage(),"Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }   
    
    
    
}
