public class Moon {

    int parent;
    double distance;
    double period;
    double diameter;
    String col;
    String name;

    double angle = 0;

    public Moon(int pa, double ds, double pe, double dm, String c, String n)
    {
        parent = pa;
        distance = ds/2;
        period = pe;
        diameter = dm;
        col = c;
        name = n;
    }

    public void updatePosition()
    {
        angle = angle + (365.25/period);
        if(angle >= 360)
        {
            angle = angle - 360;
        }
    }
}
