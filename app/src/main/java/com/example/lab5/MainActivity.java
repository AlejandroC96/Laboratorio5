package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Perros> perros;

    private void inicializarDatos(){
        perros = new ArrayList<>();
        perros.add(new Perros("Buldog","3 Años de edad","Se llama Firulais",R.drawable.buldog));
        perros.add(new Perros("Chiguaguas","4 Años de edad","Se llama Roberto",R.drawable.chiguagua));
        perros.add(new Perros("Dalmata","2 Años de edad","Se llama Samuel",R.drawable.dalmata));
        perros.add(new Perros("Gran danes","4 Años de edad","Se llama Luz",R.drawable.grandanes));
        perros.add(new Perros("Pequines","5 Años de edad","Se llama Gigante",R.drawable.pequines));
        perros.add(new Perros("Perro Peruano","7 Años de edad","Se llama Chilenito",R.drawable.peruano));
        perros.add(new Perros("Rottweiler","1 Años de edad","Se llama Cariñosito",R.drawable.rottweiler));
        perros.add(new Perros("Shitzu","9 Años de edad","Se llama Blanca",R.drawable.shitzu));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(linearLayoutManager);

        inicializarDatos();

        RVAdapter rvAdapter = new RVAdapter(perros,getApplicationContext());
        recyclerView.setAdapter(rvAdapter);
    }
}