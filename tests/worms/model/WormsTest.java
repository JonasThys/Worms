package worms.model;


import static org.junit.Assert.*;

import org.junit.*;


/**
 * 
 * A class collecting tests for the class of worms.
 * 
 * @versio 1.0
 * @author Jonas Thys and Jeroen Reinenbergh
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
 *		 worm1 is named Jonas and has a radius of 2, direction of 3.045, and postion (0,0)
 *		 worm2 is named Jeroen and has a radius of 0.25, direction of 4, and postion (2,1.75)
 *		 worm3 is named Fred and has a radius of 10, direction of -2.3, and postion (-3.75,-1.5)
 * 
 */
@Before
public void setUpMutableFixtures(){
	worm1 = new Worm("Jonas", 2, 3.045, 0, 0);
	worm2 = new Worm("Jeroen", 0.5, 4, 2, 1.75);
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
@Test
public void setInvalidName(){
	worm1.setName("jonas");
	assertEquals("Jonas",worm1.getName());
	
}

/**
 * A method to test the method to set a valid radius for the worm.
 */
@SuppressWarnings("deprecation")
@Test
public void setValidRadius(){
	worm1.setRadius(3);
	assertEquals(3, worm1.getRadius());
}

/**
 * A method to test the method to set an invalid radius for the worm.
 */
@SuppressWarnings("deprecation")
@Test
public void setInvalidRadius(){
	worm1.setRadius(.1);
	assertEquals(2, worm1.getRadius());
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
@Test
public void canMoveWithNegativeNumberOfSteps(){
	assertFalse(worm1.canMove(-1));
}

/**
 * A method to test the method whether the worm can move with a too big number of steps.
 */
@Test
public void canMoveWithTooBigNumberOfSteps(){
	assertFalse(worm1.canMove(17795));
}

/**
 * A method to test the method to do a valid move of the worm.
 */
@SuppressWarnings("deprecation")
@Test
public void activeValidMove(){
	worm1.activeMove(5);
	assertEquals(-9.9533855557, worm1.getX());
	assertEquals(.964425198, worm1.getY());
	assertEquals(35578, worm1.getNumberOfActionPoints());
}
/**
 * A method to test the method to do a move of the worm with a too big number of steps.
 */
@SuppressWarnings("deprecation")
@Test
public void activeTooBigMove(){
	worm1.activeMove(17795);
	assertEquals(0.0, worm1.getX());
	assertEquals(0.0, worm1.getY());
	assertEquals(35588, worm1.getNumberOfActionPoints());
}

/**
 * A method to test the method to do a move of the worm with a negative number of steps.
 */
@SuppressWarnings("deprecation")
@Test
public void activeNegativeMove(){
	worm1.activeMove(-5);
	assertEquals(0.0, worm1.getX());
	assertEquals(0.0, worm1.getY());
	assertEquals(35588, worm1.getNumberOfActionPoints());
}

/**
 * A method to test the method to do a valid turn of the worm.
 */
@SuppressWarnings("deprecation")
@Test
public void activeValidTurn(){
	worm1.activeTurn(1.5);
	assertEquals(4.545, worm1.getDirection());
	assertEquals(35573, worm1.getNumberOfActionPoints());
}

/**
 * A method to test the method to do a turn of the worm which costs too much action points.
 */
@Test
public void activeTooExpensiveTurn(){
}

/**
 * A method to test the method to return the worm's time after a jump.
 */
@SuppressWarnings("deprecation")
@Test
public void jumpValidTime(){
	assertEquals(.1456145734, worm1.jumpTime());
}

/**
 * A method to test the method to return the worm's coordinates during a specific time of its jump.
 */
@Test
public void jumpValidStep(){
	assertEquals(-14.737635, worm1.jumpStep(2.0));
}

/**
 * A method to test the method to do an invalid jump of the worm.
 */
@SuppressWarnings("deprecation")
@Test
public void invalidJump(){
	worm2.jump();
	assertEquals(2, worm2.getX());
	assertEquals(70, worm2.getNumberOfActionPoints());
	assertEquals(1.75, worm2.getY());	
}

/**
 * A method to test the method to do a valid jump of the worm.
 */
@SuppressWarnings("deprecation")
@Test
public void validJump(){
	worm1.jump();
	assertEquals(-1.073007217, worm1.getX());
	assertEquals(0, worm1.getNumberOfActionPoints());
	assertEquals(0, worm1.getY());	
}

}
