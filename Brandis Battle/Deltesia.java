import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Deltesia extends World
{

    //create characters
    Brandis brandis = new Brandis();
    Lich lich1 = new Lich();
    
    Ground ground = new Ground();
    int timeElapsed = 0;
    
    //make background music
    GreenfootSound music = new GreenfootSound("retro-music.mp3");

    public Deltesia()
    {    
        
        super(900, 700, 1); 
        prepare();
        //set half speed
        Greenfoot.setSpeed(50);
        //set full volume
        music.setVolume(100);
        
        //specify what order sprites are drawn in
        setPaintOrder(Lightning.class, Grass.class, Rock.class, Brandis.class, Platform.class, Lich.class, Ground.class, Tree.class);
    }
    
    public void act() {
        //play music at the start of the game
        if (timeElapsed == 0) {
            music.playLoop();
        }
        //stop if game is over
        if (lich1.health <= 0 || brandis.health <= 0) {
            music.stop();
        }
        //increase time that has passed.
        timeElapsed++;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        addObject(ground,447,678);
        Tree tree = new Tree();
        addObject(tree,183,327);
        Grass grass = new Grass();
        addObject(grass,444,650);
        
        addObject(brandis,406,583);
        Platform platform = new Platform();
        addObject(platform,330,501);
        Platform platform2 = new Platform();
        addObject(platform2,95,369);
        Platform platform3 = new Platform();
        addObject(platform3,300,238);

        addObject(lich1,759,164);
    }
}
