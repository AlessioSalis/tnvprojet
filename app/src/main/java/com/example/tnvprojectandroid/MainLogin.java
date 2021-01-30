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

import static com.example.tnvprojectandroid.Registrazione.packag;

public class MainLogin extends AppCompatActivity {

    EditText username,password;
    TextView usernameInserita,passwordInserita,passwordConfermataInserita,cittaInserita,dataInserita;
    Button accedi;
    TextView nuovaRegistrazione;
    Utente utente;
    ListView listaUtenti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        accedi=findViewById(R.id.accediButton);
        nuovaRegistrazione=findViewById(R.id.nuovaRegistrazione);
     //   listaUtenti=findViewById(R.id.lista_utenti);

     //   ArrayList<Utenti> listaUtentiInseriti= new ArrayList<>();

      //  utente =new Utente("admin","admin","admin","carpineto romano","15/06/1993");

        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(controlloInserimento()) {
                    Intent passaggioTraActivity=new Intent(MainLogin.this,Home.class);
                    passaggioTraActivity.putExtra(packag, utente);
                    startActivity(passaggioTraActivity);
                }
            }
        });


        nuovaRegistrazione.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent passaggioTraActvity = new Intent(MainLogin.this, Registrazione.class);
                startActivity(passaggioTraActvity);
            }

        });

        Intent intent=getIntent();
        Serializable object=intent.getSerializableExtra(packag);
/*
        usernameInserita=findViewById(R.id.usernameInserito);
        passwordInserita=findViewById(R.id.passwordInserita);
        passwordConfermataInserita=findViewById(R.id.passwordConfermataInserita);
        cittaInserita=findViewById(R.id.cittaDiProvenienzaInserita);
        dataInserita=findViewById(R.id.dataDiNascitaInserita);


        if(object instanceof Utenti) {
            utenti = (Utenti) object;
        }else {
            utenti = new Utenti();
        }


        usernameInserita.setText(utenti.getUsername());
        passwordInserita.setText(utenti.getPassword());
        passwordConfermataInserita.setText(utenti.getConfermaPassowrd());
        cittaInserita.setText(utenti.getCittaDiProvenienza());
        dataInserita.setText(utenti.getDataDiNascita());
*/
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

        return errors==0;

    }
}