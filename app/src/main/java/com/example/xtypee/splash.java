package com.example.xtypee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

 //import com.example.xtypee.Service.UsuariosDBService;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //UsuariosDBService usuariosDBService = new UsuariosDBService(splash.this);
       // SQLiteDatabase db = usuariosDBService.getWritableDatabase();

    /*    if(db!= null){
            Toast.makeText(this,"BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        } */

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this,choice.class));
                finish();
            }
        },3000);
    }
}