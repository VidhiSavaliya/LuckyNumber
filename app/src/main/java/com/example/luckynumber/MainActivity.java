package com.example.luckynumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

     Button buttonWish;
     EditText InputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonWish=findViewById(R.id.button_wish);
        InputName=findViewById(R.id.editTextName);

        buttonWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=InputName.getText().toString();
                int luckyNumber=new Random().nextInt(999);

                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("User_Name", Name);
                intent.putExtra("Lucky_Number",luckyNumber);

                startActivity(intent);


            }
        });

    }
}