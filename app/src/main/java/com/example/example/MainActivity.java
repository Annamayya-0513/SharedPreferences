package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText UserEditTxt;
    Button LoginBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserEditTxt = (EditText)findViewById(R.id.UserEditTxt);
        LoginBtn = (Button) findViewById(R.id.LoginBtn);

        sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);

        final Intent intent = new Intent(MainActivity.this,Second.class);

        if (sharedPreferences.contains("username")){
            startActivity(intent);
        }

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = UserEditTxt.getText().toString();

                if (Name.equals("hii")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username",Name);

                    editor.commit();

                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "No valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
