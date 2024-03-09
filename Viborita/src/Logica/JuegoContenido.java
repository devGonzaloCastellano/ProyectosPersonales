package Logica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JuegoContenido extends JPanel implements ActionListener {

    //Pantalla
    static final int PANTALLA = 400;
    static final int PIXEL = 20;
    static final int CUADRICULA = (int) PANTALLA / PIXEL;
    static final int TOTALPIXELES = (PANTALLA * PANTALLA) / PIXEL;

    //Serpiente
    int[] serpienteX = new int[TOTALPIXELES];
    int[] serpienteY = new int[TOTALPIXELES];
    int InicioSerpiente = 3;
    String direccion = "Derecha";

    //Comida
    int comidaX, comidaY;
    Random r = new Random();
    int contador = 0;

    //timer
    boolean running = true;
    int DELAY =  50;
    Timer timer;

    public JuegoContenido() {

        this.setPreferredSize(new Dimension(PANTALLA, PANTALLA));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new Controles());
        IniciarJuego();

    }

    public void IniciarJuego() {
        AgregarComida();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    //Genera de manera Random el punto para comer
    public void AgregarComida() {
        comidaX = r.nextInt(CUADRICULA) * PIXEL;
        comidaY = r.nextInt(CUADRICULA) * PIXEL;
    }

    //Metodo para el control de movimiento de la serpiente
    public void MoverSerpiente() {
        for (int i = InicioSerpiente; i > 0; i--) {
            serpienteX[i] = serpienteX[i - 1];
            serpienteY[i] = serpienteY[i - 1];
        }

        switch (direccion) {
            case "Arriba":
                serpienteY[0] = serpienteY[0] - PIXEL;
                break;
            case "Abajo":
                serpienteY[0] = serpienteY[0] + PIXEL;
                break;
            case "Izquierda":
                serpienteX[0] = serpienteX[0] - PIXEL;
                break;
            case "Derecha":
                serpienteX[0] = serpienteX[0] + PIXEL;
                break;
        }

    }

    //Metodo para controlar la comida de la serpiente
    public void CheckComida() {

        if (serpienteX[0] == comidaX && serpienteY[0] == comidaY) {
            InicioSerpiente++;
            AgregarComida();
        }
    }

  

    //Metodo para chequear las colisiones contra el fin de pantalla
    public void CheckColision() {
        if (serpienteX[0] < 0) {
            running = false;
        }
        if (serpienteY[0] < 0) {
            running = false;
        }
        if (serpienteX[0] > PANTALLA - PIXEL - 1) {
            running = false;
        }
        if (serpienteY[0] > PANTALLA - PIXEL - 1) {
            running = false;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            MoverSerpiente();
            CheckComida();
            CheckColision();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Dibujo de cuadricula 
        for (int i = 0; i < CUADRICULA; i++) {
            g.drawLine(0, PIXEL * i, PANTALLA, PIXEL * i);
            g.drawLine(PIXEL * i, 0, PIXEL * i, PANTALLA);
            g.setColor(Color.BLACK);
        }

        //Dibujo para la comida
        g.setColor(Color.red);
        g.fillOval(comidaX, comidaY, PIXEL, PIXEL);

        //Dibujo de serpiente
        g.setColor(Color.green);
        for (int i = 0; i < InicioSerpiente; i++) {
            g.fillRect(serpienteX[i], serpienteY[i], PIXEL, PIXEL);
        }
    }

    public class Controles extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    direccion = "Arriba";
                    break;
                case KeyEvent.VK_S:
                    direccion = "Abajo";
                    break;
                case KeyEvent.VK_A:
                    direccion = "Izquierda";
                    break;
                case KeyEvent.VK_D:
                    direccion = "Derecha";
                    break;

                case KeyEvent.VK_UP:
                    direccion = "Arriba";
                    break;
                case KeyEvent.VK_DOWN:
                    direccion = "Abajo";
                    break;
                case KeyEvent.VK_LEFT:
                    direccion = "Izquierda";
                    break;
                case KeyEvent.VK_RIGHT:
                    direccion = "Derecha";
                    break;
            }

        }

    }

}
