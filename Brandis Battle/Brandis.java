import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brandis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brandis extends Collision
{
    //create variables
    int timeElapsed = 0;
    int walkCycle = 0;
    int speed = 4;
    int xMovement;
    int yMovement;
    int gravity;
    boolean isOnPlatform;
    Deltesia delta = (Deltesia)getWorld();
    boolean isOnGround;
    boolean canThrow;
    int health = 100;
    GreenfootSound jumpSound = new GreenfootSound("jump.wav");

    String direction = "Right";
    //arrays
    String[] sprite = {"Brandis-0-" + direction + ".png", "Brandis-1-" + direction + ".png", "Brandis-2-" + direction + ".png"};
    String[] jumpSprite = {"Brandis-Up-" + direction + ".png", "Brandis-Down-" + direction + ".png"};

    public Brandis() {
        gravity = 1;
        canThrow = true;
        jumpSound.setVolume(90);
    }

    public void act() 
    {
        changeImages();

        controlMovement();
        if (isOnPlatform == true) {
            enforceFriction();
        }
        if (Greenfoot.isKeyDown("up") && isOnPlatform) {
            jumpSound.play();
            jump(20);
        }
        if (Greenfoot.isKeyDown("space")) {
            throwRock();
        }
        getWorld().showText("BRANDIS HEALTH: " + health, 150, 30);
        checkForPlatform();
        enforceGravity();
        getHit();
        getHitByLich();
        die();
        setLocation(getX() + xMovement, getY() + yMovement);
        timeElapsed += 1;
    }  

    void animate() {
        if (timeElapsed % 6 == 0 && isOnPlatform) {
            setImage(sprite[walkCycle]);
            walkCycle += 1;
            if (walkCycle >= 3) {
                walkCycle = 0;
            }
        } else if (!isOnPlatform && yMovement <= 0) {
            setImage(jumpSprite[0]);
        } else if (!isOnPlatform && yMovement > 0) {
            setImage(jumpSprite[1]);
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
            if (isOnPlatform) {
                setImage(sprite[0]);
            } else {
                animate();
            }
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
        setLocation(getX(), getY() - 10);
        yMovement -= jumpStrength;
    }

    void enforceGravity() {
        if (isOnPlatform == false) {
            yMovement += gravity;
        } else {
            yMovement = 0;
        }
    }

    void checkForPlatform() {

        if (isTouching(Platform.class)) {
            if (getY() <= getOneIntersectingObject(Platform.class).getY() - getImage().getHeight()/2 && yMovement >= 0){
                isOnPlatform = true;
                yMovement = 0;
            } else {
                isOnPlatform = false;
            }
        } else {
            isOnPlatform = false;
        }

        if (isTouching(Platform.class) == false) {
            if (isTouching(Ground.class)) {
                isOnPlatform = true;
            } else {
                isOnPlatform = false;
            }
        }
    }

    void changeImages() {
        for (int i = 0; i < 3; i++) {
            sprite[i] = "Brandis-" + i + "-" + direction + ".png";
        }
        jumpSprite[0] = "Brandis-Up-" + direction + ".png";
        jumpSprite[1] = "Brandis-Down-" + direction + ".png";
    }

    void throwRock() {
        if (canThrow == true) {
            getWorld().addObject(new Rock(direction), getX(), getY());
        }
        canThrow = false;
    }

    void getHit() {
        if (touch(Lightning.class)) {
            health -= 20;
            getWorld().removeObject(getOneTouchedObject(Lightning.class));
            xMovement -= 30;
        }
    }

    void getHitByLich() {
        if (touch(Lich.class)) {
            health -= 20;
            xMovement -= 60;
        }
    }

    void die() {
        if (health <= 0) {
            getWorld().showText("The Lich has defeated you! You lose!", 450, 50);
            getWorld().showText("BRANDIS HEALTH: " + health, 150, 30);
            Greenfoot.stop();
        }
    }

}
