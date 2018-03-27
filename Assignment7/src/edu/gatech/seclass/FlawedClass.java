package edu.gatech.seclass;

public class FlawedClass {



    public int flawedMethod1(int x, int y){
        if( x == 0 || y != 0){
            y = y/x;
        }
        return y;
    }

    public int flawedMethod2(int x, int y){
        if( x == 0 || y != 0){
            y = y/x;
        }
        return y;
    }
}
