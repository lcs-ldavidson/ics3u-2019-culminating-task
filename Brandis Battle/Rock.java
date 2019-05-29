import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Collision
{
    int xMovement;
    int yMovement;
    int timeElapsed = 0;
    
    public Rock(String direction) {
        if (direction == "Left") {
         xMovement = -15;  
        } else if (direction == "Right") {
            xMovement = 15;
        }
        
    }
    
    public void act() 
    {
        if (timeElapsed == 0) {
            yMovement = -5 + ((Deltesia)getWorld()).brandis.yMovement;
        }
        setLocation(getX() + xMovement, getY() + yMovement);
        yMovement++;
        turn(xMovement);
        if (getY() == 699 || touch(Lightning.class)) {
            ((Deltesia)getWorld()).brandis.canThrow = true;
            getWorld().removeObject(this);
        }
        timeElapsed++;
    }    
}
