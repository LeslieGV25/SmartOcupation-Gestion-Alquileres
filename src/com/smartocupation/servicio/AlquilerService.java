package com.smartocupation.servicio;

import com.smartocupation.dao.AlquilerDAO;
import com.smartocupation.modelo.Alquiler;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AlquilerService implements IAlquilerService {

    private final AlquilerDAO alquilerDAO;

    public AlquilerService(AlquilerDAO alquilerDAO) {
        this.alquilerDAO = Objects.requireNonNull(alquilerDAO, "alquilerDAO no puede ser null");
    }

    @Override
    public List<Alquiler> obtenerAlquileresPorRango(Date fechaInicio, Date fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin son obligatorias.");
        }
        if (fechaInicio.after(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }

        return alquilerDAO.buscarAlquileresPorFechas(fechaInicio, fechaFin);
    }
}
