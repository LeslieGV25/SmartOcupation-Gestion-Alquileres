/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartocupation.modelo;

//importamos la clase date para manejar la fecha de entrada 
import java.util.Date;

/**
 * POJO/ representa un alquiler
 * esta es la clase principal que compone las otras clases
 * la clase alquiler tiene sus propios datos, tiene un CLIENTE Y una VIVIENDA
 * 
 * @author Usuario
 */
public class Alquiler {
    public enum TipoAlquiler {
        LARGA_DURACION,
        TURISTICO
    }

    // atributos de la tabla alquileres
    private int idAlquiler;
    private String numExpediente;
    private Date fechaEntrada; // Usamos java.util.Date
    private int tiempoEstimadoMeses;
    private String estadoCobro;
    private TipoAlquiler tipoAlquiler;
    private Integer cantidadNoches;
    private Double tarifaLimpieza;

    public Alquiler() {
    }

    public Alquiler(int idAlquiler, String numExpediente, Date fechaEntrada, int tiempoEstimadoMeses,
            String estadoCobro, TipoAlquiler tipoAlquiler, Integer cantidadNoches, Double tarifaLimpieza,
            Cliente cliente, Vivienda vivienda) {
        this.idAlquiler = idAlquiler;
        this.numExpediente = numExpediente;
        this.fechaEntrada = fechaEntrada;
        this.tiempoEstimadoMeses = tiempoEstimadoMeses;
        this.estadoCobro = estadoCobro;
        this.tipoAlquiler = tipoAlquiler;
        this.cantidadNoches = cantidadNoches;
        this.tarifaLimpieza = tarifaLimpieza;
        this.cliente = cliente;
        this.vivienda = vivienda;
    }

    // para un mejor manejo de datos en la inrterfaz voy a guardar
    // los objetos enteros , en vez de solo los IDS
    private Cliente cliente;
    private Vivienda vivienda;

    // getters y setters

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getTiempoEstimadoMeses() {
        return tiempoEstimadoMeses;
    }

    public void setTiempoEstimadoMeses(int tiempoEstimadoMeses) {
        this.tiempoEstimadoMeses = tiempoEstimadoMeses;
    }

    public String getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(String estadoCobro) {
        this.estadoCobro = estadoCobro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public TipoAlquiler getTipoAlquiler() {
        return tipoAlquiler;
    }

    public void setTipoAlquiler(TipoAlquiler tipoAlquiler) {
        this.tipoAlquiler = tipoAlquiler;
    }

    public Integer getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(Integer cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public Double getTarifaLimpieza() {
        return tarifaLimpieza;
    }

    public void setTarifaLimpieza(Double tarifaLimpieza) {
        this.tarifaLimpieza = tarifaLimpieza;
    }

    @Override
    public String toString() {
        // Un toString más completo para depurar
        String nombreCliente = (cliente != null) ? cliente.getNombreCompleto() : "N/A";
        String ubicacionVivienda = (vivienda != null) ? vivienda.getUbicacion() : "N/A";

        return "Alquiler{" + "exp=" + numExpediente + ", fecha=" + fechaEntrada +
                ", cliente=" + nombreCliente + ", vivienda=" + ubicacionVivienda + '}';
    }
}
