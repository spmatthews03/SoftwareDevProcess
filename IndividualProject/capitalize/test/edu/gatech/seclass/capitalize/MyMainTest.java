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
//@Test
//public void capitalizeTest1() throws Exception {
//    File inputFile1 = createInputFile4();
//
//    String args[] = {inputFile1.getPath()};
//    edu.gatech.seclass.capitalize.Main.main(args);
//
//    String expected1 = "Hello there how is your day going today?\n";
//
//    String actual1 = getFileContent(inputFile1.getPath());
//
//    assertEquals("The files are the same!", expected1, actual1);
//}
//
//
//// Purpose: Present File with size of one line, no string, delimiter with quotes, more than one in length
//// Frame #: 14
//    @Test
//    public void capitalizeTest2() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-w", "go", inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "hello there hoW is yoUr day gOing toDay?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
////
////
////// Purpose: Present file with size of multiple lines, String with length 0, delimiter present in quotes no special characters with length more than one
////// Frame #: 17
//    @Test
//    public void capitalizeTest3() throws IllegalArgumentException {
//        try {
//            File inputFile1 = createInputFile5();
//        }
//        catch(IllegalArgumentException e){
//            System.out.println("Illegal Argument");
//        }
//        catch(Exception e){
//            System.out.println("Exception");
//        }
//    }
//
//
//// Purpose: File present with size of one, String of multiple length that shows up once, no delimiter
//// Frame #: 19
//    @Test
//    public void capitalizeTest4() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-m","ERE",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "hello thERE how is your day going today?\n";
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: length of string 1
//// Frame #: 2
//    @Test
//    public void capitalizeTest5() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-m","O",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "hellO there hOw is yOur day gOing tOday?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: Alphanumeric numbers in string
//// Frame #: 3
//    @Test
//    public void capitalizeTest6() throws Exception {
//        File inputFile1 = createInputFile2();
//
//        String args[] = {"-m","4",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "G4T3CH 0H Y3AH!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!!", expected1, actual1);
//    }
//
//
//// Purpose: Special characters in delimiter
//// Frame #: 7
//    @Test
//    public void capitalizeTest7() throws Exception {
//        File inputFile1 = createInputFile6();
//
//        String args[] = {"-w","#",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "Here are some special characters\n" +
//                "#Oh#Yeah#LETS#See!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: Delimiter of length 1
//// Frame #: 11
//    @Test
//    public void capitalizeTest8() throws Exception {
//        File inputFile1 = createInputFile5();
//
//        String args[] = {"-w","n",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "This onE has two linEs.\n" +
//                "see? Here is the seconD!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: One line output, many string occurences, length of string more than one in quotes
//// Frame #: 22
//    @Test
//    public void capitalizeTest9() throws Exception {
//        File inputFile1 = createInputFile7();
//
//        String args[] = {"-m","IS", inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "Hello IS a word that IS made of letters and IS 5 letters long\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
////
////// Purpose:One line file, multiple length string, occurrence 1
////// Frame #: 31
//    @Test
//    public void capitalizeTest10() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-m","HOW", inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "hello there HOW is your day going today?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: One line file, one occurence string, multiple length string, delimiter in quotes multiple length
//// Frame #:35
//    @Test
//    public void capitalizeTest11() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-m","OW","-w","oa",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "hello there hOW is yoUr daY goIng toDaY?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: Many lines file, length more than one string, one occurrence, delimiter with quotes length more than once
//// Frame #: 38
//    @Test
//    public void capitalizeTest12() throws Exception {
//        File inputFile1 = createInputFile3();
//
//        String args[] = {"-m","ASSIGN","-w","ia",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "I'm workiNg reaLly haRd on thiS ASSIGNment,\n" +
//                "however I'm not sure how iT iS goiNg to end up.\n" +
//                "We shaLl see when the graDes come iN!!!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: Multiple lines file, many occurences of string length more than one, delimiter in quotes length more than one
//// Frame #: 41
//    @Test
//    public void capitalizeTest13() throws Exception {
//        File inputFile1 = createInputFile3();
//
//        String args[] = {"-m","IS","-w","sun", inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "I'm workinG really hard on thIS asSignMenT,\n" +
//                "however I'm nOt sUre how it IS goinG to enD uP.\n" +
//                "We sHall sEe when the grades come in!!!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: String never shows up
//// Frame #: 6
//    @Test
//    public void capitalizeTest14() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-m","z",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "hello there how is your day going today?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//// Purpose: Many lines, length more than one in quotes, multiple occurence, delimiter in quotes multiple length
//// Frame #: 26
//    @Test
//    public void capitalizeTest15() throws Exception {
//        File inputFile1 = createInputFile3();
//
//        String args[] = {"-m","I'M","-w","oa",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "I'M woRking reaLly haRd oN this aSsignment,\n" +
//                "hoWever I'M noT sure hoW it is goIng to end up.\n" +
//                "We shaLl see when the graDes coMe in!!!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//
//    @Test
//    public void capitalizeTest16() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "HELLO THERE HOW IS YOUR DAY GOING TODAY?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest17() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-w","o","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "HELLO THERE HOw IS YOuR DAY GOiNG TOdAY?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest18() throws Exception {
//        File inputFile1 = createInputFile2();
//
//        String args[] = {"-w","A","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "g4t3ch 0h y3ah!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }

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

