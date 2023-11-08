import java.util.Random;

public class Moon {

    Random rand = new Random();

    int parent;
    double distance;
    double period;
    double diameter;
    String col;
    String name;
    double angle;

    public Moon(int pa, double ds, double pe, double dm, String c, String n)
    {
        parent = pa;
        distance = ds/2;
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