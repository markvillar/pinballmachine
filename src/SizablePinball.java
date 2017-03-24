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
	
	//Constructor
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
    	   this.radius = this.decreaseRadius(this.radius);
       }
       
       // check if it has hit the right Wall
       if(currentXLocation >= (rightWallPosition - radius))
       {
    	   this.radius = this.decreaseRadius(this.radius);
       }
       
       //check if it has hit the top Wall
       if(currentYLocation <= (topWallPosition + radius))
       {
    	   this.radius = this.increaseRadius(this.radius);
       }
       
       // check if it has hit the bottom Wall
       if(currentYLocation >= (bottomWallPosition - radius))
       {
    	   this.radius = this.increaseRadius(this.radius);
       }
       
       // draw again at new position
       machine.draw(this);
       
   }
	
	private int decreaseRadius(int radius)
	{
		return this.radius = (this.radius - ((this.radius/100) * 10));
	}
	
	private int increaseRadius(int radius)
	{
		return this.radius = (this.radius + ((this.radius/100) * 10));
	}
	
	//Randomiser
	public int random(int min, int max)
	{
	   int range = Math.abs(max - min) + 1;
	   return (int) ((Math.random() * range) + (min <= max ? min : max));
	}
	
}