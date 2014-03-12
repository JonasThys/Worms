package worms.model;

import be.kuleuven.cs.som.annotate.*;

/**
 * 
 * A class of worms involving a name, an x-coordinate, a y-coordinate, an direction,
 * a radius and a current number of action points.
 * 
 * @version 1.0
 * @author Jonas Thys & Jeroen Reinenbergh
 * 
 */

public class Worm {

	/**
	 * Initialize this new worm with given name, given x-coordinate, given y-coordinate,
	 * given direction and given radius.
	 * 
	 * @param	name (def)
	 * 			The name of the worm.
	 * @param 	x (def)
	 * 			The x-coordinate of the worm's position expressed in metres.
	 * @param	y (def)
	 * 			The y-coordinate of the worm's position expressed in metres.
	 * @param	direction (nominal)
	 * 			The direction towards which the worm faces expressed in radians.
	 * @param	radius (def)
	 * 			The radius of the spherical body of the worm expressed in metres.
	 * @post 	The new name of this worm is equal to the given name.
	 * 		|	new.getName() = name
	 * @post 	The new radius of this worm is equal to the given radius.
	 * 		|	new.getRadius() = radius
	 * @post 	The new direction of this worm is equal to the given direction.
	 * 		|	new.getDirection() = direction
	 * @post 	The new x-coordinate of this worm is equal to the given x-coordinate.
	 * 		|	new.getX() = x
	 * @post 	The new y-coordinate of this worm is equal to the given y-coordinate.
	 * 		|	new.getY() = y
	 * @post	The new current number of action points of this worm is equal to the maximum number of action points of this worm.
	 * 		|	new.getNumberOfActionPoints() = new.getMaxNumberOfActionPoints()
	 * @throws 	IllegalArgumentException("Radius is too small!")
	 * 			The given radius is too small for any worm.
	 * 		|	! isPossibleRadius(radius)
	 * @throws 	IllegalArgumentException("Name is not valid!")
	 * 			The given name is not a valid name for any worm.
	 * 		|	! isPossibleName(name)
	 * 
	 */
	
	public Worm (String name, double radius, double direction, double x, double y) throws IllegalArgumentException {
		setRadius(radius);
		setDirection(direction);
		setName(name);
		setX(x);
		setY(y);
		setNumberOfActionPoints(this.getMaxNumberOfActionPoints());
	}

	/**
	 * Return the name of the worm.
	 * 	The name expresses the alphabetic identification of the worm.
	 */
	@Basic
	public String getName() {
		return name;
	}	
	
	/**
	 * Check whether the given name is a possible name for any worm.
	 * 
	 * @param	name
	 * 			The name to check.
	 * @return	True if and only if the given name contains at least 2 charachters,
	 * 			starts with an uppercase letter and only contains letters, quotes and spaces.
	 * 		|	result == (name.matches("[A-Z]"+"[A-Za-z\"\' ]+"))
	 */
	private static boolean isPossibleName(String name) {
		return name.matches("[A-Z]"+"[A-Za-z\"\' ]+");
	}	
	
	/**
	 * Set the name of this worm to the given name

	 * @param	name
	 * 			The new name of this worm.
	 * @post	The new name of this worm is equal to the given name.
	 * 		|	new.getName() == name
	 * @throws 	IllegalArgumentException("Name is not valid!")
	 * 			This worm cannot have the given name as its name.
	 * 		|	! isPossibleName(name)
	 */	
	public void setName(String name) throws IllegalArgumentException {
		if (!isPossibleName(name))
			throw new IllegalArgumentException("Name is not valid!");
		this.name = name;
	}
	
	/**
	 * Variable registering the name of this worm.
	 */
	private String name;

	/**
	 * Return the x-coordinate of the worm.
	 * 	The x-coordinate expresses the position
	 * 	at which the worm is located on the x-axis.
	 */
	@Basic
	public double getX() {
		return x;
	}
	
	/**
	 * Set the x-coordinate of this worm to the given x-coordinate

	 * @param	x
	 * 			The new x-coordinate of this worm.
	 * @post	The new x-coordinate of this worm is equal to the given x-coordinate.
	 * 		|	new.getX() == x
	 */
	private void setX(double x) {
		this.x = x;
	}

	/**
	 * Variable registering the x-coordinate of this worm.
	 */
	private double x;

	/**
	 * Return the y-coordinate of the worm.
	 * 	The y-coordinate expresses the position
	 * 	at which the worm is located on the y-axis.
	 */
	@Basic
	public double getY() {
		return y;
	}

