import java.awt.Color;
import java.util.ArrayList;

public class FlashPinball extends PinballObject {
	
	//Instance Variables
	private boolean isFlashing;
	private Color[] flasObjectColourList = new Color[]{Color.RED, Color.BLUE, Color.GREEN};
	private Color currentColour;
	private int currentColourTracker;
	
	//FlashPinball Constructor
	public FlashPinball(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
	{
		super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, pinballObjects);
		
		currentColourTracker = 0;
		isFlashing = true;
	}
	
	public void move()
	{
		super.move();
        // remove from universe at the current position
       machine.erase(this);
       
       // check if it has hit the left Wall
       if(currentXLocation <= (leftWallPosition + radius))
       {
    	   this.changeColour(currentColourTracker);
       }
       
       // check if it has hit the right Wall
       if(currentXLocation >= (rightWallPosition - radius))
       {
    	   this.changeColour(currentColourTracker);
       }
       
       //check if it has hit the top Wall
       if(currentYLocation <= (topWallPosition + radius))
       {
    	   this.changeColour(currentColourTracker);
       }
       
       // check if it has hit the bottom Wall
       if(currentYLocation >= (bottomWallPosition - radius))
       {
    	   this.changeColour(currentColourTracker);
       }
       
       currentColour = flasObjectColourList[currentColourTracker];
       
       //Change flashballObject colour
       
       
       // draw again at new position
       machine.draw(this);
       
   }
	
	public void collisionCheck(ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
	{
		super.collisionCheck(bumperObjects, holeObjects, pinballObjects);
		
		//Check if flashball colliding to itself
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
	
	//Colour change toggle
	public void toggleColour()
	{
		
	}
	
	public void changeColour(int currentColourTracker)
	{
		
	}
	
}
