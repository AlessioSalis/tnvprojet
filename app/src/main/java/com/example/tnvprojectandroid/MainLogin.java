package com.example.tnvprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.example.tnvprojectandroid.Registrazione.packag;

public class MainLogin extends AppCompatActivity {

    public static ArrayList<Utente> utenti = new ArrayList<>();
    EditText username, password;
    //   TextView usernameInserita,passwordInserita,passwordConfermataInserita,cittaInserita,dataInserita;
    Button accedi;
    TextView nuovaRegistrazione;
    Utente utente;
    //   ListView listaUtenti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        accedi = findViewById(R.id.accediButton);
        nuovaRegistrazione = findViewById(R.id.nuovaRegistrazione);

        Utente primoutente = new Utente("admin", "admin", "admincity", "11/12/15", true);

        utenti.add(primoutente);


        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlloInserimento()) {
                  int i= index(username.getText().toString(),password.getText().toString());
                  utente=utenti.get(i);

                   if (utente.getAdmin()) {
                        Intent passaggioTraActivity = new Intent(MainLogin.this, HomeAdmin.class);
                        passaggioTraActivity.putExtra(packag, utente);
                        startActivity(passaggioTraActivity);
                    }
                    else {
                        Intent passaggioTraActivity = new Intent(MainLogin.this, Home_User.class);
                        passaggioTraActivity.putExtra(packag, utente);
                        startActivity(passaggioTraActivity);
                    }
                }


            }
        });


        nuovaRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent passaggioTraActvity = new Intent(MainLogin.this, Registrazione.class);
                startActivity(passaggioTraActvity);
            }

        });


   /*     Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(packag);
        if (object instanceof Utente) {
            utente = (Utente) object;
        } else {
            utente = new Utente();
        }
      //  MainLogin.utenti.add(utente);*/

    }

    private boolean controlloInserimento() {
        int errors = 0;

        if (username.getText().toString().length() == 0) {
            username.setError("Inserire username");
            errors++;

        } else {
            username.setError(null);
        }
        if (password.getText().toString().length() == 0) {
            password.setError("Inserire password");
            errors++;

        } else {
            password.setError(null);
        }

        return errors == 0;

    }

   private int index(String nome, String password) {

        for (int i=0; i< utenti.size();i++) {
            if (utenti.get(i).getUsername().equals(nome) && utenti.get(i).getPassword().equals(password))
            {
                    return i;
                }
        }
        return 0;
    }
}