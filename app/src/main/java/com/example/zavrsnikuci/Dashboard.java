package com.example.zavrsnikuci;

import com.example.zavrsnikuci.rute.kopacki;
import com.example.zavrsnikuci.rute.promenada;
import com.example.zavrsnikuci.rute.ZlatnaGreda;
import com.example.zavrsnikuci.rute.predgrade;
import com.example.zavrsnikuci.Omeni;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        findViewById(R.id.card1).setOnClickListener(this::onClick);
        findViewById(R.id.card2).setOnClickListener(this::onClick);
        findViewById(R.id.card3).setOnClickListener(this::onClick);
        findViewById(R.id.card4).setOnClickListener(this::onClick);
        findViewById(R.id.card5).setOnClickListener(this::onClick);
        findViewById(R.id.card6).setOnClickListener(this::onClick);
        findViewById(R.id.card7).setOnClickListener(this::onClick);
        findViewById(R.id.card8).setOnClickListener(this::onClick);
        getSupportActionBar().hide();
    }
    private void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.card1:
                Intent intent = new Intent(Dashboard.this, kopacki.class);
                startActivity(intent);
                break;
            case R.id.card2:
                Intent intent1 = new Intent(Dashboard.this, predgrade.class);
                startActivity(intent1);
                break;
            case R.id.card3:
                Intent intent2 = new Intent(Dashboard.this, promenada.class);
                startActivity(intent2);
                break;
            case R.id.card4:
                Intent intent3 = new Intent(Dashboard.this, ZlatnaGreda.class);
                startActivity(intent3);
                break;
            case R.id.card5:
                Toast.makeText(this, "Dolazi uskoro!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card6:
                Toast.makeText(this, "Dolazi uskoro!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card7:
                Intent intent4 = new Intent(Dashboard.this, Omeni.class);
                startActivity(intent4);
                break;
            case R.id.card8:
                finish();
                System.exit(0);
                break;

        }

    }


}