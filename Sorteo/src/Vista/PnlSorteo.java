package Vista;

import Modelo.Participante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PnlSorteo extends javax.swing.JPanel {

    private List<Participante> listaParticipantes;
    private Timer timer;
    private int progresoBarra;

    public PnlSorteo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbPrimero = new javax.swing.JLabel();
        lbSegundo = new javax.swing.JLabel();
        lbTercero = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        pbCarga = new javax.swing.JProgressBar();
        btnSorteo = new javax.swing.JButton();
        jlWallpaper = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbPrimero.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        lbPrimero.setForeground(new java.awt.Color(255, 255, 255));
        lbPrimero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPrimero.setText("Ganador");
        jPanel2.add(lbPrimero, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        lbSegundo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbSegundo.setForeground(new java.awt.Color(255, 255, 255));
        lbSegundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSegundo.setText("Suplente");
        jPanel2.add(lbSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        lbTercero.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbTercero.setForeground(new java.awt.Color(255, 255, 255));
        lbTercero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTercero.setText("Suplente");
        jPanel2.add(lbTercero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/podio.png"))); // NOI18N
        jPanel2.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pbCarga.setBackground(new java.awt.Color(102, 0, 102));
        pbCarga.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pbCarga.setForeground(new java.awt.Color(0, 51, 204));
        pbCarga.setStringPainted(true);
        jPanel1.add(pbCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 580, 43));

        btnSorteo.setBackground(new java.awt.Color(102, 0, 102));
        btnSorteo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSorteo.setForeground(new java.awt.Color(255, 255, 255));
        btnSorteo.setText("SORTEAR");
        btnSorteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSorteoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSorteo, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 368, 150, 50));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        jlWallpaper.setText("jLabel1");
        jPanel1.add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 600, 510));

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

    private void btnSorteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSorteoActionPerformed
        iniciarSorteo();
    }//GEN-LAST:event_btnSorteoActionPerformed

    //Trae la lista desde el panel Participantes
    public void setListaParticipantes(List<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    //Metodo para sortear participantes
    private void iniciarSorteo() {
        if (listaParticipantes == null || listaParticipantes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay participantes para el sorteo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        progresoBarra = 0;
        pbCarga.setValue(progresoBarra);

        timer = new Timer(50, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                progresoBarra += 1;
                pbCarga.setValue(progresoBarra);
                if (progresoBarra >= 100) {
                    timer.stop();
                    seleccionarGanadores();
                }
            }
        });
        timer.start();
    }

    private void seleccionarGanadores() {
        List<Participante> listaPonderada = new ArrayList<>();
        //Recorre la lista de participantes para agregar las chances extra
        for (Participante p : listaParticipantes) {
            for (int i = 0; i < p.getChances(); i++) {
                //Nueva lista con chances extra
                listaPonderada.add(p);
            }
        }

        //Reordena la lista de manera random
        Collections.shuffle(listaPonderada);
        //Obtiene los participantes del listado por orden
        Participante ganador = listaPonderada.get(0);

        // Inicializar los suplentes
        Participante suplente1 = null;
        Participante suplente2 = null;

        // Buscar suplente 1 eliminando de las opciones al ganador
        for (Participante p : listaPonderada) {
            if (!p.equals(ganador)) {
                suplente1 = p;
                break;
            }
        }

        // Buscar suplente 2 eliminando de las opciones al ganador y a suplente1
        for (Participante p : listaPonderada) {
            if (!p.equals(ganador) && !p.equals(suplente1)) {
                suplente2 = p;
                break;
            }
        }

        //Setea los ganadores a los label correspondientes
        lbPrimero.setText(ganador.getUsuario());
        lbSegundo.setText(suplente1.getUsuario());
        lbTercero.setText(suplente2.getUsuario());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSorteo;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JLabel lbPrimero;
    private javax.swing.JLabel lbSegundo;
    private javax.swing.JLabel lbTercero;
    private javax.swing.JProgressBar pbCarga;
    // End of variables declaration//GEN-END:variables
}
