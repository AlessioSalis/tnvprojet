package com.example.tnvprojectandroid;

import java.io.Serializable;

public class Utente implements Serializable {

    private String username,password,cittaDiProvenienza,dataDiNascita;
    private Boolean admin=false;


    public Utente(String username, String password, String cittaDiProvenienza, String dataDiNascita, Boolean admin) {
        this.username = username;
        this.password = password;
        this.cittaDiProvenienza = cittaDiProvenienza;
        this.dataDiNascita = dataDiNascita;
        this.admin = admin;
    }

    public Utente() {
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
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
