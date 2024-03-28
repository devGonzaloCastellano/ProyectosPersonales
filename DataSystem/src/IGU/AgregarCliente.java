package IGU;

import java.sql.*;
import Logica.Conexion;
import java.awt.Color;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class AgregarCliente extends javax.swing.JFrame {

    public AgregarCliente() {
        initComponents();

        setTitle("Registro nuevo cliente - sesion de " + Acceso.user);
        setSize(550, 350);
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
        txtMail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jlTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 30));

        txtMail.setBackground(new java.awt.Color(153, 153, 255));
        txtMail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtMail.setForeground(new java.awt.Color(255, 255, 255));
        txtMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, 30));

        txtTelefono.setBackground(new java.awt.Color(153, 153, 255));
        txtTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 30));

        txtDireccion.setBackground(new java.awt.Color(153, 153, 255));
        txtDireccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, 30));

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Registro de Clientes");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

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
        jLabel5.setText("Direccion :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registrar Cliente");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 120, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 120, 120));

        jlWallpaper.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlWallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        int validacion = 0;
        String nombre, mail, telefono, direccion;

        nombre = txtNombre.getText().trim();
        mail = txtMail.getText().trim();
        telefono = txtTelefono.getText().trim();
        direccion = txtDireccion.getText().trim();

        //Validacion de campos
        if (nombre.equals("")) {
            txtNombre.setBackground(Color.red);
            validacion++;
        }
        if (mail.equals("")) {
            txtMail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txtTelefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.equals("")) {
            txtDireccion.setBackground(Color.red);
            validacion++;
        }
        
        
        if (validacion == 0) {
            
            try {
                
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "INSERT clientes VALUES (?,?,?,?,?,?)");
                
                pst.setInt(1, 0);
                pst.setString(2, nombre);
                pst.setString(3, mail);
                pst.setString(4, telefono);
                pst.setString(5, direccion);
                pst.setString(6, Acceso.user);
                
                pst.executeUpdate();
                cn.close();
                
                Limpiar();
                
                txtNombre.setBackground(Color.green);
                txtMail.setBackground(Color.green);
                txtTelefono.setBackground(Color.green);
                txtDireccion.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                this.dispose();
                
                
            } catch (Exception e) {
                System.err.println("Error en registrar cliente " + e);
                JOptionPane.showMessageDialog(null, "Error al registrar cliente. Comunicarse con administracion");
            }
            
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
        txtNombre.setText("");
        txtMail.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }

}
