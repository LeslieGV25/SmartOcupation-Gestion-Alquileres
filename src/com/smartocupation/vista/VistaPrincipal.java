/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smartocupation.vista;

//imports de nuestro modelo
import com.smartocupation.modelo.Alquiler;
// imports de Swing y utilidades
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import com.smartocupation.controlador.AlquilerControlador;
import com.smartocupation.dao.AlquilerDAO;
import com.smartocupation.servicio.AlquilerService;

/**
 * ventana principal de la aplicacion smartOcupation
 * 
 * @author Usuario
 */
public class VistaPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger
            .getLogger(VistaPrincipal.class.getName());

    // referencia al controlador
    private AlquilerControlador controlador;

    // constructor de la ventana
    public VistaPrincipal() {
        // metodo generado por netbeans para dibujar la ventana
        initComponents();

        // inicializamos el DAOy el servicio
        AlquilerDAO alquilerDAO = new AlquilerDAO();
        AlquilerService alquilerService = new AlquilerService(alquilerDAO);

        // inicializamos el controlador con la vista y el servicio (inyección de
        // dependencia)
        controlador = new AlquilerControlador(this, alquilerService);

        // centramos la ventana en la pantalla
        this.setLocationRelativeTo(null);
        this.setTitle("Gestión de Alquileres - SmartOcupation");
    }

    /**
     * metodo personalizado para rrellenar la tabla con una lista de alquileres.
     * este metodo traduce nuestros objetos 'alquiler a filas de la tabla
     */
    public void cargarTabla(List<Alquiler> listaAlquileres) {
        // 1. definimos la columna de la tabla
        String[] columnas = {
                "Expediente", "Fecha", "Cliente", "DNI", "Vivienda", "Precio/Mes", "Tipo", "Duración", "Estado"
        };

        // 2. modelo de la tabla (es quien guarda los datos)
        // hacemos que las celdas no sean editables (sobreescribiendo isCellEditable)
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 3. recorremos la lista y añadimos filas al modelo
        for (Alquiler a : listaAlquileres) {
            String tipo = (a.getTipoAlquiler() != null) ? a.getTipoAlquiler().toString() : "";
            String duracion;
            if (a.getTipoAlquiler() == Alquiler.TipoAlquiler.TURISTICO) {
                duracion = (a.getCantidadNoches() != null) ? a.getCantidadNoches() + " noches" : "";
            } else {
                duracion = a.getTiempoEstimadoMeses() + " meses";
            }

            Object[] fila = {
                    a.getNumExpediente(),
                    a.getFechaEntrada(),
                    a.getCliente().getNombreCompleto(),
                    a.getCliente().getDni(),
                    a.getVivienda().getUbicacion(),
                    a.getVivienda().getPrecioAlquilerMes() + "€",
                    tipo,
                    duracion,
                    a.getEstadoCobro()
            };
            modelo.addRow(fila);
        }

        // 4. asignamos el modelo a la tabla visual
        tablaAlquileres.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlquileres = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jDateChooserFin = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnInforme = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAlquileres.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane2.setViewportView(tablaAlquileres);

        btnBuscar.setText("Buscar Alquileres");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jDateChooserInicio,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 125,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(jDateChooserFin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addComponent(btnBuscar)))
                                .addContainerGap(150, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jDateChooserFin, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(btnBuscar)
                                .addContainerGap(69, Short.MAX_VALUE)));

        jLabel1.setText("Fecha Inicio");

        jLabel2.setText("Fecha Fin");

        btnInforme.setText("Generar Informe");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(120, 120, 120)
                                                                .addComponent(jLabel1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 74,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(91, 91, 91)
                                                                .addComponent(jLabel2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 61,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(51, 51, 51)
                                                                .addComponent(jPanel1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(92, 92, 92)
                                                                .addComponent(btnInforme,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 351,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 61, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnInforme)
                                .addContainerGap(60, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBuscarActionPerformed
        // primero: recogemos las fechas que el usuario eligió en los calendarios
        // usamos el metodo .getdate() del componente JDareChooser
        Date fechaInicio = jDateChooserInicio.getDate();
        Date fechaFin = jDateChooserFin.getDate();
        // delegamos toda la validación y el acceso a datos al controlador
        controlador.procesarBusqueda(fechaInicio, fechaFin);
    }// GEN-LAST:event_btnBuscarActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInformeActionPerformed
        // recogemos las fechas de los calendarios
        java.util.Date fechaInicio = jDateChooserInicio.getDate();
        java.util.Date fechaFin = jDateChooserFin.getDate();
        // delegamos la generación del informe al controlador
        controlador.procesarInforme(fechaInicio, fechaFin);

    }// GEN-LAST:event_btnInformeActionPerformed

    public static void main(String args[]) {
        // Inicializar el diseño moderno FlatLaf
        try {
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Error al inicializar FlatLaf: " + ex.getMessage());
        }

        // Arrancar la ventana principal
        java.awt.EventQueue.invokeLater(() -> new VistaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnInforme;
    private com.toedter.calendar.JDateChooser jDateChooserFin;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaAlquileres;
    // End of variables declaration//GEN-END:variables
}
