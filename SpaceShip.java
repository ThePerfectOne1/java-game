import java.awt.Polygon;
import java.awt.*;
/**
@SuppressWarnings("serial")
public class SpaceShip extends Polygon{
	
	// Upper left hand corner of space ship
	
	static int uLeftXPos = 500, uLeftYPos = 400;
	
	// Center of space ship
	
	int centerX = 515;
	int centerY = 415;
	
	// Determines the direction the ship moves
	
	static int xDirection = 0;
	static int yDirection = 0;
	
	// Get the board width and height
	
	int width = GameBoard.boardWidth;
	int height = GameBoard.boardHeight;
	
	// Will hold the x & y coordinates for the ship
	// Everything is based on coordinates from the center
	// It is done this way so that rotation works properly
		
	public static int[] polyXArray = {-13,14,-13,-5,-13};
	public static int[] polyYArray = {-15,0,15,0,-15};
	
	// Defines if the ship should rotate
	
	static int rotationAngle = 0;
	
	// Holds the area of the ship polygon
	
	static double areaOfShip;
	
	// Creates a new space ship
	
	public SpaceShip(){
			
			// Creates a Polygon by calling the super or parent class of Rock Polygon
			
			super(polyXArray, polyYArray, 5);
			
			getShipArea();
			
			updateCenterPoints();
			
	}
*/

/**	
	public void move(){
		
		// Get the upper left and top most point for the Polygon
		// This will be dynamic later on

		/*
		int uLeftXPos = super.xpoints[0]; 
		int uLeftYPos = super.ypoints[0];
		
		// If the ship hits a wall it will go in the opposite direction
		
		if (uLeftXPos < 0 || (uLeftXPos + 25) > width) xDirection = -xDirection; 
		
		if (uLeftYPos < 0 || (uLeftYPos + 50) > height) yDirection = -yDirection; 
		
		// Change the values of the points for the Polygon
		
		for (int i = 0; i < super.xpoints.length; i++){
			
			super.xpoints[i] += xDirection;
			super.ypoints[i] += yDirection;
			
		}
		*//*
		super.xpoints = SpaceShip.polyXArray;
		super.ypoints = SpaceShip.polyYArray;
		
	}
*/
	
	// This is here just as a demonstration. IT ISN'T USED
/**	
	public void rotateRight(){

		// Calculate the length of the line from 1 vector to the next
		// SQRT ((x1-x2)^2 + (y1-y2)^2)
		// Find the angle of the line from 1 vector to the next
		// x1*x2 + y1*y2 = C
		// SQRT ( x1^2 + x2^2 ) = A
		// SQRT ( y1^2 + y2^2 ) = B
		// ARCCOS ( C / A * B) = Angle of line
		// x2 = x1 + cos(angleOfLine) * length
		// y2 = y1 + sin(angleOfLine) * length
		
		// How to find new x & y points for the rotating polygon
		// This works on paper, but doesn't with Java because errors occur
		// because we have to convert floats into ints
		
		/*
		
		for(int i = 0; i < super.xpoints.length; i++){
			
			polyXArray[i] = this.centerX + (int) ((super.xpoints[i] - this.centerX) * cos(angle) -
					(super.ypoints[i] - this.centerY) * sin(angle));
			
			polyYArray[i] = this.centerY + (int) ((super.xpoints[i] - this.centerX) * sin(angle) +
					(super.ypoints[i] - this.centerY) * cos(angle));
			
		}
		
		
	}
*/	
	// How to find the ships area
	// This is here just as a demonstration. IT ISN'T USED
