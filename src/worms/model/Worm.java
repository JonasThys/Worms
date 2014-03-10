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
	public static boolean isPossibleName(String name) {
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
	public void setX(double x) {
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
	public void setY(double y) {
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
	 * @post	The new direction of this worm is equal to the given direction.
	 * 		|	new.getDirection() == direction
	 */
	public void setDirection(double direction) {
		this.direction = direction;
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
	public boolean isPossibleRadius(double radius){
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
	private int getMaxNumberOfActionPoints(){
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
	public void setNumberOfActionPoints(int numberOfActionPoints) throws IllegalArgumentException {
		if(numberOfActionPoints < 0)
			numberOfActionPoints = 0;
		else if(numberOfActionPoints > this.getMaxNumberOfActionPoints())
			numberOfActionPoints = this.getMaxNumberOfActionPoints();
		this.numberOfActionPoints = numberOfActionPoints;
	}
	
	/**
	 * Variable registering the current number of action points of this worm.
	 */	
	int numberOfActionPoints;
		


	


	/**
	 * 
	 * @param	numberOfSteps
	 * 			The number of steps to be taken in this direction.
	 * @post	The new X-coordinate of the worm is equal to the old X-coordinate plus the cosinus of the direction, multiplied by the number of steps.
	 * 		|	new.getX() == this.getX() + Math.cos(direction)*numberOfSteps
	 * @post	The new Y-coordinate of the worm is equal to the old Y-coordinate plus the cosinus of the direction, multiplied by the number of steps.
	 * 		|	new.getY() == this.getY() + Math.sin(direction)*numberOfSteps
	 * @throws 	IllegalArgumentException("Number of steps is too small!")
	 * 			The given number of steps is smaller than or equal to zero.
	 * 		|	! numberOfSteps > 0
	 */
	public void move(int numberOfSteps) throws IllegalArgumentException {
		if (numberOfSteps > 0)
			for (int i=1; i	< numberOfSteps + 1; i++){
				setX(x + Math.cos(direction));
				setY(y + Math.sin(direction));
			}
		else throw new IllegalArgumentException("You didn't move the worm");
	}
		
	
	/**
	 * 
	 * @param 	turnByAngle
	 * @pre		The given angle should be different from zero.
	 * 		|	! turnByAngle == 0
	 * @post	The new direction is equal to the old direction plus the given angle.
	 * 		|	new.getDirection() == this.getDirection() + turnByAngle
	 */
	public void turn(double turnByAngle){
		assert  turnByAngle > 0 || turnByAngle < 0;
		setDirection(direction + turnByAngle);
	}
	
	/**
	 * 
	 * @param 	numberOfSteps
	 * @post	The new number of action points equals the old number of action points reduced with the number of steps times the weighted direction.
	 * 		|	new.getNumberOfActionPoints() == this.getNumberOfActionPoints - numberOfSteps*(Math.cos(direction) + 4 * Math.sin(direction))
	 * @throws 	IllegalArgumentException("Number of steps is too small!")
	 * 			The given number of steps is smaller than or equal to zero.
	 * 		|	! numberOfSteps > 0
	 */
	public void payAmountOfActionPointsForMoving(int numberOfSteps ) throws IllegalArgumentException {
		if (numberOfSteps > 0)
		setNumberOfActionPoints(numberOfActionPoints - numberOfSteps * ( (int) Math.ceil(Math.cos(direction) + 4 * Math.sin(direction))));
		else throw new IllegalArgumentException("You didn't move the worm");
	}
	
	
	/**
	 * 
	 * @param 	turnByAngle
	 * @pre		The given angle should be different from zero.
	 * 		|	! turnByAngle == 0
	 * @post	The new direction is equal to the old direction plus the given angle.
	 * 		|	new.getDirection() == this.getDirection() + turnByAngle	
	 * 
	 */
	public void payAmountOfActionPointsForTurning(double turnByAngle){
		assert  turnByAngle > 0 || turnByAngle < 0;
		setNumberOfActionPoints(numberOfActionPoints - (int) Math.ceil((turnByAngle ) * (60/ 2 * Math.PI)));
	}
	
	
	/** @param 	numberOfSteps
	 * @post	The new number of action points equals the old number of action points reduced with the number of steps times the weighted direction.
	 * 		|	new.getNumberOfActionPoints() == this.getNumberOfActionPoints - numberOfSteps*(Math.cos(direction) + 4 * Math.sin(direction))
	 * @throws 	IllegalArgumentException("Number of steps is too small!")
	 * 			The given number of steps is smaller than or equal to zero.
	 * 		|	! numberOfSteps > 0
	 */
	public void takeActiveStep(int numberOfSteps) throws IllegalArgumentException {
		if (numberOfSteps > 0){
		move(numberOfSteps);
		payAmountOfActionPointsForMoving(numberOfSteps);}
		
		else {
				throw new IllegalArgumentException("You didn't move the worm");
		}
		
	}
	
	
	/**
	 * 
	 * @param 	turnByAngle
	 * @pre		The given angle should be different from zero.
	 * 		|	! turnByAngle == 0
	 * @post	The new direction is equal to the old direction plus the given angle.
	 * 		|	new.getDirection() == this.getDirection() + turnByAngle	
	 * 
	 */
	public void takeActiveTurn( double turnByAngle){
		assert  turnByAngle > 0 || turnByAngle < 0;{
			turn(turnByAngle);
			payAmountOfActionPointsForTurning(turnByAngle);
		}
	}
}
