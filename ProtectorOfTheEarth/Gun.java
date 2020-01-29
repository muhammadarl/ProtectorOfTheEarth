import greenfoot.*;
/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Actor
{
    GreenfootSound meteor = new GreenfootSound("EnergyGun.mp3");
    private ScoreKeeper gunScoreKeeper;
    public Gun(ScoreKeeper scorekeeper)
    {
        gunScoreKeeper = scorekeeper;
    }
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        if(Greenfoot.mouseClicked(null))
        {
            meteor meteor = (meteor) getOneObjectAtOffset(0,0,meteor.class);
            meteor();
            if(meteor!=null)
            {
                meteor.destroy();
                gunScoreKeeper.incrementScore(ProtectorOfTheEarth.scoreOfmeteors);
                Greenfoot.playSound ("MetalExplosion.mp3");
            }
        }
    }
    private void meteor()
        {
            meteor.setVolume(50);
        }
        
}
