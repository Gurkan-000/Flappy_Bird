package Util;

import Modelo.*;

public class Colision {

    public static boolean colisiono(Pajaro pajaro, Tubo tubo){
        
        if(
            ((pajaro.getPosicionY()+pajaro.getAltura()) >= pajaro.getPanel().getHeight())
                ||
            (
            ((pajaro.getPosicionX() + pajaro.getAncho()) >= tubo.getPosicionX() && pajaro.getPosicionX() <= (tubo.getPosicionX() + tubo.getAncho()))
                &&
            (pajaro.getPosicionY() <= tubo.getAltura() || (pajaro.getPosicionY() + pajaro.getAltura()) >= tubo.getPosicionTuboInferiorY())  
            )    
        ){
            return true;
        }

        return false;
    }

}
