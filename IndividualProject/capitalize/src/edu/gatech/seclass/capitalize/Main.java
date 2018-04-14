package edu.gatech.seclass.capitalize;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class Main {

    private static String file;
    private static File actualFile;
    private static List<String> fileContents;
    private static List<String> arguments;
    private static boolean FILE_EXISTS;
    private static boolean PRINT_TO_FILE;
    private static List<String> originalContents;
    private static String[] allowedArgs = {"-w","-f","-i","-I","-m","-o"};


    public static void main(String[] args) {

        if(args == null) {
            usage();
            return;
        }


        try {
            if(args.length > 0 && args.length <= 6){
                arguments = new ArrayList<>(Arrays.asList(args));

                if(!acceptablArguments()){
                    usage();
                    return;
                }
                parseArgs();
            }
            else{
                throw new IllegalArgumentException("Invalid Arguments");
            }

            //Parse arguments

            if (FILE_EXISTS) {
                fileContents = new ArrayList<>();
                actualFile = new File(file);

                capitalize();
            }
        }
        catch (IOException e){
            System.out.println("File not found!");
        }
    }


    /**
     * method to compute which capitalize method should be used in the specified order
     * @throws IOException
     */

    private static void capitalize() throws IOException{

        if(arguments.size() == 0){
            noFlags();
        }
        else {
            for (int i = 0; i < arguments.size(); i++) {

                switch (arguments.get(i)) {
                    case "-w":
                        if (i + 1 == arguments.size()) {
                            delimiterCapitilize(" ");
                        } else if (arguments.get(i + 1).equals("-w") || arguments.get(i + 1).equals("-f")) {
                            delimiterCapitilize(" ");
                        } else {
                            delimiterCapitilize(arguments.get(i + 1));
                        }
                        break;
                    case "-m":
                        if (arguments.get(i + 1).equals("-w") || arguments.get(i + 1).equals("-f")) {
                            throw new IllegalArgumentException("String flag must have a string.");
                        } else {
                            stringCapitilize(arguments.get(i + 1));
                        }
                        break;
                    case "-f":
                        if (arguments.get(arguments.size() - 1).equals("-f")) {
                            flipAll();
                        }
                        break;
                    case "-i":
                    case "-I":
                        if(arguments.get(0).equals("-i") || arguments.get(0).equals("-I")) {
                            changeAll(arguments.get(i));
                        }
                        break;
                }
            }
        }
    }




    /**
     * Parses the arguments passed into the program
     *
     */

    private static void parseArgs() throws IOException{
        PRINT_TO_FILE = true;

        try {

            // Parsing filename
            if (fileExists(arguments.get(arguments.size() - 1))){
                FILE_EXISTS = true;
                file = arguments.get(arguments.size() - 1);

                arguments.remove(arguments.size()-1);
            }
            else{
                FILE_EXISTS = false;
                System.err.println("File Not Found");
                return;
            }

            // Parsing
            for(int i = 0; i < arguments.size(); i++){
                if(arguments.get(i).equals("-i") || arguments.get(i).equals("-I")){
                    int index = arguments.indexOf(arguments.get(i));
                    String tmp = arguments.get(i);
                    arguments.remove(index);
                    arguments.add(0, tmp);
                }
                else if(arguments.get(i).equals("-o")){
                    PRINT_TO_FILE = false;
                    Path path = Paths.get(file);
                    originalContents = new ArrayList<>();
                    originalContents = Files.readAllLines(path, Charset.defaultCharset());

                }
                else if(arguments.get(i).equals("-f")){
                    int index = arguments.indexOf("-f");
                    String tmp = arguments.get(i);
                    arguments.remove(index);
                    arguments.add(tmp);
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File doesn't exist!");
        }
    }

    private static boolean acceptablArguments(){
        for(int i = 0; i < arguments.size(); i++){
            boolean found = false;

            if(arguments.get(i).startsWith("-")){
                for(String arg : allowedArgs){
                    if(arguments.get(i).equals(arg)){
                        found = true;
                    }
                    if(arguments.get(i).equals("-m")){
                        if(i == arguments.size()-1  || arguments.get(i+1).startsWith("-")){
                            return false;
                        }
                    }
                }
                if(!found){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * print how to use the utility
     */
    private static void usage() {
        System.err.println("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>");
    }


    /**
     * Capitalizes the letter directly after a delimiter
     * @param delimiter
     * @throws IOException
     */

    private static void delimiterCapitilize(String delimiter) throws IOException{
        Path path = Paths.get(file);
        List<String> content = new ArrayList<>();
        byte[] tmpArray = Files.readAllBytes(Paths.get(file));
        String tmpString = new String(tmpArray, "ISO-8859-1");
        char[] ch = tmpString.toCharArray();


        for(int i = 0; i < ch.length; i++) {
            char c = ch[i];

            for (int j = 0; j < delimiter.length(); j++) {
                if (c == delimiter.charAt(j) && (i + 1) != ch.length) {
                    ch[i + 1] = Character.toUpperCase(ch[i + 1]);
                }
                if (i == 0 && delimiter.equals(" ")) {
                    ch[i] = Character.toUpperCase(ch[i]);
                }
                if (!String.valueOf(ch[i]).matches(".")&& delimiter.equals(" ")) {
                    if(i != ch.length-1)
                        ch[i + 1] = Character.toUpperCase(ch[i+1]);
                }
            }
        }
        content.add(new String(ch));

        printOut(path,content);
    }


    private static void changeAll(String arg) throws IOException{
        if(arg.equals("-i")){
            allToLowerCase();
        }
        else{
            allToUpperCase();
        }
    }


    private static void allToLowerCase()throws IOException{
        Path path = Paths.get(file);
        List<String> content = new ArrayList<>();

        byte[] tmpArray = Files.readAllBytes(Paths.get(file));
        String tmpString = new String(tmpArray, "ISO-8859-1");
        char[] ch = tmpString.toCharArray();


        for(char letter : ch) {

            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                c = Character.toLowerCase(c);
                ch[i] = c;
            }
        }
        content.add(new String(ch));
        printOut(path,content);
    }


    private static void allToUpperCase() throws IOException{
        Path path = Paths.get(file);
        List<String> content = new ArrayList<>();

        byte[] tmpArray = Files.readAllBytes(Paths.get(file));
        String tmpString = new String(tmpArray, "ISO-8859-1");
        char[] ch = tmpString.toCharArray();


        for(char letter : ch) {

            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                c = Character.toUpperCase(c);
                ch[i] = c;
            }
        }
        content.add(new String(ch));
        printOut(path,content);
    }


    /**
     * Capitilizes the matching string
     * @param chars
     * @throws IOException
     */
    private static void stringCapitilize(String chars) throws IOException{

        byte[] tmpArray = Files.readAllBytes(Paths.get(file));
        String tmpString = new String(tmpArray, "ISO-8859-1");
        char[] ch = tmpString.toCharArray();
        List<String> list = new ArrayList<>(Arrays.asList(tmpString.split("\\r\\n?\\r?\\n")));

        Path path = Paths.get(file);
        Stream<String> lines = list.stream();
        List<String> toReplace =
                lines.map(line -> line.replaceAll("(?i)"+ Pattern.quote(chars), chars))
                        .collect(Collectors.toList());



        StringBuilder builder = new StringBuilder();
        for(String word : toReplace){
            builder.append(word);
        }
        char[] charArray = builder.toString().toCharArray();


        List<String> content = new ArrayList<>();
        content.add(new String(charArray));
        printOut(path,content);
        lines.close();
    }


    private static void printOut(Path path, List<String> list)throws IOException{
        if(PRINT_TO_FILE) {
            printToFile(list);
        }
        else{
            printToConsole(list);
        }
    }

    private static void printToConsole(List<String> list) throws IOException{
        for(String str : list){
            System.out.println(str);
        }
        printToFile(originalContents);
    }


    /**
     * Flips all characters to the other case
     * @throws IOException
     */

    public static void flipAll() throws IOException{
        List<String> content = new ArrayList<>();
        try{
            byte[] tmpArray = Files.readAllBytes(Paths.get(file));
            String tmpString = new String(tmpArray, "ISO-8859-1");
            char[] ch = tmpString.toCharArray();

            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                } else if (Character.isLowerCase(c)) {
                    c = Character.toUpperCase(c);
                }
                ch[i] = c;
            }
            content.add(new String(ch));
            printOut(Paths.get(file),content);

        }
        catch(IOException e){
            System.out.println(e);
        }


    }


    /**
     * Method for if there is no flags other than filename
     * @throws IOException
     */

    private static void noFlags() throws IOException{
        Path path = Paths.get(file);
        List<String> content = new ArrayList<>();

        byte[] tmpArray = Files.readAllBytes(Paths.get(file));
        String tmpString = new String(tmpArray, "ISO-8859-1");
        char[] ch = tmpString.toCharArray();

        for(int i = 0; i < ch.length; i++){
            if(!String.valueOf(ch[i]).matches(".")){
                if(i != ch.length -1) {
                    ch[i+1] = Character.toUpperCase(ch[i+1]);
                }
            }
            if(i == 0){
                ch[i] = Character.toUpperCase(ch[i]);
            }
        }
        content.add(new String(ch));
        printOut(path,content);
    }

    /**
     *
     * @param filename
     * @return
     * @throws FileNotFoundException
     */

    private static boolean fileExists(String filename) throws FileNotFoundException{
        File file = new File(filename);
        if(file.exists())
            return true;
        else
            return false;
    }

    private static void printToFile(List<String> contents) throws IOException{
        FileOutputStream out = new FileOutputStream(file);

        for(int i = 0; i < contents.size(); i++){
            if(i != contents.size()-1) {
                out.write(contents.get(i).getBytes());
                out.write('\n');
            }
            else{
                out.write(contents.get(i).getBytes());
            }
        }
        out.close();

    }
}