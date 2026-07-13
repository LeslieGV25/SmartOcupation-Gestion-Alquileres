package com.smartocupation.servicio;

import com.smartocupation.modelo.Alquiler;
import java.util.Date;
import java.util.List;

public interface IAlquilerService {
    List<Alquiler> obtenerAlquileresPorRango(Date fechaInicio, Date fechaFin);
}
