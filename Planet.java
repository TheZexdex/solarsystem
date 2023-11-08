import java.util.Random;

public class Planet {

    Random rand = new Random();

    double distance;
    double period;
    double diameter;
    String col;
    String name;
    double angle;

    public Planet(double ds, double pe, double dm, String c, String n)
    {
        distance = ds;
        period = pe;
        diameter = dm;
        col = c;
        name = n;

        angle = rand.nextDouble()*360;
    }

    public void updatePosition()
    {
        UpdatePosition UP = new UpdatePosition(angle, period);
        angle = UP.getNewPosition();
    }
}
