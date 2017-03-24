import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;

/**
 * An object that exists in the pinball. The object bounces off
 * the left wall of the machine (N.B - the final object should bounce
 * off all walls).
 *
 * Movement can be initiated by repeated calls to the "move" method.
 *
 * N.B This class is incomplete and still under development. It will require updating to
 * complete the INTPROG coursework assignment.
 *
 * @author (your name)
 * @version (a version number or a date)
 *
 */

public class PinballObject extends BallObject
{
    protected int speedXTravel;
    protected int speedYTravel;
    protected final int leftWallPosition;
    protected final int rightWallPosition;
    protected final int topWallPosition;
    protected final int bottomWallPosition;
    protected final int gapWidth;
    protected final int lengthToGap;
    protected int myScore;
    protected boolean isObjectRemoved;

    /**
     * Constructor for objects of class Pinball_Obj
     *
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectRadius  the radius (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theMachine  the machine this object is in
     */
    public PinballObject(int xPos, int yPos, int xVel, int yVel, Color objectColor, int objectRadius, Machine theMachine, ArrayList<PinballObject> pinballObjects)
    {
    	super(xPos, yPos, objectColor, objectRadius, theMachine);
        speedXTravel = xVel;
        speedYTravel = yVel;
        leftWallPosition = machine.getLeftWall();
        rightWallPosition = machine.getRightWall();
        topWallPosition = machine.getToptWall();
        bottomWallPosition = machine.getBottomWall();
        gapWidth = machine.getGapWidth();
        lengthToGap = machine.getLengthToGap();
        myScore = 0;
        isObjectRemoved = false;
        pinballObjects.add(this);
    }

    /**
     * Move this object according to its position and speed and redraw.
     **/
    public void move()
    {
         // remove from universe at the current position
        machine.erase(this);

        // compute new position
        currentYLocation += speedYTravel;
        currentXLocation += speedXTravel;

        // check if it has hit the leftwall
        if(currentXLocation <= (leftWallPosition + radius))
        {
            currentXLocation = leftWallPosition + radius;
            speedXTravel = -speedXTravel;
            myScore = myScore + 1;
        }

        // check if it has hit the righttwall
        if(currentXLocation >= (rightWallPosition - radius))
        {
            currentXLocation = rightWallPosition - radius;
            speedXTravel = -speedXTravel;
            myScore = myScore + 1;
        }

        //check if it has hit the top Wall
        if(currentYLocation <= (topWallPosition + radius))
        {
            currentYLocation = topWallPosition + radius;
            speedYTravel = -speedYTravel;
            myScore = myScore + 1;
        }

        // check if it has hit the bottom Wall
        if(currentYLocation >= (bottomWallPosition - radius))
        {
        	//Go through the Gap
        	if (currentXLocation >= lengthToGap && currentXLocation < (lengthToGap + gapWidth))
        	{
        		// Pinball falls between the gap
        		
        		// Hits the wall - (Pinball has to go back up)
        		if (currentXLocation != (radius + lengthToGap))
        		{
        			System.out.println("Bounce Back!");
        			speedYTravel = -speedYTravel;
        			
            		//Refresh the machine
            		machine.drawMachine();
        		}
        		
        		//Refresh the machine
        		machine.drawMachine();
        		
        	}
        	
        	//Hits the bottom wall - Bounce back up!
        	else if (currentXLocation <= lengthToGap || currentXLocation > (lengthToGap + gapWidth))
        	{
                currentYLocation = bottomWallPosition - radius;
                speedYTravel = -speedYTravel;
                myScore = myScore + 1;
        	}
        }
        
        // draw again at new position
        machine.draw(this);

    }
    
    public int getSpeedX()
    {
    	return speedXTravel;
    }
    
    public int getSpeedY()
    {
    	return speedYTravel;
    }
    
    public void setSpeedX(int newSpeedX)
    {
    	speedXTravel = newSpeedX;
    }
    
    public void setSpeedY(int newSpeedY)
    {
    	speedYTravel = newSpeedY;
    }
    
    public void collisionCheck(ArrayList<BallObject> bumperObjects, ArrayList<BallObject> holeObjects, ArrayList<PinballObject> pinballObjects)
    {
        for(PinballObject other : ((ArrayList<PinballObject>)pinballObjects))
        {   
            //Check if pinball collides to itself
            if ((currentXLocation != other.getXPosition()) && (currentYLocation != other.getYPosition()))
            {
                int diffX = currentXLocation - other.getXPosition();
                int diffY = currentYLocation - other.getYPosition();
                
                int squaredX = (int) Math.pow(diffX, 2);
                int squaredY = (int) Math.pow(diffY, 2);
                
                int distance = (int) Math.sqrt(squaredX + squaredY);
                
                //Pinball Collision
                if (distance < (radius + other.getRadius()))
                {
                	int x = speedXTravel;
                    int y = speedYTravel;
                    int x2 = other.getSpeedX();
                    int y2 = other.getSpeedY();
                	
                	speedXTravel = x2;
                    other.setSpeedX(x);
                    
                    speedYTravel = y2;
                    other.setSpeedY(y);
                    
                    myScore = myScore + 5;
                }
            }
        }
        
        //Check if Pinball collides with a bumper
        for(BallObject pinball : ((ArrayList<BallObject>)bumperObjects))
        {
            int bumperDiffX = currentXLocation - pinball.getXPosition();
            int bumperDiffY = currentYLocation - pinball.getYPosition();
            
            int bumperSquaredDiffX = (int) Math.pow(bumperDiffX, 2);
            int bumperSquaredDiffY = (int) Math.pow(bumperDiffY, 2);
            
            int distanceFromBumper = (int) Math.sqrt(bumperSquaredDiffX + bumperSquaredDiffY);
            
            //Pinball collided with a bumper
            if (distanceFromBumper < (radius + pinball.getRadius()))
            {
            	speedXTravel = -speedXTravel;
            	speedYTravel = -speedYTravel;
            	
            	//Add 2 points
            	myScore = myScore + 2;
            }
            
            //Refresh the bumper
            pinball.reDraw();
        }
        
        //Check if Pinball goes in a hole
        for(BallObject pinball : ((ArrayList<BallObject>)holeObjects))
        {
            int holeDiffX = currentXLocation - pinball.getXPosition();
            int holeDiffY = currentYLocation - pinball.getYPosition();
            
            int holeSquaredDiffX = (int) Math.pow(holeDiffX, 2);
            int holeSquaredDiffY = (int) Math.pow(holeDiffY, 2);
            
            int distanceFromHole = (int) Math.sqrt(holeSquaredDiffX + holeSquaredDiffY);
            
            //Pinball goes in a hole and looses all points
            if ((distanceFromHole <= Math.abs(radius - pinball.getRadius())))
            {
            	this.isObjectRemoved = true;
            	machine.erase(this);
            }
            
            //Draw live score on Pinballs
            machine.drawString(myScore, currentXLocation, currentYLocation);
            
            //Refresh the hole
            pinball.reDraw();
        }
    }
}