	/**
	 * Set the y-coordinate of this worm to the given y-coordinate

	 * @param	y
	 * 			The new y-coordinate of this worm.
	 * @post	The new y-coordinate of this worm is equal to the given y-coordinate.
	 * 		|	new.getY() == y
	 */
	private void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Variable registering the y-coordinate of this worm.
	 */
	private double y;

	/**
	 * Return the direction of the worm.
	 * 	The direction expresses the direction towards which the worm is faced.
	 */
	@Basic
	public double getDirection() {
		return direction;
	}

	/**
	 * Set the direction of this worm to the given direction

	 * @param	direction
	 * 			The new direction of this worm.
	 * @post	The new direction of this worm is similar to the given direction 
	 * 			and is equal to its smallest representative angle that lies between zero and 2*pi, excluding the latter.
	 * 		|	new.getDirection() == convertToRepresentativeAngle(direction)
	 */
	private void setDirection(double direction) {
		this.direction = convertToRepresentativeAngle(direction);
	}

	/**
	 * Convert the given angle to a representative angle that is equal to or greater than zero and smaller than two times pi radians.

	 * @param	angle
	 * 			The angle to be converted.
	 * @return	The converted angle is a geometrically identical angle that lies between zero and two times pi, excluding the latter.
	 * 		|	angle = result + (constant * 2 * pi)
	 * 		|	0 <= result < (2 * pi)
	 */	
	private double convertToRepresentativeAngle(double angle){
		while(angle < 0){
			angle += 2 * Math.PI;
		}
		return (angle % (2 * Math.PI));
	}
	
	/**
	 * Variable registering the direction of this worm.
	 */
	private double direction;

	/**
	 * Return the radius of the worm.
	 * 	The radius expresses the radius of the spherical body of the worm.
	 */
	@Basic
	public double getRadius() {
		return radius;
	}

	/**
	 * Check whether the given radius is a possible radius for any worm.
	 * 
	 * @param	radius
	 * 			The radius to check.
	 * @return	True if and only if the given radius is not smaller than its lower bound.
	 * 		|	result == (radius >= lowerBoundOfRadius)
	 */
	private boolean isPossibleRadius(double radius){
		return radius >= lowerBoundOfRadius;
	}
	
	/**
	 * Set the radius of this worm to the given radius

	 * @param	radius
	 * 			The new radius of this worm.
	 * @post	The new radius of this worm is equal to the given radius.
	 * 		|	new.getRadius() == radius
	 * @throws 	IllegalArgumentException("Radius is too small!")
	 * 			The given radius is too small for any worm.
	 * 		|	! isPossibleRadius(radius)
	 */
	public void setRadius(double radius) throws IllegalArgumentException {
		if (!isPossibleRadius(radius))
			throw new IllegalArgumentException("Radius is too small!");
		this.radius = radius;
	}

	/**
	 * Return the mass of the worm.
	 * @return 	Mass of the worm based on calculations involving the radius of the worm.
	 * 		|	result == (1062 * (4 / 3) * Math.PI * Math.pow(radius, 3))
	 */
	public double getMass() {
		double p = 1062;
		return (p * (4 / 3) * Math.PI * Math.pow(this.radius, 3));
	}

	/**
	 * Return the maximum number of action points of the worm.
	 * @return	Maximum number of action points of the worm based on calculations involving the mass of the worm.
	 */
	@Raw
	public int getMaxNumberOfActionPoints(){
		return (int) Math.round(this.getMass());
	}	

	/**
	 * Variable registering the radius of this worm.
	 */
	private double radius;

	/**
	 * Variable registering the lower bound of the radius.
	 */	
	private double lowerBoundOfRadius = 0.25;

	/**
	 * Return the current number of action points of the worm.
	 * 	The current number of action points expresses the number of action points this worm has left.
	 */	
	@Basic
	public int getNumberOfActionPoints() {
		return numberOfActionPoints;
	}

	/**
	 * Set the number of action points of this worm to the given number of action points.
	 * 
	 * @param	numberOfActionPoints
	 * 			The new number of action points for this worm.
	 * @post	If the given number of action points is not below zero and not above the maximum number of action points,
	 * 			the new number of action points of this worm is equal to the given number of action points.
	 * 			If the given number of action points is negative, the new number of action points is equal to zero.
	 * 			If the given number of action points is greater than the maximum number of action points, the new number
	 * 			of action points is equal to the maximum number of action points.
	 * 		|	if ((numberOfActionPoints >= 0) && (numberOfActionPoints <= this.getMaxNumberOfActionPoints())) new.getNumberOfActionPoints == numberOfActionPoints
	 * 		|	else if (numberOfActionPoints < 0) new.getNumberOfActionPoints == 0
	 * 		|	else if (numberOfActionPoints > this.getMaxNumberOfActionPoints()) new.getNumberOfActionPoints == this.getMaxNumberOfActionPoints
	 */
	private void setNumberOfActionPoints(int numberOfActionPoints) throws IllegalArgumentException {
		if(numberOfActionPoints < 0)
			numberOfActionPoints = 0;
		else if(numberOfActionPoints > this.getMaxNumberOfActionPoints())
			numberOfActionPoints = this.getMaxNumberOfActionPoints();
		this.numberOfActionPoints = numberOfActionPoints;
	}
	
