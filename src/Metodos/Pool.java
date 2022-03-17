/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;


import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
/**
 *
 * @author fundacion
 */
public class Pool {
    
    public DataSource dataSource;
    
    public String db = "bdcontactos";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
    
    public Pool() {
        
        inicializaDataSource();
        
    }
    
    
    private void inicializaDataSource() {
        
        
            BasicDataSource basicDataSource = new BasicDataSource();
            
            basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
            basicDataSource.setUsername(user);
            basicDataSource.setPassword(pass);
            basicDataSource.setUrl(url);
            basicDataSource.setMaxActive(50);
            
            dataSource = basicDataSource;
            
    }
    
    
    
}
