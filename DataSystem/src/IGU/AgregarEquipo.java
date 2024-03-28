package IGU;

import java.sql.*;
import Logica.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class AgregarEquipo extends javax.swing.JFrame {

    int idclienteSeleccionado = 0;
    String user, nombreCl;

    public AgregarEquipo() {
        initComponents();
        user = Acceso.user;
        idclienteSeleccionado = GestionarClientes.IDclienteSeleccion;

        //Carga de nombre del cliente en JTextField
        try {

            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_cl FROM clientes WHERE ID_cliente = '" + idclienteSeleccionado + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombreCl = rs.getString("nombre_cl");
                txtNombre.setText(nombreCl);
            }

        } catch (Exception e) {
            System.err.println("Error al cargar nombre del cliente");
            JOptionPane.showMessageDialog(null, "Error al cargar nombre del cliente. Contactar con administracion");
        }

        setTitle("Registrar nuevo equipo para " + nombreCl);
        setSize(650,400);
        setResizable(false);
        setLocationRelativeTo(null);
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

        txtNombre = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtNumeroSerie = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        cbMarca = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpObservaciones = new javax.swing.JTextPane();
        btnRegistrarEquipo = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txtModelo.setBackground(new java.awt.Color(153, 153, 255));
        txtModelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(255, 255, 255));
        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txtNumeroSerie.setBackground(new java.awt.Color(153, 153, 255));
        txtNumeroSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txtNumeroSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        cbTipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celular", "PC", "Notebook", "Impresora", "Otro/Generico" }));
        getContentPane().add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cbMarca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motorola", "Philips", "HP", "Samsung", "Epson", "Intel", "AMD" }));
        getContentPane().add(cbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jScrollPane1.setViewportView(tpObservaciones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 330, 230));

        btnRegistrarEquipo.setBackground(new java.awt.Color(153, 153, 255));
        btnRegistrarEquipo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnRegistrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarEquipo.setText("Registrar Equipo");
        btnRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 210, 35));

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Registro de equipos");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del cliente :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo de Equipo :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Marca :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Número de serie :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Daño reportado y Observaciones");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEquipoActionPerformed

        int validacion = 0;
        String tipo, marca, modelo, numSerie, diaIngreso, mesIngreso, añoIngreso, estado, Observaciones;

        //Obtencion de datos de los campos de texto y combo box
        tipo = cbTipo.getSelectedItem().toString();
        marca = cbMarca.getSelectedItem().toString();
        modelo = txtModelo.getText().trim();
        numSerie = txtNumeroSerie.getText().trim();
        Observaciones = tpObservaciones.getText();
        estado = "Nuevo Ingreso";

        //Obtencion de dia, mes y año actual.
        Calendar calendario = Calendar.getInstance();
        diaIngreso = Integer.toString(calendario.get(Calendar.DATE));
        mesIngreso = Integer.toString(calendario.get(Calendar.MONTH));
        añoIngreso = Integer.toString(calendario.get(Calendar.YEAR));

        //Validacion de campos de texto
        if (modelo.equals("")) {
            txtModelo.setBackground(Color.red);
            validacion++;
        }
        if (numSerie.equals("")) {
            txtNumeroSerie.setBackground(Color.red);
            validacion++;
        }
        if (Observaciones.equals("")) {
            tpObservaciones.setText("Sin Observaciones");
        }

        if (validacion == 0) {
            try {
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "INSERT INTO equipos VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                pst.setInt(1, 0);
                pst.setInt(2, idclienteSeleccionado);
                pst.setString(3, tipo);
                pst.setString(4, marca);
                pst.setString(5, modelo);
                pst.setString(6, numSerie);
                pst.setString(7, diaIngreso);
                pst.setString(8, mesIngreso);
                pst.setString(9, añoIngreso);
                pst.setString(10, Observaciones);
                pst.setString(11, estado);
                pst.setString(12, user);
                pst.setString(13, "");
                pst.setString(14, "");

                pst.executeUpdate();
                cn.close();

                txtNombre.setBackground(Color.green);
                txtModelo.setBackground(Color.green);
                txtNumeroSerie.setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                this.dispose();

            } catch (Exception e) {
                System.err.println("Error al cargar datos de equipo a la BD");
                JOptionPane.showMessageDialog(null, "Error al almacenar datos. Comuniquese con administracion");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
        }

    }//GEN-LAST:event_btnRegistrarEquipoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarEquipo;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTextPane tpObservaciones;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroSerie;
    // End of variables declaration//GEN-END:variables
}
