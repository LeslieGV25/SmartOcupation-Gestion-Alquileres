/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartocupation.modelo;

/**
 POJO / Molde que representa una fila de la tabla 'Viviendas'.
 * Usamos 'double' para el precio, para que coincida con la bbdd.
 * @author Usuario
 */
public class Vivienda {
    //ojo debo poner los atributos de tal modo que coincida con la BD
    private int idVivienda;
    private String refCatastral;
    private String ubicacion;
    private int metrosCuadrados;
    private int habitaciones;
    private int banos;
    private double precioAlquilerMes;
    
    public Vivienda(){
        
  }

    public int getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(int idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getRefCatastral() {
        return refCatastral;
    }

    public void setRefCatastral(String refCatastral) {
        this.refCatastral = refCatastral;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public double getPrecioAlquilerMes() {
        return precioAlquilerMes;
    }

    public void setPrecioAlquilerMes(double precioAlquilerMes) {
        this.precioAlquilerMes = precioAlquilerMes;
    }

    //metodo tostring 
    //para depurar y ver lo que tiene el objeto en consola
    
    @Override
    public String toString(){
    return "Vivienda{" + "id="+ idVivienda + ", ref=" + refCatastral + " , ubicacion=" + ubicacion + '}';
    }
}
