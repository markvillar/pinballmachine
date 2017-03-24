import java.awt.Color;
import java.util.ArrayList;

public class FlashPinball extends PinballObject {
	
	//Instance Variables
	private boolean isFlashing;
	
	//FlashPinball Constructor
	public FlashPinball(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
	{
		super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, pinballObjects);
		
		isFlashing = false;
	}
	
	//Move the flashballObject around the machine
	public void move()
	{
		super.move();
        // remove from universe at the current position
       machine.erase(this);
       
       // check if it has hit the left Wall
       if(currentXLocation <= (leftWallPosition + radius))
       {
    	   this.isFlashing = false;
    	   this.changeColour(colour);
       }
       
       // check if it has hit the right Wall
       if(currentXLocation >= (rightWallPosition - radius))
       {
    	   this.isFlashing = false;
    	   this.changeColour(colour);
       }
       
       //check if it has hit the top Wall
       if(currentYLocation <= (topWallPosition + radius))
       {
    	   this.isFlashing = false;
    	   this.changeColour(colour);
       }
       
       // check if it has hit the bottom Wall
       if(currentYLocation >= (bottomWallPosition - radius))
       {
    	   this.isFlashing = false;
    	   this.changeColour(colour);
       }
       
       // draw again at new position
       machine.draw(this);
       
   }
	
	//Collision check
	public void collisionCheck(ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
	{
		super.collisionCheck(bumperObjects, holeObjects, pinballObjects);
		
		//Check if flashballObject colliding to itself
		
		for(PinballObject other : ((ArrayList<PinballObject>)pinballObjects))
        {
	        if ((currentXLocation != other.getXPosition()) && (currentYLocation != other.getYPosition()))
	        {
                int diffX = currentXLocation - other.getXPosition();
                int diffY = currentYLocation - other.getYPosition();
                
                int squaredX = (int) Math.pow(diffX, 2);
                int squaredY = (int) Math.pow(diffY, 2);
                
                int distance = (int) Math.sqrt(squaredX + squaredY);
                
                if (isFlashing == true)
                {
                	this.changeColour(colour);
                }
                
                //Flashball Collision
                if (distance < (radius + other.getRadius()))
                {
                	isFlashing = true;
                }
                else
                {
                	continue;
                }
	        }
        }
	}
	
	//Change the colour
	private void changeColour(Color colour)
	{
		if (this.colour == Color.RED)
		{
			this.colour = Color.BLUE;
		}
		else if (this.colour == Color.BLUE)
		{
			this.colour = Color.GREEN;
		}
		else if (this.colour == Color.GREEN)
		{
			this.colour = Color.RED;
		}
		else
		{
			this.colour = Color.RED;
		}
	}
	
}
