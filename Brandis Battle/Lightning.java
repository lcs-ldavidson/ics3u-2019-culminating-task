import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lightning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lightning extends Collision
{
    boolean isShielding = true;
    int timeElapsed = 0;

    public void act() 
    {
        if (isShielding) {
            setLocation(((Deltesia)getWorld()).lich.getX(), ((Deltesia)getWorld()).lich.getX());
        } else {
            getImage().scale(50, 50);
            setLocation(getX() - 3, getY());
        }
        if (timeElapsed >= 50) {
            isShielding = false;
        }
        timeElapsed++;
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }    
}
