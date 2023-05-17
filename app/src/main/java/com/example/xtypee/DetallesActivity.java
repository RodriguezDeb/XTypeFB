package com.example.xtypee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesActivity extends AppCompatActivity {

    TextView detailName;
    TextView detailTamano;
    TextView detailGarage;
    TextView detailBanos;
    TextView detailHabitaciones;
    TextView detailPrecio;
    TextView detailDescripcion;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        detailName = findViewById(R.id.detailName);
        detailTamano = findViewById(R.id.detalleTamano);
        detailHabitaciones = findViewById(R.id.detalleHabitaciones);
        detailGarage = findViewById(R.id.detalleGarage);
        detailBanos = findViewById(R.id.detalleBanos);
        detailPrecio = findViewById(R.id.detallePrecio);
        detailDescripcion = findViewById(R.id.detalleDescripcion);
        detailImage = findViewById(R.id.detailImage);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String garage = intent.getStringExtra("garage");
            String tamano = intent.getStringExtra("tamano");
            String bano = intent.getStringExtra("bano");
            String habitaciones = intent.getStringExtra("habitaciones");
            String precio = intent.getStringExtra("precio");
            String descripcion = intent.getStringExtra("descripcion");
            int image = intent.getIntExtra("image", R.drawable.huno);

            detailName.setText(name);
            detailTamano.setText(tamano);
            detailGarage.setText(garage);
            detailBanos.setText(bano);
            detailHabitaciones.setText(habitaciones);
            detailPrecio.setText(precio);
            detailDescripcion.setText(descripcion);
            detailImage.setImageResource(image);
        }
    }
}







