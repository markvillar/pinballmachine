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
        
        BallObject bumper1 = new BallObject(130, 120, Color.LIGHT_GRAY, 15, machine, bumperObjects);
        BallObject bumper2 = new BallObject(380, 420, Color.LIGHT_GRAY, 15, machine, bumperObjects);
        
        BallObject largeHole = new BallObject(470, 230, Color.BLACK, 45, machine, holeObjects);
        BallObject smallHole = new BallObject(60, 60, Color.BLACK, 15, machine, holeObjects);
        
        FlashPinball flashPinball1 = new FlashPinball(50, 200, -5, 3, Color.RED, 20, machine, bumperObjects, holeObjects, pinballObjects);
        FlashPinball flashPinball2 = new FlashPinball(200, 200, -7, 8, Color.RED, 45, machine, bumperObjects, holeObjects, pinballObjects);
        FlashPinball flashPinball3 = new FlashPinball(400, 350, 7, 8, Color.RED, 30, machine, bumperObjects, holeObjects, pinballObjects);
        
        SizablePinball sizeablePinball1 = new SizablePinball(100, 300, 1, 2, Color.CYAN, 55, machine, pinballObjects);
        SizablePinball sizeablePinball2 = new SizablePinball(450, 125, -1, -1, Color.MAGENTA, 40, machine, pinballObjects);
        SizablePinball sizeablePinball3 = new SizablePinball(100, 200, 2, -2, Color.YELLOW, 25, machine, pinballObjects);
        
        for(int i = 0; i <= 4000; i++)
        {
            machine.pauseMachine();		// small delay
            flashPinball1.move();
            flashPinball1.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            
            flashPinball2.move();
            flashPinball2.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            
            flashPinball3.move();
            flashPinball3.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            
            sizeablePinball1.move();
            sizeablePinball1.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            
            sizeablePinball2.move();
            sizeablePinball2.collisionCheck(bumperObjects, holeObjects, pinballObjects);
            
            sizeablePinball3.move();
            sizeablePinball3.collisionCheck(bumperObjects, holeObjects, pinballObjects);
        }
    }
}
