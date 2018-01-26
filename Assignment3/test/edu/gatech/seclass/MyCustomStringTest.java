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


    // Test supplied by professor
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    // Testing one complete multi digit number
    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("123456");
        assertEquals(1, mycustomstring.countNumbers());
    }

    // Testing a string like the one supplied
    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("W3 are Te5t1ng this meth0d");
        assertEquals(4, mycustomstring.countNumbers());
    }


    // Test with NO digits
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("There should be no numbers in this string!");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // Testing special characters, but expecting no #'s
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("$#&*#&$*#(@(@(#*$&%");
        assertEquals(0, mycustomstring.countNumbers());
    }

    // Testing a string with multiple numbers and digits
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("I 5upp063 I can t35t 1 m0r3");
        assertEquals(6, mycustomstring.countNumbers());
    }

    // Test provided by instructor
    @Test
    public void testIncreaseDigits1() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        assertEquals("H7y, l7t'9 put 94me d595ts in this 9tr5n9!55!!", mycustomstring.increaseDigits(4, false));
    }

    // Test provided by instructor
    @Test
    public void testIncreaseDigits2() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        assertEquals("H9y, l9t'1 put 16me d727ts in this 1tr7n2!77!!", mycustomstring.increaseDigits(-4, true));
    }

    // Basic test to see wrapping Positive #s
    @Test
    public void testIncreaseDigits3() {
        mycustomstring.setString("12345");
        assertEquals("89012", mycustomstring.increaseDigits(7, true));
    }

    // Basic test to see no wrapping Positive #s
    @Test
    public void testIncreaseDigits4() {
        mycustomstring.setString("12345");
        assertEquals("89999", mycustomstring.increaseDigits(7, false));
    }

    // Test to see if null pointer excpetion is thrown
    @Test(expected = NullPointerException.class)
    public void testIncreaseDigits5() {
        MyCustomString string = new MyCustomString();
        mycustomstring.increaseDigits(-6, true);
    }

    // Test no wrapping with negative numbers
    @Test
    public void testIncreaseDigits6() {
        mycustomstring.setString("T35t 5 w0rk3d th3 f1r5t t1m3");
        assertEquals("T00t 0 w0rk0d th0 f0r0t t0m0", mycustomstring.increaseDigits(-9, false));
    }

    // Additional test for no wrapping with positive numbers
    @Test
    public void testIncreaseDigits7() {
        mycustomstring.setString("9999999998");
        assertEquals("9999999999", mycustomstring.increaseDigits(4, false));
    }

    // Test to see if illegalArgument excpetion is thrown
    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseDigits8() {
        mycustomstring.setString("1111111");
        mycustomstring.increaseDigits(-10, false);
    }

    // Test for no digits
    @Test
    public void testIncreaseDigits9() {
        mycustomstring.setString("Boundary Conditions");
        assertEquals("Boundary Conditions", mycustomstring.increaseDigits(-3, true));
    }

    // Another test for wrapping with positive
    @Test
    public void testIncreaseDigits10() {
        mycustomstring.setString("945643");
        assertEquals("389087", mycustomstring.increaseDigits(4, true));
    }

    // Test for wrapping but adding nothing
    @Test
    public void testIncreaseDigits11() {
        mycustomstring.setString("L00ks L1k3 They work");
        assertEquals("L00ks L1k3 They work", mycustomstring.increaseDigits(0, true));
    }

    // Test for wrapping and negative numbers
    @Test
    public void testIncreaseDigits12() {
        mycustomstring.setString("Testing is C0mplete");
        assertEquals("Testing is C3mplete", mycustomstring.increaseDigits(-7, true));
    }

    // Provided by instructor
    @Test
    public void testConvertLettersToDigitsInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(19, 28);
        assertEquals("H3y, l3t'5 put 50m05 041612019 09n this 5tr1n6!11!!", mycustomstring.getString());
    }

    // provided by instructor
    @Test(expected = NullPointerException.class)
    public void testConvertLettersToDigitsInSubstring2() {
        MyCustomString string = new MyCustomString();
        mycustomstring.convertLettersToDigitsInSubstring(200, 100);
    }

    // provided by instructor
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertLettersToDigitsInSubstring3() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(200, 100);
    }

    // Test to see if illegalargument excpetion is thrown
    @Test(expected = IllegalArgumentException.class)
    public void testConvertLettersToDigitsInSubstring4() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(200, 10);
    }

    // Basic test converting first digits
    @Test
    public void testConvertLettersToDigitsInSubstring5() {
        mycustomstring.setString("L3Ts try this one!");
        mycustomstring.convertLettersToDigitsInSubstring(1, 2);
        assertEquals("123Ts try this one!", mycustomstring.getString());
    }

    // Testing that myIndexoutofBoundexception is thrown
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertLettersToDigitsInSubstring6() {
        mycustomstring.setString("A");
        mycustomstring.convertLettersToDigitsInSubstring(1,3);
    }

    // Testing all but one Digit
    @Test
    public void testConvertLettersToDigitsInSubstring7() {
            mycustomstring.setString("10202938478B0432");
            mycustomstring.convertLettersToDigitsInSubstring(1,16);
            assertEquals("10202938478020432", mycustomstring.getString());
    }

    // Testing upper and lowercase letters
    @Test
    public void testConvertLettersToDigitsInSubstring8() {
        mycustomstring.setString("aAbBcCdD");
        mycustomstring.convertLettersToDigitsInSubstring(1,8);
        assertEquals("0101020203030404", mycustomstring.getString());
    }

    // Testing just the first letter in string
    @Test
    public void testConvertLettersToDigitsInSubstring9() {
        mycustomstring.setString("Test #9");
        mycustomstring.convertLettersToDigitsInSubstring(1,1);
        assertEquals("20est #9", mycustomstring.getString());
    }

    // Testing to see if illegal argument excpetion is thrown
    @Test(expected = IllegalArgumentException.class)
    public void testConvertLettersToDigitsInSubstring10() {
        mycustomstring.setString("One last error Test");
        mycustomstring.convertLettersToDigitsInSubstring(2, 1);
    }

}
