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

    public String dbServer = "mysql-72602-0.cloudclusters.net"; // change it to your database server name
    public int dbPort = 12447; // change it to your database server port
    public String dbName = "UsersLogin";
    public String userName = "admin";
    public String password = "Jye0g2UG";
    public String url = "jdbc:mysql://" + dbServer + ":" + dbPort + "/" + dbName + "?characterEncoding=utf8";


    public Pool() {
        
        inicializaDataSource();
        
    }
    
    
    private void inicializaDataSource() {
        
        
            BasicDataSource basicDataSource = new BasicDataSource();
            
            basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
            basicDataSource.setUsername(userName);
            basicDataSource.setPassword(password);
            basicDataSource.setUrl(url);
            basicDataSource.setMaxActive(50);
            
            dataSource = basicDataSource;
            
    }
    
    
    
}
