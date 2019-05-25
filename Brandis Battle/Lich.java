import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lich here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lich extends Collision
{
    int timeElapsed = 0;
    int walkCycle = 0;
    int speed = 4;
    int yMovement;
    String direction = "Right";
    String[] sprite = {"Lich-1.png", "Lich-2.png", "Lich-3.png"};

    public Lich() {
    }

    public void act() 
    {
        animate();
        alterMovement();
        setLocation(getX(), getY() + yMovement);
        timeElapsed += 1;
    }  

    void animate() {
        if (timeElapsed % 11 == 0) {
            setImage(sprite[walkCycle]);
            walkCycle += 1;
            if (walkCycle >= 3) {
                walkCycle = 0;
            }
        }
        
        
    }  
    
    void alterMovement() {
        if (timeElapsed % 20 == 0) {
            yMovement = Greenfoot.getRandomNumber(10) - 5;
        }
        
        if (isAtEdge()) {
            yMovement = -yMovement * 2;
        }
    }
    
}
