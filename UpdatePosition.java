public class UpdatePosition
{
    double angle;
    double period;
    double speed;

    public UpdatePosition(double a, double pe, double s) //The UpdatePosition class is called by most objects as they update their positions. It calculates a new angle based on...
    {
        angle = a;//... the previous angle
        period = pe;//... the orbital period
        speed = s;//.. and the current simulation speed dictated by the Speed Controller

        angle = angle + (365.25 / period * speed); //since the orbital period is measured in days, it divides the period into 365.25

        if (angle >= 360) //This if statement subtracts 360 degrees from the object once it has completed a full orbit
        {
            while (angle >= 360) //At very high simulation speeds and/or with objects with short periods, they may complete more than one full orbit in a frame. The while loop ensures the angle is returned to between 0 and 360 before moving on
            {
                angle = angle - 360;
            }
        }
        else if (angle < 0) //In the case of objects with retrograde motion (Like Neptune's moon Triton) This else if and while loop peform the same operation as before but for such objects with a negative period
        {
            while (angle < 0)
            {
                angle = angle + 360;
            }
        }
    }
    public double getNewPosition() //Once the UpdatePosition class has been called, this method is called to retun the newly calculated angle
    {
        return(angle);
    }
}
