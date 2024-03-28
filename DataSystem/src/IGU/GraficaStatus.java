package IGU;

import Logica.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class GraficaStatus extends javax.swing.JFrame {

    String user;
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado;

    String[] vectorStatusNombre = new String[5];
    int[] vectorStatusCantidad = new int[5];

    public GraficaStatus() {
        initComponents();
        user = Acceso.user;

        setTitle("Tecnico - sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT status, COUNT(status) AS Cantidad FROM equipos GROUP BY status");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vectorStatusNombre[posicion] = rs.getString(1);
                    vectorStatusCantidad[posicion] = rs.getInt(2);

                    if (vectorStatusNombre[posicion].equalsIgnoreCase("En Revision")) {
                        EnRevision = vectorStatusCantidad[posicion];
                    } else if (vectorStatusNombre[posicion].equalsIgnoreCase("Entregado")) {
                        Entregado = vectorStatusCantidad[posicion];
                    } else if (vectorStatusNombre[posicion].equalsIgnoreCase("No Reparado")) {
                        NoReparado = vectorStatusCantidad[posicion];
                    } else if (vectorStatusNombre[posicion].equalsIgnoreCase("Nuevo Ingreso")) {
                        NuevoIngreso = vectorStatusCantidad[posicion];
                    } else if (vectorStatusNombre[posicion].equalsIgnoreCase("Reparado")) {
                        Reparado = vectorStatusCantidad[posicion];
                    }

                    posicion++;

                } while (rs.next());
            }
        } catch (Exception e) {
            System.err.println("Error en conectar con la Base de datos al graficar " + e);
            JOptionPane.showMessageDialog(null, "Error al Graficar. Contactar con Administracion");
        }

        repaint();

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
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Grafica de Estado");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables

    public int StatusMasRepetido(int NuevoIngreso, int NoReparado, int EnRevision, int Reparado, int Entregado) {

        if (NuevoIngreso > NoReparado && NuevoIngreso > EnRevision
                && NuevoIngreso > Reparado && NuevoIngreso > Entregado) {
            return NuevoIngreso;

        } else if (NoReparado > EnRevision && NoReparado > Reparado
                && NoReparado > Entregado) {
            return NoReparado;

        } else if (EnRevision > NoReparado && EnRevision > Entregado) {
            return EnRevision;

        } else if (Reparado > Entregado) {
            return Reparado;

        } else {

            return Entregado;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int StatusMasRepetido = StatusMasRepetido(NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado);

        int LargoNuevoIngreso = NuevoIngreso * 400 / StatusMasRepetido;
        int LargoNoReparado = NoReparado * 400 / StatusMasRepetido;
        int LargoEnRevision = EnRevision * 400 / StatusMasRepetido;
        int LargoReparado = Reparado * 400 / StatusMasRepetido;
        int LargoEntregado = Entregado * 400 / StatusMasRepetido;

        //Barra para Nuevo Ingreso
        g.setColor(new Color(240, 248, 0));
        g.fillRect(100, 100, LargoNuevoIngreso, 40);
        g.drawString("Nuevo Ingreso", 10, 118);
        g.drawString("Cantidad :" + NuevoIngreso, 10, 133);

        //Barra para No Reparado
        g.setColor(new Color(255, 0, 0));
        g.fillRect(100, 150, LargoNoReparado, 40);
        g.drawString("No Reparado", 10, 168);
        g.drawString("Cantidad :" + NoReparado, 10, 183);

        //Barra para En Revision
        g.setColor(new Color(0, 0, 0));
        g.fillRect(100, 200, LargoEnRevision, 40);
        g.drawString("En Revision", 10, 218);
        g.drawString("Cantidad :" + EnRevision, 10, 233);

        //Barra para Reparado
        g.setColor(new Color(255, 255, 255));
        g.fillRect(100, 250, LargoReparado, 40);
        g.drawString("Reparado", 10, 268);
        g.drawString("Cantidad :" + Reparado, 10, 283);

        //Barra para Entregado
        g.setColor(new Color(0, 85, 0));
        g.fillRect(100, 300, LargoEntregado, 40);
        g.drawString("Entregado", 10, 318);
        g.drawString("Cantidad :" + Entregado, 10, 333);

    }

}
