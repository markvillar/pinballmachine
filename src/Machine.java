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
    private boolean isMachineRunning;
    public static int totalScore;

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
        isMachineRunning = true;
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
    public void erase(BallObject pinballObj)
    {
        machine.eraseCircle(pinballObj.getXPosition() - pinballObj.getRadius(), pinballObj.getYPosition()- pinballObj.getRadius(), pinballObj.getDiameter());
    }
    
    /**
    * Draw an BallObject at its current position onto the view of the pinball machine
    * 
    * @param ballObject The object to be drawn
    */
    public void draw(BallObject ballObject)
    {
        machine.setForegroundColor(ballObject.getColor());
        machine.fillCircle(ballObject.getXPosition() - ballObject.getRadius(), ballObject.getYPosition() - ballObject.getRadius(), ballObject.getDiameter());
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
     * Return the edge of the right-hand wall
     */
    public int getRightWall()
    {
        return rightEdge - 10;
    }
    
    /**
     * Return the edge of the top wall
     */
    public int getToptWall()
    {
        return topEdge + 10;
    }
    
    /**
     * Return the edge of the bottom wall
     */
    public int getBottomWall()
    {
        return bottomEdge - 10;
    }
    
    /**
     * Get the distance between the edge of the machine and the start of the gap
     * @return int
     */
    public int getLengthToGap()
    {
    	return lengthToGap;
    }
    
    /**
     * Get the gap width between the bottom wall
     * @return int
     */
    public int getGapWidth()
    {
    	return gapWidth;
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
    
    /**
     * Sets the machine's status
     * @param newStatus
     */
    public void setMachineStatus(boolean newStatus)
    {
    	isMachineRunning = newStatus;
    }
    
    /**
     * Gets the machine's current status
     * @return
     */
    public boolean getMachineStatus()
    {
    	return isMachineRunning;
    }
    
    /**
     * Sets new total score
     */
    public void addTotalScore(int newValue)
    {
    	totalScore = totalScore + newValue;
    }
    
    /**
     * Returns total score
     * @return
     */
    public int getTotalScore()
    {
    	return totalScore;
    }
    
    /**
     * Draw score method
     * @param Text
     * @param X-Postion
     * @param Y-Postion
     */
    public void drawString(int myScore, int xPos, int yPos)
    {
    	String currenScore =Integer.toString(myScore);
    	machine.drawString(currenScore, xPos, yPos);
    }
    
    /**
     * Draw final score method
     * @param text
     * @param xPos
     * @param yPos
     */
    public void drawString(String text, int xPos, int yPos)
    {
    	machine.drawString(text, xPos, yPos);
    }
    
}
