package com.example.tnvprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import static com.example.tnvprojectandroid.Registrazione.packag;

public class ModificaPassword extends AppCompatActivity {
    TextView nome, password,errore;
    EditText setpassword, setConfermaPassword;
    Utente utente;
    Button home, aggiornaPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_password);

        errore= findViewById(R.id.errore);
        nome = findViewById(R.id.utenteModificaPassword);
        password = findViewById(R.id.passwordModificapassword);
        setpassword = findViewById(R.id.setpassword);
        setConfermaPassword = findViewById(R.id.repitepassword);
        aggiornaPassword = findViewById(R.id.aggiornaPassword);
        home = findViewById(R.id.returnHome);

        home.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificaPassword.this, Home_User.class);
                intent.putExtra(packag,utente);
                startActivity(intent);
            }});


        Intent intent = getIntent();
        Serializable object = intent.getSerializableExtra(packag);

        if (object instanceof Utente) {
            utente = (Utente) object;
        } else {
            utente = new Utente();
        }
        nome.setText(utente.getUsername());
        password.setText(utente.getPassword());

        aggiornaPassword.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                boolean okChange = chekInput();

                if (okChange) {
                    utente.setPassword(setpassword.getText().toString());
                    Intent showResult = new Intent(ModificaPassword.this, Home_User.class);
                    showResult.putExtra(packag,utente);
                    startActivity(showResult);
                }
                else {return;}

            }
        });

    }

    private boolean chekInput() {
       int errore=0;

        if (setpassword.getText().toString().length() == 0) {
            setpassword.setError("Inserire la password");
            errore++;

        }
        else{setpassword.setError(null);}
        if (setpassword.getText().toString().equals(password.toString())) {
            setpassword.setError("La password inserita non è valida");
            errore++;
        }
        else{setpassword.setError(null);}
        if (!(setpassword.getText().toString().equals(setConfermaPassword.getText().toString()))) {
            setConfermaPassword.setError("Le password inserite sono differenti");
            errore++;
        }
        else{setConfermaPassword.setError(null);}

        return errore==0;
    }
}