//    @Test
//    public void capitalizeTest20() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-w","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "HELLO tHERE hOW iS yOUR dAY gOING tODAY?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest21() throws Exception {
//        File inputFile1 = createInputFile5();
//
//        String args[] = {"-m","THIS ONE hAS TwO","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "this one Has tWo LINES.\n" +
//                "SEE? hERE IS THE SECOND!\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest22() throws Exception {
//        File inputFile1 = createInputFile8();
//
//        String args[] = {"-m","AAaa",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "AAaaAAaaAAaaAAaaaaa\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest23() throws Exception {
//        File inputFile1 = createInputFile8();
//
//        String args[] = {"-w","a",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "aAaAaAaAaAaAaAaAaAa\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest24() throws Exception {
//        File inputFile1 = createInputFile8();
//
//        String args[] = {"-w","A",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "aaaaaaaaaaaaaaaaaaa\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest25() throws Exception {
//        File inputFile1 = createInputFile8();
//
//        String args[] = {"-m","AAAAaaaa","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "aaaaAAAAaaaaAAAAAAA\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest26() throws Exception {
//        File inputFile1 = createInputFile8();
//
//        String args[] = {"-m","A","-w","a","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "aaaaaaaaaaaaaaaaaaa\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest27() throws Exception {
//        File inputFile1 = createInputFile8();
//
//        String args[] = {"-m","AaAaAa","-w","a","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "aAaAaAaAaAaAaAaAaAa\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest28() throws Exception {
//        File inputFile1 = createInputFile8();
//        try {
//            String args[] = {"-m", "-w", "-f", inputFile1.getPath()};
//        }
//        catch(IllegalArgumentException e){
//            System.out.println("Illegal Argument!");
//        }
//    }
//
//    @Test
//    public void capitalizeTest29() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-m","HELLO tHERE hOW iS yOUR dAY gOING tODAY","-f",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "hello There How Is Your Day Going Today?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }
//
//    @Test
//    public void capitalizeTest30() throws Exception {
//        File inputFile1 = createInputFile4();
//
//        String args[] = {"-m","HELLO",inputFile1.getPath()};
//        edu.gatech.seclass.capitalize.Main.main(args);
//
//        String expected1 = "HELLO there how is your day going today?\n";
//
//        String actual1 = getFileContent(inputFile1.getPath());
//
//        assertEquals("The files are the same!", expected1, actual1);
//    }

}
