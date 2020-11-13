import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTest {

    private Volvo240 volvo = new Volvo240();
    private Saab95 saab = new Saab95();
    private Car volvo240 = new Volvo240();

    @Test
    public void testMove(){
        volvo.startEngine();

        volvo.direction = Car.Direction.UP;
        volvo.move();
        assertTrue(volvo.getPos().getX() == 0);
        assertTrue(volvo.getPos().getY() != 0);
        volvo.turnRight();
        volvo.move();
        assertTrue(volvo.getPos().getX() != 0);
        assertTrue(volvo.getPos().getY() != 0);
        volvo.turnRight();
        volvo.move();
        assertTrue(volvo.getPos().getX() != 0);
        assertTrue(volvo.getPos().getY() == 0);
        volvo.turnRight();
        volvo.move();
        assertTrue(volvo.getPos().getX() == 0);
        assertTrue(volvo.getPos().getY() == 0);



    }

    @Test
    public void testTurnLeft(){
        saab.direction = Car.Direction.UP;
        saab.turnLeft();

        assertTrue(saab.getDirection() == Car.Direction.LEFT);
        saab.turnLeft();
        assertTrue(saab.getDirection() == Car.Direction.DOWN);
        saab.turnLeft();
        assertTrue(saab.getDirection() == Car.Direction.RIGHT);
        saab.turnLeft();
        assertTrue(saab.getDirection() == Car.Direction.UP);
    }

    @Test
    public void testTurnRight(){
        saab.direction = Car.Direction.UP;
        saab.turnRight();

        assertTrue(saab.getDirection() == Car.Direction.RIGHT);
        saab.turnRight();
        assertTrue(saab.getDirection() == Car.Direction.DOWN);
        saab.turnRight();
        assertTrue(saab.getDirection() == Car.Direction.LEFT);
        saab.turnRight();
        assertTrue(saab.getDirection() == Car.Direction.UP);
    }

    @Test
    public void testGas(){
        volvo.startEngine();
        saab.startEngine();

        Double inVolvo = volvo.getCurrentSpeed();
        Double inSaab = saab.getCurrentSpeed();

        volvo.gas(0.5);
        saab.gas(0.5);

        assertTrue(volvo.getCurrentSpeed() > inVolvo);
        assertTrue(saab.getCurrentSpeed() > inSaab);
    }

    @Test
    public void testBrake(){
        volvo.startEngine();
        saab.startEngine();
        Double inVolvo = volvo.getCurrentSpeed();
        Double inSaab = saab.getCurrentSpeed();
        volvo.brake(0.5);
        saab.brake(0.5);

        assertTrue(volvo.getCurrentSpeed() < inVolvo);
        assertTrue(saab.getCurrentSpeed() < inSaab);
    }

    @Test
    public void testNrDoors(){
        assertTrue(saab.getNrDoors() == 2);
        assertTrue(volvo.getNrDoors() == 4);

    }

    @Test
    public void testEnginePower(){
        assertTrue(saab.getEnginePower() == 125);
        assertTrue(volvo.getEnginePower() == 100);
    }

    @Test
    public void testColor(){

        assertTrue(saab.getColor().equals(Color.CYAN));
        assertTrue(volvo.getColor().equals(Color.GRAY));

        volvo.setColor(Color.green);
        saab.setColor(Color.yellow);
        assertTrue(saab.getColor().equals(Color.YELLOW));
        assertTrue(volvo.getColor().equals(Color.green));
    }

    @Test
    public void testStartEngine(){
        volvo.startEngine();
        saab.startEngine();

        assertTrue(volvo.getCurrentSpeed() == 0.1);
        assertTrue(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testStopEngine(){
        volvo.stopEngine();
        saab.stopEngine();

        assertTrue(volvo.getCurrentSpeed() == 0.0);
        assertTrue(saab.getCurrentSpeed() == 0.0);
    }

    @Test
    public void testSpeedFactor(){
        saab.setTurboOff();
        assertTrue(saab.speedFactor() == 1.25);
        assertTrue(volvo240.speedFactor() == 1.25);
        saab.setTurboOn();
        assertTrue(saab.speedFactor() == 1.625);

    }

    @Test
    public void testGetPos(){
        Point2D.Double point = new Point2D.Double(0,0);
        assertTrue(saab.getPos().equals(point));
    }

    @Test
    public void testTurboOn(){
        saab.setTurboOn();
        assertTrue(saab.speedFactor() == 1.625);

    }

    @Test
    public void testTurboOff(){
        saab.setTurboOff();
        assertTrue(saab.speedFactor() == 1.25);
    }
    
}
