**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:       | 18 |
|-----------------|---|
| Student Names:  |  Muteeba Jamal |
|                 |  Shahzill Naveed |
|                 |  Iman Niaz |
|                 |  Rumaisa Talukder |

# Introduction

In this lab we were tasked to perform mutation testing on our previously develoved test cases for DataUtilities and Range classes. We started with 52% and 41% for DataUtilities and Range respectively. We then added more test cases in our classes to increase the mutation coverage and hence improving our test cases.  To do this, we used PitClipse plugin downloaded from the eclipse marketplace. 

In the second part, we were tasked to use Selenium IDE to develop test cases for GUI of our chosen websites. These tests were automated and tested different functionalities of the website and the results were documented.


# Analysis of 10 Mutants of the Range class 

1) Line 147
getCenteralValue() - Substituted 2.0 with 1.0 → KILLED
- The value gets divided by 1.0 instead of 2.0
- The mutant will be killed by any test where the expected value is other than zero as in centeralValueCorrectNegativeNegative()

2) Line 90
Range(double lower, double upper) - removed conditional - replaced comparison check with false → SURVIVED
- The condition changes the comparison (lower > upper) to false
- The mutant should be killed by any test where the lower bound is greater than the upper bound
- It survived in our test cases because we did not have any test where the lower bound was greater than the upper bound 

3) Line 138
getLength() - Incremented (a++) double field upper → SURVIVED
- This mutant increments the value of the upper bound after the test is executed
- As the value of the length is stored before the increment, the mutant does not affect the length and hence survives

4) Line 147
getCenteralValue() - replaced double addition with subtraction → KILLED
- This mutant changes the addition to a subtraction giving the difference of the ranges and not the centeral value
- This mutant will be killed by any non zero range test as in centeralValueCorrectNegativeNegative()

5) Line 138
getLength() - Incremented (++a) double field upper → KILLED
- This mutant increments the value of the upper bound before the test is executed
- As the value of the length is stored after the increment, the value is different from what is expected
- This mutant is caught and killed by any test where the length of a range is being tested as in getLengthValidOutput()

6) Line 165
contains(double value) - replaced boolean return with false for org/jfree/data/Range::contains → KILLED
- The return value is set to false by this mutant
- The mutant is killed by any test expecting a true return as in inLowerBoundary()

7) Line 198
intersects(Range range) - replaced boolean return with true for org/jfree/data/Range::intersects → SURVIVED
- This mutant changes the return value of a valid range to true
- This mutant will be killed by any test testing a valid range and expecting a false answer
- We did not have such a test case hence the mutant survived

8) Line 147
getCenteralValue() - replaced double division with multiplication → KILLED
- This mutant changes the division by 2 to multiplication by two
- This mutant will be killed by any non zero range test as in centeralValueCorrectNegativeNegative()

9) Line 280
combineIgnoringNaN(Range range1, Range range2) - replaced return value with null for org/jfree/data/Range::combineIgnoringNaN → KILLED
- This mutant changes the return value from a range to null
- This mutant will be killed by any test expecting a non-null range as in testCombineIgnoringNaN2NaN1Range()

10) Line 239
combine(Range range1, Range range2) - negated conditional → KILLED
- This mutant changes the condition (range1 == null) to (range1 != null)
- This mutant will be killed by any test where range 1 is not null and range 1 is expected back as in secondRangeNull()






# Report all the statistics and the mutation score for each test class

DataUtilities: 

Our initial mutation coverage for the DataUtilities class was 52% with 457/881 bugs killed. After adding more tests for calculateColumnTotal, calculateRowTotal, and Equals, we were able to bring the coverage up to 73% with 640/881 bugs killed. 

Range:

Our initial mutation coverage for the Range class was 41% with 591/1431 bugs killed. After adding more tests for hash, scale, combinedIgnoringNaN and range, we were able to bring the coverage up to 58% with 828/1431 bugs killed. 

Original mutation tests:

<img width="619" alt="image" src="https://user-images.githubusercontent.com/101993148/224931743-31fb7d95-1859-430f-93d1-28204a26153b.png">

Updated mutation tests:

<img width="618" alt="image" src="https://user-images.githubusercontent.com/101993148/225538662-6598d2cf-e4cb-4ea1-98e9-280bfe233b07.png">




# Analysis drawn on the effectiveness of each of the test classes

Text ...

# A discussion on the effect of equivalent mutants on mutation score accuracy

Text ...

# A discussion of what could have been done to improve the mutation score of the test suites

Text ...

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

Text ...

# Explain your SELENUIM test case design process

Text ...

# Explain the use of assertions and checkpoints

Text ...

# how did you test each functionaity with different test data

Text ...

# Discuss advantages and disadvantages of Selenium vs. Sikulix

Text ...

# How the team work/effort was divided and managed

Text ...


# Difficulties encountered, challenges overcome, and lessons learned

Text ...

# Comments/feedback on the lab itself

Text ...
