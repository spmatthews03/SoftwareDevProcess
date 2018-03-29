package edu.gatech.seclass;

public class FlawedClass {



    public void flawedMethod1(boolean a, boolean b){

        // This case is impossible. It is impossible to have 100% branch coverage that doesn't reveal the fault, and
        // have every test suit that achieves a 100% statement coverage that reveals a fault. This is because
        // 100% branch coverage would include the test case with the statement coverage. Branch is more thorough
        // then statement testing


    }

    public int flawedMethod2(boolean a){

        int i = 0;

        if(a)
            i = 1;

        return 1/i;
    }

    public int flawedMethod3(boolean a, boolean b){

        int i = 1;

        if(a)
            i = i + 1;
        if(b)
            i = 5;
        else
            i = i - 1;

        return 1/i;
    }

    public void flawedMethod4(boolean a, boolean b){
        // this is not possible
        // path coverage covers all possible routes through the method, therefore this will include any, and all test
        // suits  of 100% branch coverage
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
