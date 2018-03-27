package edu.gatech.seclass;

public class FlawedClass {



    public int flawedMethod1(int x, int y){
        if( x == 0 || y != 0){
            y = y/x;
        }
        return y;
    }

    public int flawedMethod2(int x, int y){

        return 0;
    }

    public int flawedMethod3(int x, int y){

        return 0;
    }

    public int flawedMethod4(int x, int y){
        return 0;
    }

    public boolean flawedMethod5(boolean a, boolean b){
        int x = 2;
        int y = 4;
        if(a)
            x = 4;
        else
            y = y/x;
        if(b)
            y -= x;
        else
            x += y;
        return ((x/y)>0);
    }
}
