import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameassets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameassets extends World
{

    /**
     * Constructor for objects of class gameassets.
     * 
     */
    public gameassets()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 439, 1);
    }
    public void act()
    {
        tombolkembali1 kembali1 = new tombolkembali1();
        addObject(kembali1,50,400);
        next lanjut = new next();
        addObject(lanjut,900,400);
    }
}
