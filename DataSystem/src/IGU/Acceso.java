package IGU;

import java.sql.*;
import Logica.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Acceso extends javax.swing.JFrame {

    public static String user = "";
    String pass = "";

    public Acceso() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);

        //Agregar Logo
        ImageIcon Logo = new ImageIcon("src/img/DS.png");
        Icon IconoLogo = new ImageIcon(Logo.getImage().getScaledInstance(
                jlLogo.getWidth(), jlLogo.getHeight(), Image.SCALE_DEFAULT));
        jlLogo.setIcon(IconoLogo);
        this.repaint();

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

        jlLogo = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnAcceso = new javax.swing.JButton();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 10, 270, 270));

        txtUser.setBackground(new java.awt.Color(153, 153, 255));
        txtUser.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        txtPass.setBackground(new java.awt.Color(153, 153, 255));
        txtPass.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPass.setForeground(new java.awt.Color(255, 255, 255));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 380, 210, -1));

        btnAcceso.setBackground(new java.awt.Color(153, 153, 255));
        btnAcceso.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btnAcceso.setForeground(new java.awt.Color(255, 255, 255));
        btnAcceso.setText("Acceder");
        btnAcceso.setBorder(null);
        btnAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccesoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 430, 210, 35));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 403, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccesoActionPerformed
        user = txtUser.getText().trim();
        pass = txtPass.getText().trim();

        //Validacion de Usuario y contraseña
        if (!user.equals("") || !pass.equals("")) {
            try {
                //Conexion a base de datos y consulta SQL
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT tipo_nivel, status FROM usuarios WHERE username = '" + user + "' and password = '" + pass + "'");
                ResultSet rs = pst.executeQuery();

                //Validacion de Niveles
                if (rs.next()) {
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String status = rs.getString("status");

                    //Compara nivel y status para abrir una nueva interfaz
                    if (tipo_nivel.equals("Administrador") && status.equals("Activo")) {
                        dispose();
                        new Administrador().setVisible(true);

                    } else if (tipo_nivel.equals("Atencion al cliente") && status.equals("Activo")) {
                        dispose();
                        new AtencionCliente().setVisible(true);

                    } else if (tipo_nivel.equals("Tecnico") && status.equals("Activo")) {
                        dispose();
                        new Tecnico().setVisible(true);
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                    txtUser.setText("");
                    txtPass.setText("");
                }

            } catch (Exception e) {
                System.out.println("Error en el boton ingresar" + e);
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion, comuniquese con el Administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
        }
    }//GEN-LAST:event_btnAccesoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceso;
    private javax.swing.JLabel jlLogo;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
