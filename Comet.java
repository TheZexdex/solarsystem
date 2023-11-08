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

    public Comet(double ds, double pe, double dm, String c, String n, double e, int dr)
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

    public void updatePosition()
    {
        UpdatePosition UP = new UpdatePosition(angle, period);
        angle = UP.getNewPosition();
    }

}