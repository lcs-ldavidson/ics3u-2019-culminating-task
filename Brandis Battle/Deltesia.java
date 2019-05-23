import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deltesia extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    Brandis brandis = new Brandis();

    public Deltesia()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 700, 1); 
        prepare();
        Greenfoot.setSpeed(50);

        setPaintOrder(Grass.class, Brandis.class, Platform.class, Lich.class, Ground.class, Tree.class);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ground ground = new Ground();
        addObject(ground,447,678);
        Tree tree = new Tree();
        addObject(tree,183,327);
        Grass grass = new Grass();
        addObject(grass,444,631);

        addObject(brandis,406,583);
        Platform platform = new Platform();
        addObject(platform,290,501);
        Platform platform2 = new Platform();
        addObject(platform2,95,369);
        Platform platform3 = new Platform();
        addObject(platform3,300,238);
        Lich lich = new Lich();
        addObject(lich,759,164);
    }
}
