package com.example.anamm.flashcardapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
    });
        findViewById(R.id.myBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }

        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode== RESULT_OK) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String s1 = data.getExtras().getString("stringKey1"); // 'string1' needs to match the key we used when we put the string in the Intent
            String s2 = data.getExtras().getString("stringKey2");
            ((TextView) findViewById(R.id.flashcard_question)).setText(s1);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(s2);

        }
    }
}


