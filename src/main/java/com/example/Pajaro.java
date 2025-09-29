package com.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Pajaro extends Figura {

    private int velocidad = 0;

    private final int gravedad = 1;

    private KeyEventSalto keyEventSalto;

    public Pajaro(int posicionX, int posicionY, int ancho, int altura, JPanel panel) {
        super(posicionX, posicionY, ancho, altura, panel);
        keyEventSalto = new KeyEventSalto();
    }

    public KeyEventSalto getKeyEventSalto() {
        return keyEventSalto;
    }

    @Override
    public void mover() {
        setPosicionY(getPosicionY() + (velocidad+=gravedad));
    }

    private class KeyEventSalto extends KeyAdapter {
        @Override
        public void keyPressed (KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                velocidad = -12;
            }
        }
    }

}