/**	
	public void getShipArea(){
		
		// Calculate the area of the polygon
				
		// Temporary sum holder
				
		double sumHolder1 = 0, sumHolder2 = 0;
				
		// Find area of polygon 
		// Multiply x coordinate of each vertex by the y coordinate
		// of the next vertex. Multiply y coordinate of each vertex 
		// by the x coordinate of the next vertex. Subtract these
		// sums and divide by 2 to get the polygons area
				
		// X Points {-13,14,-13,-5,-13}
		// Y Points {-15,0,15,0,-15}
		// -13 * 0
		// 	14 * 15 ... (Do the same for Y)
		
		for(int i = 0, n = 1; i < 4; i++, n++){
					
			sumHolder1 += super.xpoints[i] * super.ypoints[n];
					
		}
				
		for(int i = 0, n = 1; i < 4; i++, n++){
					
			sumHolder2 += super.ypoints[i] * super.xpoints[n];
					
		}
				
		areaOfShip = Math.abs(sumHolder1 - sumHolder2) / 2;
		
		System.out.println("Area of Ship: " + areaOfShip);
		
	}
*/	
	// How to find the ships center points
	// This is here just as a demonstration. IT ISN'T USED
/**	
	public void updateCenterPoints(){
		
		// Get the origin points
		// X Points {-13,14,-13,-5,-13}
		// Y Points {-15,0,15,0,-15}
		// Do the following for each row in array
		// (-13 + 14) * (-13 * 0) - (14 * -15)
		
		double xOrigin = 0, yOrigin = 0;
		
		// X Points {-13,14,-13,-5,-13};
		// Y Points {-15,0,15,0,-15};
		// Do the following for each row in array
		// (-13 + 14) * (-13 * 0) - (14 * -15)
		
		for (int j=0; j < 4; j++){

			xOrigin += (super.xpoints[j] + super.xpoints[j+1]) * ((super.xpoints[j]*super.ypoints[j+1]) - (super.xpoints[j+1]*super.ypoints[j]));
			yOrigin += (super.ypoints[j] + super.ypoints[j+1]) * ((super.xpoints[j]*super.ypoints[j+1]) - (super.xpoints[j+1]*super.ypoints[j]));
		}
		
		this.centerX = (int) (xOrigin/(6 * areaOfShip));
		
		this.centerY = (int) (yOrigin/(6 * areaOfShip));
		
		System.out.println("Center X: " + this.centerX);
		System.out.println("Center Y: " + this.centerY);
	}
	
}
*/

import java.awt.*;

@SuppressWarnings("serial")
public class SpaceShip extends Polygon{

	// Determines the speed the ship moves
	
	private double xVelocity = 0, yVelocity = 0;
	
	// Get the board width and height
	
	int gBWidth = GameBoard.boardWidth;
	int gBHeight = GameBoard.boardHeight;
	
	// Center of space ship
	
	private double centerX = gBWidth/2, centerY = gBHeight/2;
	
	// Will hold the x & y coordinates for the ship
	// Everything is based on coordinates from the center
	// It is done this way so that rotation works properly
		
	public static int[] polyXArray = {-13,14,-13,-5,-13};
	public static int[] polyYArray = {-15,0,15,0,-15};
	
	// Width and height of ship
	
	private int shipWidth = 27, shipHeight = 30;
	
	// Upper left hand corner of space ship
	
	private double uLeftXPos = getXCenter() + this.polyXArray[0];
	private double uLeftYPos = getYCenter() + this.polyYArray[0];
	
	// Defines if the ship should rotate
	
	private double rotationAngle = 0, movingAngle = 0;
	
	// Creates a new space ship
	
	public SpaceShip(){
			
			// Creates a Polygon by calling the super or parent class Polygon
			
			super(polyXArray, polyYArray, 5);
			
	}
	
	// Gets & sets the values for the x & y center of ship
	
	public double getXCenter(){ return centerX; }
	
	public double getYCenter(){ return centerY; }
	
	public void setXCenter(double xCent){ this.centerX = xCent; }
	
	public void setYCenter(double yCent){ this.centerY = yCent; }
	
	public void increaseXPos(double incAmt) { this.centerX += incAmt; }
	
	public void increaseYPos(double incAmt) { this.centerY += incAmt; }	
	
	// Gets & sets the x & y for upper left hand corner of ship
	
	public double getuLeftXPos(){ return uLeftXPos; }
	
	public double getuLeftYPos(){ return uLeftYPos; }
	
	public void setuLeftXPos(double xULPos){ this.uLeftXPos = xULPos; }
	
	public void setuLeftYPos(double yULPos){ this.uLeftYPos = yULPos; }
	
