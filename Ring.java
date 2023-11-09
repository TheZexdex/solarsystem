public class Ring {
    
    int parent;
    double internallDiameter;
    double externalDiameter;
    String col;
    String name;

    public Ring(int pa, double idm, double edm, String c, String n) //The ring class takes the id of it's parent planet, the internal and external diameters of the rings, their colour, and their name
    {
        parent = pa;
        internallDiameter = idm;
        externalDiameter = edm;
        col = c;
        name = n;
    }
}
