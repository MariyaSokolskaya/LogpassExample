package com.example.logpassexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AboutActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        constraintLayout = findViewById(R.id.color_layout);
        nameText = findViewById(R.id.pers_name);

        String colorStr = getIntent().getStringExtra("color");
        if (colorStr == null)
            colorStr = "";
        switch (colorStr){
            case "red":
                constraintLayout.setBackgroundColor(Color.RED);
                break;
            case "blue":
                constraintLayout.setBackgroundColor(Color.BLUE);
                break;
            case "green":
                constraintLayout.setBackgroundColor(Color.GREEN);
                break;
            default:
                constraintLayout.setBackgroundColor(Color.MAGENTA);

        }
    }

    public void sendResult(View view) {
        String persName = nameText.getText().toString();
        Intent backIntent = new Intent(AboutActivity.this, MainActivity.class);
        backIntent.putExtra("name", persName);
        setResult(RESULT_OK, backIntent);
        //startActivity(backIntent);
    }
}