import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class AvatarSelection extends Actor
{
    private Queue<Avatar> avatars = new Queue<>();
    private Avatar current;
    Button b1;
    Label next;

    // Adds images to the 'avatars' queue
    public AvatarSelection()
    {    
        setImage((GreenfootImage) null);

        avatars.enqueue(new Avatar("images/face_a.png"));
        avatars.enqueue(new Avatar("images/face_b.png"));
        avatars.enqueue(new Avatar("images/face_c.png"));
        
        b1 = new Button();
        b1.colorBlue();
        
        next = new Label("\u2192", 50);

        current = avatars.dequeue();
    }

    protected void addedToWorld(World world)
    {
        world.addObject(b1, world.getWidth() / 2, world.getHeight() / 2);
        world.addObject(next, world.getWidth() / 2, world.getHeight() / 2);
        updateAvatar();
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(b1) || Greenfoot.mouseClicked(next))
        {
            next();
        }
    }
    
    // Updates position of the avatar
    private void updateAvatar()
    {
        int x = 300;
        int y = 100;
        World world = getWorld();
        // Removes current avatar from the world if it exists
        if(current != null)
        {
            world.removeObject(current);
        }
        // Adds curent avatar to the world
        world.addObject(current, x, y);
    }
    
    // Switches to the next avatar in the queue
    public void next()
    {
        // Adding current avatar back into the queue
        avatars.enqueue(current);
        // Removes current avatar displayed in the world
        getWorld().removeObject(current);
        // Removing the next avatar from the queue and set it to the current avatar
        current = avatars.dequeue();
        updateAvatar();
    }
}
