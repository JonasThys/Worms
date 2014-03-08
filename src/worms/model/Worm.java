package worms.model;

import be.kuleuven.cs.som.annotate.Basic;

/**
 * 
 * A class of worms involving a X and Y coordinate, a direction, a radius, a mass, a rho
 * 
 * @version 1.0
 * @author Jonas Thys en Jeroen Reinenbergh
 * 
 */

public class Worm {
	
	/**
	 * @param 	xCoordinate
	 * 			The x-coordinate of the worm's position.
	 * @param	yCoordinate
	 * 			The y-coordinate of the worm's position.
	 * @param	direction
	 * 			The direction which the worm faces.
	 * 
	 * 
	 * 
	 */
	
	double x;
	double y;
	
	double direction;
	
	double radius;
	
	double mass;
	
	double lowerBoundOfRadius;
	
	int numberOfActionPoints;
	
	int maxNumberOfActionPoints;
	
	
	
	
	/**
	 * 
	 *  Initialize this new worm with a given radius and starting direction and given X and Y coordinates. 
	 * 
	 * @param 	radius
	 * @param 	direction
	 * @param 	x
	 * @param 	y
	 * 
	 * @post 	The new radius of this worm is equal to the given radius.
	 * 		|	new.getRadius() = radius
	 * @post 	The new direction of this worm is equal to the given direction.
	 * 		|	new.getDirection() = direction
	 * @post 	The new x of this worm is equal to the given x.
	 * 		|	new.getX() = x
	 * @post 	The new y of this worm is equal to the given y.
	 * 		|	new.getY() = y
	 * @throws 	IllegalArgumentException("Too small radius")
	 * 			This worm can't have a radius which is too small.
	 * 		|	! canHaveAsRadius(radius)
	 * 
	 */
	
	public Worm (double radius, double direction, double x, double y, int numberOfActionPoints)throws IllegalArgumentException {
		if (!canHaveAsRadius(radius))
			throw new IllegalArgumentException("Too small radius");
		this.radius = radius;
		this. direction = direction;
		this.x = x;
		this.y = y;
		this.mass = calculateMass();
		this.numberOfActionPoints = numberOfActionPoints;
		calculateMaxNumberOfActionPoints();
		
	}
	
	/**
	 * 
	 * @return 	the X coordinate of the worm
	 * 		|	result == this.getX() = x
	 */
	
	@Basic
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return 	the Y coordinate of the worm
	 * 		|	result == this.getY() = y
	 */
	
	@Basic
	public double getY() {
		return y;
	}

	
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @return 	the direction of the worm
	 * 		|	result == this.getDirection() = direction
	 */
	
	@Basic
	public double getDirection() {
		return direction;
	}

	
	public void setDirection(double direction) {
		this.direction = direction;
	}

	/**
	 * 
	 * @return 	the radius of the worm
	 * 		|	result == this.getRadius() = radius
	 */
	
	@Basic
	public double getRadius() {
		return radius;
	}

	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * 
	 * @return 	the lower bound of the radius of the worm
	 * 		|	result == this.getLowerBoundofRadius() = lowerBoundOfRadius
	 */
	
	@Basic
	public double getLowerBoundOfRadius() {
		return lowerBoundOfRadius;
	}


	public void setLowerBoundOfRadius(double lowerBoundOfRadius) {
		this.lowerBoundOfRadius = lowerBoundOfRadius;
	}

	/**
	 * 
	 * @return 	the mass of the worm
	 * 		|	result == this.getMass() = mass
	 */
	
	@Basic
	public double getMass() {
		return mass;
	}
	
	public void setMass(double mass){
		this.mass = mass;
	}

	@Basic
	public int getNumberOfActionPoints() {
		return numberOfActionPoints;
	}

	public void setNumberOfActionPoints(int numberOfActionPoints) {
		this.numberOfActionPoints = numberOfActionPoints;
	}
	
	@Basic
	public int getMaxNumberOfActionPoints() {
		return maxNumberOfActionPoints;
	}

	public void setMaxNumberOfActionPoints(int maxNumberOfActionPoints) {
		this.maxNumberOfActionPoints = maxNumberOfActionPoints;
	}

	/**
	 * 
	 * @param 	radius
	 * 			The radius relative to a worms position
	 * @post	The homogeneous density will be calculated.
	 * 		|	new.getRho() == rho
	 * @throws	IllegalArgumentException(radius, this)
	 * 		|	! canHaveAsRadius(radius)
	 * 
	 */
	private double calculateRho(double radius) throws IllegalArgumentException{
		if (this.canHaveAsRadius(radius) == true)
			return (1062 / Math.pow(radius, 3));
		else
			throw new IllegalArgumentException ("Too small radius");
	}
	
	/**
	 * 
	 * @param 	radius
	 * @return 	Mass of the worm if and only if the radius is not too small for the given worm.
	 * 		|	result == new.getMass = (rho * (4 / 3) * Math.PI * Math.pow(radius, 3))
	 * @throws	IllegalArgumentException
	 * 		|	! canHaveAsRadius(radius)
	 */
	
	public double calculateMass() throws IllegalArgumentException {
		double rho = calculateRho(radius);
		if (this.canHaveAsRadius(radius)){
			return (rho * (4 / 3) * Math.PI * Math.pow(radius, 3));}			
		else 
			throw new IllegalArgumentException("Too small radius");
	}
		
	public void changeNumberOfActionPoints(int usedActionPoints){
		setNumberOfActionPoints((numberOfActionPoints - usedActionPoints));
	}
	
	/**
	 * 
	 * @param 	radius
	 * @return	True if and only if the radius of the worm is bigger than .25m.
	 * 		|	result == this.canHaveAsRadius(radius)
	 */
	
	public boolean canHaveAsRadius(double radius){
		if (radius > lowerBoundOfRadius)
			return true;
		else 
			return false;
	}
	/**
	 * 
	 * @return	maxNumberOfActionPoints if and only if the mass of the worm exists.
	 */
	
	
	public void calculateMaxNumberOfActionPoints(){
		int roundedMass = 0;
		if (this.getMass() == 0.00 || this.getMass() < 0.00)
			setMaxNumberOfActionPoints(roundedMass);  
		else roundedMass = (int) Math.round(this.getMass());
			setMaxNumberOfActionPoints(roundedMass);
	}
	/**
	 * 
	 * @param	numberOfSteps
	 * @throws 	IllegalArgumentException
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
	 * @param	turnByAngle
	 * @pre		
	 *
	 */
	public void turn(double turnByAngle){
		setDirection(direction + turnByAngle);
	}
	
	public void payAmountOfActionPointsForMoving(int numberOfSteps ){
		setNumberOfActionPoints(numberOfActionPoints - numberOfSteps * ( (int) Math.ceil(Math.cos(direction) + 4 * Math.sin(direction))));
	}
	
	public void payAmountOfActionPointsForTurning(double turnByAngle){
		setNumberOfActionPoints(numberOfActionPoints - (int) Math.ceil((turnByAngle ) * (60/ 2 * Math.PI)));
	}
	
	public void takeActiveStep(int numberOfSteps){
		move(numberOfSteps);
		payAmountOfActionPointsForMoving(numberOfSteps);
	}
	
	public void takeActiveTurn( double turnByAngle){
		turn(turnByAngle);
		payAmountOfActionPointsForTurning(turnByAngle);
	}
}
