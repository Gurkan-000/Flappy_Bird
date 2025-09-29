package com.example;

import javax.swing.JPanel;

public class Tubo extends Figura {

    private int posicionTuboInferiorY;

    private int alturaTuboInferior;

    private int separacion = 150;

    private int coordenadaSeparacion;

    public Tubo(int posicionX, int posicionY, int ancho, JPanel panel) {
        super(posicionX, posicionY, ancho, 0, panel);
        generarCoordenadasDeSeparacion();
        establecerValoresDePosicion();
    }

    public int getPosicionTuboInferiorY() {
        return posicionTuboInferiorY;
    }

    public int getAlturaTuboInferior() {
        return alturaTuboInferior;
    }

    private void generarCoordenadasDeSeparacion() {
        coordenadaSeparacion = (int) (Math.random() * ((550 - (separacion + 50)) - 50 - 1) + 50);
    }

    private void establecerValoresDePosicion() {
        setAltura(coordenadaSeparacion);
        posicionTuboInferiorY = separacion + getAltura();
        alturaTuboInferior = getPanel().getHeight() - posicionTuboInferiorY;
    }

    @Override
    public void mover() {

        setPosicionX(getPosicionX() - 3);

        if(getPosicionX() <= -getAncho()){
            setPosicionX(getPanel().getWidth());
            generarCoordenadasDeSeparacion();
            establecerValoresDePosicion();
        }

    }

}
