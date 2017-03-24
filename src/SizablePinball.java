import java.awt.Color;
import java.util.ArrayList;

/**
 *	
 *	SizablePinball changes Size when hitting any of the machine's edges
 *	and changes Speed when hitting another Pinball.
 *	
 */

public class SizablePinball extends PinballObject {
	
	private final int maxSpeed;
	private final int minSpeed;
	private final int maxRadius;
	private final int minRadius;
	
	//Sizable Pinball Constructor
	public SizablePinball(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius,
			Machine theMachine, ArrayList<PinballObject> pinballObjects) {
		super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, pinballObjects);
		maxRadius = 60;
		minRadius = 10;
		maxSpeed = 15;
		minSpeed = 5;
	}
	
	public void move()
	{
		super.move();
        // remove from universe at the current position
       machine.erase(this);
       
       // check if it has hit the left Wall
       if(currentXLocation <= (leftWallPosition + radius))
       {
    	   radius = this.decreaseRadius(radius);
       }
       
       // check if it has hit the right Wall
       if(currentXLocation >= (rightWallPosition - radius))
       {
    	   radius = this.increaseRadius(radius);
       }
       
       //check if it has hit the top Wall
       if(currentYLocation <= (topWallPosition + radius))
       {
    	   radius = this.decreaseRadius(radius);
       }
       
       // check if it has hit the bottom Wall
       if(currentYLocation >= (bottomWallPosition - radius))
       {
    	   radius = this.increaseRadius(radius);
       }
       
       // draw again at new position
       machine.draw(this);
       
   }
	
	private int decreaseRadius(int radii)
	{
		int tempRadius = (radii - (radii/100) * 10);
		return tempRadius;
	}
	
	private int increaseRadius(int radii)
	{
		int tempRadius = (radii + (radii/100) * 10);
		return tempRadius;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void setRadius(int newRadius)
	{
		radius = newRadius;
	}
	
	//Randomiser
	public int random(int min, int max)
	{
	   int range = Math.abs(max - min) + 1;
	   return (int) ((Math.random() * range) + (min <= max ? min : max));
	}
	
    public void collisionCheck(ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
    {
    	super.collisionCheck(bumperObjects, holeObjects, pinballObjects);
    	
        for(PinballObject other : ((ArrayList<PinballObject>)pinballObjects))
        {   
            //Prevent Pinball from colliding on itself
            if ((currentXLocation != other.getXPosition()) && (currentYLocation != other.getYPosition()))
            {
                int diffX = currentXLocation - other.getXPosition();
                int diffY = currentYLocation - other.getYPosition();
                
                int squaredX = (int) Math.pow(diffX, 2);
                int squaredY = (int) Math.pow(diffY, 2);
                
                int distance = (int) Math.sqrt(squaredX + squaredY);
                
                //Pinball Collision
                if (distance < (radius + other.getRadius()))
                {
                	//Give new random speed for X and Y values
                	speedXTravel = this.random(2, 8);
                	speedYTravel = this.random(2, 10);
                }
            }
        }
    }
	
}
