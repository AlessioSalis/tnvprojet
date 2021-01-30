package com.example.tnvprojectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ModificaPassword extends AppCompatActivity {
    TextView nome,password;
    EditText setpassword,setpassword2;
    Utente utente;
    Button home,aggiornaPassword;
    public final static String MP_Package="com.example.progettoandroid.Utente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_password);
        nome=findViewById(R.id.utenteModificaPassword);
        password=findViewById(R.id.passwordModificapassword);
        setpassword=findViewById(R.id.setpassword);
        setpassword2=findViewById(R.id.repitepassword);
        aggiornaPassword=findViewById(R.id.aggiornaPassword);
        home=findViewById(R.id.returnHome);

        utente=new Utente();

        private boolean chekInput(){
            if (setpassword.getText().length()==0){
                setpassword.setError("Inserire una password!");}
            else { setpassword.setError(null);
                if(setpassword2.getText().length()==0){
                    setpassword.setError("Inserire una password!");}
                else { setpassword.setError(null);}
                if (setpassword.getText().toString().equals(setpassword2.getText().toString())){
                    setpassword.setError("Le password inserite sono diverse");}
                else { setpassword.setError(null);}
                return false;






                aggiornaPassword.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        boolean validPassword= chekInput();

                        if(validPassword){ utente.setPassWord(setpassword.getText().toString());
                            Intent showResult = new Intent(Modifica_Password.this, Utente.class);
                            showResult.putExtra(MP_Package, utente);
                            startActivity(showResult);
                        }});

                    private boolean chekInput(){


                        if (setpassword.getText().length()==0){
                            setpassword.setError("Inserire una password!");}
                        else { setpassword.setError(null);
                            if(setpassword2.getText().length()==0){
                                setpassword.setError("Inserire una password!");}
                            else { setpassword.setError(null);}
                            if (setpassword.getText().toString().equals(setpassword2.getText().toString())){
                                setpassword.setError("Le password inserite sono diverse");}
                            else { setpassword.setError(null);}
                            return false;

                        }
                    }
    }
}