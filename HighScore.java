import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScore extends World
{
    Map<String, Integer> map = new HashMap<>();
    ArrayList<String> keys = new ArrayList<>(map.keySet()); // Holds the keys of the HashMap
    Button next;
    Label name;
    Label back;
    int currentIndex;
    
    public HighScore(MenuScreen menu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        currentIndex = 0;
        
        // Add values into the HashMap
        map.put("Alice", 300);
        map.put("Bob", 149);
        map.put("Charlie", 394);
        
        back = new Label("\u2190", 50);
        
        next = new Button();
        next.colorBeige();
        
        addObject(next, getWidth() / 2, 200);
        
        // Adds all the keys into the array 'keys'
        keys.addAll(map.keySet());
    }
    
    // Loops through the ArrayList 'keys' to output onto the screen
    public void act()
    {   
        addObject(back, 25, 20);
        String key = keys.get(currentIndex);
        Label name = new Label(key + ": " + map.get(key), 30);
        addObject(name, getWidth() / 2, 100);
        
        if(Greenfoot.mouseClicked(next) && currentIndex < keys.size() - 1)
        {
            currentIndex++; 
            removeObjects(getObjects(Label.class));
        }
        else if(Greenfoot.mouseClicked(next) && currentIndex == keys.size() - 1)
        {
            currentIndex = 0;
            removeObjects(getObjects(Label.class));
        }
        
        if(Greenfoot.mouseClicked(back))
        {
            MenuScreen menu = new MenuScreen();
            Greenfoot.setWorld(menu);
        }
    }
}
