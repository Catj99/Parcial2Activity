package com.example.parcial2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;


public class EstuvistaActivity extends AppCompatActivity {
    private TextView txtv1;
    private String nom1;
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estuvista);
        Toast.makeText(this, "Bienvenido Estudiante", Toast.LENGTH_LONG).show();
        this.asignarTxt();
       this.InitializeControls();
        this.LoadListViewTemplate();
    }

    public void asignarTxt(){
        txtv1 = (TextView)findViewById(R.id.t1);
        SharedPreferences admin1 = getSharedPreferences("Estudiante", Context.MODE_PRIVATE);
        nom1= admin1.getString("nombre","Christian Terrones");
        txtv1.setText("Bienvenido "+nom1);
    }

    private void InitializeControls()
    {
        lstOpciones = (ListView)findViewById(R.id.list1);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                String opcionSeleccionada =
                    ((TextView)v.findViewById(R.id.txtl1))
                            .getText().toString();

            }
        });
    }

    private void LoadListViewTemplate()
    {
        List<Titulos> opciones = this.GetElementsToListViewTemplate();

        ListViewAdapterPropio adapter = new ListViewAdapterPropio(this, opciones);

        lstOpciones.setAdapter(adapter);
    }

    private List<Titulos> GetElementsToListViewTemplate()
    {
        List<Titulos> opciones = new ArrayList<Titulos>();

        opciones.add(new Titulos("Desarrollo I", "Semestre I", ""));
        opciones.add(new Titulos("Desarrollo II", "Semestre II", ""));
        opciones.add(new Titulos("Base de Datos I", "Semestre I", ""));
        opciones.add(new Titulos("Base de Datos II", "Semestre II", ""));
        opciones.add(new Titulos("Estructura de Datos I", "Semestre I", ""));
        opciones.add(new Titulos("Estructura de Datos II", "Semestre II", ""));
        opciones.add(new Titulos("Matematica I", "Semestre I", ""));
        opciones.add(new Titulos("Matematica II", "Semestre II", ""));
        opciones.add(new Titulos("Organizacion y Arq. I", "Semestre I", ""));
        opciones.add(new Titulos("Organizacion y Arq. II", "Semestre II", ""));
        return  opciones;

    }

    }
