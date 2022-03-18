
package Metodos;
        
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class MetodosBD {
    
Pool metodospool = new Pool();
public static PreparedStatement preparedString;
public static ResultSet result;
   
public int Guardar(String txtNombrescontacto, String txtApellidoscontacto, String txtEmail, String txtCelular, 
        String cboxSexo, String txtUsername, String txtPassword){

int resultado = 0;

Connection con = null;

String SSQL = "INSERT INTO data (nombres, apellidos, email, celular, sexo, username, password) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";


    try {
    
        con = metodospool.dataSource.getConnection();
        
    try (PreparedStatement psql = con.prepareStatement(SSQL)) {
        psql.setString(1, txtNombrescontacto);
        psql.setString(2, txtApellidoscontacto);
        psql.setString(3, txtEmail);
        psql.setString(4, txtCelular);
        psql.setString(5, cboxSexo);
        psql.setString(6, txtUsername);
        psql.setString(7, txtPassword);
        
        resultado = psql.executeUpdate();
    }
                    
    } catch (SQLException e) {
    
        JOptionPane.showMessageDialog(null, "Error al intentar almacenar la información:\n"
                                     + e, "Error en la operación", JOptionPane.ERROR_MESSAGE);
        
    }finally{
    
        try {
            
            if(con!=null){
            
                con.close();
                
            }
            
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                                     + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            
        }
    
    }

    return resultado;
    
}

public static String SearchUser(String username) {
    
    
    String searchUser = null;
    Connection conexion;
    
    try {
        
        
        conexion = ConexionMySQL.Conectar();
        String searchNames = ("SELECT nombres, apellidos FROM data WHERE username = '" + username + "'");
         preparedString = conexion.prepareStatement(searchNames);
         result = preparedString.executeQuery();
         
         
         if (result.next()) {
             String name = result.getString("nombres");
             String lastName = result.getString("apellidos");
             searchUser = (name +" "+ lastName);
         }
         
         conexion.close();
        
    } catch (SQLException e) {
        
        System.out.println(e);
               
     
        
    }
    
    return searchUser;
    
    
  
}

public static String searchRegistUser (String username, String password) {
    
    String searchUser = null;
    Connection conexion;
    
    try {
        
        
        conexion = ConexionMySQL.Conectar();
        
        String searchUserString = ("SELECT nombres, username,  password FROM data "
                + "WHERE username = '"+username+"'  && password = '"+ password +"'");
        
        preparedString = conexion.prepareStatement(searchUserString);
        result = preparedString.executeQuery();
        if (result.next()) {
            searchUser = "usuario encontrado";
        } else {
            
           searchUser = "usuario no encontardo";
        }
        
        
        conexion.close();
        
    }catch (SQLException e) {
        
        System.out.println(e);
             
        
    }
    
    return searchUser;
    
}
    
    
    
}
      

