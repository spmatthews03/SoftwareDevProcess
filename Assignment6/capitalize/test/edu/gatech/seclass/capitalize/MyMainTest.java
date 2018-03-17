package edu.gatech.seclass.capitalize;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyMainTest {


    private ByteArrayOutputStream outStream;
    private ByteArrayOutputStream errStream;
    private PrintStream outOrig;
    private PrintStream errOrig;
    private Charset charset = StandardCharsets.UTF_8;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        errStream = new ByteArrayOutputStream();
        PrintStream err = new PrintStream(errStream);
        outOrig = System.out;
        errOrig = System.err;
        System.setOut(out);
        System.setErr(err);
    }


    // Some utilities

    private File createTmpFile() throws IOException {
        File tmpfile = temporaryFolder.newFile();
        tmpfile.deleteOnExit();
        return tmpfile;
    }


    private File createInputFile1() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!");

        fileWriter.close();
        return file1;
    }

    private File createInputFile2() throws Exception {
        File file2 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file2);

        fileWriter.write("aaaaaa");

        fileWriter.close();
        return file2;
    }



    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }



/*
Place all  of your tests in this class, optionally using MainTest.java as an example.
*/

// Purpose: Present File with size of one line, no string, no delimiter, no special characters
// Frame #: 13
@Test
public void capitalizeTest1() throws Exception {
    File inputFile1 = createInputFile1();

    String args[] = {inputFile1.getPath()};
    edu.gatech.seclass.capitalize.Main.main(args);

    String expected1 = "Hello There How is your day going today?";

    String actual1 = getFileContent(inputFile1.getPath());

    assertEquals("The files differ!", expected1, actual1);
}


// Purpose: Present File with size of one line, no string, delimiter with quotes, more than one in length
// Frame #: 14
    @Test
    public void capitalizeTest2() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-w", "'as'", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Checking this test as Well";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: Present file with size of multiple lines, String with length 0, delimiter present in quotes no special characters with length more than one
// Frame #: 17
    @Test
    public void capitalizeTest3() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","-w","'mul'",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Here's another Test!\n" +
                "I have multiple lines and I want to test\n" +
                "this and that.";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: File present with size of one, String of multiple length that shows up once, no delimiter
// Frame #: 19
    @Test
    public void capitalizeTest4() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","ss",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "This class is fun!";
        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: length of string 1
// Frame #: 2
    @Test
    public void capitalizeTest5() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","o",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Length of one for the string test.";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: Alphanumeric numbers in string
// Frame #: 3
    @Test
    public void capitalizeTest6() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","1",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Test for alphnumeric Letters like H3110!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: Special characters in delimiter
// Frame #: 7
    @Test
    public void capitalizeTest7() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-w","#",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Special # Characters # in & delimiter!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: Delimiter of length 1
// Frame #: 11
    @Test
    public void capitalizeTest8() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-w","H",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "H What H is the H delimliHter?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: One line output, many string occurences, length of string more than one in quotes
// Frame #: 22
    @Test
    public void capitalizeTest9() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","'is'", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Hello is a word that is made of letters and is 5 letters long";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose:One line file, multiple length string, occurrence 1
// Frame #: 31
    @Test
    public void capitalizeTest10() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","is", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Howdy this is a easy test";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: One line file, many occurence string, multiple length string, delimiter in quotes multiple length
// Frame #:35
    @Test
    public void capitalizeTest11() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","dt","-w","'lm'",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "a test of strings with dt and dt is 2 letters, the delimiter is lm, and its also 2 letters lm.";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: Many lines file, length more than one string, one occurrence, elimiter with quotes length more than once
// Frame #: 38
    @Test
    public void capitalizeTest12() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","bad","-w","'wo'",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Howdy There\n" +
                "I have no idea what clas I'll be taking next, do you?\n" +
                "I'm taking two right now but am not sure if I will do it again\n" +
                "two classes isn't that bad, but 1 is a lot easier.";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: Multiple lines file, many occurences of string length more than one, delimiter in quotes length more than one
// Frame #: 41
    @Test
    public void capitalizeTest13() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","at","-w","'do'", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Howdy There\n" +
                "I have no idea what clas I'll be taking next, do you?\n" +
                "I'm taking two right now but am not sure if I will do it again\n" +
                "two classes isn't that bad, but 1 is a lot easier.";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: String never shows up
// Frame #: 6
    @Test
    public void capitalizeTest14() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","a",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Howdy this doesn't consist of the first letter";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }


// Purpose: Many lines, length more than one in quotes, multiple occurence, delimiter in quotes multiple length
// Frame #: 26
    @Test
    public void capitalizeTest15() throws Exception {
        File inputFile1 = createInputFile1();

        String args[] = {"-m","'es'","-w","'is'",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "This is the last test\n" +
                "It is unsure how these tests will go\n" +
                "I do know that this assignment is due tomorrow.";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

}
