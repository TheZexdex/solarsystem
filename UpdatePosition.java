public class UpdatePosition
{
    double angle;
    double period;

    public UpdatePosition(double a, double pe)
    {
        angle = a;
        period = pe;

        angle = angle + (365.25 / period / 10);

        if (angle >= 360)
        {
            while (angle >= 360)
            {
                angle = angle - 360;
            }
        }
        else if (angle < 0)
        {
            while (angle < 0)
            {
                angle = angle + 360;
            }
        }
    }
    public double getNewPosition()
    {
        return(angle);
    }
}
