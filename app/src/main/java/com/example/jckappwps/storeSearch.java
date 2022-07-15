package com.example.jckappwps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class storeSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejangsceach);

        Button bt_move = findViewById(R.id.bt_back1);

        bt_move.setOnClickListener(view -> {
            Intent intent = new Intent(storeSearch.this , MainActivity.class);
            startActivity(intent);//액티비티 이동
        });
    }
}