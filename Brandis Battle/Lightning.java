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
    int walkCycle = 0;
    String[] sprite = {"Shield-1.png", "Shield-2.png", "Shield-3.png"};

    public void act() 
    {
        if (isShielding) {
            setLocation(((Deltesia)getWorld()).lich1.getX(), ((Deltesia)getWorld()).lich1.getY());
        } else {
            getImage().scale(75, 75);
            setLocation(getX() - 5, getY());
        }
        if (timeElapsed >= 50) {
            isShielding = false;
        }
        timeElapsed++;
        if (getX() <= 1) {
            getWorld().removeObject(this);
        }
        
        if (timeElapsed % 6 == 0) {
            setImage(sprite[walkCycle]);
            if (!isShielding) {
                getImage().scale(75, 75);
            }
            walkCycle += 1;
            if (walkCycle >= 3) {
                walkCycle = 0;
            }
        }
        turn(Greenfoot.getRandomNumber(10));
    }    
}
