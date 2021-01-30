package com.example.tnvprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registrazione extends AppCompatActivity {

    TextView username,password,passwordConfermata,cittaDiProvenienza,dataDiNascita;
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

        utente =new Utente();

        registazioneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlloInserimento()) {
                    inizializzaAttributi();
                    Intent passaggioTraActvity = new Intent(Registrazione.this, MainLogin.class);
                    passaggioTraActvity.putExtra(packag, utente);
                    startActivity(passaggioTraActvity);

                }
            }
        });



    }


    private void inizializzaAttributi()throws IllegalArgumentException{
        this.utente.setUsername(username.getText().toString());
        this.utente.setPassword(password.getText().toString());
        this.utente.setPassword(passwordConfermata.getText().toString());
        this.utente.setCittaDiProvenienza(cittaDiProvenienza.getText().toString());
        this.utente.setDataDiNascita(dataDiNascita.getText().toString());
    }


    private boolean controlloInserimento(){
        int errors=0;

        if(username.getText().toString().length()==0){
            username.setText("Inserire username");
            errors++;
        }else{
            username.setError(null);
        }
        if(password.getText().toString().length()==0){
            password.setText("Inserire password");
            errors++;
        }else{
            password.setError(null);
        }

        if(passwordConfermata.getText().toString().length()==0 && passwordConfermata.equals(password)){
            passwordConfermata.setText("Conferma password");
            errors++;
        }else{
            passwordConfermata.setError(null);
        }

        if(cittaDiProvenienza.getText().toString().length()==0){
            cittaDiProvenienza.setText("Inserire citta di provenienza");
            errors++;
        }else{
            cittaDiProvenienza.setError(null);
        }

        if(dataDiNascita.getText().toString().length()==0){
            dataDiNascita.setText("Inserire data di nascita");
            errors++;
        }else{
            dataDiNascita.setError(null);
        }

        return errors==0;

    }
}