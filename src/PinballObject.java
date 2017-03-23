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
    private int speedXTravel;
    private int speedYTravel;
    private final int leftWallPosition;
    private final int rightWallPosition;
    private final int topWallPosition;
    private final int bottomWallPosition;

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
        }

        // check if it has hit the righttwall
        if(currentXLocation >= (rightWallPosition - radius))
        {
            currentXLocation = rightWallPosition - radius;
            speedXTravel = -speedXTravel;
        }

        //check if it has hit the top Wall
        if(currentYLocation <= (topWallPosition + radius))
        {
            currentYLocation = topWallPosition + radius;
            speedYTravel = -speedYTravel;
        }

        // check if it has hit the bottomwall
        if(currentYLocation >= (bottomWallPosition - radius))
        {
            currentYLocation = bottomWallPosition - radius;
            speedYTravel = -speedYTravel;
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
                
                //Collision
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
                }
            }
        }
        
        //Check if pinball collides with bumper
        for(BallObject pinball : ((ArrayList<BallObject>)bumperObjects))
        {
            int bumperDiffX = currentXLocation - pinball.getXPosition();
            int bumperDiffY = currentYLocation - pinball.getYPosition();
            
            int bumperSquaredDiffX = (int) Math.pow(bumperDiffX, 2);
            int bumperSquaredDiffY = (int) Math.pow(bumperDiffY, 2);
            
            int distanceFromBumper = (int) Math.sqrt(bumperSquaredDiffX + bumperSquaredDiffY);
            
            //Collision
            if (distanceFromBumper < (radius + pinball.getRadius()))
            {
            	speedXTravel = -speedXTravel;
            	speedYTravel = -speedYTravel;
            }
            
            //Refresh the bumper
            pinball.reDraw();
        }
        
        //Check if Pinball goes in a hole
        for(BallObject pinball : ((ArrayList<BallObject>)holeObjects))
        {
            int bumperDiffX = currentXLocation - pinball.getXPosition();
            int bumperDiffY = currentYLocation - pinball.getYPosition();
            
            int bumperSquaredDiffX = (int) Math.pow(bumperDiffX, 2);
            int bumperSquaredDiffY = (int) Math.pow(bumperDiffY, 2);
            
            int distanceFromBumper = (int) Math.sqrt(bumperSquaredDiffX + bumperSquaredDiffY);
            
            //Pinball goes in a hole
            if (distanceFromBumper < (radius + pinball.getRadius()))
            {
            	//Do something
            }
            
            //Refresh the hole
            pinball.reDraw();
        }
    }
}
