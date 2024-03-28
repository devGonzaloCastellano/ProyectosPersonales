package IGU;

import java.sql.*;
import Logica.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class Tecnico extends javax.swing.JFrame {

    String user, nombreUsuario;
    int sesion_usuario;

    public Tecnico() {
        initComponents();
        user = Acceso.user;
        sesion_usuario = Administrador.sesionUsuario;

        setTitle("Atencion al Cliente - sesion de " + user);
        setSize(550, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        //Cierre de interfaz segun quien inicie sesion 
        if (sesion_usuario == 1) {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);//Administrador
        } else {
            setDefaultCloseOperation(EXIT_ON_CLOSE);//Atencion al cliente
        }

        //Consulta SQL para obtener el nombre del usuario
        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT nombre_us FROM usuarios WHERE username ='" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombreUsuario = rs.getString("nombre_us");
                jlTitulo.setText("Bienvenido/a " + nombreUsuario);
            }

        } catch (Exception e) {
            System.err.println("Error al obtener nombre de usuario");
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
        btnGestionEquipos = new javax.swing.JButton();
        btnGraficaStatus = new javax.swing.JButton();
        btnGraficaMarca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Bienvenido");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnGestionEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/apoyo-tecnico.png"))); // NOI18N
        btnGestionEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 120));

        btnGraficaStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grafica.png"))); // NOI18N
        btnGraficaStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficaStatusActionPerformed(evt);
            }
        });
        getContentPane().add(btnGraficaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 120));

        btnGraficaMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grafica.png"))); // NOI18N
        btnGraficaMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficaMarcaActionPerformed(evt);
            }
        });
        getContentPane().add(btnGraficaMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 120));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gestion equipos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 120, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Grafica status");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 210, 130, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Grafica marcas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 120, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEquiposActionPerformed

        GestionarEquipos gestionEquipos = new GestionarEquipos();
        gestionEquipos.setVisible(true);

    }//GEN-LAST:event_btnGestionEquiposActionPerformed

    private void btnGraficaStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficaStatusActionPerformed

        GraficaStatus graficaStatus = new GraficaStatus();
        graficaStatus.setVisible(true);

    }//GEN-LAST:event_btnGraficaStatusActionPerformed

    private void btnGraficaMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficaMarcaActionPerformed

        GraficaMarcas graficaMarcas = new GraficaMarcas();
        graficaMarcas.setVisible(true);

    }//GEN-LAST:event_btnGraficaMarcaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionEquipos;
    private javax.swing.JButton btnGraficaMarca;
    private javax.swing.JButton btnGraficaStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables
}
