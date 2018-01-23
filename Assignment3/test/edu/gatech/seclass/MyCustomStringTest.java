package edu.gatech.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        fail("Not yet implemented");
    }

    @Test
    public void testCountNumbers3() {
        fail("Not yet implemented");
    }

    @Test
    public void testCountNumbers4() {
        fail("Not yet implemented");
    }

    @Test
    public void testCountNumbers5() {
        fail("Not yet implemented");
    }

    @Test
    public void testCountNumbers6() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits1() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        assertEquals("H7y, l7t'9 put 94me d595ts in this 9tr5n9!55!!", mycustomstring.increaseDigits(4, false));
    }

    @Test
    public void testIncreaseDigits2() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        assertEquals("H9y, l9t'1 put 16me d727ts in this 1tr7n2!77!!", mycustomstring.increaseDigits(-4, true));
    }

    @Test
    public void testIncreaseDigits3() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits4() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits5() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits6() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits7() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits8() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits9() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits10() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits11() {
        fail("Not yet implemented");
    }

    @Test
    public void testIncreaseDigits12() {
        fail("Not yet implemented");
    }


    @Test
    public void testConvertLettersToDigitsInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(19, 28);
        assertEquals("H3y, l3t'5 put 50m05 041612019 09n this 5tr1n6!11!!", mycustomstring.getString());
    }

    @Test(expected = NullPointerException.class)
    public void testConvertLettersToDigitsInSubstring2() {
        MyCustomString string = new MyCustomString();
        mycustomstring.convertLettersToDigitsInSubstring(200, 100);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertLettersToDigitsInSubstring3() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(200, 100);
    }

    @Test
    public void testConvertLettersToDigitsInSubstring4() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring5() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring6() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring7() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring8() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring9() {
        fail("Not yet implemented");
    }

    @Test
    public void testConvertLettersToDigitsInSubstring10() {
        fail("Not yet implemented");
    }

}
