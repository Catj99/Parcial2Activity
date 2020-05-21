package com.example.parcial2activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    String cedula,password,nom, cedula1,password1, nom1, tipo;
    EditText pass,cedu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.InicializarControles();
        this.CargarPrefProfe();
        this.CargarPrefEstud();
    }

    public void InicializarControles() {
        pass = (EditText) findViewById(R.id.txtpw);
        cedu = (EditText) findViewById(R.id.txtced);
    }

    public void CargarPrefProfe() {
        SharedPreferences admin = getSharedPreferences("Profesor", Context.MODE_PRIVATE);
        nom=admin.getString("nombre", "Juan Zamora");
        cedula = admin.getString("cedula", "8-976-284");
        password = admin.getString("contra", "31559");
    }

    public void CargarPrefEstud() {
        SharedPreferences admin1 = getSharedPreferences("Estudiante", Context.MODE_PRIVATE);
        nom1= admin1.getString("nombre", "Christian Terrones");
        cedula1 = admin1.getString("cedula", "8-941-804");
        password1 = admin1.getString("contra", "20077");
    }

    public void onClick(View view) {
        //VALIDATIONS AND LOGIN
        try {
            if(TextUtils.isEmpty(cedu.getText().toString()))
                cedu.setError("Introduzca su Cedula");
            if(TextUtils.isEmpty(pass.getText().toString()))
                pass.setError("Introduzca la Contraseña");
            else{
                if ((cedu.getText().toString().compareToIgnoreCase(cedula)==0 && pass.getText().toString().equals(password))){
                    tipo="1";
                    Intent i = new Intent(this, selectperfActivity.class);
                    i.putExtra("tipouser", tipo);
                    startActivity(i);
                } else if(cedu.getText().toString().compareToIgnoreCase(cedula1)==0 && pass.getText().toString().equals(password1)){
                    tipo="2";
                    Intent i = new Intent(this, selectperfActivity.class);
                    i.putExtra("tipouser", tipo);
                    startActivity(i);
                }else
                    Toast.makeText(this, "Email or Password incorrect.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Error:" + e, Toast.LENGTH_LONG).show();
        }
    }
}
