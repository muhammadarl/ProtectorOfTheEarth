import greenfoot.*;
import java.util.Calendar;
/**
 * ProtectorOfTheEarth
 * Game sederhana mempertahankan kota dari hujan meteor!
 * Cara Bermain:
 * Mouse = kontrol; mouse klik = Tembak!
 * 
 * Author: Muhammad Syiarul
 * 
 */
public class ProtectorOfTheEarth extends World
{   private ScoreKeeper scoreKeeper = new ScoreKeeper();
    private int actIteration = 0;
    private int x = 0;
    private int speed = 10;
    private int meteorsCreated = 0;
    private int level = 0;
    private int maxmeteorsPerLevel = 5;
    public static int scoreOfmeteors = 10;
    GreenfootSound BGM = new GreenfootSound("bgm.mp3");
    public static final GreenfootSound gameover = new GreenfootSound("game_over.mp3");
    public static int scoreOfmeteors()
    {
        return scoreOfmeteors();
    }
    
    
    /**
     * Constructor for objects of class ProtectorOfTheEarth.
     * 
     */
    public ProtectorOfTheEarth()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(950, 439, 1);
        createCity();
        addGun();
        addScoreKeeper();
        //prepare();
        
        
    }
    
    private void BGM()
    {
        BGM.playLoop();
        BGM.setVolume(40);
    }
    
    private void gameover()
    {
        gameover.playLoop();
        gameover.setVolume(60);
    }
    public void createCity()
    {
        int x = 0;
        int y = (int)(getHeight()*.93);
        int counter =1;
        while(true)
        {
            Actor cityActor = getCityActor();
            GreenfootImage image = cityActor.getImage();
            int width = image.getWidth();
            if((x + width) > getWidth())            
            {
                break;
            }

            addObject(cityActor, x+width/2, y);
            x=x+width;
            counter = counter + 1;
            
            
            if(counter % 2 == 0)
            {
            House house = new House();
            GreenfootImage houseImage = house.getImage();
            int houseWidth = houseImage.getWidth();
            if((x + houseWidth) > getWidth())
            break;

            addObject(house, x+houseWidth/2, y);
            x = x + houseWidth;
            }
            else
            {
            Building building = new Building();
            GreenfootImage buildingImage = building.getImage();
            int buildingWidth = buildingImage.getWidth();
            if((x + buildingWidth) > getWidth())
            break;

            addObject(building, x+buildingWidth/2, y);
            x = x + buildingWidth;                
            }
            counter = counter + 1;
        }
        House house = new House();
        GreenfootImage houseImage = house.getImage();
        int houseImageWidth = houseImage.getWidth();
        addObject(house,x + houseImageWidth/2, y);
        x = x + houseImageWidth;
        House house2 = new House();
        addObject(house2, x+houseImageWidth/2,y);
    }

    public void addGun()
    {
        addObject(new Gun(scoreKeeper), getWidth() /2, getHeight() /2);
    }
    
    public Actor getCityActor()
    {
        int buildingType = Greenfoot.getRandomNumber(3);
        if(buildingType == 0)
        {
            return new House();
        }
        else if(buildingType == 1)
        {
            return new Building();
        }
        else if(buildingType == 2)
        {
            return new Building2();
        }
        return null;
    }

    public void addLevelDisplay(int level)
    {
        addObject(new LevelDisplay(level), getWidth()/2, getHeight()/2);
    }
    
    public void act()
    {
        java.util.List meteorList = getObjects(meteor.class);
        if(meteorsCreated >= (maxmeteorsPerLevel * level) && meteorList.size() == 0)
        {
            level = level + 1;
            meteorsCreated = 0;
            actIteration = 0;
            speed = 1;
            addLevelDisplay(level);
            return;
        }
        java.util.List houseList = getObjects(House.class);
        int HomesLeft = 0;
        if(houseList != null)
        {
            HomesLeft = houseList.size();
            
        }
        java.util.List buildingList = getObjects(Building.class);
        if(buildingList != null)
        {
            HomesLeft = HomesLeft + buildingList.size();
        }
        
        //nyawa
        if(HomesLeft == 0)
        {
            scoreKeeper.gameOver();
            tombolLagi mainlagi = new tombolLagi();
            addObject(mainlagi,350, 370);
            tombolKeluar keluar = new tombolKeluar();
            addObject(keluar,600,370);
            addObject(new EndDisplay(), getWidth()/2, getHeight()/2);
            BGM.stop();
            gameover();
            return;
        }else{
            BGM();
            ProtectorOfTheEarth.gameover.stop();
        }
        //pertambahan kesulitan
        actIteration = actIteration + 1;
        if(actIteration % 100 == 0)
        {
            meteor meteor = new meteor(speed);
            meteorsCreated = meteorsCreated + 2;
            if(meteorsCreated > 0 && meteorsCreated % 2.5 == 0)
            {
                speed = speed + 3;
                scoreOfmeteors = scoreOfmeteors + 5;
                return;
            }
            int meteorWidth = meteor.getImage().getWidth();
            x = Greenfoot.getRandomNumber(getWidth());
            if(x - meteorWidth < 0)
            {
                x=meteorWidth / 2;
            }
            else if(x + meteorWidth > getWidth())
            {
                x = getWidth() - meteorWidth/2;
            }
            addObject(meteor, x, 0);
            return;
        }
        return;
    }
    
    public void addScoreKeeper()
    {
        addObject(scoreKeeper,850,30);
    }

   
}
