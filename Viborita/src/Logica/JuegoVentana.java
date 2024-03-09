
package Logica;

import javax.swing.JFrame;


public class JuegoVentana extends JFrame{

    public JuegoVentana() {
        
        this.setTitle("Juego");
        this.add(new JuegoContenido());
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    
}
