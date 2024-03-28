package IGU;

import java.sql.*;
import Logica.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InformacionClientes extends javax.swing.JFrame {

    DefaultTableModel tabla = new DefaultTableModel();
    int idClienteSeleccionado = 0;
    public static int idEquipo = 0;
    String user;

    public InformacionClientes() {
        initComponents();

        user = Acceso.user;
        idClienteSeleccionado = GestionarClientes.IDclienteSeleccion;

        setSize(650, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {

            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT * FROM clientes WHERE ID_cliente ='" + idClienteSeleccionado + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //Personalizacion del titulo de la interfaz 
                setTitle("Informacion del cliente " + rs.getString("nombre_cl") + " - sesion de " + user);
                jlTitulo.setText("Informacion del cliente " + rs.getString("nombre_cl"));

                //Llenado de campos de texto
                txtNombre.setText(rs.getString("nombre_cl"));
                txtMail.setText(rs.getString("email_cl"));
                txtTelefono.setText(rs.getString("telefono_cl"));
                txtDireccion.setText(rs.getString("direccion_cl"));
                txtRegistradoPor.setText(rs.getString("ultima_modif"));
            }

            cn.close();

        } catch (Exception e) {
            System.err.println("Error al cargar cliente " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar cliente. Contactar con administración");
        }

        try {

            Connection cn2 = Conexion.Conectar();
            PreparedStatement pst = cn2.prepareStatement(
                    "SELECT ID_equipo, tipo, marca, status FROM equipos "
                    + "WHERE ID_cliente = '" + idClienteSeleccionado + "'");
            ResultSet rs = pst.executeQuery();

            //Llenado de tabla
            jtEquipos = new JTable(tabla);
            jScrollPane1.setViewportView(jtEquipos);

            tabla.addColumn("ID");
            tabla.addColumn("Tipo");
            tabla.addColumn("Marca");
            tabla.addColumn("Estado");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                tabla.addRow(fila);
            }

            cn2.close();

        } catch (Exception e) {
            System.err.println("Error en la carga de datos de la tabla Equipos");
            JOptionPane.showMessageDialog(null, "Error al cargar tabla de equipos. Contactar con administración");
        }

        //Evento creado con click de mouse sobre JTable
        jtEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int fila_point = jtEquipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idEquipo = (int) tabla.getValueAt(fila_point, columna_point);
                    InformacionEquipo infoEquipo = new InformacionEquipo();
                    infoEquipo.setVisible(true);
                    
                }

            }
        });//Este parentesis es el de cierre del addMouseListener

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
        txtRegistradoPor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEquipos = new javax.swing.JTable();
        btnRegistrarEquipo = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jlTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setAutoscrolls(false);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txtMail.setBackground(new java.awt.Color(153, 153, 255));
        txtMail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtMail.setForeground(new java.awt.Color(255, 255, 255));
        txtMail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMail.setAutoscrolls(false);
        getContentPane().add(txtMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txtTelefono.setBackground(new java.awt.Color(153, 153, 255));
        txtTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setAutoscrolls(false);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txtDireccion.setBackground(new java.awt.Color(153, 153, 255));
        txtDireccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setAutoscrolls(false);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        txtRegistradoPor.setEditable(false);
        txtRegistradoPor.setBackground(new java.awt.Color(153, 153, 255));
        txtRegistradoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtRegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txtRegistradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegistradoPor.setAutoscrolls(false);
        getContentPane().add(txtRegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

        jtEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtEquipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 380, 180));

        btnRegistrarEquipo.setBackground(new java.awt.Color(153, 153, 255));
        btnRegistrarEquipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegistrarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarEquipo.setText("Registrar Equipo");
        btnRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 210, 35));

        btnActualizarCliente.setBackground(new java.awt.Color(153, 153, 255));
        btnActualizarCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnActualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCliente.setText("Actualizar Cliente");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 210, 35));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 120, 100));

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Información clientes");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefono :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Direccion :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registrado por :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jlWallpaper.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlWallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEquipoActionPerformed

        AgregarEquipo agregarEquipo = new AgregarEquipo();
        agregarEquipo.setVisible(true);

    }//GEN-LAST:event_btnRegistrarEquipoActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed

        //Declaracion de variables y obtencion de datos
        int validacion = 0;
        String nombre, mail, telefono, direccion;

        nombre = txtNombre.getText().trim();
        mail = txtMail.getText().trim();
        telefono = txtTelefono.getText().trim();
        direccion = txtDireccion.getText().trim();

        //Validacion de campos de texto
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

        //Actualizacion de datos en la BD
        if (validacion == 0) {
            try {
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "UPDATE clientes SET nombre_cl = ? ,email_cl= ?, telefono_cl= ?"
                        + ",direccion_cl=?,ultima_modif= ? WHERE ID_cliente ='"
                        + idClienteSeleccionado + "'");

                pst.setString(1, nombre);
                pst.setString(2, mail);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, user);
                pst.executeUpdate();
                cn.close();

                Limpiar();
                txtNombre.setBackground(Color.green);
                txtMail.setBackground(Color.green);
                txtTelefono.setBackground(Color.green);
                txtDireccion.setBackground(Color.green);
                txtRegistradoPor.setText(user);

                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
                this.dispose();

            } catch (Exception e) {
                System.err.println("Error al actualizar cliente");
                JOptionPane.showMessageDialog(null, "Error al actualizar. Contactarse con administracion");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
        }

    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed

        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "//Downloads/" + txtNombre.getText().trim() + ".pdf"));

            //Agrega una imagen al documento
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/img/BannerPDF.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Agrega el parrafo de Titulo
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Información del cliente \n\n");
            parrafo.setFont(FontFactory.getFont("Arial", 14, Font.BOLD, BaseColor.DARK_GRAY));

            documento.open();
            documento.add(header);
            documento.add(parrafo);

            //Tabla para datos de cliente
            PdfPTable tablaCliente = new PdfPTable(5);
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("Email");
            tablaCliente.addCell("Telefono");
            tablaCliente.addCell("Dirección");

            //Consulta a la BD para rellenar tabla de cliente
            try {
                Connection cn = Conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT * FROM clientes WHERE ID_cliente = '" + idClienteSeleccionado + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        tablaCliente.addCell(rs.getString(1));
                        tablaCliente.addCell(rs.getString(2));
                        tablaCliente.addCell(rs.getString(3));
                        tablaCliente.addCell(rs.getString(4));
                        tablaCliente.addCell(rs.getString(5));
                    } while (rs.next());

                    documento.add(tablaCliente);
                }

                //Parrafo separador y titulo para la segunda tabla
                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.add("\n\n Equipos Registrados \n\n");
                parrafo2.setFont(FontFactory.getFont("Arial", 14, Font.BOLD, BaseColor.DARK_GRAY));

                documento.add(parrafo2);

                //Segunda tabla correspondiente a equipos
                PdfPTable tablaEquipos = new PdfPTable(4);
                tablaEquipos.addCell("ID Equipo");
                tablaEquipos.addCell("Tipo");
                tablaEquipos.addCell("Marca");
                tablaEquipos.addCell("Estado");

                try {

                    Connection cn2 = Conexion.Conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "SELECT ID_equipo, tipo, marca, modelo FROM equipos WHERE ID_cliente = '" + idClienteSeleccionado + "'");
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {

                        do {
                            tablaEquipos.addCell(rs2.getString(1));
                            tablaEquipos.addCell(rs2.getString(2));
                            tablaEquipos.addCell(rs2.getString(3));
                            tablaEquipos.addCell(rs2.getString(4));
                        } while (rs2.next());
                        documento.add(tablaEquipos);
                    }

                } catch (Exception e) {
                    System.err.println("Error al obtener datos de equipo");
                }

            } catch (Exception e) {
                System.err.println("Error al obtener datos del cliente");
            }
            
            //Cierre de documento y mensaje pop-up
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado con exito");

        } catch (Exception e) {
            System.err.println("Error en crear reporte PDF o ruta de imagen");
            JOptionPane.showMessageDialog(null, "Error al generar registro PDF. Contactar con administración");
        }


    }//GEN-LAST:event_btnReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnRegistrarEquipo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTable jtEquipos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegistradoPor;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txtNombre.setText("");
        txtMail.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }

}
