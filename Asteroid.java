import java.util.Random;

public class Asteroid {

    Random rand = new Random();

    double distance;
    double period;
    double angle;

    public Asteroid()
    {
        double factor = rand.nextDouble();

        distance = 270 + (factor*40);
        period = 1200 + (factor*800);

        angle = rand.nextDouble()*360;
    }

    public void updatePosition()
    {
        UpdatePosition UP = new UpdatePosition(angle, period);
        angle = UP.getNewPosition();
    }
}
