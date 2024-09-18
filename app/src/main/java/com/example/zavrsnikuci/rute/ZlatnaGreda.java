package com.example.zavrsnikuci.rute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zavrsnikuci.MapsActivity;
import com.example.zavrsnikuci.R;

public class ZlatnaGreda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zlatna_greda);
        Button ruta = (Button) findViewById(R.id.button_greda);
        getSupportActionBar().hide();
        ruta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                MapsActivity.ruta=4;
                Intent intent = new Intent(ZlatnaGreda.this, MapsActivity.class);
                startActivity(intent);
            }

        });
    }
}