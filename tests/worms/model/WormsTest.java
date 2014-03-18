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
 * Variable referencing a mutable worm.
 */
private static Worm worm1;

/**
 * Variables referencing immutable worms.
 */
private static Worm worm3, worm4;

/**
 * Set up a mutable test fixture
 * 
 * @post 	The variable worm1 references the following new worm:
 *		 	worm1 is named Rocky and has a radius of 2, direction of 3.045 and position (0,0)
 */
@Before
public void setUpMutableFixture() throws Exception {
	worm1 = new Worm("Rocky", 2, 3.045, 0, 0);
}

/**
 * Set up a immutable test fixture
 * 
 * @post	The variables worm3 and worm4 reference the following new worms respectively:
 *		 	worm3 is named Rambo and has a radius of 6, direction of 1 and position (5,4)
 *			worm4 is named Tarzan and has a radius of 3, direction of 4.5 and position (10,9)
 */
@BeforeClass
public static void setUpImmutableFixture() throws Exception {
	worm3 = new Worm("Rambo",6,1,5,4);
	worm4 = new Worm("Tarzan",3,4.5,10,9);	
}

@Test
public void constructor_LegalCase() throws Exception {
	Worm myWorm = new Worm("Franck \"The tanck\" 'O Riley",4,3,2,1);
	assertEquals("Franck \"The tanck\" 'O Riley",myWorm.getName());
	assertEquals(4,myWorm.getRadius(),Util.DEFAULT_EPSILON);
	assertEquals(3,myWorm.getDirection(),Util.DEFAULT_EPSILON);
	assertEquals(2,myWorm.getX(),Util.DEFAULT_EPSILON);
	assertEquals(1,myWorm.getY(),Util.DEFAULT_EPSILON);
}

@Test (expected = IllegalArgumentException.class)
public void constructor_NameWithoutCapitalLetter() throws Exception {
	new Worm("joske",4,3,2,1);
}

@Test (expected = IllegalArgumentException.class)
public void constructor_NameWithInvalidCharacters() throws Exception {
	new Worm("Joske!",4,3,2,1);
}

@Test (expected = IllegalArgumentException.class)
public void constructor_RadiusTooSmall() throws Exception {
	new Worm("Joske",0.1,3,2,1);
}

@Test
public void constructor_DirectionNotBetweenZeroAnd2Pi() throws Exception {
	Worm myWorm = new Worm("Joske",4,(3 * Math.PI),2,1);
	assertEquals(Math.PI,myWorm.getDirection(),Util.DEFAULT_EPSILON);
}

@Test
public void getName() {
	assertEquals("Rambo", worm3.getName());
}

@Test
public void setName_LegalCase() throws Exception {
	worm1.setName("Wormpje");
	assertEquals("Wormpje", worm1.getName());
}

@Test (expected = IllegalArgumentException.class)
public void setName_NoCapitalLetter() throws Exception {
	worm3.setName("wormpje");
}

@Test (expected = IllegalArgumentException.class)
public void setName_InvalidCharacters() throws Exception {
	worm3.setName("Wormpje!");
}

@Test
public void getRadius() {
	assertEquals(6, worm3.getRadius(), Util.DEFAULT_EPSILON);
}

@Test
public void getLowerBoundOfRadius() {
	assertEquals(0.25, worm3.getLowerBoundOfRadius(), Util.DEFAULT_EPSILON);
}

@Test
public void setRadius_LegalCase() throws Exception {
	worm1.setRadius(3);
	assertEquals(3, worm1.getRadius(), Util.DEFAULT_EPSILON);
}

@Test (expected = IllegalArgumentException.class)
public void setRadius_RadiusTooSmall() throws Exception {
	worm1.setRadius(0.1);
	assertEquals(2, worm1.getRadius(), Util.DEFAULT_EPSILON);
}

@Test
public void getX() {
	assertEquals(5, worm3.getX(), Util.DEFAULT_EPSILON);
}

@Test
public void getY() {
	assertEquals(4, worm3.getY(), Util.DEFAULT_EPSILON);
}

@Test
public void getDirection() {
	assertEquals(1, worm3.getDirection(), Util.DEFAULT_EPSILON);
}

@Test
public void getMass() {
	assertEquals(960874.9626563597, worm3.getMass(), Util.DEFAULT_EPSILON);
}

@Test
public void getMaxNumberOfActionPoints() {
	assertEquals(960875, worm3.getMaxNumberOfActionPoints(), Util.DEFAULT_EPSILON);
}

@Test
public void getNumberOfActionPoints() {
	assertEquals(960875, worm3.getNumberOfActionPoints(), Util.DEFAULT_EPSILON);
}

@Test
public void canMove_LegalCaseTrue() throws Exception {
	assertTrue(worm3.canMove(5));	
}

@Test
public void canMove_LegalCaseFalse() throws Exception {
	assertFalse(worm3.canMove(Integer.MAX_VALUE - 1000));
}

@Test (expected = IllegalArgumentException.class)
public void canMove_NegativeNumberOfSteps() throws Exception {
	assertFalse(worm3.canMove(-1));
}

@Test
public void activeMove_LegalCase() throws Exception {
	worm1.activeMove(5);
	assertEquals(-9.9533855557, worm1.getX(), Util.DEFAULT_EPSILON);
	assertEquals(0.964425198, worm1.getY(), Util.DEFAULT_EPSILON);
	assertEquals(35578, worm1.getNumberOfActionPoints(), Util.DEFAULT_EPSILON);
}

@Test (expected = IllegalArgumentException.class)
public void activeMove_NegativeNumberOfSteps() throws Exception {
	worm3.activeMove(-5);
}

@Test (expected = UnsupportedOperationException.class)
public void activeMove_CannotMove() throws Exception {
	worm3.activeMove(Integer.MAX_VALUE - 1000);
}

@Test
public void canTurn_LegalCaseTrue() {
	assertTrue(worm3.canTurn(2));	
}

@Test
public void canTurn_LegalCaseFalse() {
	worm1.jump();
	assertTrue(worm1.canTurn(2));	
}

@Test
public void activeTurn_LegalCase() {
	worm1.activeTurn(1.5);
	assertEquals(4.545, worm1.getDirection(), Util.DEFAULT_EPSILON);
	assertEquals(35573, worm1.getNumberOfActionPoints());
}

@Test
public void activeTurn_CannotTurn() {
	for (int i = 1; i < 4; i++){
	if (worm1.canTurn(Math.PI)){
	worm1.activeTurn(Math.PI);}}
	assertEquals(4, worm1.getDirection(), Util.DEFAULT_EPSILON);
	assertEquals(10, worm1.getNumberOfActionPoints());
}

@Test
public void jumpTime(){
	assertEquals(0.1456145734, worm3.jumpTime(), Util.DEFAULT_EPSILON);
}

@Test
public void jumpStep(){
	assertEquals(14.78575087, worm3.jumpStep(2.0));
}

@Test
public void Jump_LegalCase() throws Exception {
	worm1.jump();
	assertEquals(-1.073007217, worm1.getX(), Util.DEFAULT_EPSILON);
	assertEquals(0, worm1.getNumberOfActionPoints());
	assertEquals(0, worm1.getY(), Util.DEFAULT_EPSILON);	
}

@Test (expected = UnsupportedOperationException.class)
public void Jump_CannotJump() throws Exception {
	worm4.jump();
}

}
