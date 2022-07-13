package com.example.jckappwps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_move1;
    private Button bt_move2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_move1 = findViewById(R.id.bt_a);
        bt_move2 = findViewById(R.id.bt_c);

        bt_move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , MEJANGsceach.class);
                startActivity(intent);//액티비티 이동
            }
        });
        bt_move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , CARD.class);
                startActivity(intent);//액티비티 이동
            }
        });


    }
}