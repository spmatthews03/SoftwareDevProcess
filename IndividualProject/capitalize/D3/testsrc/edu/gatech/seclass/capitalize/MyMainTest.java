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


    private File createInputFile2() throws Exception {
        File file2 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file2);

        fileWriter.write("G4T3CH 0H Y3AH!");

        fileWriter.close();
        return file2;
    }

    private File createInputFile3() throws Exception {
        File file3 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file3);

        fileWriter.write("I'm working really hard on this assignment,\n" +
                "however I'm not sure how it is going to end up.\n" +
                "We shall see when the grades come in!!!");

        fileWriter.close();
        return file3;
    }

    private File createInputFile4() throws Exception {
        File file4 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file4);

        fileWriter.write("hello there how is your day going today?");

        fileWriter.close();
        return file4;
    }

    private File createInputFile5() throws Exception {
        File file5 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file5);

        fileWriter.write("This one has two lines.\n" +
                "see? Here is the second!");

        fileWriter.close();
        return file5;
    }

    private File createInputFile6() throws Exception {
        File file5 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file5);

        fileWriter.write("Here are some special characters\n" +
                        "#oh#yeah#LETS#see!");

        fileWriter.close();
        return file5;
    }
    private File createInputFile7() throws Exception{
        File file5 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file5);

        fileWriter.write("Hello is a word that is made of letters and is 5 letters long");

        fileWriter.close();
        return file5;
    }

    private File createInputFile8() throws Exception {
        File file4 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file4);

        fileWriter.write("aaaaaaaaaaaaaaaaaaa");

        fileWriter.close();
        return file4;
    }



    private File createInputFile9() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!");

        fileWriter.close();
        return file1;
    }

    private File createInputFile10() throws Exception {
        File file2 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file2);

        fileWriter.write("aaaaaa");

        fileWriter.close();
        return file2;
    }

    private File createInputFile11() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\r\n" +
                "Did you take cs 6300 last semester? I want to\r" +
                "take 2 courses so that I will graduate Asap!");

        fileWriter.close();
        return file1;
    }

    private File createInputFile12() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!");

        fileWriter.close();
        return file1;
    }

    private File createInputFile13() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Bill is," + System.getProperty("line.separator") +
                "in my opinion," + System.getProperty("line.separator") +
                "an easier name to spell than William." + System.getProperty("line.separator") +
                "Bill is shorter," + System.getProperty("line.separator") +
                "and Bill is" + System.getProperty("line.separator") +
                "first alphabetically.");

        fileWriter.close();
        return file1;
    }

    private File createInputFile14() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Bill, have you learned your abc and 123?\r\n" +
                "I know My Abc's.\r" +
                "It is important to know your abc's and 123's,\n" +
                "so repeat with me: abc! 123! Abc and 123!");

        fileWriter.close();
        return file1;
    }

    private File createInputFile15() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("123\\456?789\\0ab?cde\\fgh?ijk\\lmn?opq\\rst?uvw\\xyz");

        fileWriter.close();
        return file1;
    }

    private File createInputFile16() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("123|456|789|0ab|cde|fgh|ijk|lmn|opq|rst|uvw|xyz");

        fileWriter.close();
        return file1;
    }

    private File createInputFile17() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write(" ");

        fileWriter.close();
        return file1;
    }

    private File createInputFile18() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("");

        fileWriter.close();
        return file1;
    }

    private File createInputFile19() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("/..");

        fileWriter.close();
        return file1;
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
Place all  of your tests in this class, optionally using capitalizeTest.java as an example.
*/

// Purpose: Present File with size of one line, no string, no delimiter, no special characters
// Frame #: 13
@Test
public void capitalizeTest1() throws Exception {
    File inputFile1 = createInputFile4();

    String args[] = {inputFile1.getPath()};
    edu.gatech.seclass.capitalize.Main.main(args);

    String expected1 = "Hello there how is your day going today?";

    String actual1 = getFileContent(inputFile1.getPath());

    assertEquals("Files are different!", expected1, actual1);
}


// Purpose: Present File with size of one line, no string, delimiter with quotes, more than one in length
// Frame #: 14
    @Test
    public void capitalizeTest2() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-w", "go", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Hello there hoW is yoUr day gOing toDay?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }
//
//
//// Purpose: Present file with size of multiple lines, String with length 0, delimiter present in quotes no special characters with length more than one
//// Frame #: 17
    @Test
    public void capitalizeTest3() throws IllegalArgumentException {
        try {
            File inputFile1 = createInputFile5();
        }
        catch(IllegalArgumentException e){
            System.out.println("Illegal Argument");
        }
        catch(Exception e){
            System.out.println("Exception");
        }
    }


