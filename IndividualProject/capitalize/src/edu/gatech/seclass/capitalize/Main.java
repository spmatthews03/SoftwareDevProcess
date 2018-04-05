package edu.gatech.seclass.capitalize;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    private static String file;


    public static void main(String[] args) {
        // Empty Skeleton Method




    }

    private static void usage() {
        System.err.println("Usage: Capitalize  [-w [string]] [-m string] [-f] <filename>");
    }

    private static void delimiterCapitilize(String delimiter){}

    private static void stringCapitilize(String chars) throws IOException{
        List<String> fileContents = new ArrayList<>();

        for (String line : Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8)) {
            //if(Pattern.compile(Pattern.quote(chars), Pattern.CASE_INSENSITIVE).matcher(line).find())
                line.replaceAll("(?i)"+ Pattern.quote(chars), "");
            //}
        }
    }

    private static void flipAll(){}

    private static void noFlags(){}

    private static boolean fileExists() throws FileNotFoundException{}




}