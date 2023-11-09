import java.util.*;

public class SolarSystemMain {

    int endprogram = 0; //Boolean integer that keeps the simulation running so long as it is 0

    SolarSystem SS = new SolarSystem(1500, 800); //Instatiates the SolarSystem class
    SpeedController SC = new SpeedController(); //Instantiates the SpeedController class, a seperate window which allows the user to control the speed of the simulation
    
    Sun sol = new Sun(50, "WHITE", "Sol"); //Instatiates a Sun class; only 1 is needed and few args provided as it is static
    ArrayList<Planet> planets = new ArrayList<Planet>(); //Declares an arraylist of Planet class, filled out in main method
    ArrayList<Ring> rings = new ArrayList<Ring>();
    ArrayList<Moon> moons = new ArrayList<Moon>(); //Declares an arraylist of Moon class, filled out in main method
    ArrayList<Asteroid> asteroids = new ArrayList<Asteroid>(); //Declares an arraylist of Asteroid class, filled out in main method
    ArrayList<Comet> comets = new ArrayList<Comet>(); //); //Declares an arraylist of Comet class, filled out in main method

    public SolarSystemMain() //The main class ran when instantiated by the Run class. The distances (ds) and diameters (dm) are not to scale, but the periods (pe) are accurate and measured in days
    {
        planets.add(new Planet(100,115.88,3,"ORANGE","Mercury")); //Adds Mercury

        planets.add(new Planet(150,224.7,9,"YELLOW","Venus")); //Adds Venus

        planets.add(new Planet(200,365.25,10,"BLUE","Earth")); //Adds Earth and the Moon
        moons.add(new Moon(2, 15, 27.32, 3, "WHITE", "Luna"));

        planets.add(new Planet(250,779.94,5,"RED","Mars")); //Adds Mars and it's moons
        moons.add(new Moon(3, 10, 0.32, 1, "WHITE", "Phobos"));
        moons.add(new Moon(3, 15, 1.26, 1, "WHITE", "Deimos"));

        for (int i = 0; i < 100; i++) //This for loop will generate 100 asteroids at random and place them between the orbits of Mars and Jupiter
        {
            asteroids.add(new Asteroid());
        }

        planets.add(new Planet(350,4332.59,25,"PINK","Jupiter")); //Adds Jupiter and it's major moons
        moons.add(new Moon(4, 30, 1.77, 2, "WHITE", "Io"));
        moons.add(new Moon(4, 35, 3.55, 2, "WHITE", "Europa"));
        moons.add(new Moon(4, 40, 7.15, 3, "WHITE", "Ganymede"));
        moons.add(new Moon(4, 45, 16.69, 3, "WHITE", "Callisto"));

        planets.add(new Planet(450,10755.7,20,"YELLOW","Saturn")); //Adds Saturn, it's rings, and it's major moons
        rings.add(new Ring(5, 25, 30, "WHITE", "Saturn's Rings"));
        moons.add(new Moon(5, 35, 0.94, 2, "WHITE", "Mimas"));
        moons.add(new Moon(5, 40, 1.37, 2, "WHITE", "Enceladus"));
        moons.add(new Moon(5, 45, 1.89, 2, "WHITE", "Tethys"));
        moons.add(new Moon(5, 50, 2.74, 2, "WHITE", "Dione"));
        moons.add(new Moon(5, 55, 4.52, 2, "WHITE", "Rhea"));
        moons.add(new Moon(5, 60, 15.95, 3, "WHITE", "Titan"));
        moons.add(new Moon(5, 65, 79.33, 2, "WHITE", "Iapetus"));

        planets.add(new Planet(550,30688.5,15,"CYAN","Uranus")); //Adds Uranus and it's major moons
        moons.add(new Moon(6, 20, 1.41, 2, "WHITE", "Miranda"));
        moons.add(new Moon(6, 25, 2.52, 2, "WHITE", "Ariel"));
        moons.add(new Moon(6, 30, 4.14, 2, "WHITE", "Umbriel"));
        moons.add(new Moon(6, 35, 8.71, 2, "WHITE", "Titania"));
        moons.add(new Moon(6, 40, 13.46, 2, "WHITE", "Oberon"));

        planets.add(new Planet(650,60195,15,"BLUE","Neptune")); //Adds Neptune and it's major moon (notice how Triton's period is negative, since Triton has a retrograde orbit)
        moons.add(new Moon(7, 20, -5.88, 2, "WHITE", "Triton"));

        comets.add(new Comet(525, 27394, 3, "PINK", "Halley's Comet", 0.6, 3)); //Adds Halley's Comet, a famous comet that completes an orbit roughly every 75 years. Its direction integer directs it to swing westward of the sun

        simulate(); //With everything now added, the method to begin simulating movements is called
    }

    public void simulate() //This method is called once everything has been added, to begin simulating the movements
    {
        while (endprogram == 0) //This loop keeps the simulation running indefinitely. Each loop represents one frame of the simulation
        {

            SS.drawSolarObject(0, 0, sol.diameter, sol.col); //This draws the sun in the centre. Nothing about how it is drawn changes as the sun is static and unchanging in the simulation

            for (int i = 0; i < planets.size(); i++) //This for loop updates the positions of all the planets, based on the simulation speed from the speedcontroller
            {
                planets.get(i).updatePosition(SC.getSpeed()); //Ideally it would also draw the planets within this for loop, but the rings need to be drawn first
            }
            for (int i = 0; i < rings.size(); i++) //This for loop places any rings of the planets
            {
                int planetID = rings.get(i).parent;
                SS.drawSolarObject(planets.get(planetID).distance, planets.get(planetID).angle, rings.get(i).externalDiameter, rings.get(i).col); //it starts by placing a circle of the ring's colour extending to the furthest diameter of the ring...
                SS.drawSolarObject(planets.get(planetID).distance, planets.get(planetID).angle, rings.get(i).internallDiameter, "BLACK"); //...before placing a black circle extending to the innermost diameter, to create the illusion of a ring
            }
            for (int i = 0; i < planets.size(); i++) //This for loop once again loops through the planets, this time actually placing them, once again augmented by the speed from the speedcontroller
            {
                SS.drawSolarObject(planets.get(i).distance, planets.get(i).angle, planets.get(i).diameter, planets.get(i).col);
            }
            for (int i = 0; i < moons.size(); i++) //This for loop updates the positions of the moons and then paints them in their new position
            {
                moons.get(i).updatePosition(SC.getSpeed());
                int planetID = moons.get(i).parent;
                SS.drawSolarObjectAbout(moons.get(i).distance, moons.get(i).angle, moons.get(i).diameter, moons.get(i).col, planets.get(planetID).distance, planets.get(planetID).angle);
            }
            for (int i = 0; i < asteroids.size(); i++) //This for loop updates the positions of the asteroids and then paints them in their new position
            {
                asteroids.get(i).updatePosition(SC.getSpeed());
                SS.drawSolarObject(asteroids.get(i).distance, asteroids.get(i).angle, 2, "GRAY");
            }
            for (int i = 0; i < comets.size(); i++) //This for loop updates the positions of any comets and then paints them in their new position
            {
                comets.get(i).updatePosition(SC.getSpeed());
                SS.drawCometObject(comets.get(i).distance, comets.get(i).angle, comets.get(i).diameter, comets.get(i).col, comets.get(i).eccentricity, comets.get(i).direction);
            }
            SS.finishedDrawing(); //With everything in place, the finishDrawing method confirms as such to the SolarSystem class, and the while loop repeats...
        }
    }
}
