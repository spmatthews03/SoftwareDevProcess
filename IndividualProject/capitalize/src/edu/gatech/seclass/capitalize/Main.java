package edu.gatech.seclass.capitalize;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.*;
import java.lang.reflect.Array;
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

public class Main {

    private static String file;
    private static List<String> fileContents;
    private static List<String> arguments;
    private static boolean FILE_EXISTS;

    public static void main(String[] args) {

        if(args == null) {
            usage();
            return;
        }

        if(args.length > 0 && args.length <= 6){
            arguments = new ArrayList<>(Arrays.asList(args));

            parseArgs(arguments);
        }
        else{
            throw new IllegalArgumentException("Invalid Arguments");
        }

        //Parse arguments
        try {
            if (FILE_EXISTS) {

                fileContents = new ArrayList<>();
                capitalize();

            }
        }

        catch (IOException e){
            System.out.println("File not found!");
        }
    }


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
                }
            }
        }
    }


    private static void parseArgs(List<String> args){
        try {
            if (fileExists(args.get(args.size() - 1))){
                FILE_EXISTS = true;
                file = args.get(args.size() - 1);

                args.remove(args.size()-1);
            }
            else{
                FILE_EXISTS = false;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File doesn't exist!");
        }
    }


    private static void usage() {
        System.err.println("Usage: Capitalize  [-w [string]] [-m string] [-f] <filename>");
    }


    private static void delimiterCapitilize(String delimiter) throws IOException{
        Path path = Paths.get(file);
        List<String> content = new ArrayList<>();
        boolean endOfLineDelimiter = false;

        for (String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {

            char[] chars =  line.toCharArray();

            for(int i = 0; i < line.length(); i++){
                char c = chars[i];

                for(int j = 0; j < delimiter.length(); j++){
                    if(c == delimiter.charAt(j) && (i+1) != line.length()){
                        chars[i+1] = Character.toUpperCase(chars[i+1]);
                    }
                    else if(c == delimiter.charAt(j) && (i+1) == line.length()){
                        endOfLineDelimiter = true;
                    }
                    else if(endOfLineDelimiter){
                        chars[i] = Character.toUpperCase(chars[i]);
                        endOfLineDelimiter = false;
                    }

                }
            }
            content.add(new String(chars));
        }
        Files.write(path, content);
    }


    private static void stringCapitilize(String chars) throws IOException{

        Path path = Paths.get(file);
        Stream<String> lines = Files.lines(path);
        List<String> toReplace =
                lines.map(line -> line.replaceAll("(?i)"+ Pattern.quote(chars), chars))
                        .collect(Collectors.toList());
        Files.write(path,toReplace);

        lines.close();
    }


    private static void flipAll() throws IOException{
        Path path = Paths.get(file);
        List<String> content = new ArrayList<>();

        for(String line : Files.readAllLines(path, StandardCharsets.UTF_8)) {


            char[] chars = line.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                } else if (Character.isLowerCase(c)) {
                    c = Character.toUpperCase(c);
                }
                chars[i] = c;
            }
            content.add(new String(chars));
        }

        Files.write(path, content);
    }


    private static void noFlags() throws IOException{
        Path path = Paths.get(file);
        List<String> content = new ArrayList<>();

        for(String line : Files.readAllLines(path, StandardCharsets.UTF_8)){
            String newLine = line.substring(0,1).toUpperCase() + line.substring(1);
            content.add(newLine);
        }
        Files.write(path, content);
    }


    private static boolean fileExists(String filename) throws FileNotFoundException{
        File file = new File(filename);
        if(file.exists())
            return true;
        else
            return false;
    }
}