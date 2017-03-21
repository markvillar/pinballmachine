import java.awt.*;
import java.util.*;

/**
 * Write a description of class BallObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallObject
{
    // instance variables - replace the example below with your own
    protected int currentXLocation;
    protected int currentYLocation;
    protected Color colour;
    protected int radius;
    protected Machine machine;

    /**
     * Constructor for objects of class BallObject for Subclasses (PinballObjects)
     */
    public BallObject(int xPos, int yPos, Color objectColor, int objectRadius, Machine theMachine)
    {
        currentXLocation = xPos;
        currentYLocation = yPos;
        colour = objectColor;
        radius = objectRadius;
        machine = theMachine;
        machine.draw(this);
    }
    
    /**
     * Generic ballObject with ArrayList argument
     */
    public BallObject(int xPos, int yPos, Color objectColor, int objectRadius, Machine theMachine, ArrayList<BallObject> ballObjects)
    {
        currentXLocation = xPos;
        currentYLocation = yPos;
        colour = objectColor;
        radius = objectRadius;
        machine = theMachine;
        machine.draw(this);
        ballObjects.add(this);
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
