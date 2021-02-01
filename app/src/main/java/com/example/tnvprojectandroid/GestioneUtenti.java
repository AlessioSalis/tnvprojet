package com.example.tnvprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class GestioneUtenti extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione_utenti);


        ListView listView = (ListView)findViewById(R.id.list);



        UtentiAdapter adapter = new UtentiAdapter(this, R.layout.activity_gestione_singolo_elemento, MainLogin.utenti);
        listView.setAdapter(adapter);
    }
}