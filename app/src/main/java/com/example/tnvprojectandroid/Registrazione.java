package com.example.tnvprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Registrazione extends AppCompatActivity {

    EditText username,password,passwordConfermata,cittaDiProvenienza,dataDiNascita;
    Utente utente;
    Button registazioneButton;
    public final static String packag="com.example.tnvprojectandroid.Utente";

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


        registazioneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (controlloInserimento()) {
                  inizializzaAttributi();
                  Intent passaggioTraActvity = new Intent(Registrazione.this, MainLogin.class);
                  startActivity(passaggioTraActvity);

               }

            }
        });
        dataDiNascita.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]", "");
                    String cleanC = current.replaceAll("[^\\d.]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        if(mon > 12) mon = 12;
                        cal.set(Calendar.MONTH, mon-1);

                        year = (year<1900)?1900: Math.min(year, 2100);
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = Math.max(sel, 0);
                    current = clean;
                    dataDiNascita.setText(current);
                    dataDiNascita.setSelection(Math.min(sel, current.length()));



                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });




    }


    private void inizializzaAttributi(){
        Utente utente= new Utente(
                username.getText().toString(),
                password.getText().toString(),
                cittaDiProvenienza.getText().toString(),
                dataDiNascita.getText().toString(),
                false
                );
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

        if ((passwordConfermata.getText().toString().length() == 0 || !(passwordConfermata.getText()
                .toString().equals(password.getText().toString())))) {
            passwordConfermata.setError("Password non corrispondono");
            errors ++;

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