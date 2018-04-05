package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlawedClassTestBC3 {

    private FlawedClass flawedClass;

    @Before
    public void setUp() {
        flawedClass = new FlawedClass();
    }

    @After
    public void tearDown() {
        flawedClass = null;
    }


    @Test
    public void test3CoverageTask1() {
        //flawedClass.testCoverageTask1(1,5);
        assertEquals(0, flawedClass.flawedMethod3(false, true));
    }

    @Test
    public void test3CoverageTask2() {
        //flawedClass.testCoverageTask1(1,5);
        assertEquals(1, flawedClass.flawedMethod3(true, false));
    }

}