	// Gets & sets the x & y for upper left hand corner of ship
	
	public int getShipWidth(){ return shipWidth; }
		
	public int getShipHeight(){ return shipHeight; }
	
	// Gets, sets, increases and decreases the ship velocity
	
	public double getXVelocity(){ return xVelocity; }
	
	public double getYVelocity(){ return yVelocity; }
	
	public void setXVelocity(double xVel){ this.xVelocity = xVel; }
	
	public void setYVelocity(double yVel){ this.yVelocity = yVel; }
	
	public void increaseXVelocity(double xVelInc){ this.xVelocity += xVelInc; }
	
	public void increaseYVelocity(double yVelInc){ this.yVelocity += yVelInc; }
	
	public void decreaseXVelocity(double xVelDec){ this.xVelocity -= xVelDec; }
	
	public void decreaseYVelocity(double yVelDec){ this.yVelocity -= yVelDec; }
	
	// Set and increase the ship movement angle
	
	public void setMovingAngle(double moveAngle){ this.movingAngle = moveAngle; }
	
	public double getMovingAngle(){ return movingAngle; }
	
	public void increaseMovingAngle(double moveAngle){ this.movingAngle += moveAngle; }
	
	// Calculate the ship angle of movement
	
	// This is trigonometry at work
	// By taking the cos of the angle I get the opposite value of x
	// Angle * Math.PI / 180 converts degrees into radians
	
	public double shipXMoveAngle(double xMoveAngle){
		
		return (double) (Math.cos(xMoveAngle * Math.PI / 180));
		
	}
	
	// By taking the sin of the angle I get the adjacent value of y
	// Angle * Math.PI / 180 converts degrees into radians 
	
	public double shipYMoveAngle(double yMoveAngle){
		
		return (double) (Math.sin(yMoveAngle * Math.PI / 180));
		
	}
	
	
	// Gets & increases or decreases the rotation angle of the ship
	
	// Increase the rotation angle by 5, but don't let it go above 360
	
	public double getRotationAngle(){ return rotationAngle; }
		
	public void increaseRotationAngle(){ 
		
		if(getRotationAngle() >= 355) { rotationAngle = 0; }
		
		else { rotationAngle += 5; }
		
	}
	
	// Decrease the rotation angle by 5, but don't let it go below 0
	
	public void decreaseRotationAngle(){ 
		
		if(getRotationAngle() < 0) { rotationAngle = 355; }
		
		else { rotationAngle -= 5; }
		
	}
	
	// Artificial rectangle that is used for collision detection
	
	public Rectangle getBounds(){
		
		return new Rectangle(getShipWidth() - 14, getShipHeight() - 15, getShipWidth(), getShipHeight());
		
	}
	
	// NEW gets the spaceships nose X vector -------------------
	
	public double getShipNoseX(){
		
		// x2 = this.getXCenter() + cos(rotationAngle) * 14
		
		return this.getXCenter() + Math.cos(rotationAngle) * 14;
		
	}
	
	// NEW gets the spaceships nose Y vector --------------------
	
	public double getShipNoseY(){
		
		// x2 = this.getXCenter() + cos(rotationAngle) * 14
		// y2 = this.getYCenter() + sin(rotationAngle) * 14
		
		return this.getYCenter() + Math.sin(rotationAngle) * 14;
		
	}
	
	public void move(){
		
		// Increase the x origin value based on current velocity 
		
		this.increaseXPos(this.getXVelocity());
		
		// If the ship goes off the board flip it to the other side of the board
		
		if(this.getXCenter() < 0){
			
			this.setXCenter(gBWidth);
			
		} else
			if (this.getXCenter() > gBWidth){
				
				this.setXCenter(0);
				
			}
		
		// Increase the x origin value based on current velocity 
		
		this.increaseYPos(this.getYVelocity());
		
		// If the ship goes off the board flip it to the other side of the board
		
		if(this.getYCenter() < 0){
			
			this.setYCenter(gBHeight);
			
		} else
			if (this.getYCenter() > gBHeight){
				
				this.setYCenter(0);
				
			}
		
	}
	
	
}