import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{
    Button next;
    Button back;
    String[] screens;
    int indexScreen;
    
    // Creates and adds buttons on the screen
    public InstructionScreen(MenuScreen menu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        next = new Button();
        next.colorBeige();
        back = new Button();
        back.colorBeige();
        
        screens = new String[3];
        indexScreen = 0;
        // Adding a string to each index in the array screens[]
        for(int i = 0; i < screens.length; i++)
        {
            screens[i] = "You're on screen #" + i;
        }
        
        addObject(next, 490, 350);
        addObject(back, 110, 350);
    }
    
    // Adds different labels on the screen depending on the value of 'indexScreen'
    public void act()
    {
        Label s1 = new Label(screens[indexScreen], 30);
        addObject(s1, getWidth() / 2, 100);
        
        // Increases indexScreen by 1 and removes any labels present
        if(Greenfoot.mouseClicked(next) && indexScreen < 2)
        {
            indexScreen++;
            removeObjects(getObjects(Label.class));
        }
        
        // Decreases indexScreen by 1 and removes any labels present
        if(Greenfoot.mouseClicked(back) && indexScreen > 0)
        {
            indexScreen--;
            removeObjects(getObjects(Label.class));
        }
        // Switches from InstructionScreen to MenuScreen when 'back' is clicked and indexScreen is at 0
        else if(Greenfoot.mouseClicked(back) && indexScreen == 0)
        {
            MenuScreen menu = new MenuScreen();
            Greenfoot.setWorld(menu);
        }
        
    }
}
