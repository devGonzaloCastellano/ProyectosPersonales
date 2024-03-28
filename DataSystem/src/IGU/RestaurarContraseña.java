package IGU;

import java.sql.*;
import Logica.Conexion;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class RestaurarContraseña extends javax.swing.JFrame {

    public RestaurarContraseña() {
        initComponents();

        setSize(400, 300);
        setTitle("Cambio de contraseña para " + GestionarUsuarios.usuarioSeleccion);
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

        txtPassword = new javax.swing.JPasswordField();
        txtConfirmarPass = new javax.swing.JPasswordField();
        btnCambiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambiar contraseña");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.setBackground(new java.awt.Color(153, 153, 255));
        txtPassword.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setToolTipText("");
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 250, -1));

        txtConfirmarPass.setBackground(new java.awt.Color(153, 153, 255));
        txtConfirmarPass.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtConfirmarPass.setForeground(new java.awt.Color(255, 255, 255));
        txtConfirmarPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtConfirmarPass.setToolTipText("");
        getContentPane().add(txtConfirmarPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 250, -1));

        btnCambiar.setBackground(new java.awt.Color(153, 153, 255));
        btnCambiar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnCambiar.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiar.setText("Cambiar Contraseña");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 250, 35));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar Contraseña");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nueva contraseña :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirmar contraseña :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed

        String password, confirmarPass;

        password = txtPassword.getText().trim();
        confirmarPass = txtConfirmarPass.getText().trim();

        //Validacion de campos vacios
        if (!password.equals("") && !confirmarPass.equals("")) {

            //Validacion de campos iguales
            if (password.equals(confirmarPass)) {

                //Modificacion de la contraseña en BD
                try {

                    Connection cn = Conexion.Conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "UPDATE usuarios SET password = ? WHERE username = '" + GestionarUsuarios.usuarioSeleccion + "'");

                    pst.setString(1, password);
                    pst.executeUpdate();
                    cn.close();

                    txtPassword.setBackground(Color.GREEN);
                    txtConfirmarPass.setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
                    this.dispose();

                } catch (Exception e) {

                    System.err.println("Error en Restauracion de Contraseña");
                    JOptionPane.showMessageDialog(null, "Error en Restauracion de Contraseña, contactar con administracion");
                }

            } else {
                txtConfirmarPass.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            }

        } else {
            txtPassword.setBackground(Color.red);
            txtConfirmarPass.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "No se admiten contraseñas vacias");
        }


    }//GEN-LAST:event_btnCambiarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarContraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JPasswordField txtConfirmarPass;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
