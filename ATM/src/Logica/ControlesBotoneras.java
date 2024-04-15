package Logica;

import javax.swing.JButton;

public class ControlesBotoneras {
    private JButton[] botones;

    public ControlesBotoneras(JButton... botones) {
        this.botones = botones;
    }

    public void setEnabled(boolean Habilitacion) {
        for (JButton boton : botones) {
            boton.setEnabled(Habilitacion);
        }
    }
}
