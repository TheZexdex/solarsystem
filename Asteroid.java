import java.util.Random;

public class Asteroid {

    Random rand = new Random();

    double distance;
    double period;
    double angle;
    double speed;

    public Asteroid() //The asteroid class does not take any external information, everything about them is preset or randomly generated
    {
        double factor = rand.nextDouble(); //A 'factor' is generated so that the period scales appropriately with the distance

        distance = 270 + (factor*40); //The asteroid is given an orbit between 270 and 310 pixels (between Mars and Jupiter)
        period = 1200 + (factor*800); //The asteroid is given an orbital period between 1200 and 2000 days. Since both are calculated with the same randomly generated 'factor', they both scale in sync

        angle = rand.nextDouble()*360; //Like most objects, each asteroid is assigned a starting angle at random
    }

    public void updatePosition(double s) //This method instatiates an UpdatePosition class, and calculates it's next position based on it's current angle, orbital period, and the simulation speed. It then returns its next angle
    {
        speed = s;
        UpdatePosition UP = new UpdatePosition(angle, period, speed);
        angle = UP.getNewPosition();
    }
}
