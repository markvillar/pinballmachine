import java.awt.*;

/**
 * An object that exists in the pinball. The object bounces off
 * the left wall of the machine (N.B - the final object should bounce
 * off all walls).
 * 
 * Movement can be initiated by repeated calls to the "move" method.
 * 
 * N.B This class is incomplete and still under development. It will require updating to
 * complete the INTPROG coursework assignment.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */

public class PinballObject
{
    private int currentXLocation;
    private int currentYLocation;
    private int speedXTravel;
    private int speedYTravel;
    private Color colour;
    private int radius;
    private Machine machine;
    private final int leftWallPosition;

    /**
     * Constructor for objects of class Pinball_Obj
     * 
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theMachine  the machine this object is in
     */
    public PinballObject(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine)
    {
        currentXLocation = xPos;
        currentYLocation = yPos;
        speedXTravel = xVel;
        speedYTravel = yVel;
        colour = objectColor;
        radius = objectRadius;
        machine = theMachine;
        leftWallPosition = machine.getLeftWall();
        
    }

    /**
     * Move this object according to its position and speed and redraw.
     **/
    public void move()
    {
         // remove from universe at the current position
        machine.erase(this);
        
        // compute new position
        currentYLocation += speedYTravel;
        currentXLocation += speedXTravel;
        
        // check if it has hit the leftwall
        if(currentXLocation <= (leftWallPosition + radius)) 
        {
            currentXLocation = leftWallPosition + radius;
            speedXTravel = -speedXTravel; 
        }

        // draw again at new position
        machine.draw(this);
    
    }
    
    /**
     * return the horizontal position of this object
     */
    public int getXPosition()
    {
        return currentXLocation;
    }
    
    /**
     * return the vertical position of this object
     */
    public int getYPosition()
    {
        return currentYLocation;
    }
    
    /**
     * return the radius of this object
     */
    public int getRadius()
    {
        return radius;
    }
    
    /**
     * return the diameter of this object
     */
    public int getDiameter()
    {
        return 2*radius;
    }
    
    /**
     * return the colour of this object
     */
    public Color getColor()
    {
        return colour;
    }
}
