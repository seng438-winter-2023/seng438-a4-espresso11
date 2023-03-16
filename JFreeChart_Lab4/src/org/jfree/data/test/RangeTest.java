package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest{

private Range testRange;


private Range exampleRange;

private Range exampleRange11;

private Range exampleRange2;

private Range rangeN;

private Range rangeZ;

private Range rangeP;

private Range range;

private Range rangeC;

private Range rangeDoub;

private Range range1, range2;

private String x,y;







@BeforeClass public static void setUpBeforeClass() throws Exception {

}

@Before

public void setUp() throws Exception {

testRange = new Range(-4, 8);
exampleRange11 = new Range(-10, 10);

exampleRange = new Range(-1, 1);

exampleRange2 = new Range(-1, -1);//size zero


rangeN = new Range(-10, 1); // range for negative lower bound

rangeZ = new Range(0, 0); // range for lower and upper bound being 0

rangeP = new Range(1, 10); // range for positive lower bound

rangeDoub = new Range(2.5, 5.0); // range for double values

range = new Range(10, 50); //create range from 10 to 100

rangeC = new Range(5, 20);// new range from 5 to 20

x = new String("String");
y = new String("String");


}


// constrain() test cases

/*if the input number is lower than the lower boundary of the range than the constrain should be the lower boundary*/

@Test

public void numberLowerThanLowerBoundary() {

assertEquals("The constrain value of -5 in the range of -1 and 1 should be -1)",-1,exampleRange.constrain(-5), 0.000001d);

}


/*if the input number is lower than the lower boundary of a range of zero than the constrain should be the lower boundary*/

@Test

public void numberLowerThanLowerBoundaryWithRangeZero() {

assertEquals("The constrain value of -5 in the range of -1 and -1 should be -1)",-1,exampleRange2.constrain(-5), 0.000001d);

}


/*if the input number is higher than the upper boundary of the range than the constrain should be the upper boundary*/

@Test

public void numberHigherThanUpperBoundary() {

assertEquals("The constrain value of 5 in the range of -1 and 1 should be 1)",1,exampleRange.constrain(5), 0.000001d);

}


/*if the input number is higher than the upper boundary of a range of zero than the constrain should be the upper boundary*/

@Test

public void numberHigherThanUpperBoundaryWithRangeZero() {

assertEquals("The constrain value of 5 in the range of -1 and -1 should be -1)",-1,exampleRange2.constrain(-5), 0.000001d);

}


/*if the input number is within the range than the constrain should be the input*/

@Test

public void numberWithinRange() {

assertEquals("The constrain value of 0 in the range of -1 and 1 should be 0)",0,exampleRange.constrain(0), 0.000001d);

}


/*if the input number is equal to the lower boundary of the range than the constrain should be the input/lower boundary*/

@Test

public void numberIsLowerBoundary() {

assertEquals("The constrain value of -1 in the range of -1 and 1 should be -1)",-1,exampleRange.constrain(-5), 0.000001d);

}


/*if the input number is equal to the upper boundary of the range than the constrain should be the input/upper boundary*/

@Test

public void numberIsUpperBoundary() {

assertEquals("The constrain value of 1 in the range of -1 and 1 should be 1)",1,exampleRange.constrain(1), 0.000001d);

}


// getLength() test cases

// pass: returns the correct length

@Test

public void getLengthValidOutput() {

assertEquals("The length of the range from -4 to 8 should be 12",

12, testRange.getLength(), .000000001d);

}




// combine() test cases

/*first range is null*/

@Test

public void firstRangeNull() {

assertEquals("The combination of null range and range[-1,1] should be [-1,1]",new Range(-1,1),Range.combine(null,(new Range(-1,1))));

}


/*second range is null*/

@Test

public void secondRangeNull() {

assertEquals("The combination of range[-1,1] and null range should be [-1,1]",new Range(-1,1),Range.combine((new Range(-1,1)),null));

}


/*both ranges are null*/

@Test

public void bothRangeNull() {

assertEquals("The combination of two null ranges should be null",null,Range.combine(null,null));

}


/*identical ranges*/

@Test

public void identicalRanges() {

assertEquals("The combination of range[-1,1] and range[-1,1] should be [-1,1]",new Range(-1,1),Range.combine((new Range(-1,1)),(new Range(-1,1))));

}


/*ranges are continuous*/

@Test

public void continuousRanges() {

try{

assertEquals("The combination of range[-1,1] and range[1,2] should be [-1,2]",new Range(-1,2),Range.combine((new Range(-1,1)),(new Range(1,2))));

}

catch(Exception e) {

fail(" continuousRanges should not have an error but we get "+ e.getClass() + e.getMessage());

}

}


/*ranges are not continuous*/

@Test

public void notContinuousRanges() {

try {

assertEquals("The combination of range[-1,1] and range[5,10] should be [-1,10]",new Range(-1,10),Range.combine((new Range(-1,1)),(new Range(5,10))));

}

catch(Exception e) {

fail(" notContinuousRanges should not have an error but we get "+ e.getClass() + e.getMessage());

}

}


// getLowerBound() test

@Test

public void testNegativeNumberForLowerBound() { // Lower bound being a negative number

assertEquals("The value of lower bound should return -10",-10, rangeN.getLowerBound(), .000000001d);

}


@Test

public void testZeroForLowerBound() { // Lower bound being at 0

assertEquals("The value of lower bound should return 0", 0, rangeZ.getLowerBound(), .000000001d);

}


@Test

public void testPositiveNumberForLowerBound() { // Lower bound being a positive number

assertEquals("The value of lower bound should return 1", 1, rangeP.getLowerBound(), .000000001d);

}

@Test

public void testDoubleForLowerBound() { // Lower bound being a double

assertEquals("The value of lower bound should return 2.5", 2.5, rangeDoub.getLowerBound(), .000000001d);

}


// getUpperBound() test cases

@Test

public void testNegativeNumberForUpperBound() { // Upper bound being a negative number

assertEquals("The value of upper bound should return 1", 1, rangeN.getUpperBound(), .000000001d);

}

// Test has a failure, the upper bound is not returned

// Test passes for the value of the lower bound


@Test

public void testZeroForUpperBound() { // Upper bound being at 0

assertEquals("The value of upper bound should return 0", 0, rangeZ.getUpperBound(), .000000001d);

}

// Test passes only because lower bound == upper bound == 0


@Test

public void testPositiveNumberForUpperBound() { // Upper bound being a positive number

assertEquals("The value of upper bound should return 10", 10, rangeP.getUpperBound(), .000000001d);

}

// Test has a failure, the upper bound is not returned

// Test passes for the value of the lower bound


@Test

public void testDoubleForUpperBound() { // Upper bound being a double

assertEquals("The value of upper bound should return 5.0", 5.0, rangeDoub.getUpperBound(), .000000001d);

}

// Test has a failure, the upper bound is not returned

// Test passes for the value of the lower bound





// shift(Range base, double delta, boolean allowZeroCrossing)


//should pass

@Test

public void testingPositiveToZeroWithTrue() {
	Range origRange = new Range(3.0, 3.0);
	Range rangeShift = Range.shift(origRange, -3.0, true);
  Range expected = new Range(0.0, 0.0);
  assertTrue("A shift of -3 should return a range of (0, 0)",
          rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingPositiveToZeroWithFalse() {
	Range origRange = new Range(3.0, 3.0);
	Range rangeShift = Range.shift(origRange, -3.0, false);
Range expected = new Range(0.0, 0.0);
assertTrue("A shift of -3 should return a range of (0, 0)",
        rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingPositiveToNegativeWithTrue() {
	Range origRange = new Range(3.0, 3.0);
	Range rangeShift = Range.shift(origRange, -5.0, true);
    Range expected = new Range(-2.0, -2.0);
    assertTrue("A shift of -5 should return a range of (0, 0)",
            rangeShift.equals(expected));
	
}

// should fail

//@Test


public void testingPositiveToNegativeWithFalse() {
	Range origRange = new Range(3.0, 3.0);
	Range rangeShift = Range.shift(origRange, -5.0, false);
    Range expected = new Range(-2.0, -2.0);
    assertTrue("A shift of -5 should return a range of (0, 0)",
            rangeShift.equals(expected));
	
}

//should pass

@Test


public void testingPositiveToNegativeWithFalseAndZero() {
	Range origRange = new Range(3.0, 3.0);
	Range rangeShift = Range.shift(origRange, -5.0, false);
 Range expected = new Range(0.0, 0.0);
 assertTrue("A shift of -5 should return a range of (0, 0)",
         rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingPositiveToPositiveWithTrue() {
	Range origRange = new Range(3.4, 3.7);
	Range rangeShift = Range.shift(origRange, 5.0, true);
    Range expected = new Range(8.4, 8.7);
    assertTrue("A shift of 5 should return a range of (8.4, 8.7)",
            rangeShift.equals(expected));
	
}

//should fail

//@Test

public void testingPositiveToPositiveWithTrueWrongAnswer() {
	Range origRange = new Range(3.4, 3.7);
	Range rangeShift = Range.shift(origRange, 5.0, true);
  Range expected = new Range(8.4, 8.9);
  assertTrue("A shift of 5 should return a range of (8.4, 8.7)",
          rangeShift.equals(expected));
	
}

//should fail

//@Test

public void testingNegativeToPositiveWithFalse() {
	Range origRange = new Range(-3.0, -2.0);
	Range rangeShift = Range.shift(origRange, 5.0, false);
  Range expected = new Range(2.0, 3.0);
  assertTrue("A shift of 5 should return a range of (0, 0)",
          rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingNegativeToPositiveWithTrue() {
	Range origRange = new Range(-3.0, -2.0);
	Range rangeShift = Range.shift(origRange, 5.0, true);
	Range expected = new Range(2.0, 3.0);
	assertTrue("A shift of 5 should return a range of (2, 3)",
        rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingNegativeToPositiveWithTrueSplitRange() {
	Range origRange = new Range(-3.0, 2.0);
	Range rangeShift = Range.shift(origRange, 5.0, true);
Range expected = new Range(2.0, 7.0);
assertTrue("A shift of 5 should return a range of (2, 7)",
      rangeShift.equals(expected));
	
}

//should fail

//@Test

public void testingNegativeToPositiveWithFalseSplitRange() {
	Range origRange = new Range(-3.0, 2.0);
	Range rangeShift = Range.shift(origRange, 5.0, false);
Range expected = new Range(2.0, 7.0);
assertTrue("A shift of 5 should return a range of (0, 7)",
    rangeShift.equals(expected));
	
}

// should pass

@Test

public void testingNegativeToPositiveWithFalseSplitRangeCorrectAnswer() {
	Range origRange = new Range(-3.0, 2.0);
	Range rangeShift = Range.shift(origRange, 5.0, false);
Range expected = new Range(0.0, 7.0);
assertTrue("A shift of 0 should return a range of (0.0, 7.0)",
    rangeShift.equals(expected));
	
}


//should fail

//@Test

public void testingPositiveToPositiveWithFalseWrongAnswer() {
	Range origRange = new Range(3.4, 3.7);
	Range rangeShift = Range.shift(origRange, 5.0, false);
Range expected = new Range(8.4, 8.9);
assertTrue("A shift of 0 should return a range of (8.4, 8.7)",
        rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingPositiveToPositiveWithFalseCorrectAnswer() {
	Range origRange = new Range(3.4, 3.7);
	Range rangeShift = Range.shift(origRange, 5.3, false);
Range expected = new Range(8.7, 9.0);
assertTrue("A shift of 5.3 should return a range of (8.7, 9.0)",
      rangeShift.equals(expected));
	
}


@Test(expected = IllegalArgumentException.class)
public void shiftTestWithNullRange() {
    Range.shift(null, -3, true);
}


//shift(Range base, double delta)

//should pass

@Test

public void testingPositiveToPositive() {
	Range origRange = new Range(3.4, 3.7);
	Range rangeShift = Range.shift(origRange, 5.3);
Range expected = new Range(8.7, 9.0);
assertTrue("A shift of 5.3 should return a range of (8.7, 9.0)",
    rangeShift.equals(expected));
	
}

// should pass 

@Test

public void testingPositiveToNegative() {
	Range origRange = new Range(3.4, 3.7);
	Range rangeShift = Range.shift(origRange, -5.3);
Range expected = new Range(0.0, 0.0);
assertTrue("A shift of -5.3 should return a range of (0 ,0)",
    rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingPositiveToNegativeSplit() {
	Range origRange = new Range(-3.4, 3.7);
	Range rangeShift = Range.shift(origRange, -5.3);
Range expected = new Range(-8.7, 0.0);
assertTrue("A shift of -5.3 should return a range of (-8.7, 0.0)",
 rangeShift.equals(expected));
	
}

//should fail

//@Test

public void testingPositiveToNegativeSplit1() {
	Range origRange = new Range(3.4, 3.7);
	Range rangeShift = Range.shift(origRange, -5.3);
Range expected = new Range(-1.9, -1.6);
assertTrue("A shift of -5.3 should return a range of (0, 0)",
rangeShift.equals(expected));
	
}

//should fail 

//@Test

public void testingNegativeToPositive() {
	Range origRange = new Range(-3.4, -3.1);
	Range rangeShift = Range.shift(origRange, 5.3);
Range expected = new Range(1.9, 2.2);
assertTrue("A shift of 5.3 should return a range of (0, 0)",
rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingNegativeToPositiveWithCorrectAnswer() {
	Range origRange = new Range(-3.4, -3.1);
	Range rangeShift = Range.shift(origRange, 5.3);
Range expected = new Range(0, 0);
assertTrue("A shift of 5.3 should return a range of (0, 0)",
rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingNegativeToPositiveWithCorrectAnswerSplit() {
	Range origRange = new Range(-3.4, 3.7);
	Range rangeShift = Range.shift(origRange, 5.3);
Range expected = new Range(0, 9);
assertTrue("A shift of 5.3 should return a range of (0, 9)",
rangeShift.equals(expected));
	
}

//should fail

//@Test

public void testingNegativeToPositiveWithWrongAnswerSplit1() {
	Range origRange = new Range(-3.4, 3.7);
	Range rangeShift = Range.shift(origRange, 5.3);
Range expected = new Range(1.9, 9);
assertTrue("A shift of 5.3 should return a range of (0, 9)",
rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingNegativeToZero() {
	Range origRange = new Range(-4.0, -4.0);
	Range rangeShift = Range.shift(origRange, 4.0);
Range expected = new Range(0, 0);
assertTrue("A shift of 4 should return a range of (0, 0)",
rangeShift.equals(expected));
	
}

//should pass

@Test

public void testingPositiveToZero() {
	Range origRange = new Range(4.0, 4.0);
	Range rangeShift = Range.shift(origRange, -4.0);
Range expected = new Range(0, 0);
assertTrue("A shift of -4 should return a range of (0, 0)",
rangeShift.equals(expected));
	
}


// should pass

@Test(expected = IllegalArgumentException.class)
public void shiftTestWithNullRange1() {
    Range.shift(null, -3 );
}


// toString() Tests


//should pass

@Test
public void NegativeAndPosistive() {
	Range range = new Range(-7.0, 3.0);
	String actual = "Range[-7.0,3.0]";
	assertTrue("The string should match Range[-7.0,3.0]", 
			actual.equals(range.toString()));
}

//should pass

@Test
public void PositiveAndPositive() {
	Range range = new Range(2.0, 3.0);
	String actual = "Range[2.0,3.0]";
	assertTrue("The string should match Range[2.0,3.0]", 
			actual.equals(range.toString()));
}

//should pass

@Test
public void NegativeAndNegative() {
	Range range = new Range(-7.0, -3.0);
	String actual = "Range[-7.0,-3.0]";
	assertTrue("The string should match Range[-7.0,-3.0]", 
			actual.equals(range.toString()));
}

//should pass

@Test
public void ZeroAndZero() {
	Range range = new Range(0.0, 0.0);
	String actual = "Range[0.0,0.0]";
	
	assertTrue("The string should match Range[0.0,0.0]", 
				actual.equals(range.toString()));
}

//should fail

//@Test
public void WrongStringFormatGap() {
	Range range = new Range(0.0, 0.0);
	String actual = range.toString();
	assertEquals("The string should match Range[0.0,0.0]", "Range[0.0, 0.0]", actual);
}

//should fail

//@Test
public void WrongStringFormatSpelling() {
	Range range = new Range(0.0, 0.0);
	String actual = range.toString();
	assertEquals("The string should match Range[0.0,0.0]", "Ran[0.0, 0.0]", actual);
}



// intersects() Tests

// should pass

@Test
public void intersectRangeRightSide() {
    
	Range orig = new Range(-2, 3);
	Range test = new Range(-8, 0);
	
	assertTrue(orig.intersects(test));
}

// should pass

@Test
public void intersectRangeLeftSide() {
    
	Range orig = new Range(-2, 3);
	Range test = new Range(-1, 5);
	
	assertTrue(orig.intersects(test));
}


//should pass

@Test
public void intersectRangeBothSides() {
 
	Range orig = new Range(-2, 3);
	Range test = new Range(0, 2);
	
	assertTrue(orig.intersects(test));
}



//should pass


@Test
public void intersectRangeFloatRightSide() {
	Range orig = new Range(-1.9, 3);
	Range test = new Range(-3, -1.7);
	
	assertTrue(orig.intersects(test));
}

//should pass

@Test
public void intersectRangeFloatLeftSide() {
	Range orig = new Range(-2, 2.9);
	Range test = new Range(2.8, 8);
	
	assertTrue(orig.intersects(test));
}



// getCenteralValue() Tests

// should pass

@Test
public void centeralValueCorrectNegativeNegative() {
	Range orig = new Range(-2, -1);
    assertEquals("The centeral value should be -1.5",
    -1.5, orig.getCentralValue(), .000000001d);
}

// should pass

@Test
public void centeralValueCorrectNegativePositive() {
	Range orig = new Range(-2, 3);
    assertEquals("The centeral value should be 0.5",
    0.5, orig.getCentralValue(), .000000001d);
}

//should pass

@Test
public void centeralValueCorrectPositivePositive() {
	Range orig = new Range(2.5, 2.9);
 assertEquals("The centeral value should be 2.7",
 2.7, orig.getCentralValue(), .000000001d);
}

//should fail

//@Test
public void centeralValueWrongPositivePositive() {
	Range orig = new Range(2.5, 2.9);
assertEquals("The centeral value should be 2.7",
2.6, orig.getCentralValue(), .000000001d);
}

//should fail

//@Test
public void centeralValueWrongNegativeNegative() {
	Range orig = new Range(-2, -1);
 assertEquals("The centeral value should be -1.5",
 -1.9, orig.getCentralValue(), .000000001d);
}

//should fail

//@Test
public void centeralValueWrongNegativePositive() {
	Range orig = new Range(-2, 3);
 assertEquals("The centeral value should be 0.5",
 0.0, orig.getCentralValue(), .000000001d);
}

// expandToInclude() Tests

// should pass

@Test
public void expandToIncludeLeftSideCorrect() {
	Range orig = new Range(-1, 1);
    assertEquals("New Range should be (-10, 1)", new Range(-10, 1),
            Range.expandToInclude(orig, -10));
}

//should pass

@Test
public void expandToIncludeRightSideCorrect() {
	Range orig = new Range(-1, 1);
	assertEquals("New Range should be (-1, 2.9)", new Range(-1, 2.9),
          Range.expandToInclude(orig, 2.9));
}

//should pass

@Test
public void NoNeedToExpandToIncludeCorrect() {
	Range orig = new Range(-1, 1);
	assertEquals("New Range should be (-1.0, 1.0)", new Range(-1.0, 1.0),
        Range.expandToInclude(orig, 0.3));
}

//should fail

//@Test
public void expandToIncludeRightSideWrong() {
	Range orig = new Range(-1, 1);
	assertEquals("New Range should be (-1, 7)", new Range(-1, 6),
      Range.expandToInclude(orig, 7));
}

//should fail

//@Test
public void expandToIncludeLeftSideWrong() {
	Range orig = new Range(-1, 1);
	assertEquals("New Range should be (-3, 1)", new Range(-2, 1),
    Range.expandToInclude(orig, -3));
}

//should pass

@Test
public void expandToIncludeLeftSideSame() {
	Range orig = new Range(-1, 1);
assertEquals("New Range should be (-1, 1)", new Range(-1, 1),
  Range.expandToInclude(orig, -1));
}

//should pass

@Test
public void expandToIncludeRightSideSame() {
	Range orig = new Range(-1, 1);
assertEquals("New Range should be (-1, 1)", new Range(-1, 1),
Range.expandToInclude(orig, 1));
}


// expand test

//@Test
public void expandUsingZeroMarginsTest() {
	range1 = new Range(12, 32);
	range2 = new Range(13, 20);
	assertEquals("Used expand with 0 on both ranges but the range changed.", Range.expand(range1, 0, 0), range2);
}

//if null range object is used
@Test
public void nullRange() {
	try {
		Range.expand(null,0.2,0.5);
		fail("InvalidParameterException was not used");
	}
	catch(Exception e) {
		assertEquals("Did not use InvalidParameterException", IllegalArgumentException.class, e.getClass());
	}
}


// Equals test
//if two upper boundaries are same but the lower boundaries are different 
@Test
public void sameUpperBoundary() {
	assertEquals("Testing two Range objects with the same upper boundary but different lower boundaries", false, range.equals(new Range(20, 50)));
}
	
//if two lower boundaries are same but the upper boundaries are different 
@Test
public void  sameLowerBoundary() {
	assertEquals("Testing two Range objects with the same lower boundary but different upper boundaries", false, range.equals(new Range(10, 40)));
}
	
//if two different objects with different ranges are equal
@Test
public void diffRanges() {
	assertEquals("Testing object with two different ranges", false, range.equals(new Range(30, 70)));
}
	
//is two different objects with same ranges are equal
@Test
public void sameRanges() {
	assertEquals("Testing object with two same ranges", true, range.equals(new Range(10, 50)));
}
	
//if null is used
@Test
public void nullRangeEquals() {
	assertEquals("Testing a null range object", false, range.equals(null));
}

//contain Tests

//if the lower boundary is in the range 
@Test
public void inLowerBoundary() {
	assertTrue("The lower boundary is out of the range", this.rangeC.contains(5));
}
	
//if the upper boundary is in the range 
@Test
public void inUpperBoundary() {
	assertTrue("The upper Bound is out of the range", this.rangeC.contains(20));
}
	
//number in between the range
@Test
public void numberInRange() {
	assertTrue("The number is out of the range", this.rangeC.contains(10));
}


// new tests A4

// Range tests

// should pass

@Test
public void ZeroAndZeroCenteral() {
	Range orig = new Range(0, 0);
	 assertEquals("The centeral value should be 0",
	 0, orig.getCentralValue(), .000000001d);
}

@Test
public void intersectRangeNegative() {
	Range range = new Range(-10,-5);
	Range original = new Range(-8, 6); 
	assertTrue("The range -10,-5 should intersect with the range -8,6",
			original.intersects(range));
}

@Test
public void IllegalRange() {
	
	Range original = new Range(-10, 7); 
	
	assertFalse("The range 5, -13 is an illegal range",
			original.intersects(5, -13));
}




//Tests for combinedIgnoringNaN
@Test
public void testCombineIgnoringNaNNull2() {
	
	Range original = new Range(-8, 8); 
	
	assertTrue("Range 1 is returned as 2 is null",
			original.equals(Range.combineIgnoringNaN(original,null)));
}

@Test
public void testCombineIgnoringNaNNull1() {
	
	Range original = new Range(-8, 8);
	
	assertTrue("Range 2 is returned as 1 is null",
			original.equals(Range.combineIgnoringNaN(null,original)));
}



@Test
public void testCombineIgnoringNaN1Null2NaN() {
	
	Range NaN = new Range(Double.NaN,Double.NaN);

	
	assertNull("Range 1 null, Rnage 2 NaN and null is returned",
	Range.combineIgnoringNaN(null,NaN));
}

@Test
public void testCombineIgnoringNaN2Null1NaN() {
	Range NaN = new Range(Double.NaN,Double.NaN);
	
	assertNull("Range 2 null, Rnage 1 NaN and null is returned",
	Range.combineIgnoringNaN(NaN,null));
}

@Test
public void testCombineIgnoringNaNBothNaN() {
	
	Range NaN = new Range(Double.NaN,Double.NaN);

	assertNull("Both NaN so null is returned",
	Range.combineIgnoringNaN(NaN,NaN));
}

@Test
public void testCombineIgnoringNaNBothNull() {
	

	assertNull("Both Null and null is returned",
	Range.combineIgnoringNaN(null,null));
}



@Test
public void testCombineIgnoringNaN1NaN2Range() {
	
	Range NaN = new Range(Double.NaN,Double.NaN);
	
	Range range = new Range(-4, 10);

	assertTrue("range 1 is NaN so range 2 is returned",
			range.equals(Range.combineIgnoringNaN(NaN,range)));
}


@Test
public void testCombineIgnoringNaN2NaN1Range() {
	
	Range NaN = new Range(Double.NaN,Double.NaN);
	
	Range range = new Range(-4, 10);

	assertTrue("range 2 is NaN so range 1 is returned",
			range.equals(Range.combineIgnoringNaN(NaN,range)));
}

//test for scale

@Test(expected = IllegalArgumentException.class)
public void testScaleNegativeScale() {
	Range Orig = new Range(-3,3);
	Range.scale(Orig,-2);
}


@Test
public void testScalePositiveScale() {
	Range newR = new Range(-9,9);
	Range Orig = new Range(-3,3);
	
	assertTrue("scaling a range from -3,3 by 3 should yield a range of -9,9",
	newR.equals(Range.scale(Orig,3)));
}

@Test(expected = IllegalArgumentException.class)
public void testScaleMutationNegativeScaleProperAssert() {
	Range newRange = new Range(10,-10);
	Range range = new Range(-5,5);
	assertEquals("Exception thrown",
	newRange, Range.scale(range,-2));
}

// hash()

@Test
public void testHashCodeMixedRange() {
	
	Range orig = new Range(-7,9);
	assertEquals("The range -7,9 has a hashCode 55443456",
	55443456, orig.hashCode());
	System.out.println(orig.hashCode());
}

@Test
public void testHashCodeSameRange() {
	Range newRange = new Range(-9,7);
	Range orig = new Range(-9,7);
	orig.hashCode();
	assertTrue("It should be the same",
			orig.equals(newRange));
}


@After

public void tearDown() throws Exception {

}

@AfterClass

public static void tearDownAfterClass() throws Exception {

}

}