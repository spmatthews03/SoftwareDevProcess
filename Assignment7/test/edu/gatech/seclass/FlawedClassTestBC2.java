package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlawedClassTestBC2 {

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
    public void test2CoverageTask1() {
        //flawedClass.testCoverageTask1(1,5);
        assertEquals(1, flawedClass.flawedMethod2(true));
    }

    @Test
    public void test2CoverageTask2() {
        //flawedClass.testCoverageTask1(1,5);
        assertEquals(0, flawedClass.flawedMethod2(false));
    }

}
