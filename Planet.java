import java.util.Random;

public class Planet {

    Random rand = new Random();

    double distance;
    double period;
    double diameter;
    String col;
    String name;
    double angle;
    double speed;

    public Planet(double ds, double pe, double dm, String c, String n) //The planet class takes the distance, orbital period (measured in days), diameter, colour and name. It generates a starting angle at random
    {
        distance = ds;
        period = pe;
        diameter = dm;
        col = c;
        name = n;

        angle = rand.nextDouble()*360;
    }

    public void updatePosition(double s) //This method instatiates an UpdatePosition class, and calculates it's next position based on it's current angle, orbital period, and the simulation speed. It then returns its next angle
    {
        speed = s;
        UpdatePosition UP = new UpdatePosition(angle, period, speed);
        angle = UP.getNewPosition();
    }
}
