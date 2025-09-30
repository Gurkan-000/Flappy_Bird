package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Modelo.*;
import Util.Colision;

public class flappy_game extends JPanel {

    private Pajaro pajaro;
    private Tubo tubo;

    private Timer animacion;

    public flappy_game() {
        setSize(325, 550);
        iniciarJuego();
    }

    public void iniciarJuego() {
        animacion = new Timer(1000 / 60, e -> animacionJuego(e));
        pajaro = new Pajaro(50, (getHeight() - 30)/2, 45, 30, this);
        tubo = new Tubo(getWidth(), 0, 60, this);

        setFocusable(true);
        addKeyListener(pajaro.getKeyEventSalto());
        animacion.start();
    }

    public void reiniciarJuego() {
        tubo.setPosicionX(getWidth());
        pajaro.setPosicionY((getHeight() - pajaro.getAltura())/2);
        animacion.start();
    }

    public Image Imagen(String url){
        return new ImageIcon(getClass().getResource("/"+url)).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);

        g.drawImage(Imagen("fondo.png"), 0, 0,getWidth(),getHeight(), this);

        g.drawImage(Imagen("bird.png"),pajaro.getPosicionX(), pajaro.getPosicionY(), pajaro.getAncho(), pajaro.getAltura(),this);

        g.drawImage(Imagen("tubo2.png"),tubo.getPosicionX(), tubo.getPosicionY(), tubo.getAncho(), tubo.getAltura(),this);
        g.drawImage(Imagen("tubo1.png"),tubo.getPosicionX(), tubo.getPosicionTuboInferiorY(), tubo.getAncho(), tubo.getAlturaTuboInferior(),this);

    }

    public void animacionJuego(ActionEvent e) {
        
        if(Colision.colisiono(pajaro, tubo)){

            animacion.stop();

            int SI = JOptionPane.showConfirmDialog(this, "Game over : ¿Quieres intentarlo de nuevo?", "", JOptionPane.YES_NO_OPTION);

            if(SI == JOptionPane.YES_OPTION){
                reiniciarJuego();
            }else{
                System.exit(0);
            }

        }else{
            pajaro.mover();
            tubo.mover();
    
            repaint();
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
