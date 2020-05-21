package com.example.parcial2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View;

public class selectperfActivity extends AppCompatActivity {
    RadioGroup grupo;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectperf);

        grupo = (RadioGroup) findViewById(R.id.opciones);
        Intent w = getIntent();
        tipo= w.getStringExtra("tipouser");
    }

    public void SelectionPerf(View view) {
        if (grupo.getCheckedRadioButtonId() == R.id.opcion1) {

           if(tipo.equals("1")){
               Intent a = new Intent(this, ProfevistaActivity.class);
               startActivity(a);

           }else if(tipo.equals("2")){
               Intent a = new Intent(this, EstuvistaActivity.class);
               startActivity(a);
           }

        }else if(grupo.getCheckedRadioButtonId() == R.id.opcion2) {
            Uri webpage = Uri.parse("http://utp.ac.pa");
            Intent a = new Intent(Intent.ACTION_VIEW, webpage);
            if (a.resolveActivity(getPackageManager()) != null) {
                startActivity(a);
            }
        }else if(grupo.getCheckedRadioButtonId() == R.id.opcion3) {
            Uri webpage = Uri.parse("http://ecampus.utp.ac.pa/moodle");
            Intent a = new Intent(Intent.ACTION_VIEW, webpage);
            if (a.resolveActivity(getPackageManager()) != null) {
                startActivity(a);
            }
        }else
            Toast.makeText(this, "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();

    }
}
