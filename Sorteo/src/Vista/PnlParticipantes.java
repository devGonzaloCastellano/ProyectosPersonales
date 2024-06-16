package Vista;

import Modelo.Participante;
import Modelo.TablaParticipantes;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class PnlParticipantes extends javax.swing.JPanel {

    // Declara una lista para almacenar los participantes
    private List<Participante> listaParticipantes;
    private PnlSorteo pnlSorteo;
    private boolean  datosCargados = false;

    public PnlParticipantes(PnlSorteo pnlSorteo) {
        initComponents();
        listaParticipantes = new ArrayList<>();
        this.pnlSorteo = pnlSorteo;

        //Setea la visual de componentes a windows
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PnlParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCargarTabla = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbParticipantes = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Carga de participantes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 588, -1));

        btnCargarTabla.setBackground(new java.awt.Color(102, 0, 102));
        btnCargarTabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCargarTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excel.png"))); // NOI18N
        btnCargarTabla.setText("Cargar Tabla");
        btnCargarTabla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCargarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTablaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCargarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 180, 60));

        tbParticipantes.setBackground(new java.awt.Color(255, 255, 255));
        tbParticipantes.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        tbParticipantes.setForeground(new java.awt.Color(0, 0, 0));
        tbParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Participantes", "Chances"
            }
        ));
        tbParticipantes.setCellSelectionEnabled(true);
        tbParticipantes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tbParticipantes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 68, 483, 338));

        btnGuardar.setBackground(new java.awt.Color(102, 0, 102));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 180, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTablaActionPerformed
        abrirFileChooser();
    }//GEN-LAST:event_btnCargarTablaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (!datosCargados) {
            MostrarMensaje("Primero debes cargar la tabla", "Error", "ERROR");
        } else {
            guardarDatosEnLista();
            MostrarMensaje("Datos guardados correctamente para realizar el sorteo", "Info", "Guardado");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    //Metodo para seleccionar archivo Excel
    private void abrirFileChooser() {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Seleccione Archivo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Excel", "xls", "xlsx");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            TablaParticipantes tablaParticipantes = new TablaParticipantes();
            String respuesta = tablaParticipantes.Importar(file, tbParticipantes);
            if (respuesta.equals("Importacion Exitosa")) {
                JOptionPane.showMessageDialog(this, "Datos importados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                datosCargados = true;
            } else {
                JOptionPane.showMessageDialog(this, "Error al importar datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCargarTabla;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbParticipantes;
    // End of variables declaration//GEN-END:variables

    //Método para guardar los datos de la tabla en la lista
    public void guardarDatosEnLista() {
        // Inicializa la lista si es nula (por si acaso)
        if (listaParticipantes == null) {
            listaParticipantes = new ArrayList<>();
        } else {
            // Borra la lista actual para evitar duplicados si se presiona el botón varias veces
            listaParticipantes.clear();
        }

        // Itera sobre cada fila de la tabla
        for (int i = 0; i < tbParticipantes.getRowCount(); i++) {
            // Obtiene el nombre de usuario y las chances de la fila actual
            String usuario = tbParticipantes.getValueAt(i, 0).toString();
            int chances = Integer.parseInt(tbParticipantes.getValueAt(i, 1).toString());

            // Crea un nuevo objeto Participante y lo agrega a la lista
            Participante participante = new Participante(usuario, chances);
            listaParticipantes.add(participante);
        }
        //Envia la lista hacia el panel de Sorteo
        pnlSorteo.setListaParticipantes(listaParticipantes);
    }

    //Método para enviar mensajes pop-up personalizados
    public void MostrarMensaje(String mensaje, String tipo, String titulo) {
        //Personalizacion de JOptionPane
        JOptionPane optionPane = new JOptionPane(mensaje); //Crea un cuadro pop-up
        //Asigna el tipo de mensaje que se va a dar
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);//Coloca titulo al cuadro pop-up
        dialog.setAlwaysOnTop(true);//se visualiza en la parte de arriba
        dialog.setVisible(true);//Lo hace visible
    }
}
