/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author fundacion
 */
public class LinkData {
    public static String nombres;
    public static String apellidos;
    public static String email;
    public static String celular;
    public static String sexo;
    
    public LinkData(String text, String text0, String text1, String text2, String toString) {
        LinkData.nombres = text;
        LinkData.apellidos = text0;
        LinkData.email = text1;
        LinkData.celular = text2;
        LinkData.sexo = toString;
    }
    
}
