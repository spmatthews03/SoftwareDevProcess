package edu.gatech.seclass.capitalize;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    private static String file;
    private static List<String> fileContents;
    private static List<String> arguments;
    private static boolean FILE_EXISTS;

    public static void main(String[] args) {

        arguments = new ArrayList<>(Arrays.asList(args));

        if(args.length > 0 && args.length <= 6){
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
//        catch(InvalidArgumentException e){
//            System.out.println("Invalid Argument");
//        }
    }


    private static void capitalize() throws IOException{

        for(int i = 0; i < arguments.size(); i++){

            switch(arguments.get(i)){
                case "-w":
                    if( i + 1 == arguments.size()){
                        delimiterCapitilize(" ");
                    }
                    else if(arguments.get(i+1).equals("-w") || arguments.get(i+1).equals("-f")){
                        delimiterCapitilize(" ");
                    }
                    else{
                        delimiterCapitilize(arguments.get(i+1));
                    }

                case "-m":
                    if(arguments.get(i + 1).equals("-w") || arguments.get(i + 1).equals("-f")){
                        throw new IllegalArgumentException("String flag must have a string.");
                    }
                    else{
                        stringCapitilize(arguments.get(i + 1));
                    }
//                case "-f":
//                    if(){
//
//                    }
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
        for (String line : Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8)) {

            for(int i = 0; i < line.length(); i++){
                for(int j = 0; i < delimiter.length(); i++){

                    if(line.indexOf(delimiter.charAt(j)) > 0){

                    }
                }
            }

            line.replaceAll("(?i)"+ Pattern.quote(delimiter), "");
        }
    }




    private static void stringCapitilize(String chars) throws IOException{

        for (String line : Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8)) {
                line.replaceAll("(?i)"+ Pattern.quote(chars), "");
        }
    }





    private static String flipAll(String line) throws IOException{
        char[] chars = line.toCharArray();

        for(char c : chars){
            if(Character.isUpperCase(c)){
                c = Character.toLowerCase(c);
            }
            else if(Character.isLowerCase(c)){
                c = Character.toUpperCase(c);
            }
        }
        return new String(chars);

    }

    private static void noFlags(){}

    private static boolean fileExists(String filename) throws FileNotFoundException{
        File file = new File(filename);
        if(file.exists())
            return true;
        else
            return false;
    }




}