	/**
	 * Variable registering the current number of action points of this worm.
	 */	
	private int numberOfActionPoints;
		
	/**
	 * Check whether the given number of steps is a possible number of steps for any worm.
	 * 
	 * @param	numberOfSteps
	 * 			The number of steps to check.
	 * @return	True if and only if the given number of steps is not smaller than zero.
	 * 		|	result == (numberOfSteps >= 0)
	 */
	private boolean isPossibleNumberOfSteps(int numberOfSteps){
		return numberOfSteps >= 0;
	}

	/**
	 * Return the amount of action points this worm has to pay for moving the given number of steps.
	 * 
	 * @param 	numberOfSteps
	 * 			The number of steps to be taken by the worm in the current direction.
	 * @return	The amount of action points to be paid equals the number of steps times the weighted direction.
	 * 		|	result == numberOfSteps*(ceil(abs(cos(direction))+abs(4*sin(direction))))
	 * @throws 	IllegalArgumentException("Invalid number of steps!")
	 * 			The given number of steps is not a possible number of steps for any worm.
	 * 		|	! isPossibleNumberOfSteps(numberOfSteps)
	 */
	private int amountOfActionPointsForMoving(int numberOfSteps ) throws IllegalArgumentException {
		if (!isPossibleNumberOfSteps(numberOfSteps)) 
			throw new IllegalArgumentException("Invalid number of steps!");
		double horizontalComponent = Math.abs(Math.cos(direction));
		double verticalComponent = Math.abs(4 * Math.sin(direction));
		int decrement = (int) Math.ceil(horizontalComponent + verticalComponent);
		return (numberOfSteps * decrement);
	}

	/**
	 * Check whether the worm can move the given number of steps.
	 * 
	 * @param	numberOfSteps
	 * 			The number of steps to be taken by the worm in the current direction.
	 * @return	True if and only if the current number of action points is not smaller than the amount of action points required to move the worm with the given number of steps.
	 * 		|	result == (numberOfActionPoints >= amountOfActionPointsForMoving(numberOfSteps))
	 */	
	public boolean canMove(int numberOfSteps) throws IllegalArgumentException {
		if (! isPossibleNumberOfSteps(numberOfSteps))
			throw new IllegalArgumentException("Invalid number of steps!");
		return (numberOfActionPoints >= amountOfActionPointsForMoving(numberOfSteps));
	}

	/**
	 * Move this worm in the current direction for the given number of steps.
	 * 
	 * @param	numberOfSteps
	 * 			The number of steps to be taken by the worm in the current direction.
	 * @post	The new X-coordinate of the worm is equal to the old X-coordinate plus the cosinus of the angle of the current direction, multiplied by the number of steps and the radius of this worm.
	 * 		|	new.getX() == this.getX() + Math.cos(direction)*numberOfSteps*radius
	 * @post	The new Y-coordinate of the worm is equal to the old Y-coordinate plus the sinus of the angle of the current direction, multiplied by the number of steps and the radius of this worm.
	 * 		|	new.getY() == this.getY() + Math.sin(direction)*numberOfSteps*radius
	 * @throws 	IllegalArgumentException("Number of steps is too small!")
	 * 			The given number of steps is not a valid number of steps for any worm.
	 * 		|	! isPossibleNumberOfSteps(numberOfSteps)
	 */
	private void move(int numberOfSteps) throws IllegalArgumentException {
		if (!isPossibleNumberOfSteps(numberOfSteps)) 
			throw new IllegalArgumentException("Invalid number of steps!");
		double incrementX = Math.cos(direction) * radius;
		double incrementY = Math.sin(direction) * radius;
		double newX = x + (numberOfSteps * incrementX);
		double newY = y + (numberOfSteps * incrementY);
		this.setX(newX);
		this.setY(newY);
	}
	
