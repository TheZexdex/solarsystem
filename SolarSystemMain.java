import java.util.*;

public class SolarSystemMain {

    int endprogram = 0;

    SolarSystem SS = new SolarSystem(1500, 800);
    
    Sun sol = new Sun(50, "WHITE", "Sol");
    ArrayList<Planet> planets = new ArrayList<Planet>();
    ArrayList<Moon> moons = new ArrayList<Moon>();
    ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>();
    Comet halley = new Comet(525, 27394, 3, "PINK", "Halley's Comet", 0.9, 3);

    public SolarSystemMain()
    {
        planets.add(new Planet(100,115.88,3,"ORANGE","Mercury"));

        planets.add(new Planet(150,224.7,9,"YELLOW","Venus"));

        planets.add(new Planet(200,365.25,10,"BLUE","Earth"));
        moons.add(new Moon(2, 20, 27.32, 3, "WHITE", "Luna"));

        planets.add(new Planet(250,779.94,5,"RED","Mars"));
        moons.add(new Moon(3, 10, 0.32, 1, "WHITE", "Phobos"));
        moons.add(new Moon(3, 15, 1.26, 1, "WHITE", "Deimos"));

        for (int i = 0; i < 100; i++)
        {
            asteroids.add(new Asteroid());
        }

        planets.add(new Planet(350,4332.59,25,"PINK","Jupiter"));
        moons.add(new Moon(4, 35, 1.77, 2, "WHITE", "Io"));
        moons.add(new Moon(4, 45, 3.55, 2, "WHITE", "Europa"));
        moons.add(new Moon(4, 55, 7.15, 3, "WHITE", "Ganymede"));
        moons.add(new Moon(4, 65, 16.69, 3, "WHITE", "Callisto"));

        planets.add(new Planet(450,10755.7,20,"YELLOW","Saturn"));
        moons.add(new Moon(5, 30, 0.94, 2, "WHITE", "Mimas"));
        moons.add(new Moon(5, 40, 1.37, 2, "WHITE", "Enceladus"));
        moons.add(new Moon(5, 50, 1.89, 2, "WHITE", "Tethys"));
        moons.add(new Moon(5, 60, 2.74, 2, "WHITE", "Dione"));
        moons.add(new Moon(5, 70, 4.52, 2, "WHITE", "Rhea"));
        moons.add(new Moon(5, 80, 15.95, 3, "WHITE", "Titan"));
        moons.add(new Moon(5, 90, 79.33, 2, "WHITE", "Iapetus"));

        planets.add(new Planet(550,30688.5,15,"CYAN","Uranus"));
        moons.add(new Moon(6, 25, 1.41, 2, "WHITE", "Miranda"));
        moons.add(new Moon(6, 35, 2.52, 2, "WHITE", "Ariel"));
        moons.add(new Moon(6, 45, 4.14, 2, "WHITE", "Umbriel"));
        moons.add(new Moon(6, 55, 8.71, 2, "WHITE", "Titania"));
        moons.add(new Moon(6, 65, 13.46, 2, "WHITE", "Oberon"));

        planets.add(new Planet(650,60195,15,"BLUE","Neptune"));
        moons.add(new Moon(7, 25, -5.88, 2, "WHITE", "Triton"));

        simulate();
    }

    public void simulate()
    {
        while (endprogram == 0)
        {

            SS.drawSolarObject(0, 0, sol.diameter, sol.col);

            for (int i = 0; i < planets.size(); i++)
            {
                planets.get(i).updatePosition();
                SS.drawSolarObject(planets.get(i).distance, planets.get(i).angle, planets.get(i).diameter, planets.get(i).col);
            }
            for (int i = 0; i < moons.size(); i++)
            {
                moons.get(i).updatePosition();
                int planetID = moons.get(i).parent;
                SS.drawSolarObjectAbout(moons.get(i).distance, moons.get(i).angle, moons.get(i).diameter, moons.get(i).col, planets.get(planetID).distance, planets.get(planetID).angle);
            }
            for (int i = 0; i < asteroids.size(); i++)
            {
                asteroids.get(i).updatePosition();
                SS.drawSolarObject(asteroids.get(i).distance, asteroids.get(i).angle, 2, "GRAY");
            }

            halley.updatePosition();
            SS.drawCometObject(halley.distance, halley.angle, halley.diameter, halley.col, halley.eccentricity, halley.direction);
            SS.finishedDrawing();
        }
    }
}
