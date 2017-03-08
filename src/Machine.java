import java.awt.*;

/**
 * A pinball machine, with a sample demo
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Machine
{
    private Canvas machine;
    private int topEdge = 0;
    private int leftEdge = 0;
    private int bottomEdge;
    private int rightEdge;
    private int lengthToGap;        // the distance between the edge of the machine and the start of the gap
    private int gapWidth = 50;

    /**
     * Create a machine with default name and size
    */
    public Machine()
    {
        machine = new Canvas("Pinball Demo", 600, 500);
        rightEdge = 600;
        bottomEdge = 500;
        lengthToGap = (rightEdge / 2) - gapWidth;
        drawMachine();
    }
    
    /**
     *  Create a machine with given name and size
     *  @param name The name to give the machine
     *  @param rightEdge The maximum x coordinate
     *  @param bottomEdge The maximum y coordinate
     */
     public Machine(String name, int rightEdge, int bottomEdge)
    {
        machine = new Canvas(name, rightEdge, bottomEdge);
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
        lengthToGap = (rightEdge / 2) - gapWidth;
        drawMachine();
    }

    /**
     * Erase a PinballObject from the view of the pinball machine
     * 
     * @param pinballObj The object to be erased
     */
    public void erase(PinballObject pinballObj)
    {
        machine.eraseCircle(pinballObj.getXPosition() - pinballObj.getRadius(), pinballObj.getYPosition()- pinballObj.getRadius(), pinballObj.getDiameter());
    }
    
    /**
    * Draw an PinballObject at its current position onto the view of the pinball machine
    * 
    * @param pinballObj The object to be drawn
    */
    public void draw(PinballObject pinballObj)
    {
        machine.setForegroundColor(pinballObj.getColor());
        machine.fillCircle(pinballObj.getXPosition() - pinballObj.getRadius(), pinballObj.getYPosition() - pinballObj.getRadius(), pinballObj.getDiameter());
    }
    
    /**
    * Draw the edge of the pinball machine 
    */
    public void drawMachine()
    {
        machine.setForegroundColor(Color.DARK_GRAY);
        
        machine.fillRectangle(0, 0, rightEdge, 10);  // top edge
        machine.fillRectangle(0, 0, 10, bottomEdge); // left edge
        machine.fillRectangle(rightEdge - 10, 0, 10, bottomEdge); // right edge
        
        machine.fillRectangle(0, bottomEdge - 10, lengthToGap, 10); // left-hand side of bottom edge
        machine.fillRectangle(rightEdge - lengthToGap, bottomEdge - 10, rightEdge, 10);     // right-hand side of bottom edge
    }
    
    /**
     * Return the edge of the left-hand wall
     */
    public int getLeftWall()
    {
        return leftEdge + 10;
    }
    
    /**
     * Introduces a small delay in ball movement, for smooth running
     */
    
    public void pauseMachine()
    {
        machine.wait(50);
    }
    
    /**
     * Resets the machine back to initial view, with no pinballs
     */
    public void resetMachine()
    {
        machine.erase();
        drawMachine();
    }
}
