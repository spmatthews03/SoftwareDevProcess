package edu.gatech.seclass;

public class FlawedClass {



    public int flawedMethod1(boolean a, boolean b){

        int x = 1;

        if(a == true)
        {
            x = x  + 1;
        }
        if(b == true)
        {
            x = 10;
        }
        else
        {
            x = x - 2;
        }

        return 1 / x;
    }

    public int flawedMethod2(boolean a, boolean b){


    }

    public int flawedMethod3(boolean a, boolean b){

        return 0;
    }

    public int flawedMethod4(boolean a, boolean b){
        return 0;
    }




    public boolean flawedMethod5 (boolean a, boolean b) {
        int x = 2;
        int y = 4;
        if(a)
            x = 4;
        else
            y = y / x;
        if(b)
            y -= x;
        else
            x += y;
        return ((x/y)>0);
    }

// | a | b |output|
// ================
// | T | T | E   |
// | T | F | T   |
// | F | T | E   |
// | F | F | T   |
// ================
// Coverage required: _____path coverage_____

}
