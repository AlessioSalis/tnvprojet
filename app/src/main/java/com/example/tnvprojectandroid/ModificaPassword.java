package com.example.tnvprojectandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ModificaPassword extends AppCompatActivity {
    TextView nome,password;
    EditText passwor,password2;
    Button home,passwordModificata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_password);
    }
}