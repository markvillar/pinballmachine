import java.awt.*;

/**
 * Class to demonstrate functionality of the Pinball machine
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Demo
{
    private Machine machine;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        machine = new Machine();
    }

    /**
     * Sample demo method - demonstrates what happens when an object rebounds off the left-hand wall
     */
    public void sampleDemo()
    {
        // sample demo
        machine.resetMachine();
        
        PinballObject obj1 = new PinballObject(50, 200, -5, 3, Color.RED, 10, machine);
        PinballObject obj2 = new PinballObject(100, 300, 1, 2, Color.BLUE, 55, machine);
        PinballObject obj3 = new PinballObject(450, 125, -1, -1, Color.YELLOW, 40, machine);
        PinballObject obj4 = new PinballObject(100, 200, 2, -2, Color.MAGENTA, 25, machine);
        
        for(int i = 0; i <= 60; i++)
        {
            machine.pauseMachine();           // small delay
            obj1.move();
            obj2.move();
            obj3.move();
            obj4.move();
        }
    }
}
