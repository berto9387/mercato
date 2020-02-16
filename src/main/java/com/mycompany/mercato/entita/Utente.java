/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato.entita;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.mongojack.ObjectId;

/**
 *
 * @author tony_
 */
public class Utente {
    private String id;
    @ObjectId
    @JsonProperty("_id")
    public String getId() {
        return id;
    }
    @ObjectId
    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }
    protected String nome;
    protected String cognome;
    protected String email;
    protected String ruolo;
    public Utente(){};
    public Utente(String nome, String cognome, String email, String ruolo) {
        
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", ruolo=" + ruolo + '}';
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    
    
}
