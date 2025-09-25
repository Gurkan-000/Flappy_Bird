package com.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class flappy_game extends JPanel {

    private Timer movPajaro;
    private Timer movTubos;

    private int xPajaro;
    private int yPajaro;

    private int xTubo;
    private int yTubo;

    private int separacion;

    private int gravedad = 1;

    private boolean salto = false;

    public flappy_game() {

        pajaroSalto salto = new pajaroSalto();
        addKeyListener(salto);
        setFocusable(true);

        iniciarJuego();
    }

    public void iniciarJuego() {

        movPajaro = new Timer(1000 / 60, e -> EventMovPajaro(e));
        movTubos = new Timer(5, e -> EventMovTubo(e));

        xPajaro = 50;
        yPajaro = 450 / 2;

        xTubo = 325;
        yTubo = 0;

        gravedad = 1;

        setSeparacion();

        movPajaro.start();
        movTubos.start();

    }

    public void setSeparacion() {
        separacion = (int) (Math.random() * ((550 - 150) - 50 - 1) + 25);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);

        g.fillRect(xPajaro, yPajaro, 30, 30);

        g.fillRect(xTubo, yTubo, 50, separacion);
        g.fillRect(xTubo, separacion + 100, 50, getHeight());

    }

    public void EventMovPajaro(ActionEvent e) {

        colision();

        if (salto) {
            yPajaro -= gravedad--;
            if(gravedad <= 0){
                salto = false;
                gravedad = 1;
            }
        } else {
            yPajaro += gravedad++;
        }

        repaint();
    }

    public void EventMovTubo(ActionEvent e) {

        xTubo -= 2;

        if (xTubo <= -50) {
            xTubo = getWidth();
            setSeparacion();
        }

    }

    private class pajaroSalto extends KeyAdapter {

        public void keyPressed(KeyEvent k) {

            if (k.getKeyCode() == KeyEvent.VK_SPACE) {
                salto = true;
                gravedad = 10;
            }

        }

    }

    public void colision() {

        if (yPajaro >= getHeight() - 30
                ||
                (
                    ((xPajaro + 30) >= xTubo && xPajaro <= xTubo + 50)
                        &&
                    !(yPajaro >= separacion && yPajaro + 30 <= (separacion + 100))
                        )) {

            movPajaro.stop();
            movTubos.stop();

            int opcion = JOptionPane.showConfirmDialog(this, "¿Quiere intentarlo de nuevo?", "Game Over",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                iniciarJuego();
            } else {
                System.exit(0);
                ;
            }

        }
    }

    public static void main(String[] args) {

        JFrame form = new JFrame();
        flappy_game flappy = new flappy_game();
        
        form.add(flappy);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setSize(325, 550);
        form.setLocation(500, 100);
        form.setResizable(false);
        form.setVisible(true);

    }

}
