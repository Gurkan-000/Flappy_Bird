package com.example;

import javax.swing.JPanel;

public abstract class Figura {

    private int posicionX;
    private int posicionY;
    
    private int ancho;
    private int altura;
    
    private JPanel panel;
    
    public Figura(int posicionX, int posicionY, int ancho, int altura, JPanel panel) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = ancho;
        this.altura = altura;
        this.panel = panel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public abstract void mover();

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}