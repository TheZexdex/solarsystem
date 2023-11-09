import java.util.Random;

public class Comet {

    Random rand = new Random();

    double distance;
    double period;
    double diameter;
    String col;
    String name;
    double eccentricity;
    int direction;
    double angle;
    double speed;

    public Comet(double ds, double pe, double dm, String c, String n, double e, int dr) //The comet class takes distance, orbital period (measured in days), diameter, colour, name, eccentricity, and directional ID. It generates a starting angle at random
    {
        distance = ds;
        period = pe;
        diameter = dm;
        col = c;
        name = n;
        eccentricity = e;
        direction = dr;

        angle = rand.nextDouble()*360;
    }

    public void updatePosition(double s) //This method instatiates an UpdatePosition class, and calculates it's next position based on it's current angle, orbital period, and the simulation speed. It then returns its next angle
    {
        speed = s;
        UpdatePosition UP = new UpdatePosition(angle, period, speed);
        angle = UP.getNewPosition();
    }

}