package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
        getSupportActionBar().setTitle("List Product Activity");

        Button btnGotodetail = findViewById(R.id.btnGotoDetail);

        btnGotodetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListProductActivity.this,DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}