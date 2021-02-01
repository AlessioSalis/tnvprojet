package com.example.tnvprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Registrazione extends AppCompatActivity {

    EditText username,password,passwordConfermata,cittaDiProvenienza,dataDiNascita;
    Utente utente;
    Button registazioneButton;
    public final static String packag="com.example.tnvprojectandroid.Utente";
   // public List<Utente> utenti= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        username=findViewById(R.id.usernameInserito);
        password=findViewById(R.id.passwordInserita);
        passwordConfermata=findViewById(R.id.passwordConfermataInserita);
        cittaDiProvenienza=findViewById(R.id.cittaDiProvenienzaInserita);
        dataDiNascita=findViewById(R.id.dataDiNascitaInserita);
        registazioneButton=findViewById(R.id.registrazioneButton);

   /*     Utente primoutente =new Utente("admin","admin","cagliari","11/12/15",true);

  utenti.add(primoutente);*/
        Utente utente= new Utente();
        registazioneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (controlloInserimento()) {

                  inizializzaAttributi();
                    Intent passaggioTraActvity = new Intent(Registrazione.this, MainLogin.class);
              //con l'arrayList static, possiamo recuperare i dati dove ci servono senza usare la putExtra
               //     passaggioTraActvity.putExtra(packag, utente);
                    startActivity(passaggioTraActvity);

               }

            }
        });



    }


    private void inizializzaAttributi(){
        this.utente.setUsername(username.getText().toString());
        this.utente.setPassword(password.getText().toString());
        this.utente.setPassword(passwordConfermata.getText().toString());
        this.utente.setCittaDiProvenienza(cittaDiProvenienza.getText().toString());
        this.utente.setDataDiNascita(dataDiNascita.getText().toString());
        this.utente.setAdmin(false);
        MainLogin.utenti.add(utente);
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

        if (passwordConfermata.getText().toString().length() == 0 && passwordConfermata.equals(password)) {
            passwordConfermata.setError("Conferma password");
            errors++;

        } else {
            passwordConfermata.setError(null);
        }

        if (cittaDiProvenienza.getText().toString().length() == 0) {
            cittaDiProvenienza.setError("Inserire citta di provenienza");
            errors++;

        } else {
            cittaDiProvenienza.setError(null);
        }

        if (dataDiNascita.getText().toString().length() == 0) {
            dataDiNascita.setError("Inserire data di nascita");
            errors++;

        } else {
            dataDiNascita.setError(null);
        }

        return errors==0;

    }


}