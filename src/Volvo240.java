import java.awt.*;

public class Volvo240 extends Car {


    private final static double trimFactor = 1.25;

    protected Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        stopEngine();
    }

    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /** Här får man en speedFactor som tar hänsyn till en trimFactor.
     * Den används sedan i incrementSpeed och decrementSpeed.
     * Den overridear den som finns i Car. Det som skiljer denna från den i Car är att här
     * tar man hänsyn till trimFactor, något som den i Car inte gör.
     */
}

