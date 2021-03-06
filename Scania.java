import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Car {

    private final static double trimFactor = 1.5;
    private static double angle = 0;

    /**
     * Construktor, apply startvalues to an object of Scania
     */
    public Scania(){
        super(2, 200, Color.WHITE, "Scania", new Point2D.Double(0,0));
        stopEngine();
    }

    /**
     * @return speedFactor, depending on enginePower and trimFactor
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * @param amount car gas with amount
     */
    public void gas(Double amount) {
        if(getAngle() == 0)
            gas(amount);
    }

    /**
     * @param change , tilts the lift with the angle change which can be both neg and pos
     */
    public void tilt(double change) {
        if(getCurrentSpeed() == 0)
            if((angle + change) >=0 && (angle + change) <= 75)
                angle += change;
    }

    /**
     * @return the current angle of the lift
     */
    public double getAngle() {
        return angle;
    }
}
