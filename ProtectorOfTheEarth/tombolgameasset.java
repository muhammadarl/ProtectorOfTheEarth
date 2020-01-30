import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tombolgameasset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tombolgameasset extends Actor
{
    /**
     * Act - do whatever the tombolgameasset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage image = new GreenfootImage("gameassets.png");
        image.scale(100,50);
        setImage(image);
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new gameassets());
        }
    }    
}
