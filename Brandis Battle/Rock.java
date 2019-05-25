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
    
    public Rock(String direction) {
        if (direction == "Left") {
         xMovement = -15;  
        } else if (direction == "Right") {
            xMovement = 15;
        }
        yMovement = -10;
    }
    
    public void act() 
    {
        setLocation(getX() + xMovement, getY() + yMovement);
        yMovement++;
        turn(xMovement);
        if (getY() == 699) {
            ((Deltesia)getWorld()).brandis.canThrow = true;
            getWorld().removeObject(this);
        }
    }    
}
