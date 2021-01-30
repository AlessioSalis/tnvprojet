package com.example.tnvprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import static com.example.tnvprojectandroid.Registrazione.packag;

public class Home extends AppCompatActivity {

    TextView username,password,cittaDiProvenienza,dataDiNascita;
    Button logout,modificaPassword;
    Utente utente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username=findViewById(R.id.utente);
        password=findViewById(R.id.password);
        cittaDiProvenienza=findViewById(R.id.citta);
        dataDiNascita=findViewById(R.id.dataDiNascita);
        logout=findViewById(R.id.logout);
        modificaPassword=findViewById(R.id.passwordChange);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  finish();
            }
        });

        modificaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Home.this,ModificaPassword.class);
                startActivity(intent);
            }
        });


        Intent intent=getIntent();
        Serializable object =intent.getSerializableExtra(packag);

        if(object instanceof Utente){
            utente = (Utente) object;
        }else{
            utente =new Utente();
        }

        username.setText(utente.getUsername());
        password.setText(utente.getPassword());
        cittaDiProvenienza.setText(utente.getCittaDiProvenienza());
        dataDiNascita.setText(utente.getDataDiNascita());

    }
}