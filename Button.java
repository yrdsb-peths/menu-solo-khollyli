import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    GreenfootImage button1;
    GreenfootImage button2;
    
    public Button()
    {
        //this.action = action;
        button1 = new GreenfootImage("images/buttonLong_blue.png");
        button2 = new GreenfootImage("images/buttonLong_beige.png");
    }

    public void colorBlue()
    {
        setImage(button1);
    }
    
    public void colorBeige()
    {
        setImage(button2);
    }
    
}
