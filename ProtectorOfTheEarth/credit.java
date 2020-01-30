import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class credit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class credit extends World
{

    /**
     * Constructor for objects of class credit.
     * 
     */
    public credit()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 439, 1);
        tombolKembali kembali = new tombolKembali();
        addObject(kembali,50,400);
        tombolgameasset gameassets = new tombolgameasset();
        addObject(gameassets,870,410);
        
        
    }
}
