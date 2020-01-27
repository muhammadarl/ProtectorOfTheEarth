 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuAwal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuAwal extends World
{
    public static final GreenfootSound start = new GreenfootSound("start.wav");
    /**
     * Constructor for objects of class MenuAwal.
     * 
     */
    public MenuAwal()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 439, 1);
        start();
        prepare();
    }
    
    private void prepare()
    {
        tombolPlay play = new tombolPlay();
        addObject(play,320,370);
        tombolPetunjuk petunjuk = new tombolPetunjuk();
        addObject(petunjuk,(int) getWidth()/2,370);
        tombolKeluar keluar = new tombolKeluar();
        addObject(keluar,630,370);
        info information = new info();
        addObject(information,930,20);
        

        
    }
    private void start()
    {
        start.setVolume(90);
    }   
}
