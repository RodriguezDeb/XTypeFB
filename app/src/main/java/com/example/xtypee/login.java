package com.example.xtypee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// import com.example.xtypee.Service.DbUsuarios;
import com.example.xtypee.des.MyDesUtil;
import com.example.xtypee.json.MyInfo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class login extends AppCompatActivity {


    private FirebaseAuth auth;


    public static final String KEY = "+4xij6jQRSBdCymMxweza/uMYo+o0EUg";
    private String testClaro = "Hola mundo";
    private String testDesCifrado;

    public String correo;
    public String mensaje;
    public static List<MyInfo> list;
    public static String TAG = "mensaje";
    public static String TOG = "error";
    public static String json = null;
    public static String usr,pswd;
    private Button button1, button2, button3,buttonfeis, buttonIG, buttonTT, buttonGIT;
    String _url="https://www.instagram.com/technoswamp/";
    String _urlT="https://twitter.com/Technoswam";
    String _urlfb="https://www.facebook.com/profile.php?id=100086036944709&mibextid=ZbWKwL";
    String _urlgit="https://github.com/Technoswamp";
    public MyDesUtil myDesUtil= new MyDesUtil().addStringKeyBase64(KEY);

    /* EditText email1 = findViewById(R.id.email); */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
       // EditText email1 = findViewById(R.id.email);

        button2 = findViewById(R.id.buttonR);
        button1 = findViewById(R.id.buttonL);
        buttonfeis = findViewById(R.id.buttonfeis);
        buttonIG = findViewById(R.id.buttonIG);
        buttonTT = findViewById(R.id.buttonTT);
        buttonGIT = findViewById(R.id.buttonGIT);
      /**/  EditText email1 = findViewById(R.id.user);
        EditText pswds = findViewById(R.id.pswds);

        buttonGIT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_urlgit);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        buttonfeis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_urlfb);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        buttonTT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_urlT);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        buttonIG.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri _link = Uri.parse(_url);
                Intent i = new Intent(Intent.ACTION_VIEW,_link);
                startActivity(i);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                correo = email1.getText().toString();
              /*  usr = String.valueOf(usuario.getText()); */
                pswd = String.valueOf(pswds.getText());
               /* acceso(usr , pswd); */

               if(!correo.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(correo).matches()){

                   if(!pswd.isEmpty()){
                       auth.signInWithEmailAndPassword(correo, pswd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                           @Override
                           public void onSuccess(AuthResult authResult) {
                               startActivity(new Intent(login.this, MainActivity.class));
                               finish();
                           }
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Toast.makeText(login.this, "Error", Toast.LENGTH_SHORT).show();
                           }
                       });
                   }else{
                       pswds.setError("La contraseña no puede estar vacía");
                   }

                }if(correo.isEmpty()){
                   email1.setError("El correo no puede estar vacío");
                }else{
                   email1.setError("Por favor ingresa un correo válido");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, registro.class);
                startActivity(intent);
            }
        });
    }

   /* public void acceso(String usr , String pswd){
        int i=0;
        if(usr.equals("")||pswd.equals("")){
            Toast.makeText(getApplicationContext(), "Llena los campos", Toast.LENGTH_LONG).show();
        }else{
            DbUsuarios dbUsuarios = new DbUsuarios(login.this);
            MyInfo myInfo = dbUsuarios.GetUsuario(usr);
            if (myInfo!=null){
               if (myInfo.getPassword().equals(pswd)){
                    Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(login.this, MainActivity.class);
                    intent.putExtra("Objeto", myInfo);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "No se ha encontrado el usuario", Toast.LENGTH_LONG).show();
            }
        }
    }*/
}