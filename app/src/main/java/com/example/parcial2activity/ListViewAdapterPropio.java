package com.example.parcial2activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapterPropio extends ArrayAdapter<Titulos>
{

    private  List<Titulos> opciones = new ArrayList<>();

    public ListViewAdapterPropio(Context context, List<Titulos> datos){
        super(context, R.layout.activity_estuvista, datos);

        opciones= datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_estuvista, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.txtl1);
        lblTitulo.setText(opciones.get(position).getTitulo());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.txtl1);
        lblSubtitulo.setText(opciones.get(position).getSubtitulo());

        return(item);
    }
}
