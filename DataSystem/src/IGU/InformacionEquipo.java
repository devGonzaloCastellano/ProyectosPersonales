package IGU;

import Logica.Conexion;
import java.awt.Color;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class InformacionEquipo extends javax.swing.JFrame {

    int id_clienteSeleccionado = 0, idEquipo = 0;
    String user = "", nombreCliente = "";

    public InformacionEquipo() {
        initComponents();
        user = Acceso.user;
        idEquipo = InformacionClientes.idEquipo;
        id_clienteSeleccionado = GestionarClientes.IDclienteSeleccion;

        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_cl FROM clientes WHERE ID_cliente = '" + id_clienteSeleccionado + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombreCliente = rs.getString("nombre_cl");
                txtNombre.setText(nombreCliente);
            }

        } catch (Exception e) {
            System.err.println("Error al consultar nombre de cliente " + e);
        }

        try {

            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM equipos WHERE ID_equipo = '" + idEquipo + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                cbTipo.setSelectedItem(rs.getString("tipo"));
                cbMarca.setSelectedItem(rs.getString("marca"));
                cbStatus.setSelectedItem(rs.getString("status"));
                txtModelo.setText(rs.getString("modelo"));
                txtNumeroSerie.setText(rs.getString("num_serie"));
                txtUltimaModificacion.setText(rs.getString("ultima_mod"));

                String dia = "", mes = "", año = "";

                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                año = rs.getString("año_ingreso");

                txtFechaIngreso.setText(dia + "/" + mes + "/" + año);

                tpObservaciones.setText(rs.getString("observaciones"));
                tpComentariosTecnico.setText(rs.getString("comentarios_tec"));

            }

        } catch (Exception e) {
            System.err.println("Error al consultar informacion del equipo " + e);
        }

        setTitle("Equipo registrado con el ID = " + idEquipo + " - sesion de " + user);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //Cambia el icono de la interfaz
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
                "img/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtModelo = new javax.swing.JTextField();
        txtNumeroSerie = new javax.swing.JTextField();
        txtUltimaModificacion = new javax.swing.JTextField();
        txtFechaIngreso = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        spObservaciones = new javax.swing.JScrollPane();
        tpObservaciones = new javax.swing.JTextPane();
        spComentariosTecnico = new javax.swing.JScrollPane();
        tpComentariosTecnico = new javax.swing.JTextPane();
        cbTipo = new javax.swing.JComboBox<>();
        cbMarca = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Modelo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModelo.setBackground(new java.awt.Color(153, 153, 255));
        txtModelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(255, 255, 255));
        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 210, -1));

        txtNumeroSerie.setBackground(new java.awt.Color(153, 153, 255));
        txtNumeroSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txtNumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, -1));

        txtUltimaModificacion.setBackground(new java.awt.Color(153, 153, 255));
        txtUltimaModificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtUltimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtUltimaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUltimaModificacion.setEnabled(false);
        getContentPane().add(txtUltimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 210, -1));

        txtFechaIngreso.setBackground(new java.awt.Color(153, 153, 255));
        txtFechaIngreso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtFechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaIngreso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaIngreso.setEnabled(false);
        getContentPane().add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setEnabled(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, -1));

        spObservaciones.setViewportView(tpObservaciones);

        getContentPane().add(spObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 330, 120));

        tpComentariosTecnico.setEditable(false);
        spComentariosTecnico.setViewportView(tpComentariosTecnico);

        getContentPane().add(spComentariosTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 330, 120));

        cbTipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celular", "PC", "Notebook", "Impresora", "Otro/Generico" }));
        getContentPane().add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        cbMarca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motorola", "Philips", "HP", "Samsung", "Epson", "Intel", "AMD" }));
        getContentPane().add(cbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        cbStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo Ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(153, 153, 255));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar Equipo");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 210, 35));

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Información de Equipo");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Cliente :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        Modelo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Modelo.setForeground(new java.awt.Color(255, 255, 255));
        Modelo.setText("Modelo :");
        getContentPane().add(Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Numero de Serie :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ultima Modificación :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha de Ingreso");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Observaciones :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Comentarios Tecnico :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Estado :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jlWallpaper.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlWallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        int validacion = 0;
        String tipo, marca, modelo, numeroSerie, status, observaciones;

        tipo = cbTipo.getSelectedItem().toString();
        marca = cbMarca.getSelectedItem().toString();
        status = cbStatus.getSelectedItem().toString();

        modelo = txtModelo.getText().trim();
        numeroSerie = txtNumeroSerie.getText().trim();
        observaciones = tpObservaciones.getText();

        //Validacion de campos
        if (modelo.equals("")) {
            txtModelo.setBackground(Color.red);
            validacion++;
        }
        if (numeroSerie.equals("")) {
            txtNumeroSerie.setBackground(Color.red);
            validacion++;
        }
        if (observaciones.equals("")) {
            tpObservaciones.setText("Sin comentarios");
            validacion++;
        }

        if (validacion == 0) {

            try {

                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "UPDATE equipos SET tipo = ?,marca = ?, modelo = ?, "
                        + "num_serie = ?, observaciones = ?, status = ?, "
                        + "ultima_mod = ? WHERE ID_equipo = '" + idEquipo + "'");

                pst.setString(1, tipo);
                pst.setString(2, marca);
                pst.setString(3, modelo);
                pst.setString(4, numeroSerie);
                pst.setString(5, observaciones);
                pst.setString(6, status);
                pst.setString(7, user);

                pst.executeUpdate();
                cn.close();

                Limpiar();

                txtNombre.setBackground(Color.green);
                txtFechaIngreso.setBackground(Color.green);
                txtModelo.setBackground(Color.green);
                txtNumeroSerie.setBackground(Color.green);
                txtUltimaModificacion.setText(user);

                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                this.dispose();

            } catch (Exception e) {
                System.err.println("Error al actualizar equipo " + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar equipo, contactar con administracion");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Modelo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JScrollPane spComentariosTecnico;
    private javax.swing.JScrollPane spObservaciones;
    private javax.swing.JTextPane tpComentariosTecnico;
    private javax.swing.JTextPane tpObservaciones;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JTextField txtUltimaModificacion;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txtModelo.setText("");
        txtNumeroSerie.setText("");
        txtNombre.setText("");
        txtFechaIngreso.setText("");
        tpObservaciones.setText("");
    }

}