	/** 
	 * Move this worm while paying the appropriate amount of action points.
	 * 
	 * @param 	numberOfSteps
	 * 			The number of steps to be taken by the worm in the current direction.
	 * @post	The new X-coordinate of the worm is equal to the old X-coordinate plus the cosinus of the angle of the current direction, multiplied by the number of steps and the radius of this worm.
	 * 		|	new.getX() == this.getX() + Math.cos(direction)*numberOfSteps*radius
	 * @post	The new Y-coordinate of the worm is equal to the old Y-coordinate plus the sinus of the angle of the current direction, multiplied by the number of steps and the radius of this worm.
	 * 		|	new.getY() == this.getY() + Math.sin(direction)*numberOfSteps*radius
	 * @post	The new number of action points equals the old number of action points reduced with the amount of action points to be paid for moving the given number of steps.
	 * 		|	new.getNumberOfActionPoints() == this.getNumberOfActionPoints - amountOfActionPointsForMoving(numberOfSteps)
	 * @throws 	IllegalArgumentException("Invalid number of steps!")
	 * 			The given number of steps is not a possible number of steps for any worm.
	 * 		|	! isPossibleNumberOfSteps(numberOfSteps)
	 * @throws 	UnsupportedOperationException("Cannot move!")
	 * 			The worm cannot move the given number of steps.
	 * 		|	! canMove(numberOfSteps)
	 */
	public void activeMove(int numberOfSteps) throws IllegalArgumentException {
		if (! isPossibleNumberOfSteps(numberOfSteps))
			throw new IllegalArgumentException("Invalid number of steps!");
		if (! canMove(numberOfSteps))
			throw new UnsupportedOperationException("Cannot move!");
		move(numberOfSteps);
		setNumberOfActionPoints(numberOfActionPoints - amountOfActionPointsForMoving(numberOfSteps));
	}
		
	/**
	 * Return the amount of action points this worm has to pay to turn by the given angle.
	 * 
	 * @param 	turnByAngle
	 * 			The angle by which this worm will be turned.
	 * @pre		The representative angle of the given angle to turn by is not zero.
	 * 		|	convertToRepresentativeAngle(turnByAngle) != 0
	 * @return	The resulting amount of action points to be paid is equal to the quotient of 60 and a factor that is calculated by dividing 2 times pi by the converted representative angle.
	 * 		|	result == ceil(60 / ((2*pi)/convertToRepresentativeAngle(turnByAngle)))	
	 */
	private int amountOfActionPointsForTurning(double turnByAngle){
		double factor = (2 * Math.PI) / convertToRepresentativeAngle(turnByAngle);
		int decrement = (int) Math.ceil(60 / factor);
		return decrement;
	}

	/**
	 * Check whether the worm can turn by the given angle.
	 * 
	 * @param	turnByAngle
	 * 			The angle by which this worm will be turned.
	 * @pre		The representative angle of the given angle to turn by is not zero.
	 * 		|	convertToRepresentativeAngle(turnByAngle) != 0
	 * @return	True if and only if the current number of action points is not smaller than the amount of action points required to turn the worm by the given angle.
	 * 		|	result == (numberOfActionPoints >= amountOfActionPointsForTurning(turnByAngle))
	 */
	public boolean canTurn(double turnByAngle){
		return (numberOfActionPoints >= amountOfActionPointsForTurning(turnByAngle));
	}

	/**
	 * Turn the direction of this worm by the given angle.
	 * 
	 * @param 	turnByAngle
	 * 			The angle by which this worm will be turned.
	 * @post	The new direction of this worm is similar to the old direction incremented with the given angle
	 * 			and is equal to its smallest representative angle that lies between zero and 2*pi, excluding the latter.
	 * 		|	new.getDirection() == convertToRepresentativeAngle(this.getDirection() + turnByAngle)
	 */
	private void turn(double turnByAngle){
		setDirection(convertToRepresentativeAngle(direction + turnByAngle));
	}
	
	/**
	 * Turn this worm while paying the appropriate amount of action points.
	 * 
	 * @param 	turnByAngle
	 * 			The angle by which this worm will be turned.
	 * @pre		This worm can turn by the given angle.
	 * 		|	this.canTurn(turnByAngle)
	 * @post	The new number of action points equals the old number of action points reduced with the amount of action points to be paid for turning by the given angle.
	 * 		|	new.getNumberOfActionPoints() == this.getNumberOfActionPoints - amountOfActionPointsForTurning(turnByAngle)
	 * @post	The new direction of this worm is similar to the old direction incremented with the given angle
	 * 			and is equal to its smallest representative angle that lies between zero and 2*pi, excluding the latter.
	 * 		|	new.getDirection() == convertToRepresentativeAngle(this.getDirection() + turnByAngle)
	 */
	public void activeTurn(double turnByAngle){
		turn(turnByAngle);
		setNumberOfActionPoints(numberOfActionPoints - amountOfActionPointsForTurning(turnByAngle));
	}
}
