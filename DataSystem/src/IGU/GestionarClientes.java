package IGU;

import java.sql.*;
import Logica.Conexion;
import java.awt.Image;
import java.awt.Toolkit;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestionarClientes extends javax.swing.JFrame {
    
    
    public static int IDclienteSeleccion = 0;
    DefaultTableModel tabla = new DefaultTableModel();

    public GestionarClientes() {
        initComponents();
        setSize(650,350);
        setTitle("Gestionar clientes - sesion de " + Acceso.user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Llenado de Tabla clientes
        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT ID_cliente, nombre_cl, email_cl, telefono_cl, direccion_cl FROM clientes");
            ResultSet rs = pst.executeQuery();

            jtClientes = new JTable(tabla);
            jScrollPane1.setViewportView(jtClientes);

            tabla.addColumn("ID");
            tabla.addColumn("Nombre");
            tabla.addColumn("Email");
            tabla.addColumn("Telefono");
            tabla.addColumn("Modificado por");

            while (rs.next()) {
                Object[] fila = new Object[5];
                for (int i = 0; i < 5; i++) {

                    fila[i] = rs.getObject(i + 1);
                }

                tabla.addRow(fila);
            }

            cn.close();

        } catch (Exception e) {
            System.err.println("Error al llenar tabla " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar tabla. Comuniquese con administración");
        
        }
        
        

        //Evento creado con click de mouse sobre JTable
        jtClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int fila_point = jtClientes.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDclienteSeleccion = (int) tabla.getValueAt(fila_point, columna_point);
                
                    InformacionClientes infoClientes = new InformacionClientes();
                    infoClientes.setVisible(true);   
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clientes registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtClientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 650, 250));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTable jtClientes;
    // End of variables declaration//GEN-END:variables
}
