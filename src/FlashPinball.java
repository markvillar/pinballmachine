import java.awt.Color;
import java.util.ArrayList;

public class FlashPinball extends PinballObject {
	
	//Instance Variables
	private boolean isFlashing;

	public FlashPinball(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, ArrayList<FlashPinball> flashPinballObjects) {
		super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, flashPinballObjects);
	//FlashPinball Constructor
		
		isFlashing = true;
		flashPinballObjects.add(this);
	}
	
	public void move()
	{
		super.move();
	}
	
	public void collisionCheck(bumperObjects, holeObjects, pinballObjects)
	{
		super.collisionCheck(bumperObjects, holeObjects, pinballObjects);
	}
	
	public void toggleFlash()
	{
		
	}
	
	public void toggleColour()
	{
		
	}
	
}
