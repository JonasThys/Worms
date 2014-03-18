package worms.model;


import static org.junit.Assert.*;

import org.junit.*;

import worms.util.Util;


/**
 * 
 * A class collecting tests for the class of worms.
 * 
 * @version 1.0
 * @author Jonas Thys & Jeroen Reinenbergh
 * 
 *
 */

public class WormsTest {
	
/**
 * Variables referencing worms
 * 
 */
private static Worm worm1, worm2, worm3;


/**
 * 
 * Set up a mutable test fixture
 * 
 * @post The variables worm1, worm2, worm3 reference to new worms.
 *		 worm1 is named Jonas and has a radius of 2, direction of 3.045, and position (0,0)
 *		 worm2 is named Jeroen and has a radius of 0.25, direction of 4, and position (2,1.75)
 *		 worm3 is named Fred and has a radius of 10, direction of -2.3, and position (-3.75,-1.5)
 * 
 */
@Before
public void setUpMutableFixtures(){
	worm1 = new Worm("Jonas", 2, 3.045, 0, 0);
	worm2 = new Worm("Jeroen", 0.25, 4, 2, 1.75);
	worm3 = new Worm("Fred", 10, -2.3, -3.75, -1.5);
	
}


/**
 * A method to test the method to set a valid name for the worm. 
 */
@Test
public void setValidName(){
	worm1.setName("Wormpje");
	assertEquals("Wormpje", worm1.getName());
}
/**
 * A method to test the method to set an invalid name for the worm.
 */
@Test(expected= IllegalArgumentException.class)
public void setInvalidName(){
	worm1.setName("jonas");
	assertEquals("Jonas",worm1.getName());
	
}

/**
 * A method to test the method to set a valid radius for the worm.
 */

@Test
public void setValidRadius(){
	worm1.setRadius(3);
	assertEquals(3, worm1.getRadius(), Util.DEFAULT_EPSILON);
}

/**
 * A method to test the method to set an invalid radius for the worm.
 */

@Test(expected= IllegalArgumentException.class)
public void setInvalidRadius(){
	worm1.setRadius(0.1);
	assertEquals(2, worm1.getRadius(), Util.DEFAULT_EPSILON);
}

/**
 * A method to test the method whether the worm can move or not with a valid input.
 */
@Test
public void canMoveWithValidNumberOfSteps(){
	assertTrue(worm1.canMove(5));
	
}

/**
 * A method to test the method whether the worm can move or not with a negative number of steps.
 */
@Test(expected= IllegalArgumentException.class)
public void canMoveWithNegativeNumberOfSteps(){
	assertFalse(worm1.canMove(-1));
}

/**
 * A method to test the method whether the worm can move with a too big number of steps.
 */
@Test
public void canMoveWithTooBigNumberOfSteps(){
	assertFalse(worm1.canMove(Integer.MAX_VALUE));
}

/**
 * A method to test the method to do a valid move of the worm.
 */

@Test
public void activeValidMove(){
	worm1.activeMove(5);
	assertEquals(-9.9533855557, worm1.getX(), Util.DEFAULT_EPSILON);
	assertEquals(.964425198, worm1.getY(), Util.DEFAULT_EPSILON);
	assertEquals(35578, worm1.getNumberOfActionPoints(), Util.DEFAULT_EPSILON);
}
/**
 * A method to test the method to do a move of the worm with a too big number of steps.
 */

@Test
public void activeTooBigMove(){
	worm1.activeMove(Integer.MAX_VALUE);
	//assertEquals(0.0, worm1.getX(), Util.DEFAULT_EPSILON);
	//assertEquals(0.0, worm1.getY(), Util.DEFAULT_EPSILON);
	assertEquals(35588, worm1.getNumberOfActionPoints());
}

/**
 * A method to test the method to do a move of the worm with a negative number of steps.
 */

@Test(expected= IllegalArgumentException.class)
public void activeNegativeMove(){
	worm1.activeMove(-5);
	assertEquals(0, worm1.getX(), Util.DEFAULT_EPSILON);
	assertEquals(0, worm1.getY(), Util.DEFAULT_EPSILON);
	assertEquals(35588, worm1.getNumberOfActionPoints());
}

/**
 * A method to test the method to do a valid turn of the worm.
 */

@Test
public void activeValidTurn(){
	worm1.activeTurn(1.5);
	assertEquals(4.545, worm1.getDirection(), Util.DEFAULT_EPSILON);
	assertEquals(35573, worm1.getNumberOfActionPoints());
}

/**
 * A method to test the method to do a turn of the worm which costs too much action points.
 */
@Test
public void activeTooExpensiveTurn(){
	for (int i = 1; i < 4; i++){
	if (worm2.canTurn(Math.PI)){
	worm2.activeTurn(Math.PI);}}
	assertEquals(4, worm2.getDirection(), Util.DEFAULT_EPSILON);
	assertEquals(10, worm2.getNumberOfActionPoints());
}


@Test
public void getValidMass(){
	assertEquals(69.50773746, (worm2.getMass()), Util.DEFAULT_EPSILON);
}

/**
 * A method to test the method to return the worm's time after a jump.
 */

@Test
public void jumpValidTime(){
	assertEquals(.1456145734, worm1.jumpTime(), Util.DEFAULT_EPSILON);
}

/**
 * A method to test the method to return the worm's coordinates during a specific time of its jump.
 */
@Test
public void jumpValidStep(){
	assertEquals(14.78575087, worm1.jumpStep(2.0));
}

/**
 * A method to test the method to do an invalid jump of the worm.
 */

@Test(expected= UnsupportedOperationException.class)
public void invalidJump(){
	worm2.jump();
	assertEquals(2, worm2.getX(), Util.DEFAULT_EPSILON);
	assertEquals(70, worm2.getNumberOfActionPoints());
	assertEquals(1.75, worm2.getY(), Util.DEFAULT_EPSILON);	
}

/**
 * A method to test the method to do a valid jump of the worm.
 */

@Test
public void validJump(){
	worm1.jump();
	assertEquals(-1.073007217, worm1.getX(), Util.DEFAULT_EPSILON);
	assertEquals(0, worm1.getNumberOfActionPoints());
	assertEquals(0, worm1.getY(), Util.DEFAULT_EPSILON);	
}

}
