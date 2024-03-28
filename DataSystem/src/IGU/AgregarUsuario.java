package IGU;

import java.sql.*;
import Logica.Conexion;
import java.awt.Color;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class AgregarUsuario extends javax.swing.JFrame {

    int permisos_cmb, validacion = 0;
    String nombre, mail, telefono, usuario, pass, permisosString;

    public AgregarUsuario() {
        initComponents();
        setTitle("Registro de nuevos usuarios - sesion de " + Acceso.user);
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

        jlTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbNiveles = new javax.swing.JComboBox<>();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Agregar Usuarios");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtEmail.setBackground(new java.awt.Color(153, 153, 255));
        txtEmail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Telefono :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtTelefono.setBackground(new java.awt.Color(153, 153, 255));
        txtTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Usuario :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(153, 153, 255));
        txtUsuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Contraseña :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        txtPassword.setBackground(new java.awt.Color(153, 153, 255));
        txtPassword.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 210, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 120, 120));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Permiso de:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        cbNiveles.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cbNiveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Atencion al cliente", "Tecnico" }));
        cbNiveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNivelesActionPerformed(evt);
            }
        });
        getContentPane().add(cbNiveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        jlWallpaper.setText("jLabel7");
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        //Captura de datos
        nombre = txtNombre.getText().trim();
        mail = txtEmail.getText().trim();
        telefono = txtTelefono.getText().trim();
        usuario = txtUsuario.getText().trim();
        pass = txtPassword.getText().trim();
        permisos_cmb = cbNiveles.getSelectedIndex() + 1;

        //Validacion de campos incompletos
        if (nombre.equals("")) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (mail.equals("")) {
            txtEmail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txtTelefono.setBackground(Color.red);
            validacion++;
        }
        if (usuario.equals("")) {
            txtUsuario.setBackground(Color.red);
            validacion++;
        }
        if (pass.equals("")) {
            txtPassword.setBackground(Color.red);
            validacion++;
        }

        //Validacion de datos para nivel de permiso
        if (permisos_cmb == 1) {
            permisosString = "administrador";
        } else if (permisos_cmb == 2) {
            permisosString = "atencion al cliente";
        } else if (permisos_cmb == 3) {
            permisosString = "tecnico";
        }
        
        //Validacion de usuario ya registrado
        try {
            
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT username FROM usuarios WHERE username = '" + usuario + "'");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                txtUsuario.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Usuario no disponible");
            }else{
               
                cn.close();
                
                if (validacion == 0) {
                    
                    try {
                        
                        Connection cn2 = Conexion.Conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "INSERT usuarios VALUES(?,?,?,?,?,?,?,?,?)");
                        
                        pst2.setInt(1, 0);
                        pst2.setString(2, nombre);
                        pst2.setString(3, mail);
                        pst2.setString(4, telefono);
                        pst2.setString(5, usuario);
                        pst2.setString(6, pass);
                        pst2.setString(7, permisosString);
                        pst2.setString(8, "activo");
                        pst2.setString(9, Acceso.user);
                        
                        pst2.executeUpdate();
                        
                        
                        cn2.close();
                        Limpiar();
                        
                        txtEmail.setBackground(Color.GREEN);
                        txtNombre.setBackground(Color.GREEN);
                        txtTelefono.setBackground(Color.GREEN);
                        txtUsuario.setBackground(Color.GREEN);
                        txtPassword.setBackground(Color.GREEN);
                        
                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                        this.dispose();
                       
                    } catch (Exception e) {
                    
                        System.err.println("Error al registrar usuario " + e);
                        JOptionPane.showMessageDialog(null,"Error al registrar usuario, contactarse con el administrador");
                    
                    }
                    
                    
                }
               
                
            }       
        } catch (Exception e) {
        
            System.err.println("Error en validar nombre de usuario " + e);
            JOptionPane.showMessageDialog(null, "Error al comparar usuario, contactarse con el administrador");
            
        }
        
        


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbNivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNivelesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNivelesActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox<String> cbNiveles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

     public void Limpiar() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
        cbNiveles.setSelectedIndex(0);
    }

}
