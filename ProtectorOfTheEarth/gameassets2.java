import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameassets2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameassets2 extends World
{

    /**
     * Constructor for objects of class gameassets2.
     * 
     */
    public gameassets2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 439, 1); 
    }
    public void act()
    {
        kembali2 kembali = new kembali2();
        addObject(kembali,50,400);
    }
}
