package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView luckyNumberText;
    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        luckyNumberText=findViewById(R.id.textLuckyNumber);
        shareButton=findViewById(R.id.button_Share);

        Intent intent=getIntent();
        String userName=intent.getStringExtra("User_Name");
        int luckyNumber=intent.getIntExtra("Lucky_Number",0);

        luckyNumberText.setText(userName+"'s Lucky Number is:\n\n\n\n"+luckyNumber);
        luckyNumberText.setGravity(Gravity.CENTER);


        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareText=userName+"'s Lucky Number is:"+luckyNumber;

                Intent shareIntent=new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareText);
                shareIntent.setType("text/plain");

                startActivity(Intent.createChooser(shareIntent,"Share via"));
            }
        });

    }
}