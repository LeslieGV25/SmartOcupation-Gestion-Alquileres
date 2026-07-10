/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartocupation.db;

import java.sql.Connection;
//clase de prueba temporal
public class MainTest {
   
     public static void main(String[] args) {
        System.out.println("Intentando conectar a la base de datos...");
        
        // Pedimos la conexión
        Connection conn = ConexionDB.getConnection();
        
        if (conn != null) {
            System.out.println("¡ÉXITO! La conexión no es nula.");
            System.out.println("Prueba del Paso 1 superada.");
        } else {
            System.out.println("FALLO. La conexión es nula. Revisa los errores en la consola.");
        }
    }
}
