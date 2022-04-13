package com.ndp.picodiploma.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;    //limit upto 20 from 1

    }

    public void randomNumberGenerator() //for repeating the game
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }

    public void onGuess(View view) {

        String message;
        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());

        try {
            if(guessedNumber < randomNumber)
                message="Higher !!";
            else if(guessedNumber > randomNumber)
                message="Lower !!";
            else
            {
                message="You got me !!";
                randomNumberGenerator();    //kinda recurtion !
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
             message = "Something went wrong !!";
             Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
//        finally {
//            Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();
//        }
    }

}