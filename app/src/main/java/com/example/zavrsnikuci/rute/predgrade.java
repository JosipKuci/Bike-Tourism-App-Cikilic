package com.example.zavrsnikuci.rute;
import androidx.appcompat.app.AppCompatActivity;
import com.example.zavrsnikuci.MapsActivity;
import com.example.zavrsnikuci.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class predgrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predgrade);
        Button ruta = (Button) findViewById(R.id.button_greda);
        getSupportActionBar().hide();
        ruta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                MapsActivity.ruta=2;
                Intent intent = new Intent(predgrade.this, MapsActivity.class);
                startActivity(intent);
            }

        });
    }
}