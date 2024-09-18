package com.example.zavrsnikuci.rute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.zavrsnikuci.MapsActivity;
import com.example.zavrsnikuci.R;

public class kopacki extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopacki);
        Button ruta = (Button) findViewById(R.id.button_greda);
        getSupportActionBar().hide();
        ruta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                MapsActivity.ruta=1;
                Intent intent = new Intent(kopacki.this, MapsActivity.class);
                startActivity(intent);
            }

        });
    }


}

