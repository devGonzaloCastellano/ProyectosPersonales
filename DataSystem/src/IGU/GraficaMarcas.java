package IGU;

import Logica.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class GraficaMarcas extends javax.swing.JFrame {

    String user;
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado;

    String[] vectoMarcasNombre = new String[7];
    int[] vectorMarcasCantidad = new int[7];
    int Motorola, Philips, HP, Samsung, Epson, Intel, AMD;

    public GraficaMarcas() {
        initComponents();
        user = Acceso.user;

        setTitle("Tecnico - sesion de " + user);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        try {
            Connection cn = Conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT marca, COUNT(status) AS Marcas FROM equipos GROUP BY marca");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vectoMarcasNombre[posicion] = rs.getString(1);
                    vectorMarcasCantidad[posicion] = rs.getInt(2);

                    if (vectoMarcasNombre[posicion].equalsIgnoreCase("AMD")) {
                        AMD = vectorMarcasCantidad[posicion];
                    } else if (vectoMarcasNombre[posicion].equalsIgnoreCase("Epson")) {
                        Epson = vectorMarcasCantidad[posicion];
                    } else if (vectoMarcasNombre[posicion].equalsIgnoreCase("HP")) {
                        HP = vectorMarcasCantidad[posicion];
                    } else if (vectoMarcasNombre[posicion].equalsIgnoreCase("Intel")) {
                        Intel = vectorMarcasCantidad[posicion];
                    } else if (vectoMarcasNombre[posicion].equalsIgnoreCase("Motorola")) {
                        Motorola = vectorMarcasCantidad[posicion];
                    } else if (vectoMarcasNombre[posicion].equalsIgnoreCase("Phillips")) {
                        Philips = vectorMarcasCantidad[posicion];
                    } else if (vectoMarcasNombre[posicion].equalsIgnoreCase("Samsung")) {
                        Samsung = vectorMarcasCantidad[posicion];
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
        jlTitulo.setText("Grafica de Marcas");
        getContentPane().add(jlTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaperPrincipal.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficaMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int totalMarcas = AMD + Epson + HP + Intel + Motorola + Philips + Samsung;

        int gradosAMD = AMD * 360 / totalMarcas;
        int gradosEpson = Epson * 360 / totalMarcas;
        int gradosHP = HP * 360 / totalMarcas;
        int gradosIntel = Intel * 360 / totalMarcas;
        int gradosMotorola = Motorola * 360 / totalMarcas;
        int gradosPhillips = Philips * 360 / totalMarcas;
        int gradosSamsung = Samsung * 360 / totalMarcas;

        //Arco AMD
        g.setColor(new Color(175, 122, 197));
        g.fillArc(25, 100, 270, 270, 0, gradosAMD);
        g.fillRect(310, 120, 20, 20);
        g.setColor(new Color(0, 0, 0));
        g.drawString(AMD + " de AMD", 340, 135);
        
        //Arco Epson
        g.setColor(new Color(255, 0, 0));
        g.fillArc(25, 100, 270, 270, gradosAMD, gradosEpson);
        g.fillRect(310, 150, 20, 20);
        g.setColor(new Color(0, 0, 0));
        g.drawString(Epson + " de Epson", 340, 165);
        
        //Arco HP
        g.setColor(new Color(0, 255, 0));
        g.fillArc(25, 100, 270, 270, gradosAMD + gradosEpson, gradosHP);
        g.fillRect(310, 180, 20, 20);
        g.setColor(new Color(0, 0, 0));
        g.drawString(HP + " de HP", 340, 195);
        
        //Arco Intel
        g.setColor(new Color(0, 0, 255));
        g.fillArc(25, 100, 270, 270, gradosAMD + gradosEpson + gradosHP, gradosIntel);
        g.fillRect(310, 210, 20, 20);
        g.setColor(new Color(0, 0, 0));
        g.drawString(Intel + " de Intel", 340, 225);
        
        //Arco Motorola
        g.setColor(new Color(240, 248, 0));
        g.fillArc(25, 100, 270, 270, gradosAMD + gradosEpson + gradosHP + gradosIntel, gradosMotorola);
        g.fillRect(310, 240, 20, 20);
        g.setColor(new Color(0, 0, 0));
        g.drawString(Motorola + " de Motorola", 340, 255);
        
        //Arco Phillips
        g.setColor(new Color(148, 10, 77));
        g.fillArc(25, 100, 270, 270, gradosAMD + gradosEpson + gradosHP + gradosIntel + gradosMotorola, gradosPhillips);
        g.fillRect(310, 270, 20, 20);
        g.setColor(new Color(0, 0, 0));
        g.drawString(Philips + " de Phillips", 340, 285);
        
        //Arco Samsung
        g.setColor(new Color(152, 120, 148));
        g.fillArc(25, 100, 270, 270, gradosAMD + gradosEpson + gradosHP + gradosIntel + gradosMotorola + gradosPhillips, gradosSamsung);
        g.fillRect(310, 300, 20, 20);
        g.setColor(new Color(0, 0, 0));
        g.drawString(Samsung + " de Samsung", 340, 315);
        
        
    }

}
