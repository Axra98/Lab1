import java.awt.*;

public class Car implements Movable{

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    int dir, x, y;
    Point pos = new Point(x, y);

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        if(currentSpeed >= 0 && currentSpeed <= getEnginePower()) {
            return currentSpeed;
        }
        else {
            return 0;
        }
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public void move() {
        if(dir == 0)
            pos.move(x, y+1);
        if(dir == 1)
            pos.move(x+1, y);
        if(dir == 2)
            pos.move(x, y-1);
        if(dir == 3)
            pos.move(x-1, y);
    }

    public void turnLeft() {
        if(dir == 0)
            dir = 3;
        else
            dir = dir-1;
    }

    public void turnRight() {
        if(dir == 3)
            dir = 0;
        else
            dir = dir+1;
    }
}
