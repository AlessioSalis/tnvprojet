/*package com.example.tnvprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GestioneUtenti extends AppCompatActivity {
    Utente utente;
    @Override
      protected void onCreate (Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gestione_utenti);
           Utente[] utente = new String[]{"Torino", "Roma", "Milano", "Napoli", "Firenze"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_home, citta);
            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);
        }
    }
*/