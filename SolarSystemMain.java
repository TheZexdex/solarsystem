public class SolarSystemMain {
    public static void main(String[] args)
    {
        int endProgram = 0;
        int earthPos  = 0;

        SolarSystem SS = new SolarSystem(2000, 1000);
        while (endProgram == 0)
        {
            SS.drawSolarObject(0, 0, 100, "YELLOW");
            SS.drawSolarObject(100, earthPos, 10, "BLUE");
            SS.finishedDrawing();
            if (earthPos == 359)
            {
                earthPos = 0;
            }
            else
            {
                earthPos = earthPos + 1;
            }
        }

    }
}
