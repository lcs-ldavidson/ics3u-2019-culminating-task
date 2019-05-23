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
    String direction = "Right";
    String[] sprite = {"Lich-1.png", "Lich-2.png", "Lich-3.png"};

    public Lich() {
    }

    public void act() 
    {
        animate();
        setLocation(getX() + Greenfoot.getRandomNumber(20) - 10, getY() + Greenfoot.getRandomNumber(20) - 10);
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
}
