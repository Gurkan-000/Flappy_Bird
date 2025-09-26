package com.example;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pajaro extends Figura {

    private int salto;

    private final int gravedad = 1;

    public Pajaro(int posicionX, int posicionY, int ancho, int altura, int salto) {
        super(posicionX, posicionY, ancho, altura);

        this.salto = salto;

        pajaroSalto keySalto = new pajaroSalto();

        addKeyListener(keySalto);

    }

    public void saltar() {

    }

    private class pajaroSalto extends KeyAdapter {

        public void keyPressed(KeyEvent k) {

            if (k.getKeyCode() == KeyEvent.VK_SPACE) {
                salto = true;
                gravedad = 10;
            }

        }

    }

}
