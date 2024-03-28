package IGU;

import Logica.Conexion;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Administrador extends javax.swing.JFrame {

    String user, nombreUsuario;
    public static int sesionUsuario;

    public Administrador() {
        initComponents();

        user = Acceso.user;
        sesionUsuario = 1;

        setTitle("Administrador - sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Agrega wallpaper
        ImageIcon wallpaper = new ImageIcon("src/img/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(
                jlWallpaper.getWidth(), jlWallpaper.getHeight(), Image.SCALE_DEFAULT));
        jlWallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT nombre_us FROM usuarios WHERE username = '" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                nombreUsuario = rs.getString("nombre_us");
                jlTitulo.setText("Bienvenido al sistema de administracion " + nombreUsuario);

            }
        } catch (Exception e) {
            System.out.println("Error en conexion Administrador " + e);
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

        jlTitulo = new javax.swing.JLabel();
        btnAgregarUs = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGestionUs = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAtCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnTecnico = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnOpciones = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 630, 40));

        btnAgregarUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addUser.png"))); // NOI18N
        btnAgregarUs.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgregarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 120));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, -1));

        btnGestionUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/informationuser.png"))); // NOI18N
        btnGestionUs.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnGestionUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionUsActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 120, 120));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gestion Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 120, -1));

        btnAtCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atencionCl.png"))); // NOI18N
        btnAtCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnAtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 120, 120));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("At. al cliente");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 120, -1));

        btnTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnico.png"))); // NOI18N
        btnTecnico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(btnTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 120, 120));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tecnico");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 120, -1));

        btnOpciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/opciones.png"))); // NOI18N
        btnOpciones.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionesActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 120, 120));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Opciones");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 120, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsActionPerformed

        AgregarUsuario addUsuario = new AgregarUsuario();
        addUsuario.setVisible(true);

    }//GEN-LAST:event_btnAgregarUsActionPerformed

    private void btnGestionUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionUsActionPerformed

        GestionarUsuarios gestionarUsuarios = new GestionarUsuarios();
        gestionarUsuarios.setVisible(true);

    }//GEN-LAST:event_btnGestionUsActionPerformed

    private void btnAtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtClienteActionPerformed

        AtencionCliente atencionCliente = new AtencionCliente();
        atencionCliente.setVisible(true);

    }//GEN-LAST:event_btnAtClienteActionPerformed

    private void btnTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTecnicoActionPerformed

        Tecnico tecnico = new Tecnico();
        tecnico.setVisible(true);

    }//GEN-LAST:event_btnTecnicoActionPerformed

    private void btnOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionesActionPerformed
        int opcion = 0;

        try {
            
            do {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menu de opciones \n\n"
                        + "1. Cambiar Usuario\n"
                        + "2. Acerca De\n"
                        + "3. Salir\n"
                ));

                switch (opcion) {
                    case 1:
                        opcion = 3;
                        Acceso acceso = new Acceso();
                        acceso.setVisible(true);
                        this.dispose();

                        break;
                    case 2:
                        opcion = 3;
                        AcercaDe acercaDe = new AcercaDe();
                        acercaDe.setVisible(true);
                        break;
                    case 3:
                        opcion = 3;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opcion seleccionada no es correcta");

                }
                
                
            } while (opcion != 3);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Solo se pueden seleccionar caracteres numericos");
        }


    }//GEN-LAST:event_btnOpcionesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUs;
    private javax.swing.JButton btnAtCliente;
    private javax.swing.JButton btnGestionUs;
    private javax.swing.JButton btnOpciones;
    private javax.swing.JButton btnTecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables

}
