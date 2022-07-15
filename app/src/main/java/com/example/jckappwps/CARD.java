package com.example.jckappwps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CARD extends AppCompatActivity {

    private Button bt_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        bt_move = findViewById(R.id.bt_back2);

        bt_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CARD.this , MainActivity.class);
                startActivity(intent);//액티비티 이동
            }
        });
    }
}