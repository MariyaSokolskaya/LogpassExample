package com.example.logpassexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
}