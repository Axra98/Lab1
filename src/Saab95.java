import java.awt.*;

public class Saab95 extends Car{
    /** Denna klass ärver från Car. Man får med alla metoder pluss att man lägger till egna här.
     *
     */

    private boolean turboOn;

    protected Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff(){
        turboOn = false;
    }

    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
            return enginePower * 0.01 * turbo;
    }
    /**Denna metod heter speedFactor vilket är samma som den i Car klassen. Mha en override skriver man dock
     * över det som finns i car och använder denna istället, eftersom Saab95 har en turbo.
     * Skulle någon annan bil (skapar en annan klass som ärver från Car) inte ha några speciella
     * preferenser kring speedFactor kan man använda den som finns i Car och behöver därmed inte skapa en ny.
     */
}
