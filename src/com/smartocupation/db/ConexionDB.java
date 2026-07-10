/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartocupation.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; //importamos el diálogo para los errores


public class ConexionDB {

    // constantes para la conexión
    // añadimos parámetros para evitar errores comunes de zona horaria y SSL
    private static final String URL = "jdbc:mysql://localhost:3306/smartocupation?useSSL=false&serverTimezone=UTC";
    
    // driver de mysql
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    // credenciales de XAMPP 
    private static final String USER = "root";
    private static final String PASSWORD = ""; // La contraseña de root en XAMPP es vacía

    // guarda la instancia de la conexion
    private static Connection conexion = null;

    /**
     * Constructor privado para evitar que se creen múltiples instancias.
     */
    private ConexionDB() {
        // Constructor vacío
    }

    /**
     * metodo público estático para obtener la conexión.
     * si la conexión no existe (es nula), la crea.
     * si ya existe, devuelve la existente.
     */
    public static Connection getConnection() {

        if (conexion == null) {
            try {
                // 1.cargar el Driver
                Class.forName(DRIVER);
                
                // 2. Establecer la conexión
                // Usamos el DriverManager para pedir una conexión con nuestras credenciales
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                
                System.out.println("Conexión a MySQL  establecida con éxito.");

            } catch (ClassNotFoundException e) {
                System.out.println("Error: No se encontró el Driver de MySQL (JAR).");
                
                
            } catch (SQLException e) {
                System.out.println("Error al conectar con MySQL: " + e.getMessage());
            }
        }
        
        // devuelve la conexion (nueva o existente)
        return conexion;
    }
}