package com.example.tnvprojectandroid;

import java.io.Serializable;

public class Utente implements Serializable {

    private String username,password,cittaDiProvenienza,dataDiNascita;



    public Utente(String username, String password,String cittaDiProvenienza, String dataDiNascita) {
        this.username = username;
        this.password = password;
        this.cittaDiProvenienza = cittaDiProvenienza;
        this.dataDiNascita = dataDiNascita;
    }

    public Utente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCittaDiProvenienza() {
        return cittaDiProvenienza;
    }

    public void setCittaDiProvenienza(String cittaDiProvenienza) {
        this.cittaDiProvenienza = cittaDiProvenienza;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
