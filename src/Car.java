import javax.swing.text.Position;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Car implements Movable{

    protected int nrDoors; // Number of doors on the car
    protected double enginePower, currentSpeed, x,y; // Engine power of the car The current speed of the car, riktningarna i planet för move.
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected Direction direction = Direction.UP;
    protected Point.Double position = new Point.Double(); //default x=0, y=0

    protected int getNrDoors(){
        return nrDoors;
    }

    /**
     * Returnerar antalet dörrar.
     */

    protected double getEnginePower(){
        return enginePower;
    }

    /**
     * Returnerar motoreffekten
     */

    protected double getCurrentSpeed(){
        return currentSpeed;
    }
    /** Eftersom incrementspeed och decrementspeed ger att man inte kan överstiga
     * enginepower respektive understiga 0
     * Returnerar currentSpeed
     */

    protected Color getColor(){
        return color;
    }

    /**
     * Returnerar färgen på en bil
     * @param clr
     */

    protected void setColor(Color clr){
        color = clr;
    }

    /**
     * Används för att sätta färgen på en bil
     */

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Startar motorn
     */

    protected void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Stänger av motorn
     * @return
     */

    protected abstract double speedFactor();
    /**
     * En speedFactor som anvädns i incrementSpeed och decrementSpeed
     * @param amount
     */

    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    /**Eftersom min funktionen väljer det som är minst av funktionen och enginpower
     * kommer currentSpeed aldrig vara större än enginePower.
     */

    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0.0);
    }
    /**Eftersom max funktionen väljer det som är störst av funktionen och 0.0
     * kommer currentSpeed aldrig vara mindre än 0.0.
     */

    protected void gas(double amount){
        if(amount>=0.0 && amount <= 1.0)
            incrementSpeed(amount);
    }
    /**if satsen accepterar bara värden mellan 0 och 1. Detta gör att gas aldrig kommer
    * kunna sänka farten.
    */

    // TODO fix this method according to lab pm
    protected void brake(double amount){
        if(amount>=0.0 && amount <= 1.0)
            decrementSpeed(amount);
    }
    /**if-satsen accepterar bara värden mellan 0 och 1. Detta gör att break aldrig kommer
    * kunna höja farten.
    */

    protected enum Direction{
        RIGHT,
        LEFT,
        UP,
        DOWN,
    }

    public void move() {
        switch (direction){
            case UP: position.setLocation(x, y += currentSpeed); break;
            case RIGHT: position.setLocation(x += currentSpeed, y); break;
            case DOWN: position.setLocation(x, y -= currentSpeed); break;
            case LEFT: position.setLocation(x -= currentSpeed, y); break;
        }
    }
     /**Tanken är att man ska ändra x/y koordninaterna efter riktning och hastighet
     eftersom vi gör om Point till en double använder vi setLocation istället för move för
     att byta lokalen.
     */

    public void turnLeft() {
        switch (direction){
            case UP: direction = Direction.LEFT; break;
            case LEFT: direction = Direction.DOWN; break;
            case DOWN: direction = Direction.RIGHT; break;
            case RIGHT: direction = Direction.UP; break;
        }
    }
    /** Här ändras riktningen mha switch statement. Så vid turnLeft så ändras riktningen ett steg till vänster
     * så turnLeft: UP->LEFT, LEFT->DOWN
     */

   public void turnRight() {
        switch (direction){
            case UP: direction = Direction.RIGHT; break;
            case RIGHT: direction = Direction.DOWN; break;
            case DOWN: direction = Direction.LEFT; break;
            case LEFT: direction = Direction.UP; break;
        }
    }
    /** Samma princip som i turnLeft fast åt motsatt håll.
     *
     */

    protected Point2D getPos(){
       return position;
    }

    protected Direction getDirection(){
       return direction;
    }
}