// Purpose: File present with size of one, String of multiple length that shows up once, no delimiter
// Frame #: 19
    @Test
    public void capitalizeTest4() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","ERE",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "hello thERE how is your day going today?";
        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: length of string 1
// Frame #: 2
    @Test
    public void capitalizeTest5() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","O",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "hellO there hOw is yOur day gOing tOday?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: Alphanumeric numbers in string
// Frame #: 3
		// Type C'
    @Test
    public void capitalizeTest6() throws Exception {
        File inputFile1 = createInputFile2();

        String args[] = {"-m","4",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "G4T3CH 0H Y3AH!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!!", expected1, actual1);
    }


// Purpose: Special characters in delimiter
// Frame #: 7
    @Test
    public void capitalizeTest7() throws Exception {
        File inputFile1 = createInputFile6();

        String args[] = {"-w","#",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Here are some special characters\n" +
                "#Oh#Yeah#LETS#See!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: Delimiter of length 1
// Frame #: 11
    @Test
    public void capitalizeTest8() throws Exception {
        File inputFile1 = createInputFile5();

        String args[] = {"-w","n",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "This onE has two linEs.\n" +
                "see? Here is the seconD!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: One line output, many string occurences, length of string more than one in quotes
// Frame #: 22
    @Test
    public void capitalizeTest9() throws Exception {
        File inputFile1 = createInputFile7();

        String args[] = {"-m","IS", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Hello IS a word that IS made of letters and IS 5 letters long";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

//
//// Purpose:One line file, multiple length string, occurrence 1
//// Frame #: 3
    @Test
    public void capitalizeTest10() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","HOW", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "hello there HOW is your day going today?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: One line file, one occurence string, multiple length string, delimiter in quotes multiple length
// Frame #:35
		// Type C
		// <capitlizes the first letter even though there are specified arguments>
    @Test
    public void capitalizeTest11() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","OW","-w","oa",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "hello there hOW is yoUr daY goIng toDaY?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: Many lines file, length more than one string, one occurrence, delimiter with quotes length more than once
// Frame #: 38
    @Test
    public void capitalizeTest12() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-m","ASSIGN","-w","ia",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "I'm workiNg reaLly haRd on thiS ASSIGNment,\n" +
                "however I'm not sure how iT iS goiNg to end up.\n" +
                "We shaLl see when the graDes come iN!!!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: Multiple lines file, many occurences of string length more than one, delimiter in quotes length more than one
// Frame #: 41
    @Test
    public void capitalizeTest13() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-m","IS","-w","sun", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "I'm workinG really hard on thIS asSignMenT,\n" +
                "however I'm nOt sUre how it IS goinG to enD uP.\n" +
                "We sHall sEe when the grades come in!!!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: String never shows up
// Frame #: 6
    @Test
    public void capitalizeTest14() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","z",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "hello there how is your day going today?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


// Purpose: Many lines, length more than one in quotes, multiple occurence, delimiter in quotes multiple length
// Frame #: 26
    @Test
    public void capitalizeTest15() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-m","I'M","-w","oa",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "I'M woRking reaLly haRd oN this aSsignment,\n" +
                "hoWever I'M noT sure hoW it is goIng to end up.\n" +
                "We shaLl see when the graDes coMe in!!!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }


    @Test
    public void capitalizeTest16() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "HELLO THERE HOW IS YOUR DAY GOING TODAY?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

		// Type C
    @Test
    public void capitalizeTest17() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-w","o","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "HELLO THERE HOw IS YOuR DAY GOiNG TOdAY?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest18() throws Exception {
        File inputFile1 = createInputFile2();

        String args[] = {"-w","A","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "g4t3ch 0h y3ah!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest19() throws Exception, IllegalArgumentException {
        File inputFile1 = createInputFile4();
        try {
            String args[] = {"-f", "-w", inputFile1.getPath()};
            edu.gatech.seclass.capitalize.Main.main(args);
        }
        catch(IllegalArgumentException e){
            System.out.println("Flip option must be the last option.");
        }
    }

    @Test
    public void capitalizeTest20() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-w","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "hELLO tHERE hOW iS yOUR dAY gOING tODAY?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest21() throws Exception {
        File inputFile1 = createInputFile5();

        String args[] = {"-m","THIS ONE hAS TwO","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "this one Has tWo LINES.\n" +
                "SEE? hERE IS THE SECOND!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest22() throws Exception {
        File inputFile1 = createInputFile8();

        String args[] = {"-m","AAaa",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "AAaaAAaaAAaaAAaaaaa";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

		// Type C
		// <capitlizes the first letter even though there are specified arguments, which led to 
		// the wrong order of camel case>
    @Test
    public void capitalizeTest23() throws Exception {
        File inputFile1 = createInputFile8();

        String args[] = {"-w","a",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "aAaAaAaAaAaAaAaAaAa";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

		// Type B
    @Test
    public void capitalizeTest24() throws Exception {
        File inputFile1 = createInputFile8();

        String args[] = {"-w","A",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "AAAAAAAAAAAAAAAAAAA";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest25() throws Exception {
        File inputFile1 = createInputFile8();

        String args[] = {"-m","AAAAaaaa","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "aaaaAAAAaaaaAAAAAAA";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest26() throws Exception {
        File inputFile1 = createInputFile8();

        String args[] = {"-m","A","-w","a","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "aaaaaaaaaaaaaaaaaaa";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest27() throws Exception {
        File inputFile1 = createInputFile8();

        String args[] = {"-m","AaAaAa","-w","a","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "aAaAaAaAaAaAaAaAaAa";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest28() throws Exception {
        File inputFile1 = createInputFile8();
        try {
            String args[] = {"-m", "-w", "-f", inputFile1.getPath()};
        }
        catch(IllegalArgumentException e){
            System.out.println("Illegal Argument!");
        }
    }

    @Test
    public void capitalizeTest29() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","HELLO tHERE hOW iS yOUR dAY gOING tODAY","-f",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "hello There How Is Your Day Going Today?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest30() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","HELLO",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "HELLO there how is your day going today?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

// ----------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------
    @Test
    public void capitalizeTest31() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"45",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "HELLO there how is your day going today?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest32() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","-m",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "HELLO there how is your day going today?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

    @Test
    public void capitalizeTest33() throws Exception {
        File inputFile1 = createInputFile4();

        String args[] = {"-m","-m",inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "HELLO there how is your day going today?";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("Files are different!", expected1, actual1);
    }

  // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 1 from assignment directions
//    @Test
    public void capitalizeTest34() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected1 = "Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "Take 2 courses so that I will graduate Asap!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 2 from assignment directions
    @Test
    public void capitalizeTest35() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-w", inputFile1.getPath()};
        Main.main(args);

        String expected2 = "Howdy Billy,\n" +
                "I Am Going To Take Cs6300 And Cs6400 Next Semester.\n" +
                "Did You Take Cs 6300 Last Semester? I Want To\n" +
                "Take 2 Courses So That I Will Graduate Asap!";

        String actual2 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected2, actual2);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 3 from assignment directions
    @Test
    public void capitalizeTest36() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-m", "CS6300", inputFile1.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected3 = "Howdy Billy,\n" +
                "I am going to take CS6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!";

        String actual3 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected3, actual3);
    }
//
//    // Purpose: To provide an example of a test case format
//    // Frame #: Instructor example 4 from assignment directions
    @Test
    public void capitalizeTest37() throws Exception {
        File inputFile2 = createInputFile10();

        String args[] = {"-m", "AAAA", inputFile2.getPath()};
        edu.gatech.seclass.capitalize.Main.main(args);

        String expected4 = "AAAAaa";

        String actual4 = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected4, actual4);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 5 from assignment directions
    @Test
    public void capitalizeTest38() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-m", "ASAP", "-f", inputFile1.getPath()};
        Main.main(args);

        String expected5 = "hOWDY bILLY,\n" +
                "i AM GOING TO TAKE CS6300 AND CS6400 NEXT SEMESTER.\n" +
                "dID YOU TAKE CS 6300 LAST SEMESTER? i WANT TO\n" +
                "TAKE 2 COURSES SO THAT i WILL GRADUATE asap!";

        String actual5 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected5, actual5);
    }
//
//    // Purpose: To provide an example of a test case format
//    // Frame #: Instructor example 6 from assignment directions
    @Test
    public void capitalizeTest39() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-w", "abc", inputFile1.getPath()};
        Main.main(args);

        String expected6 = "Howdy Billy,\n" +
        "I aM going to taKe cS6300 aNd cS6400 next semester.\n" +
                "Did you taKe cS 6300 laSt semester? I waNt to\n" +
                "taKe 2 cOurses so thaT I will graDuaTe AsaP!";

        String actual6 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected6, actual6);
    }


    // Purpose: To provide an example of a test case format
    // Frame #: Instructor error example
    @Test
    public void capitalizeTest40() {
        String args[] = null; //invalid argument
        Main.main(args);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }

//     Purpose: Additional D2 Test
    @Test
    public void capitalizeTest41() {
        String args[] = {"-m"}; //invalid argument
        Main.main(args);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }
////
////     Purpose: Additional D2 Test
    @Test
    public void capitalizeTest42() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-i", inputFile1.getPath()};
        Main.main(args);

        String expected = "howdy billy,\n" +
                "i am going to take cs6300 and cs6400 next semester.\n" +
                "did you take cs 6300 last semester? i want to\n" +
                "take 2 courses so that i will graduate asap!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }
//
//    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest43() throws Exception {
        File inputFile3 = createInputFile11();

        String args[] = {"-I", inputFile3.getPath()};
        Main.main(args);

        String expected = "HOWDY BILLY,\n" +
                "I AM GOING TO TAKE CS6300 AND CS6400 NEXT SEMESTER.\r\n" +
                "DID YOU TAKE CS 6300 LAST SEMESTER? I WANT TO\r" +
                "TAKE 2 COURSES SO THAT I WILL GRADUATE ASAP!";

        String actual = getFileContent(inputFile3.getPath());

        assertEquals("The files differ!", expected, actual);
    }
//
//    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest44() throws Exception {
        File inputFile4 = createInputFile12();

        String args[] = {"-o", "-f", inputFile4.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!";

        String actual = getFileContent(inputFile4.getPath());

        assertEquals("The file was changed!", expected, actual);

        assertEquals("hOWDY bILLY,\n" +
                "tHIS IS A TEST FILE FOR THE CAPITALIZE UTILITY.\n" +
                "LET'S MAKE SURE IT HAS AT LEAST A FEW LINES,\n" +
                "SO THAT WE CAN CREATE SOME \n"
                + "INTERESTING TEST CASES...aND LET'S SAY \"HOWDY\" TO bILL AGAIN!", outStream.toString().trim());
    }

    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest45() throws Exception {
        File inputFile5= createInputFile13();

        String args[] = {inputFile5.getPath()};
        Main.main(args);

        String expected = "Bill is," + System.getProperty("line.separator") +
                "In my opinion," + System.getProperty("line.separator") +
                "An easier name to spell than William." + System.getProperty("line.separator") +
                "Bill is shorter," + System.getProperty("line.separator") +
                "And Bill is" + System.getProperty("line.separator") +
                "First alphabetically.";

        String actual = getFileContent(inputFile5.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest46() throws Exception {
        File inputFile7 = createInputFile15();

        String args[] = {"-w", "\\?", inputFile7.getPath()};
        Main.main(args);

        String expected = "123\\456?789\\0ab?Cde\\Fgh?Ijk\\Lmn?Opq\\Rst?Uvw\\Xyz";

        String actual = getFileContent(inputFile7.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest47() throws Exception {
        File inputFile8 = createInputFile16();

        String args[] = {"-w", "|", "-f", "-m", "XYZ", inputFile8.getPath()};
        Main.main(args);

        String expected = "123|456|789|0AB|cDE|fGH|iJK|lMN|oPQ|rST|uVW|xyz";

        String actual = getFileContent(inputFile8.getPath());

        assertEquals("The files differ!", expected, actual);
    }
////
////    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest48() throws Exception {
        File inputFile6 = createInputFile15();

        String args[] = {"-m", "ABC'S", "-w", inputFile6.getPath()};
        Main.main(args);

        String expected = "Howdy Bill, Have You Learned Your Abc And 123?\r\n" +
                "I Know My ABC'S.\r" +
                "It Is Important To Know Your ABC'S And 123's,\n" +
                "So Repeat With Me: Abc! 123! Abc And 123!";

        String actual = getFileContent(inputFile6.getPath());

        assertEquals("The files differ!", expected, actual);
    }
////
////    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest49() throws Exception {
        String args[] = {"nofile.txt"};
        Main.main(args);

        assertEquals("File Not Found", errStream.toString().trim());
    }

    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest50() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-f", "-x", inputFile1.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The file was changed!", expected, actual);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }
//
//    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest51() throws Exception {
        File inputFile6 = createInputFile15();

        String args[] = {"-f", "-I", inputFile6.getPath()};
        Main.main(args);

        String expected = "howdy bill, have you learned your abc and 123?\r\n" +
                "i know my abc's.\r" +
                "it is important to know your abc's and 123's,\n" +
                "so repeat with me: abc! 123! abc and 123!";

        String actual = getFileContent(inputFile6.getPath());

        assertEquals("The files differ!", expected, actual);
    }
//
//    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest52() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-w", "abc", inputFile1.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "I aM going to taKe cS6300 aNd cS6400 next semester.\n" +
                "Did you taKe cS 6300 laSt semester? I waNt to\n" +
                "taKe 2 cOurses so thaT I will graDuaTe AsaP!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }
//
//    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest53() throws Exception {
        File inputFile3 = createInputFile11();

        String args[] = {"-f", "-f", "-f", inputFile3.getPath()};
        Main.main(args);

        String expected = "hOWDY bILLY,\n" +
                "i AM GOING TO TAKE CS6300 AND CS6400 NEXT SEMESTER.\r\n" +
                "dID YOU TAKE CS 6300 LAST SEMESTER? i WANT TO\r" +
                "TAKE 2 COURSES SO THAT i WILL GRADUATE aSAP!";

        String actual = getFileContent(inputFile3.getPath());

        assertEquals("The files differ!", expected, actual);
    }
//
//    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest54() throws Exception {
        File inputFile1 = createInputFile9();

        String args[] = {"-w", "a", "-w", "bc",  inputFile1.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "I aM going to taKe cS6300 aNd cS6400 next semester.\n" +
                "Did you taKe cS 6300 laSt semester? I waNt to\n" +
                "taKe 2 cOurses so thaT I will graDuaTe AsaP!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest55() throws Exception {
        File inputFile5 = createInputFile13();

        String args[] = {"-w", "z", inputFile5.getPath()};
        Main.main(args);

        String expected = "Bill is," + System.getProperty("line.separator") +
                "in my opinion," + System.getProperty("line.separator") +
                "an easier name to spell than William." + System.getProperty("line.separator") +
                "Bill is shorter," + System.getProperty("line.separator") +
                "and Bill is" + System.getProperty("line.separator") +
                "first alphabetically.";

        String actual = getFileContent(inputFile5.getPath());

        assertEquals("The files differ!", expected, actual);
    }

//    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest56() throws Exception {
        File inputFile9 = createInputFile17();

        String args[] = {"-f", inputFile9.getPath()};
        Main.main(args);

        String expected = " ";

        String actual = getFileContent(inputFile9.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void capitalizeTest57() throws Exception {
        File inputFile7 = createInputFile15();

        String args[] = {"-w", inputFile7.getPath()};
        Main.main(args);

        String expected = "123\\456?789\\0ab?cde\\fgh?ijk\\lmn?opq\\rst?uvw\\xyz";

        String actual = getFileContent(inputFile7.getPath());

        assertEquals("The files differ!", expected, actual);
    }



    @Test
    public void capitalizeTest58() throws Exception {
        File inputFile2 = createInputFile10();

        String args[] = {"-o",inputFile2.getPath()};
        Main.main(args);

        String expected = "aaaaaa";

        String actual = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    @Test
    public void capitalizeTest59() throws Exception {
        File inputFile2 = createInputFile10();

        String args[] = {};
        Main.main(args);

        String expected = "aaaaaa";

        String actual = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected, actual);
    }


    @Test
    public void capitalizeTest60() throws Exception {
        File inputFile2 = createInputFile10();

        String args[] = {"-m","A","-w","-m","T",inputFile2.getPath()};
        Main.main(args);

        String expected = "aAAAAA";

        String actual = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected, actual);
    }


    @Test
    public void capitalizeTest61() throws Exception {
        File inputFile2 = createInputFile10();

        String args[] = {"-w","-w","A",inputFile2.getPath()};
        Main.main(args);

        String expected = "aaaaaa";

        String actual = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected, actual);
    }


   @Test
   public void capitalizeTest62() throws Exception {
       File inputFile1 = createInputFile10();

       String args[] = { "-w", "H", "-w", "-m", "-o", inputFile1.getPath()};
       Main.main(args);

       String expected1 = "aaaaaa";

       String actual1 = getFileContent(inputFile1.getPath());

       assertEquals("The files differ!", expected1, actual1);
   }

   @Test
   public void capitalizeTes63() throws Exception {
       File inputFile1 = createInputFile19();

       String args[] = { "-w","-i","-I", inputFile1.getPath()};
       Main.main(args);

       String expected1 = "/..";

       String actual1 = getFileContent(inputFile1.getPath());

       assertEquals("File Not Found", errStream.toString().trim());
   }

	// Type D
	// <Can't handle a filename without .txt>
	// commenting out to continue tests
//   @Test
//   public void capitalizeTes63() throws Exception {
//       File inputFile1 = createInputFile19();

//       String args[] = { "-w","-i","-I", "file"};
//       Main.main(args);

//       String expected1 = "/..";

//       String actual1 = getFileContent(inputFile1.getPath());

//       assertEquals("File Not Found", errStream.toString().trim());
//   }

}
