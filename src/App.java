
import Utilities.ShowDataBase;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fundacion
 */
public class App {
    public static void main(String[] args) throws SQLException {
        ShowDataBase rs = new ShowDataBase();
        String[][] registros = rs.showData();
        
      
        for (String[] registro : registros) {
            System.out.print("[");
            for (int y = 0; y < registro.length; y++) {
                System.out.print(registro[y]);
                if (y != registro.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
             
    }
}
