package worms.model;

/**
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
	
	int xCoordinate;
	int yCoordinate;
	
	long direction;
	
	double radius;
	
	double mass;
	
	double rho;
	
	double lowerBoundOfRadius;
	
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
	public void calculateRho(double radius) throws IllegalArgumentException{
		if (this.canHaveAsRadius(radius) == true)
			setRho(1062 / Math.pow(radius, 3));
		else
			throw new IllegalArgumentException ("Too small radius");
	}
	
	public void setRho(double rho){
		this.rho = rho;
	}
	
	public void calculateMass(double radius, double rho){
		if (this.canHaveAsRadius(radius) == true)
	setMass(rho * (4 / 3) * Math.PI * Math.pow(radius, 3));	
		else
			throw new IllegalArgumentException("Too small radius");
	}
	 
	public void setMass(double mass){
		this.mass = mass;
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
	
	
	
	

}
