package IGU;

import java.awt.Image;
import java.awt.Toolkit;

public class Principal extends javax.swing.JFrame {

    String dnis[] = new String[10];
    String nombres[] = new String[10];
    String apellidos[] = new String[10];
    String direcciones[] = new String[10];
    String telefonoss[] = new String[10];
    String fechanacs[] = new String[10];

    public Principal() {
        initComponents();
    }

    //Cambia el icono de la interfaz
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
                "img/agenda.png"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        wallpaper2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtIndice = new javax.swing.JTextField();
        jlCheck = new javax.swing.JLabel();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agenda Electrónica");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 730, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 850, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 342, 720, 10));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DNI :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 41, -1));

        txtDni.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 25, 210, 30));

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 95, 210, 30));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 70, -1));

        txtApellido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 165, 210, 30));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 70, -1));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Direccion :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 70, -1));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 25, 210, 30));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 95, 210, 30));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha Nacimiento :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 130, -1));

        txtFechaNac.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 165, 210, 30));

        wallpaper2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaper.jpg"))); // NOI18N
        jPanel2.add(wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 240));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 720, 240));

        btnGuardar.setBackground(new java.awt.Color(51, 51, 255));
        btnGuardar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 120, 40));

        btnRetroceder.setBackground(new java.awt.Color(51, 51, 255));
        btnRetroceder.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnRetroceder.setForeground(new java.awt.Color(255, 255, 255));
        btnRetroceder.setText("<<");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });
        jPanel1.add(btnRetroceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 60, 40));

        btnAvanzar.setBackground(new java.awt.Color(51, 51, 255));
        btnAvanzar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnAvanzar.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzar.setText(">>");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 60, 40));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Indice :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        txtIndice.setEditable(false);
        txtIndice.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtIndice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIndice.setText("0");
        jPanel1.add(txtIndice, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 30, 30));

        jlCheck.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlCheck.setForeground(new java.awt.Color(0, 153, 51));
        jPanel1.add(jlCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, -1));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wallpaper.jpg"))); // NOI18N
        jPanel1.add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 730, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        //Se obtiene el valor del indice en String y se pasa a entero
        String indice = txtIndice.getText();
        int ind = Integer.parseInt(indice);

        //Restringe el indice para que 0 el ultimo valor
        if (ind > 0) {
            ind = ind - 1;
            indice = String.valueOf(ind);
            txtIndice.setText(indice);

            //Muestra los valores guardados en cada indice
            txtDni.setText(dnis[ind]);
            txtNombre.setText(nombres[ind]);
            txtApellido.setText(apellidos[ind]);
            txtDireccion.setText(direcciones[ind]);
            txtTelefono.setText(telefonoss[ind]);
            txtFechaNac.setText(fechanacs[ind]);

            jlCheck.setText("");
        }

    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed

        //Se obtiene el valor del indice en String y se pasa a entero
        String indice = txtIndice.getText();
        int ind = Integer.parseInt(indice);

        //Restringe el indice para que 9 sea el ultimo valor
        if (ind < 9) {
            ind = ind + 1;
            indice = String.valueOf(ind);
            txtIndice.setText(indice);

            //Muestra los valores guardados en cada indice
            txtDni.setText(dnis[ind]);
            txtNombre.setText(nombres[ind]);
            txtApellido.setText(apellidos[ind]);
            txtDireccion.setText(direcciones[ind]);
            txtTelefono.setText(telefonoss[ind]);
            txtFechaNac.setText(fechanacs[ind]);

            jlCheck.setText("");
        }

    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        //Se obtiene el valor del indice en String y se pasa a entero
        String indice = txtIndice.getText();
        int ind = Integer.parseInt(indice);

        dnis[ind] = txtDni.getText();
        nombres[ind] = txtNombre.getText();
        apellidos[ind] = txtApellido.getText();
        direcciones[ind] = txtDireccion.getText();
        telefonoss[ind] = txtTelefono.getText();
        fechanacs[ind] = txtFechaNac.getText();

        jlCheck.setText("¡Registro Exitoso!");


    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jlCheck;
    private javax.swing.JLabel jlWallpaper;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtIndice;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JLabel wallpaper2;
    // End of variables declaration//GEN-END:variables
}
