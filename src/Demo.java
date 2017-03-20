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
    public ArrayList<PinballObject> pinballObjects;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        machine = new Machine();
        pinballObjects = new ArrayList<PinballObject>();
    }

    /**
     * Sample demo method - demonstrates what happens when an object rebounds off the left-hand wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
        BallObject bumper = new BallObject(130, 120, Color.LIGHT_GRAY, 15, machine);
        BallObject largeHole = new BallObject(470, 170, Color.BLACK, 45, machine);
        BallObject smallHole = new BallObject(60, 60, Color.BLACK, 15, machine);
        PinballObject pinballObj1 = new PinballObject(50, 200, -5, 3, Color.RED, 10, machine, pinballObjects);
        PinballObject pinballObj2 = new PinballObject(100, 300, 1, 2, Color.BLUE, 55, machine, pinballObjects);
        PinballObject pinballObj3 = new PinballObject(450, 125, -1, -1, Color.YELLOW, 40, machine, pinballObjects);
        PinballObject pinballObj4 = new PinballObject(100, 200, 2, -2, Color.MAGENTA, 25, machine, pinballObjects);
        
        for(int i = 0; i <= 4000; i++)
        {
            machine.pauseMachine();           // small delay
            pinballObj1.move();
            pinballObj2.move();
            pinballObj3.move();
            pinballObj4.move();
            
            pinballObj1.collisionCheck(pinballObjects);
            pinballObj2.collisionCheck(pinballObjects);
            pinballObj3.collisionCheck(pinballObjects);
            pinballObj4.collisionCheck(pinballObjects);
        }
    }
}
