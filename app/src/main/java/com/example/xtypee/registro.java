package com.example.xtypee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

// import com.example.xtypee.Service.DbUsuarios;
import com.example.xtypee.des.MyDesUtil;
import com.example.xtypee.json.MyData;
import com.example.xtypee.json.MyInfo;
import com.example.xtypee.metodos.Metodos;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class registro extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth auth;


    private Button button4,pick;
    private EditText usuario,pswd,mail,num,fec,nombre;
    private CheckBox box1, box2, box3;
    private Spinner spinner;
    private RadioButton r1,r2;
    private int dia, mes , ano;
    private static final String TAG = "MainActivity";
    public static final String archivo = "S.json";
    String json = null;
    public static String usr,password,email,numero,fecha,region,nom;
    public static int sw = 0;
    public static int activado;
    public static String[] box = new String[3];
    public static String box1s;
    public static String box2s;
    public static String box3s;

    public static List<MyInfo> list =new ArrayList<MyInfo>();
    public static List<MyData> lista;
    public static final String KEY = "+4xij6jQRSBdCymMxweza/uMYo+o0EUg";
    public MyDesUtil myDesUtil= new MyDesUtil().addStringKeyBase64(KEY);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        auth = FirebaseAuth.getInstance();

        //Contraseñas nuevas
        lista= new ArrayList<>();
        MyData myData=null;
        String [] opciones = {"Norte","Sur","Centro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        pick = findViewById(R.id.pick);
        button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        usuario = findViewById(R.id.usuario);
        pswd = findViewById(R.id.pswd);
        mail = findViewById(R.id.email);
        num = findViewById(R.id.num);
        fec = findViewById(R.id.fec);
        fec.setEnabled(false);
        nombre = findViewById(R.id.nombre);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(registro.this, login.class);
                startActivity(intent);
            }
        });
        pick.setOnClickListener(this);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí borrale el trim si algo sale mal
                MyInfo info= new MyInfo();
                usr = String.valueOf(usuario.getText()).trim();
                password = String.valueOf(pswd.getText()).trim();
                email= String.valueOf(mail.getText());
                numero = String.valueOf(num.getText());
                fecha = String.valueOf(fec.getText());
                //region = spinner.getSelectedItem().toString();
                nom = String.valueOf(nombre.getText());

                /*if(box1.isChecked()==true){
                    box1s="opcion1";
                }else{
                    box1s="no";
                }
                if(box2.isChecked()==true){
                    box2s="opcion2";
                }else{
                    box2s="no";
                }
                if(r1.isChecked()==true){
                    activado=1;
                }
                if(r2.isChecked()==true){
                    activado=1;
                }
                 */
                //Validaciones
                if(usr.equals("")||password.equals("")||email.equals("")){
                    Log.d(TAG,"vacio");
                    Log.d(TAG,usr);
                    Log.d(TAG,password);
                    Log.d(TAG,email);
                    Toast.makeText(getApplicationContext(), "LLena los campos", Toast.LENGTH_LONG).show();
                }else{
                    //Aquí le moviste
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(registro.this, "Registro Exitoso",  Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(registro.this, login.class));
                            }else{
                               Toast.makeText(registro.this, "Registro Fallido", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                  /*  if(Metodos.validarEmail(email)){
                        Metodos.fillInfo(info);
                        DbUsuarios dbUsuarios = new DbUsuarios(registro.this);
                        long id=dbUsuarios.saveUser(info);
                        if (id > 0){
                            Toast.makeText(registro.this, "REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(registro.this, "ERROR AL GUARDAR REGISTRO",Toast.LENGTH_LONG).show();
                        }

                    }else{
                        Toast.makeText(getApplicationContext(), "Introduzca un correo válido", Toast.LENGTH_LONG).show();
                    } */

                }
            }
        });


    }



    @Override
    public void onClick(View v) {
        if(v==pick){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    fec.setText(i2+"/"+(i1+1)+"/"+i);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
}