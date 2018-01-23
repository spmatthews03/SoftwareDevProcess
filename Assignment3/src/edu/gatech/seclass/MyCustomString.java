package edu.gatech.seclass;

public class MyCustomString implements MyCustomStringInterface {
    private String string;

    private MyCustomString(){
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

        return 0;
    }

    @Override
    public String increaseDigits(int n, boolean wrap) throws NullPointerException, IllegalArgumentException{
        // throw checks
        if(string == null)
            throw new NullPointerException("String is null");
        if(n > Math.abs(n))
            throw new IllegalArgumentException("Number passed in cannot be greater than 9 or less than -9.");

        int tmp;

        for(int i = 0; i < string.length(); i++){
            if(Character.isDigit(string.charAt(i))){
                tmp = Integer.parseInt(string.valueOf(string.charAt(i)));
                tmp = tmp + n;
                if( tmp > 9) {
                    tmp = tmp % 9;
                }
                string = string.substring(0,i) + tmp +string.substring(i+1);
            }
        }

        return null;
    }

    @Override
    public void convertLettersToDigitsInSubstring(int startPosition, int endPosition) {

    }
}
