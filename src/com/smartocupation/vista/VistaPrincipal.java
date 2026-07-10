/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.smartocupation.vista;
//imports de nuestro modelo y DAO
import com.smartocupation.dao.AlquilerDAO;
import com.smartocupation.modelo.Alquiler;

// imports de Swing y utilidades
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *ventana principal de la aplicacion smartOcupation
 * @author Usuario
 */
public class VistaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VistaPrincipal.class.getName());
    
    //referencia al DAO
    private AlquilerDAO alquilerDAO;
    
    //constructor de la ventana
    public VistaPrincipal() {
     //metodo generado por netbeans para dibujar la ventana
     initComponents();
     
     //inicializamos nuestro DAO
     alquilerDAO = new AlquilerDAO();
     
     //centramos la ventana en la pantalla
     this.setLocationRelativeTo(null);
     this.setTitle("Gestión de Alquileres - SmartOcupation");
    }

    /**
     * metodo personalizado para rrellenar la tabla con una lista de alquileres.
     * este metodo traduce nuestros objetos 'alquiler a filas de la tabla
     */
    private void cargarTabla(List<Alquiler> listaAlquileres){
    //1. definimos la columna de la tabla
    String[] columnas = {
    "Expediente", "Fecha", "Cliente", "DNI", "Vivienda", "Precio/Mes", "Estado"
    };
    
    //2. modelo de la tabla (es quien guarda los datos)
    //hacemos que las celdas no sean editables (sobreescribiendo isellEditable)
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0){
    @Override
    public boolean isCellEditable( int row, int column){
    return false; 
        }
    };
    
    //3. recorremos la lista y añadimos filas al modelo
    for (Alquiler a: listaAlquileres){
    Object[] fila = {
    a.getNumExpediente(),
    a.getFechaEntrada(),
    a.getCliente().getNombreCompleto(),
    a.getCliente().getDni(),
    a.getVivienda().getUbicacion(),
    a.getVivienda().getPrecioAlquilerMes() + "€",
    a.getEstadoCobro()
     };
    modelo.addRow(fila);
    }
    
    //4. asignamos el modelo a la tabla visual
    tablaAlquileres.setModel(modelo);
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAlquileres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
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
                        .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jDateChooserFin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnBuscar)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btnBuscar)
                .addContainerGap(69, Short.MAX_VALUE))
        );

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInforme)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // primero: recogemos las fechas que el usuario eligió en los calendarios
        //usamos el metodo .getdate() del componente JDareChooser
        Date fechaInicio = jDateChooserInicio.getDate();
        Date fechaFin = jDateChooserFin.getDate();
        
        //2. segundo: validamos que no esten vacias 
        //si alguna es null, mostramos una letra y nos vamos (return)
        if (fechaInicio == null || fechaFin == null) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, seleccione ambas fechas.", 
                "Fechas Incompletas", JOptionPane.WARNING_MESSAGE);
            return; 
        }
        
        //3. tercero: validamos que el inicio no sea despues del fin
        if (fechaInicio.after(fechaFin)){
        JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de fin.",
                "Rango Inválido", JOptionPane.WARNING_MESSAGE);
        return;
        }
        //4. cuarto: llamamos al DAO
        try{
            //pedimos al DAO que busque y nos de la lista
        List<Alquiler> resultados = alquilerDAO.buscarAlquileresPorFechas(fechaInicio, fechaFin);
        
        //si  la lista esta vacia avisamos (pero no es un error)
        if (resultados.isEmpty()){
        JOptionPane.showMessageDialog(this, "No se encontraron alquileres en ese rango.",
                "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
           }
        
        //5. quinto: llamamos al metodo cargarTabla pasándole la lista que trajimos 
            cargarTabla(resultados);
            
          }catch(Exception e){
          //si algo explota ( a parte de mi cabeza enn este momento ,claro) mostramos el error
          e.printStackTrace();
          JOptionPane.showMessageDialog(this," Error crítico al buscar: " +e.getMessage(),
          "Error", JOptionPane.ERROR_MESSAGE);
          
          } 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
      //recogemos las fechas de los calendarios 
        java.util.Date fechaInicio = jDateChooserInicio.getDate();
      java.util.Date fechaFin = jDateChooserFin.getDate();
      
      //si alguna fecha esta vacia da aviso y se detiene 
      if(fechaInicio == null || fechaFin == null){
      javax.swing.JOptionPane.showMessageDialog(this,"por favor, selleciona las fechas.");
      return;
      }
      
      //aqui abrimos un bloque try , por si falla la base de datos y llamamos a la clase AlquileresDAO 
      //para traer la lista de alquileres
      try{
      //pedimos la lista al DAO
      java.util.List<com.smartocupation.modelo.Alquiler> lista = alquilerDAO.buscarAlquileresPorFechas(fechaInicio, fechaFin);
      
      //si la lista esta vacia avisamos y paramos 
      if(lista.isEmpty()){
      javax.swing.JOptionPane.showInternalMessageDialog(this,"No hay datos para generar el informe");
      return;
      }
      //en este bloque se carga el archivo , lo compilamos y envolvemos la lista de datos en un
      // paquete que jasper entienda
      
      //cargar ek archivo jrxml
      java.io.InputStream molde = getClass().getResourceAsStream("/com/smartocupation/vista/plantillaAlquileres.jrxml");
      
      if(molde==null){
      javax.swing.JOptionPane.showInternalMessageDialog(this,"ni encuentro el archivo de la plantilla .jrxml");
      return;
      }
      
      //compilamos el reporte 
      net.sf.jasperreports.engine.JasperReport reporte = net.sf.jasperreports.engine.JasperCompileManager.compileReport(molde);
      
      //preparamos los datos, convertimos la lista java a jasper
      net.sf.jasperreports.engine.data.JRBeanCollectionDataSource datos = new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(lista);
      
      //mapa de parametros 
      java.util.Map<String,Object> parametros = new java.util.HashMap<>();
      
      //ahora se junta todo porque se crea el archivo fisico con exportReportToFile y cerramos el bloque try-catch
      
      //llenamos el repprte con los datos
      net.sf.jasperreports.engine.JasperPrint print = net.sf.jasperreports.engine.JasperFillManager.fillReport(reporte, parametros, datos);
      
      //exportar al pdf , creamos el archivo real
      net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfFile(print, "informe_Alquileres.pdf");
      
      //abrir el pdf automaticamente
      try{
      java.awt.Desktop.getDesktop().open(new java.io.File("Informe_Alquileres.pdf"));
      }catch (Exception ex){
      }
      javax.swing.JOptionPane.showMessageDialog(this, "Informe pdf generado con éxito");
      }catch(Exception e){
      e.printStackTrace(); //imprimir error en consola
      javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
      }
        
    }//GEN-LAST:event_btnInformeActionPerformed

    
                                             
        
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(()-> new VistaPrincipal().setVisible(true));
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
