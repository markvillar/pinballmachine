import java.awt.Color;
import java.util.ArrayList;

public class FlashPinball extends PinballObject {
	
	//Instance Variables
	private boolean isFlashing;
	private String[] flasObjectColourList = new String[]{"RED", "BLUE", "Green"};
	
	//FlashPinball Constructor
	public FlashPinball(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, ArrayList<PinballObject> pinballObjects) {
		super(xPos, yPos, xVel, yVel, objectColor, objectRadius, theMachine, pinballObjects);
		
		isFlashing = true;
		pinballObjects.add(this);
	}
	
	public void move()
	{
		super.move();
	}
	
	public void toggleFlash(boolean isFlashing)
	{
		if (isFlashing == true){
			isFlashing = false;
		}
		else if (isFlashing == false){
			isFlashing = true;
		}
	}
	
	public void toggleColour()
	{
		
	}
	
}
