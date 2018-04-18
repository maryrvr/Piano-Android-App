package com.example.geovana.login1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);//activity_main

        Name = (EditText)findViewById(R.id.etxtNombreUsuario);
        Password = (EditText)findViewById(R.id.etxtContraseña);
        Info = (TextView)findViewById(R.id.txtvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No. de intentos restantes: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if(userName.equals("Admin") && userPassword.equals("1234")){
            Intent intent = new Intent(MainActivity.this,PianoActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("No. de intentos restantes: " + String.valueOf(counter));
            if(counter == 0){
                Login.setEnabled(false);
                Name.setEnabled(false);
                Password.setEnabled(false);
                Info.setText("Debe reiniciar la aplicacion");
            }
        }
    }

}