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
         xMovement = -5;  
        } else if (direction == "Right") {
            xMovement = 5;
        }
        yMovement = 15;
    }
    
    public void act() 
    {
        setLocation(getX() + xMovement, getY() + yMovement);
        yMovement--;
        
        if (isTouching(Ground.class)) {
            getWorld().removeObject(this);
        }
    }    
}
