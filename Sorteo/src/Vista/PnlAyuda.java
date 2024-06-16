package Vista;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class PnlAyuda extends javax.swing.JPanel {

    // Arreglos para almacenar las rutas de las imágenes
    String[] images = {"img/Ayuda1.png", "img/Ayuda2.png", "img/Ayuda3.png"};
    
    public PnlAyuda() {
        initComponents();
        txtIndice.setText("1");
        actualizarImagen(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBotonera = new javax.swing.JPanel();
        btnRetroceder = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        txtIndice = new javax.swing.JTextField();
        jlAyuda = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpBotonera.setBackground(new java.awt.Color(51, 51, 51));
        jpBotonera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRetroceder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRetroceder.setText("<<");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        btnRetroceder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRetrocederKeyPressed(evt);
            }
        });
        jpBotonera.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        btnSiguiente.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSiguiente.setText(">>");
        btnSiguiente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnSiguienteFocusGained(evt);
            }
        });
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        btnSiguiente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSiguienteKeyPressed(evt);
            }
        });
        jpBotonera.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        txtIndice.setEditable(false);
        txtIndice.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtIndice.setText("1");
        txtIndice.setEnabled(false);
        jpBotonera.add(txtIndice, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        add(jpBotonera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 600, 70));

        jlAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ayuda1.png"))); // NOI18N
        add(jlAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        //Se obtiene el valor del indice en String y se pasa a entero
        String indice = txtIndice.getText();
        int ind = Integer.parseInt(indice);

        //Restringe el indice para que 1 el ultimo valor
        if (ind > 1) {
            ind = ind - 1;
            indice = String.valueOf(ind);
            txtIndice.setText(indice);

            //Muestra las imagenes segun corresponda a cada indice
            actualizarImagen(ind);
        }
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        //Se obtiene el valor del indice en String y se pasa a entero
        String indice = txtIndice.getText();
        int ind = Integer.parseInt(indice);

        //Restringe el indice para que 3 sea el ultimo valor
        if (ind < 3) {
            ind = ind + 1;
            indice = String.valueOf(ind);
            txtIndice.setText(indice);

            //Muestra las imagenes segun corresponda a cada indice
            actualizarImagen(ind);

        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnSiguienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSiguienteKeyPressed
        // Verificar si la tecla presionada es la flecha derecha
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            btnSiguienteActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            btnRetroceder.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnSiguienteKeyPressed

    private void btnRetrocederKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRetrocederKeyPressed
        // Verificar si la tecla presionada es la flecha izquierda
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            btnRetrocederActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            btnSiguiente.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnRetrocederKeyPressed

    private void btnSiguienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSiguienteFocusGained
      btnSiguiente.requestFocusInWindow();
    }//GEN-LAST:event_btnSiguienteFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jlAyuda;
    private javax.swing.JPanel jpBotonera;
    private javax.swing.JTextField txtIndice;
    // End of variables declaration//GEN-END:variables

    //Metodo para cambiar las imagenes
    private void actualizarImagen(int indice) {
        // Cargar la imagen correspondiente al índice
        String rutaImagen = images[indice - 1];
        ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource(rutaImagen));
        jlAyuda.setIcon(icono);
    }

   

}
