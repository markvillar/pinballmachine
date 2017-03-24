import java.awt.*;
import java.util.ArrayList;

/**
 * Class to demonstrate functionality of the Pinball machine
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo
{
	private Machine machine;
    public ArrayList<BallObject> bumperObjects;
    public ArrayList<BallObject> holeObjects;
    public ArrayList<PinballObject> pinballObjects;
    
    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        machine = new Machine();
        bumperObjects = new ArrayList<BallObject>();
        holeObjects = new ArrayList<BallObject>();
        pinballObjects = new ArrayList<PinballObject>();
    }

    /**
     * Sample demo method - demonstrates what happens when an object rebounds off the left-hand wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
        BallObject bumper1 = new BallObject(170, 220, Color.LIGHT_GRAY, 15, machine, bumperObjects);
        BallObject bumper2 = new BallObject(420, 460, Color.LIGHT_GRAY, 15, machine, bumperObjects);
        
        BallObject largeHole = new BallObject(450, 230, Color.BLACK, 70, machine, holeObjects);
        BallObject smallHole = new BallObject(60, 60, Color.BLACK, 30, machine, holeObjects);
        
        FlashPinball flashPinball1 = new FlashPinball(400, 100, -5, 5, Color.RED, 40, machine, bumperObjects, holeObjects, pinballObjects);
        FlashPinball flashPinball2 = new FlashPinball(100, 200, 5, 4, Color.RED, 30, machine, bumperObjects, holeObjects, pinballObjects);
        FlashPinball flashPinball3 = new FlashPinball(300, 200, -5, 2, Color.RED, 20, machine, bumperObjects, holeObjects, pinballObjects);
        
        SizablePinball sizeablePinball1 = new SizablePinball(200, 450, 7, -7, Color.CYAN, 20, machine, pinballObjects);
        SizablePinball sizeablePinball2 = new SizablePinball(150, 130, 5, 2, Color.MAGENTA, 35, machine, pinballObjects);
        SizablePinball sizeablePinball3 = new SizablePinball(300, 400, 8, -8, Color.YELLOW, 20, machine, pinballObjects);
        
        while (machine.getMachineStatus() == true)
        {
            machine.pauseMachine();		// small delay
            
            /**
             * Primary Pinball
             */
            
            //FlashPinball 1
            if (flashPinball1.isObjectRemoved == false)
            {
	            flashPinball1.move();
	            flashPinball1.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            }
            else
            {
            	pinballObjects.remove(flashPinball1);
            }
            
            //FlashPinball 2
            if (flashPinball2.isObjectRemoved == false)
            {
	            flashPinball2.move();
	            flashPinball2.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            }
            else
            {
            	pinballObjects.remove(flashPinball2);
            }
            
            //FlashPinball 3
            if (flashPinball3.isObjectRemoved == false)
            {
	            flashPinball3.move();
	            flashPinball3.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            }
            else
            {
            	pinballObjects.remove(flashPinball3);
            }
            
            /**
             * Second Pinball Type
             */
            
            //SizeablePinball 1
            if (sizeablePinball1.isObjectRemoved == false)
            {
                sizeablePinball1.move();
                sizeablePinball1.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            }
            else
            {
            	pinballObjects.remove(sizeablePinball1);
            }
            
            //SizeablePinball 2
            if (sizeablePinball2.isObjectRemoved == false)
            {
                sizeablePinball2.move();
                sizeablePinball2.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            }
            else
            {
            	pinballObjects.remove(sizeablePinball2);
            }
            
            //SizeablePinball 3
            if (sizeablePinball3.isObjectRemoved == false)
            {
                sizeablePinball3.move();
                sizeablePinball3.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            }
            else
            {
            	pinballObjects.remove(sizeablePinball3);
            }
            
            // Check if pinballObjects ArrayList still have objects simulating
            if (pinballObjects.isEmpty())
            {
            	//Stops the machine 
            	machine.setMachineStatus(false);
            	
            	//Show accumulated score
            	machine.drawString(machine.getTotalScore(), 320, 250);
            	machine.drawString("Total Score: ", 240, 250);
            }
        }
    }
}
