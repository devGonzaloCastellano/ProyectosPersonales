package Vista;

import javax.swing.Icon;
import javax.swing.ImageIcon;



public class PnlBienvenida extends javax.swing.JPanel {

    
    public PnlBienvenida() {
        initComponents();
       
        
        //Cambia fondo del panel
        ImageIcon wallpaper = new ImageIcon("src/img/Bienvenida.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(600, 500, WIDTH));
        jlWallpaper.setIcon(icono);
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlWallpaper = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlWallpaper.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jlWallpaper.setForeground(new java.awt.Color(255, 255, 255));
        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Bienvenida.jpg"))); // NOI18N
        jPanel1.add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables

}
