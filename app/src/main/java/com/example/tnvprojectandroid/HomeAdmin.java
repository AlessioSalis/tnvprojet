package com.example.tnvprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import static com.example.tnvprojectandroid.Registrazione.packag;

public class HomeAdmin extends AppCompatActivity {
    TextView username, password, cittaDiProvenienza, dataDiNascita,benVenuto;
    Button logout, modificaPassword,gestisciUtenti;
    Utente utente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        benVenuto=findViewById(R.id.benvenutoAdmin);
        username = findViewById(R.id.utenteAdmin);
        password = findViewById(R.id.passwordAdmin);
        cittaDiProvenienza = findViewById(R.id.cittaAdmin);
        dataDiNascita = findViewById(R.id.dataDiNascitaAdmin);
        logout = findViewById(R.id.logOutAdmin);
        modificaPassword = findViewById(R.id.passwordChangeAdmin);
        gestisciUtenti = findViewById(R.id.gestisciUtentiAdmin);





        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent esci = new Intent( HomeAdmin.this, MainLogin.class);
                esci.putExtra(packag,utente);
                startActivity(esci);
            }
        });

        modificaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAdmin.this, ModificaPassword.class);
                intent.putExtra(packag,utente);
                startActivity(intent);
            }
        });


        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(packag);

        if (object instanceof Utente) {
            utente = (Utente) object;
        } else {
            utente = new Utente();
        }
        benVenuto.setText("Benvenuto "+utente.getUsername()+"!");
        username.setText(utente.getUsername());
        password.setText(utente.getPassword());
        cittaDiProvenienza.setText(utente.getCittaDiProvenienza());
        dataDiNascita.setText(utente.getDataDiNascita());

    }
}