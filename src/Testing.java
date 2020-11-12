import org.junit.Test;

import java.awt.*;

public class Testing {

    public static void main(String[] args){

        Volvo240 snabbsomfan = new Volvo240();
        Saab95 snabbare = new Saab95();
        Saab95 en = new Saab95();

        snabbare.startEngine();
        System.out.println(snabbare.getCurrentSpeed());

        en.startEngine();
        en.setTurboOn();

        System.out.println(en.position);
    }
}


