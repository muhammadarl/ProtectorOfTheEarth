import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
   private GreenfootImage[] images= new GreenfootImage[8];
    private int currentImage;
    public Explosion()
    {
        images[0] = new GreenfootImage("e1.png");
        images[1] = new GreenfootImage("e2.png");
        images[2] = new GreenfootImage("e3.png");
        images[3] = new GreenfootImage("e4.png");
        images[4] = new GreenfootImage("e5.png");
        images[5] = new GreenfootImage("e6.png");
        images[6] = new GreenfootImage("e7.png");
        images[7] = new GreenfootImage("e8.png");
    }
    public void act()
    {
        ExplosionAnimation();
        if(currentImage == 7)
        {
            getWorld().removeObject(this);
        }
    }
    private void ExplosionAnimation()
    {
        if(currentImage >= 7)
        currentImage = 7;
        else
        currentImage++;
        //endif
        setImage(images[currentImage]);
    }
}
