import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author Kholly Li
 * @version October 2024
 */
public class MenuScreen extends World
{
    AvatarSelection avatar;
    Button instructions;
    Button highscore;
    Label inst;
    Label hs;
    
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        instructions = new Button();
        instructions.colorBlue();
        
        highscore = new Button();
        highscore.colorBlue();

        avatar = new AvatarSelection();
        
        inst = new Label("Instructions", 20);
        hs = new Label("Sample", 20);
        
        addObject(instructions, getWidth() / 2, 265);
        addObject(highscore, getWidth() / 2, 330);
        addObject(avatar, getWidth() / 2, 100);
        addObject(inst, getWidth() / 2, 265);
        addObject(hs, getWidth() / 2, 330);
    }
    
    public void act()
    {
        // When button is button is clicked, it executes the following function inside
        if(Greenfoot.mouseClicked(instructions) || Greenfoot.mouseClicked(inst))
        {
            goInstructions();
        }
        
        if(Greenfoot.mouseClicked(highscore) || Greenfoot.mouseClicked(hs))
        {
            goHighScore();
        }
    }
    
    // Switches from MenuScreen to InstructionScreen
    public void goInstructions()
    {
        Greenfoot.setWorld(new InstructionScreen(this));
    }
    
    // Switched from MenuScreen to HighScore screen
    public void goHighScore()
    {
        Greenfoot.setWorld(new HighScore(this));
    }
}
