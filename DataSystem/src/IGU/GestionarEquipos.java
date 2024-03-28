package IGU;

import java.sql.*;
import Logica.Conexion;
import com.mysql.cj.xdevapi.Result;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestionarEquipos extends javax.swing.JFrame {

    public static int IDequipoSeleccion = 0;
    DefaultTableModel tabla = new DefaultTableModel();

    public GestionarEquipos() {
        initComponents();
        setTitle("Tecnico - sesion de " + Acceso.user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Llenado de Tabla equipos
        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT ID_equipo, tipo, marca, status FROM equipos");
            ResultSet rs = pst.executeQuery();

            jtEquipos = new JTable(tabla);
            jScrollPane1.setViewportView(jtEquipos);

            tabla.addColumn(" ");
            tabla.addColumn("Tipo");
            tabla.addColumn("Marca");
            tabla.addColumn("Status");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {

                    fila[i] = rs.getObject(i + 1);
                }
                tabla.addRow(fila);
            }

            cn.close();

        } catch (Exception e) {
            System.err.println("Error al llenar tabla " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar tabla. Comunicarse con administración");
        }

        ObtenerDatosTabla();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEquipos = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();
        cbStatus = new javax.swing.JComboBox<>();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Equipos registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jtEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtEquipos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 650, 180));

        btnMostrar.setBackground(new java.awt.Color(143, 143, 255));
        btnMostrar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 210, 35));

        cbStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo Ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 150, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        String seleccion = cbStatus.getSelectedItem().toString();
        String SentenciaSQL = "";

        tabla.setRowCount(0);
        tabla.setColumnCount(0);

        try {

            Connection cn = Conexion.Conectar();

            if (seleccion.equalsIgnoreCase("Todos")) {
                SentenciaSQL = "SELECT ID_equipo, tipo, marca, status FROM equipos";
            } else {
                SentenciaSQL = "SELECT ID_equipo, tipo, marca, "
                        + "status FROM equipos WHERE status = '" + seleccion + "'";
            }
            
            PreparedStatement pst = cn.prepareStatement(SentenciaSQL);
            ResultSet rs = pst.executeQuery();
            
            jtEquipos = new JTable(tabla);
            jScrollPane1.setViewportView(jtEquipos);
            
            tabla.addColumn(" ");
            tabla.addColumn("Tipo");
            tabla.addColumn("Marca");
            tabla.addColumn("Status");

            while (rs.next()) {
                
                Object [] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                tabla.addRow(fila);
            }
            cn.close();
    
        } catch (Exception e) {
            System.err.println("Error al recuperar los registros de equipos " + e);
        }
        ObtenerDatosTabla();

    }//GEN-LAST:event_btnMostrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTable jtEquipos;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTabla() {
        //Evento creado con click de mouse sobre JTable
        jtEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int fila_point = jtEquipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipoSeleccion = (int) tabla.getValueAt(fila_point, columna_point);

                  InformacionEquipoTecnico informacionEquipoTecnico = new InformacionEquipoTecnico();
                  informacionEquipoTecnico.setVisible(true);
                  
                }
            }
        });//Este parentesis es el de cierre del addMouseListener
    }
}
