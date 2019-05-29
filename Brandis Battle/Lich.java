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
    boolean canTakeDamage = true;
    int health = 100;
    String direction = "Right";
    String[] sprite = {"Lich-1.png", "Lich-2.png", "Lich-3.png"};

    public Lich() {
    }

    public void act() 
    {
        animate();
        alterMovement();
        getWorld().showText("LICH HEALTH: " + health, 750, 30);
        setLocation(getX(), getY() + yMovement);
        getHit();
        createShield();
        die();
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
            yMovement = Greenfoot.getRandomNumber(20) - 10;
        }
        
        if (getY() < ((Deltesia)getWorld()).brandis.getY()) {
            yMovement += Greenfoot.getRandomNumber(2);
        } else {
            yMovement -= Greenfoot.getRandomNumber(2);
        }
        
        if (isAtEdge()) {
            yMovement = -yMovement * 2;
        }
    }
    
    void getHit() {
        if (canTakeDamage && touch(Rock.class)) {
            setImage("hurt.png");
            ((Deltesia)getWorld()).brandis.canThrow = true;
            getWorld().removeObject(getOneTouchedObject(Rock.class));
            health -= 5;
        }
    }
    
    void createShield() {
        if (timeElapsed % 150 == 0) {
            getWorld().addObject(new Lightning(), getX(), getY());
        }
    }
    
    void die() {
        if (health <= 0) {
            getWorld().showText("The Lich has been defeated! You win!", 450, 50);
            Greenfoot.stop();
        }
    }
}
