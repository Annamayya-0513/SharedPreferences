package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Second extends AppCompatActivity {

    Button LogoutBtn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LogoutBtn = (Button)findViewById(R.id.LogoutBtn);

        sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);

        LogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sharedPreferences.contains("username")){

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();

                     Intent intent = new Intent(Second.this,MainActivity.class);
                     startActivity(intent);

                }

            }
        });
    }
}
