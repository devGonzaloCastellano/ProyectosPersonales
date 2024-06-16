package Vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JFrame {
    
    PnlSorteo sorteo = new PnlSorteo();
    PnlParticipantes participantes = new PnlParticipantes(sorteo);
    PnlBienvenida bienvenida = new PnlBienvenida();
    PnlAyuda ayuda = new PnlAyuda();
    
    public Inicio() {
        initComponents();
        MostrarPanel(bienvenida);
    }

    //Cambia el icono de la interfaz
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
                "img/icono.png"));
        
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlBotonera = new javax.swing.JPanel();
        btnParticipantes = new javax.swing.JButton();
        btnSorteo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlBotonera2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlPantalla = new javax.swing.JPanel();
        Barra = new javax.swing.JMenuBar();
        Inicio = new javax.swing.JMenu();
        MenuPart = new javax.swing.JMenuItem();
        MenuSorteo = new javax.swing.JMenuItem();
        MenuCancelar = new javax.swing.JMenuItem();
        Informacion = new javax.swing.JMenu();
        MenuVersion = new javax.swing.JMenuItem();
        MenuAcercaDe = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();
        MenuAyuda = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        pnlFondo.setBackground(new java.awt.Color(0, 0, 0));

        pnlBotonera.setBackground(new java.awt.Color(102, 0, 102));

        btnParticipantes.setBackground(new java.awt.Color(255, 255, 255));
        btnParticipantes.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnParticipantes.setForeground(new java.awt.Color(102, 0, 102));
        btnParticipantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Participantes.png"))); // NOI18N
        btnParticipantes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipantesActionPerformed(evt);
            }
        });

        btnSorteo.setBackground(new java.awt.Color(255, 255, 255));
        btnSorteo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSorteo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Sorteo.png"))); // NOI18N
        btnSorteo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSorteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSorteoActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Participantes");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sorteo");

        javax.swing.GroupLayout pnlBotoneraLayout = new javax.swing.GroupLayout(pnlBotonera);
        pnlBotonera.setLayout(pnlBotoneraLayout);
        pnlBotoneraLayout.setHorizontalGroup(
            pnlBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoneraLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnParticipantes, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(btnSorteo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        pnlBotoneraLayout.setVerticalGroup(
            pnlBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoneraLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnSorteo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlBotonera2.setBackground(new java.awt.Color(102, 0, 102));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cancelar.png"))); // NOI18N
        btnCancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Salir.png"))); // NOI18N
        btnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cancelar");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Salir");

        javax.swing.GroupLayout pnlBotonera2Layout = new javax.swing.GroupLayout(pnlBotonera2);
        pnlBotonera2.setLayout(pnlBotonera2Layout);
        pnlBotonera2Layout.setHorizontalGroup(
            pnlBotonera2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonera2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonera2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotonera2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlBotonera2Layout.setVerticalGroup(
            pnlBotonera2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonera2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPantalla.setBackground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout pnlPantallaLayout = new javax.swing.GroupLayout(pnlPantalla);
        pnlPantalla.setLayout(pnlPantallaLayout);
        pnlPantallaLayout.setHorizontalGroup(
            pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        pnlPantallaLayout.setVerticalGroup(
            pnlPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlBotonera2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(pnlBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlBotonera2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        Inicio.setText("Inicio");

        MenuPart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        MenuPart.setText("Participantes");
        MenuPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPartActionPerformed(evt);
            }
        });
        Inicio.add(MenuPart);

        MenuSorteo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        MenuSorteo.setText("Sorteo");
        MenuSorteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSorteoActionPerformed(evt);
            }
        });
        Inicio.add(MenuSorteo);

        MenuCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        MenuCancelar.setText("Cancelar");
        MenuCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCancelarActionPerformed(evt);
            }
        });
        Inicio.add(MenuCancelar);

        Barra.add(Inicio);

        Informacion.setText("Informacion");

        MenuVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        MenuVersion.setText("Version");
        MenuVersion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVersionActionPerformed(evt);
            }
        });
        Informacion.add(MenuVersion);

        MenuAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        MenuAcercaDe.setText("Acerca De");
        MenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAcercaDeActionPerformed(evt);
            }
        });
        Informacion.add(MenuAcercaDe);

        Barra.add(Informacion);

        Salir.setText("Ayuda");

        MenuAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        MenuAyuda.setText("Ayuda");
        MenuAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAyudaActionPerformed(evt);
            }
        });
        Salir.add(MenuAyuda);

        Barra.add(Salir);

        jMenu1.setText("Salir");

        MenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        MenuSalir.setText("Salir");
        MenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSalir);

        Barra.add(jMenu1);

        setJMenuBar(Barra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Barra de Menu
    private void MenuPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPartActionPerformed
        MostrarPanel(participantes);
    }//GEN-LAST:event_MenuPartActionPerformed

    private void MenuSorteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSorteoActionPerformed
        MostrarPanel(sorteo);
    }//GEN-LAST:event_MenuSorteoActionPerformed

    private void MenuCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCancelarActionPerformed
        MostrarPanel(bienvenida);
    }//GEN-LAST:event_MenuCancelarActionPerformed

    private void MenuVersionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVersionActionPerformed
        MostrarMensaje("Version 1.0", "Info", "Version del Sistema");
    }//GEN-LAST:event_MenuVersionActionPerformed

    private void MenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAcercaDeActionPerformed
        MostrarMensaje("Dev. Gonzalo Castellano \n"
                + "monocastellano@Outlook.com",
                "Info", "Acerca del creador");
    }//GEN-LAST:event_MenuAcercaDeActionPerformed

    private void MenuAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAyudaActionPerformed
        MostrarPanel(ayuda);
    }//GEN-LAST:event_MenuAyudaActionPerformed

    private void MenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuSalirActionPerformed

    //Botonera
    private void btnParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipantesActionPerformed
        MostrarPanel(participantes);
    }//GEN-LAST:event_btnParticipantesActionPerformed

    private void btnSorteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSorteoActionPerformed
        MostrarPanel(sorteo);
    }//GEN-LAST:event_btnSorteoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MostrarPanel(bienvenida);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    //Metodo Generico para mostrar paneles
    private void MostrarPanel(JPanel p) {
        p.setSize(600, 500);
        p.setLocation(0, 0);
        
        pnlPantalla.removeAll();
        pnlPantalla.add(p, BorderLayout.CENTER);
        pnlPantalla.revalidate();
        pnlPantalla.repaint();
    }

    //Metodo Generico para mostrar mensaje
    public void MostrarMensaje(String mensaje, String tipo, String titulo) {
        //Personalizacion de JOptionPane
        JOptionPane optionPane = new JOptionPane(mensaje); //Crea un cuadro pop-up
        //Asigna el tipo de mensaje que se va a dar
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);//Coloca titulo al cuadro pop-up
        dialog.setAlwaysOnTop(true);//se visualiza en la parte de arriba
        dialog.setVisible(true);//Lo hace visible
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Barra;
    private javax.swing.JMenu Informacion;
    private javax.swing.JMenu Inicio;
    private javax.swing.JMenuItem MenuAcercaDe;
    private javax.swing.JMenuItem MenuAyuda;
    private javax.swing.JMenuItem MenuCancelar;
    private javax.swing.JMenuItem MenuPart;
    private javax.swing.JMenuItem MenuSalir;
    private javax.swing.JMenuItem MenuSorteo;
    private javax.swing.JMenuItem MenuVersion;
    private javax.swing.JMenu Salir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnParticipantes;
    private javax.swing.JButton btnSalir;
    public javax.swing.JButton btnSorteo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel pnlBotonera;
    private javax.swing.JPanel pnlBotonera2;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlPantalla;
    // End of variables declaration//GEN-END:variables
}
