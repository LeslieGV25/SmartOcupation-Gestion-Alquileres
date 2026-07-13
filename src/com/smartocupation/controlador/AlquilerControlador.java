package com.smartocupation.controlador;

import com.smartocupation.modelo.Alquiler;
import com.smartocupation.servicio.IAlquilerService;
import com.smartocupation.vista.VistaPrincipal;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AlquilerControlador {

    private final VistaPrincipal vista;
    private final IAlquilerService alquilerService;

    /**
     * Constructor principal: inyecta la vista y el servicio.
     */
    public AlquilerControlador(VistaPrincipal vista, IAlquilerService alquilerService) {
        this.vista = vista;
        this.alquilerService = alquilerService;
    }

    /**
     * Método que valida (a nivel de controlador) y obtiene los alquileres mediante
     * el servicio.
     */
    public void procesarBusqueda(Date fechaInicio, Date fechaFin) {
        try {
            List<Alquiler> resultados = alquilerService.obtenerAlquileresPorRango(fechaInicio, fechaFin);

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(vista,
                        "No se encontraron alquileres en ese rango.",
                        "Sin resultados",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            vista.cargarTabla(resultados);
        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(vista,
                    iae.getMessage(),
                    "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista,
                    "Error al buscar alquileres: " + e.getMessage(),
                    "Error de búsqueda",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Genera un informe PDF para el rango indicado delegando en el servicio para
     * obtener datos.
     */
    public void procesarInforme(Date fechaInicio, Date fechaFin) {
        try {
            List<Alquiler> lista = alquilerService.obtenerAlquileresPorRango(fechaInicio, fechaFin);

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "No hay datos para generar el informe",
                        "Sin datos", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            java.io.InputStream molde = getClass()
                    .getResourceAsStream("/com/smartocupation/vista/plantillaAlquileres.jrxml");

            if (molde == null) {
                JOptionPane.showMessageDialog(vista, "No se encontró la plantilla .jrxml",
                        "Plantilla no encontrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            net.sf.jasperreports.engine.JasperReport reporte = net.sf.jasperreports.engine.JasperCompileManager
                    .compileReport(molde);

            net.sf.jasperreports.engine.data.JRBeanCollectionDataSource datos = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(
                    lista);

            java.util.Map<String, Object> parametros = new java.util.HashMap<>();

            net.sf.jasperreports.engine.JasperPrint print = net.sf.jasperreports.engine.JasperFillManager
                    .fillReport(reporte, parametros, datos);

            net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfFile(print, "informe_Alquileres.pdf");

            try {
                java.awt.Desktop.getDesktop().open(new java.io.File("Informe_Alquileres.pdf"));
            } catch (Exception ex) {
                // ignorar error al abrir el PDF automáticamente
            }

            JOptionPane.showMessageDialog(vista, "Informe pdf generado con éxito",
                    "Informe generado", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(vista,
                    iae.getMessage(),
                    "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al generar informe: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
