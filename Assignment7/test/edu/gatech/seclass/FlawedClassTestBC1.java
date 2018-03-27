package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FlawedClassTestBC1 {

    private FlawedClass flawedClass;

    @Before
    public void setUp() {
        flawedClass = new FlawedClass();
    }

    @After
    public void tearDown() {
        flawedClass = null;
    }


    // Test supplied by professor
    @Test
    public void testCoverageTask1() {
        //flawedClass.testCoverageTask1(1,5);
        assertEquals(5, flawedClass.flawedMethod1(1,5));
    }



}
