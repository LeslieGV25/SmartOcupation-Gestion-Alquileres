/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.AlquilerDAO to edit this template
 */
package com.smartocupation.dao;

//importar la conexion
import com.smartocupation.db.ConexionDB;
//importar los moldes 
import com.smartocupation.modelo.Alquiler;
import com.smartocupation.modelo.Cliente;
import com.smartocupation.modelo.Vivienda;

//importar JDBC para SQL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date; // ojo: el que usa el JCalendar
import java.util.List;
import javax.swing.JOptionPane;
/**
 *DAO para la entidad alquiler 
 * esta clase contiene toda la logica para el acceso a los datos 
 * relacionada con los alquileres 
 * @author Usuario
 */
public class AlquilerDAO {
    private Connection conexion;
    /**
     * construcctor del DAO
     */
    public AlquilerDAO(){
    this.conexion = ConexionDB.getConnection();
    }
    
    /**
     * metodo principal
     * busca alquileres en la bbdd que esten dentro de un rango de fechas 
     * @param fechaInicio fecha de inicio del rango
     * @param fechaFin fecha fin del rango
     * @return una lista de objetos Alquiler
     */
    public List<Alquiler> buscarAlquileresPorFechas(Date fechaInicio, Date fechaFin){
    
        //1. preparamos la lista para guardar los resultados
        List<Alquiler> alquileresEncontrados = new ArrayList<>();
        
        //2. esta es la consulta SQL . es la parte mas importante 
        //usamos join para unir las 3 tablas y traer todos los datos de una
        // 'a' es alias de Alquileres
        //'c' de Clientes
        //'v' de Viviendas
        String sql = "SELECT " + 
         "a.id_alquiler, a.num_expediente, a.fecha_entrada, a.tiempo_estimado_meses, a.estado_cobro, " +
                     "c.id_cliente, c.dni, c.nombre_completo, c.email, c.telefono, c.datos_facturacion, " +
                     "v.id_vivienda, v.ref_catastral, v.ubicacion, v.metros_cuadrados, v.habitaciones, v.banos, v.precio_alquiler_mes " +
                     "FROM Alquileres a " +
                     "JOIN Clientes c ON a.id_cliente = c.id_cliente " +
                     "JOIN Viviendas v ON a.id_vivienda = v.id_vivienda " +
                     "WHERE a.fecha_entrada >= ? AND a.fecha_entrada <= ? " +
                     "ORDER BY a.fecha_entrada DESC"; // ORDENA POR FECHAS
        
        //3  usamos try-with-resources para qyue el PreparedStatement se cierre solo
        try(PreparedStatement pstmt = this.conexion.prepareStatement(sql)){
        
            //4. asignamos valores a los "?" 
            //esto en vital para la seguridad porue evita la inyeccion sql
            //y para que las fechas funcionen bien
            
            //el ? en la posicion 1 es la fechaInicio
            //CONVERTIMOS DE JAVA.UTIL.DATE A JAVA.SQL.DATE
            pstmt.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            pstmt.setDate(2, new java.sql.Date(fechaFin.getTime()));
            
              System.out.println("Ejecutando SQL: " + pstmt);
              
            //5. ejecutar la consulta y obtener los resultadosç
            ResultSet rs = pstmt.executeQuery();
            
            //6. recorrer los resultados 
            while(rs.next()){
            
                //creamos los tres objetos molde vacios
                Alquiler alquiler = new Alquiler();
                Cliente cliente = new Cliente();
                Vivienda vivienda = new Vivienda();
                
                //rellenamos el objeto vivienda
                vivienda.setIdVivienda(rs.getInt("id_vivienda"));
                vivienda.setRefCatastral(rs.getString("ref_catastral"));
                vivienda.setUbicacion(rs.getString("ubicacion"));
                vivienda.setMetrosCuadrados(rs.getInt("metros_cuadrados"));
                vivienda.setHabitaciones(rs.getInt("habitaciones"));
                vivienda.setBanos(rs.getInt("banos"));
                vivienda.setPrecioAlquilerMes(rs.getDouble("precio_alquiler_mes"));
                
                // rellenamos el objeto Cliente
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setDni(rs.getString("dni"));
                cliente.setNombreCompleto(rs.getString("nombre_completo"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDatosFacturacion(rs.getString("datos_facturacion"));

                // rellenamos el objeto Alquiler
                alquiler.setIdAlquiler(rs.getInt("id_alquiler"));
                alquiler.setNumExpediente(rs.getString("num_expediente"));
                alquiler.setFechaEntrada(rs.getDate("fecha_entrada"));
                alquiler.setTiempoEstimadoMeses(rs.getInt("tiempo_estimado_meses"));
                alquiler.setEstadoCobro(rs.getString("estado_cobro"));
                
                //7 aqui hacemos la magia 
                //metemos el objeto cliente y Vivienda dentro del alquiler
                alquiler.setCliente(cliente);
                alquiler.setVivienda(vivienda);
                
                //8 añadimos el alquiler completo a nuestra lista
                alquileresEncontrados.add(alquiler);
            }
            System.out.println("Busqueda finalizada. Encontrados: "+ alquileresEncontrados.size());
        } catch(SQLException e){
            System.out.println("Error al buscar alquileres por fecha: "+ e.getMessage());
            e.printStackTrace();
            //informamos al usuario con un dialogo
            JOptionPane.showMessageDialog(null,"Error al consultar la base de datos: "+ e.getMessage(),
                    "Error de Busqueda",JOptionPane.ERROR_MESSAGE);
        }
        //9 devolvemos la lista (vacia o llena)
        return alquileresEncontrados;
    
    }
}
    



















