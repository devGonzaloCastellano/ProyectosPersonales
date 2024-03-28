package IGU;

import java.sql.*;
import Logica.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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

public class AtencionCliente extends javax.swing.JFrame {

    String user, nombreUsuario;
    int sesion_usuario;

    public AtencionCliente() {
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
        btnAgregar = new javax.swing.JButton();
        btnGestionar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
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

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 120));

        btnGestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/informationuser.png"))); // NOI18N
        btnGestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 120));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 120));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agregar Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 120, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gestionar Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 210, 130, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Imprimir");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 120, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        AgregarCliente agregarCliente = new AgregarCliente();
        agregarCliente.setVisible(true);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarActionPerformed

        GestionarClientes gestionarClientes = new GestionarClientes();
        gestionarClientes.setVisible(true);

    }//GEN-LAST:event_btnGestionarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Downloads/ListaClientes.pdf"));

            //Agrega una imagen al documento
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/img/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de clientes \n\n ");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY ));
            
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Mail");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            
            try {
                
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT * FROM clientes");
                ResultSet rs = pst.executeQuery();
                
                if (rs.next()) {
                    
                    do {                        
                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        
                    } while (rs.next());
                    
                    documento.add(tabla);
                }
                
            } catch (Exception e) {
                System.err.println("Error al generar lista de clientes " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de clientes generada exitosamente");

        } catch (Exception e) {
            System.err.println("Error al generar PDF clientes " + e);
            JOptionPane.showMessageDialog(null, "Error al generar reporte. Contactar con administración");
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtencionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGestionar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables
}
