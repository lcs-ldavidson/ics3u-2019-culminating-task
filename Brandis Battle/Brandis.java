import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brandis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brandis extends Collision
{
    int timeElapsed = 0;
    int walkCycle = 0;
    int speed = 4;
    int xMovement;
    int yMovement;
    int gravity;
    
    String direction = "Right";
    String[] sprite = {"Brandis-0-" + direction + ".png", "Brandis-1-" + direction + ".png", "Brandis-2-" + direction + ".png"};

    public Brandis() {
        gravity = 1;
        
    }

    public void act() 
    {
        for (int i = 0; i < 3; i++) {
            sprite[i] = "Brandis-" + i + "-" + direction + ".png";
        }
        controlMovement();
        enforceFriction();
        if (Greenfoot.isKeyDown("up")) {
            jump(14);
        }
        enforceGravity();
        setLocation(getX() + xMovement, getY() + yMovement);
        timeElapsed += 1;
    }  

    void animate() {
        if (timeElapsed % 7 == 0) {
            setImage(sprite[walkCycle]);
            walkCycle += 1;
            if (walkCycle >= 3) {
                walkCycle = 0;
            }
        }
    }

    void controlMovement() {
        if (Greenfoot.isKeyDown("right")) {
            changeSpeed(2, 5);
            direction = "Right";
            animate();
        } else if (Greenfoot.isKeyDown("left")) {
            changeSpeed(-2, -5);
            direction = "Left";
            animate();
        } else {
            setImage(sprite[0]);
        }
    }

    void changeSpeed(int acceleration, int maxSpeed) {
        if (maxSpeed > 0) {
            if (xMovement <= maxSpeed) {
                xMovement += acceleration;
            }
        }
        if (maxSpeed < 0) {
            if (xMovement >= maxSpeed) {
                xMovement += acceleration;
            }
        }
    }

    void enforceFriction() {
        if (xMovement > 0) {
            xMovement -= 1;
        }
        if (xMovement < 0) {
            xMovement += 1;
        }
    }

    void jump(int jumpStrength) {
        yMovement -= jumpStrength;
    }
    
    void enforceGravity() {
        yMovement += gravity;
    }
}
