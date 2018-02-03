package edu.gatech.seclass.vcipher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class VCipherActivity extends AppCompatActivity {

    Button button;
    EditText resultText;
    private String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vcipher);
        button = (Button) findViewById(R.id.runButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                encryptEntry();
            }
        });
    }

    private void encryptEntry(){
        EditText edText = (EditText) findViewById(R.id.text);
        EditText cypherText = (EditText) findViewById(R.id.keyphrase);

        String text = edText.getText().toString();
        String cypherBy = cypherText.getText().toString();
        RadioButton rb1 = (RadioButton)findViewById(R.id.encrypt);
        RadioButton rb2 = (RadioButton)findViewById(R.id.decrypt);
        resultText = (EditText)findViewById(R.id.answer);
        boolean noError = true;

        if(cypherBy.isEmpty()){
            cypherText.setError("Keyphrase required");
            noError = false;
        }
        if(!hasLetters(text)){
            edText.setError("Nothing to encode/decode");
            noError = false;
        }
        if(!noDigits(cypherBy)){
            cypherText.setError("Non-alphabetic character(s) in keyphrase");
            noError = false;
        }

        else if( noError ){
            if(rb1.isChecked())
                ans = encrypt(text, cypherBy);
            else if(rb2.isChecked())
                ans = decrypt(text, cypherBy);

            resultText.setText(ans, TextView.BufferType.EDITABLE);
        }

    }

    private boolean noDigits(String str) {
        boolean hasDigits = false;
        for(int i = 0; i < str.length(); i++)
        {
            if(Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }


    private boolean hasLetters(String s){
        boolean hasLetter = false;
        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isAlphabetic(s.charAt(i)))
                return true;
        }
        return false;
    }


    private String encrypt(String text, final String key) {
        String crypt = "";
        String newKey = key.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            boolean upper = false;

            if(Character.isAlphabetic(text.charAt(i))) {
                char c = text.charAt(i);
                // Checking if letter and upper case
                if (Character.isUpperCase(c)) {
                    upper = true;
                } else
                    c = Character.toUpperCase(c);

                if (c < 'A' || c > 'Z') continue;

                char tmpChar = (char) ((c + newKey.charAt(j) - 2 * 'A') % 26 + 'A');
                if (upper == true)
                    crypt += tmpChar;
                else
                    crypt += Character.toLowerCase(tmpChar);
                j = ++j % newKey.length();
            }
            else {
                crypt += text.charAt(i);
            }
        }
        return crypt;
    }

    private String decrypt(String text, final String key) {
        String crypt = "";
        String newKey = key.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            boolean upper = false;

            if(Character.isAlphabetic(text.charAt(i))) {
                char c = text.charAt(i);

                // Checking if letter and upper case
                if (Character.isUpperCase(text.charAt(i))) {
                    upper = true;
                }else
                    c = Character.toUpperCase(c);

                if (c < 'A' || c > 'Z') continue;
                char tmpChar = (char) ((c - newKey.charAt(j) + 26) % 26 + 'A');
                if (upper == true)
                    crypt += tmpChar;
                else
                    crypt += Character.toLowerCase(tmpChar);
                j = ++j % newKey.length();
            }else {
                crypt += text.charAt(i);
            }
        }
        return crypt;
    }

}
