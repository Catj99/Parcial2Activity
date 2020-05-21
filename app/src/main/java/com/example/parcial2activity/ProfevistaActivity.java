package com.example.parcial2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfevistaActivity extends AppCompatActivity {
    TextView txtv;
    String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profevista);
        Toast.makeText(this, "Bienvenido Profesor", Toast.LENGTH_LONG).show();
        this.asignarTxt();
    }
    public void asignarTxt(){
        txtv = (TextView)findViewById(R.id.txtv);
            SharedPreferences admin1 = getSharedPreferences("Profesor", Context.MODE_PRIVATE);
        nom= admin1.getString("nombre","Juan Zamora");
        txtv.setText("Bienvenido "+nom);
    }
}
