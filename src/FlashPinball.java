import java.awt.Color;
import java.util.ArrayList;

public class FlashPinball extends PinballObject {
	
	//Instance Variables
	private boolean isFlashing;
	
	//FlashPinball Constructor
	public FlashPinball(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
	{
		super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, pinballObjects);
		
		isFlashing = true;
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
    	   this.changeColour(colour);
       }
       
       // check if it has hit the right Wall
       if(currentXLocation >= (rightWallPosition - radius))
       {
    	   this.changeColour(colour);
       }
       
       //check if it has hit the top Wall
       if(currentYLocation <= (topWallPosition + radius))
       {
    	   this.changeColour(colour);
       }
       
       // check if it has hit the bottom Wall
       if(currentYLocation >= (bottomWallPosition - radius))
       {
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
        if ((currentXLocation != this.getXPosition()) && (currentYLocation != this.getYPosition()))
        {
			//Toggle Flash
			this.toggleFlash(isFlashing);
			colour = Color.BLUE;
        }
	}
	
	//Flash method
	public void toggleFlash(boolean isFlashing)
	{
		if (isFlashing == true){
			isFlashing = false;
		}
		else if (isFlashing == false){
			isFlashing = true;
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
