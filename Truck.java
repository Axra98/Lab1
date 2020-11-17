import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Truck extends Car{

    private final static double trimFactor = 1.5;
    private boolean up = true;
    private List<Car> cars = new ArrayList<>();

    public Truck() {
        super(2, 300, Color.BLUE, "Truck", new Point2D.Double(0,0));
        stopEngine();
    }

    /**
     *  Checks if the ramp is up
     */

    public void rampUp() {
        up = true;
    }

    public void rampDown() {
        if(getCurrentSpeed()==0)
            up = false;
    }

    public void gas(Double amount) {
        if(up)
            gas(amount);
    }

    public void loadCar(Car car) {
        if(up == false && car.getPos().equals(getPos())) {
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        int last = cars.lastIndexOf(car);
        if(cars.contains(car) && cars.indexOf(car) == last)
            cars.remove(car);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}