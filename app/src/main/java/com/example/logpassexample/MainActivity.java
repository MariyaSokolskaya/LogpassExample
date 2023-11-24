package com.example.logpassexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText loginText, passwordText;
    Button enterButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //поиск объектов в разметке
        loginText = findViewById(R.id.login);
        passwordText = findViewById(R.id.password);
        enterButton = findViewById(R.id.enter_button);
        resultText = findViewById(R.id.res_enter);

        //обработка нажатий на кнопку
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = loginText.getText().toString();
                String password = passwordText.getText().toString();
                String res="";
                if (password.equals("qwerty")){
                    resultText.setTextColor(Color.WHITE);
                    res = login + ", пароль верный!!!";
                }else {
                    resultText.setTextColor(Color.RED);
                    res = login + ", пароль неверный!!!";
                }
                resultText.setText(res);
                loginText.setText("");
                passwordText.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //Вариант 1
        menu.findItem(R.id.about).setIntent(new Intent(MainActivity.this, AboutActivity.class));

        return true;
    }
    //Вариант 2 - использование функции

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        startActivity(item.getIntent());
        if (item.getItemId() == R.id.exit){
            finish();
        }
        return true;
    }
}