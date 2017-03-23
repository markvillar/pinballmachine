import java.awt.Color;
import java.util.ArrayList;

public class FlashPinball extends PinballObject {
	
	//Instance Variables
	private boolean isFlashing;
	private String[] flasObjectColourList = new String[]{"RED", "BLUE", "Green"};
	private int currentColour;
	
	//FlashPinball Constructor
	public FlashPinball(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
	{
		super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, pinballObjects);
		
		currentColour = 0;
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
    	   colour = Color.CYAN;
       }
       
       // check if it has hit the right Wall
       if(currentXLocation >= (rightWallPosition - radius))
       {
    	   colour = Color.GREEN;
       }
       
       //check if it has hit the top Wall
       if(currentYLocation <= (topWallPosition + radius))
       {
    	   colour = Color.PINK;
       }
       
       // check if it has hit the bottom Wall
       if(currentYLocation >= (bottomWallPosition - radius))
       {
    	   colour = Color.RED;
       }
       
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
	
}
