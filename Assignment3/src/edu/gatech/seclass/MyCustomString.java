package edu.gatech.seclass;

public class MyCustomString implements MyCustomStringInterface {
    private String string;

    public MyCustomString(){
        // leaving null
    }

    @Override
    public String getString() {
        return this.string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int countNumbers() {
        int num = 0;
        boolean prev = false;

        for( int i = 0; i < string.length(); i++){
            if(Character.isDigit(string.charAt(i)) && !prev){
                num++;
                prev = true;
            }
            else{
                prev = false;
            }
        }

        return num;
    }

    @Override
    public String increaseDigits(int n, boolean wrap) throws NullPointerException, IllegalArgumentException{
        // throw checks
        String tmpString = this.string;
        if(tmpString == null)
            throw new NullPointerException("String is null");
        if(n > Math.abs(n))
            throw new IllegalArgumentException("Number passed in cannot be greater than 9 or less than -9.");

        int tmp;

        for(int i = 0; i < tmpString.length(); i++){
            if(Character.isDigit(tmpString.charAt(i))){
                tmp = Integer.parseInt(tmpString.valueOf(tmpString.charAt(i)));
                tmp = tmp + n;
                if( tmp > 9) {
                    tmp = tmp % 9;
                }
                tmpString = tmpString.substring(0,i) + tmp +tmpString.substring(i+1);
            }
        }

        return tmpString;
    }

    @Override
    public void convertLettersToDigitsInSubstring(int startPosition, int endPosition) throws NullPointerException,
            IllegalArgumentException, MyIndexOutOfBoundsException {
        String tmpString = this.string;
        String buildString = "";

        if(tmpString == null)
            throw new NullPointerException("String is null");
        if(startPosition < 1 || endPosition < startPosition)
            throw new IllegalArgumentException(" Invalid Start Position");
        if(endPosition > tmpString.length())
            throw new MyIndexOutOfBoundsException("End Position is larger then length of the string");

        for(int i = 0; i < tmpString.length(); i++ ){
            if(Character.isAlphabetic(tmpString.charAt(i))) {
                int asci = (int) tmpString.charAt(i);
                int newAsci = asci + 1;

                if(newAsci > 9)
                    buildString = buildString + newAsci;
                else
                    buildString = buildString + "0" + newAsci;
            }
            else{
                buildString = buildString + tmpString.charAt(i);
            }
        }


    }
}
