package IGU;

import java.sql.*;
import Logica.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class InformacionUsuarios extends javax.swing.JFrame {

    String usuario = "", usuarioActualizado = "";
    int ID;

    public InformacionUsuarios() {
        initComponents();
        usuario = Acceso.user;
        usuarioActualizado = GestionarUsuarios.usuarioSeleccion;

        setTitle("Información de usuario " + usuarioActualizado + " - Sesion de " + usuario);
        setSize(650, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {

            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM usuarios WHERE username = '" + usuarioActualizado + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                ID = rs.getInt("ID_usuario");
                txtNombre.setText(rs.getString("nombre_us"));
                txtEmail.setText(rs.getString("email"));
                txtTelefono.setText(rs.getString("telefono"));
                txtUsuario.setText(rs.getString("username"));
                txtRegistradoPor.setText(rs.getString("registrado_por"));

                cbNiveles.setSelectedItem(rs.getString("tipo_nivel"));
                cbStatus.setSelectedItem(rs.getString("status"));
            }

            cn.close();

        } catch (Exception e) {
            System.err.println("Error a cargar informacion del usuario " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar datos, por favor contactar con el administrador");
        }

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
        txtEmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtRegistradoPor = new javax.swing.JTextField();
        cbNiveles = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        btnPassword = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setToolTipText("");
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txtEmail.setBackground(new java.awt.Color(153, 153, 255));
        txtEmail.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setToolTipText("");
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txtTelefono.setBackground(new java.awt.Color(153, 153, 255));
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setToolTipText("");
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txtUsuario.setBackground(new java.awt.Color(153, 153, 255));
        txtUsuario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setToolTipText("");
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        txtRegistradoPor.setEditable(false);
        txtRegistradoPor.setBackground(new java.awt.Color(153, 153, 255));
        txtRegistradoPor.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtRegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txtRegistradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegistradoPor.setToolTipText("");
        getContentPane().add(txtRegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        cbNiveles.setEditable(true);
        cbNiveles.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cbNiveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Atencion al cliente", "Tecnico" }));
        getContentPane().add(cbNiveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        cbStatus.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        btnActualizar.setBackground(new java.awt.Color(153, 153, 255));
        btnActualizar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar Usuario");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 210, 35));

        btnPassword.setBackground(new java.awt.Color(153, 153, 255));
        btnPassword.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnPassword.setForeground(new java.awt.Color(255, 255, 255));
        btnPassword.setText("Restarurar Contraseña");
        btnPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btnPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 210, 35));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(225, 255, 255));
        jLabel1.setText("Informacion de usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nivel :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuario :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Estado :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Registrado por :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        int Nivelcb, Statuscb, validacion = 0;
        String nombre, mail, telefono, username, pass, nivelString = "", statusString = "";

        nombre = txtNombre.getText().trim();
        mail = txtEmail.getText().trim();
        telefono = txtTelefono.getText().trim();
        username = txtUsuario.getText().trim();
        Nivelcb = cbNiveles.getSelectedIndex() + 1;
        Statuscb = cbStatus.getSelectedIndex() + 1;

        //Validacion de campos
        if (nombre.equals("")) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (mail.equals("")) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (username.equals("")) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }

        //Validacion de combo box
        if (validacion == 0) {
            if (Nivelcb == 1) {
                nivelString = "Administrador";
            } else if (Nivelcb == 2) {
                nivelString = "Atencion al cliente";
            } else if (Nivelcb == 3) {
                nivelString = "Tecnico";
            }
        

            if (Statuscb == 1) {
                statusString = "Activo";
            } else if (Statuscb == 2) {
                statusString = "Inactivo";
            }
            
            
            //Consulta a la base de datos
            try {
                //Validacion de usuario
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT username FROM usuarios WHERE username = '" 
                                + username + "' AND NOT ID_usuario = '" + ID + "'");
                
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    txtUsuario.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                    cn.close();
                    
                }else{
                    //Actualizacion de usuario
                    Connection cn2 = Conexion.Conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                    "UPDATE usuarios SET nombre_us= ?, email = ?, telefono = ?, "
                            + "username = ?,tipo_nivel = ?, status = ? "
                            + "WHERE ID_usuario = '" + ID + "'");
                    
                    pst2.setString(1, nombre);
                    pst2.setString(2, mail);
                    pst2.setString(3, telefono);
                    pst2.setString(4, username);
                    pst2.setString(5, nivelString);
                    pst2.setString(6, statusString);
                    
                    pst2.executeUpdate();
                    cn2.close();
                    
                    JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        
                }
                
                
                
            } catch (Exception e) {
                System.err.println("Error al actualizar usuario " + e);
                JOptionPane.showMessageDialog(null, "Error al actualizar usuario, comuniquese con el administrador");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswordActionPerformed
        
        RestaurarContraseña restauracion = new RestaurarContraseña();
        restauracion.setVisible(true);
        
    }//GEN-LAST:event_btnPasswordActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnPassword;
    private javax.swing.JComboBox<String> cbNiveles;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegistradoPor;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
