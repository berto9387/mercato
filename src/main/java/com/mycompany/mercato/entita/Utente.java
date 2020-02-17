/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato.entita;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mycompany.mercato.ObjectIdDeserializer;
import org.bson.types.ObjectId;
import org.mongojack.Id;
/**
 *
 * @author tony_
 */
public class Utente {
    
    @Id
    @JsonDeserialize(using = ObjectIdDeserializer.class)
    private String _id;
    private String nome;
    private String cognome;
    private String email;
    private String ruolo;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }
    public Utente(){};
    public Utente(String nome, String cognome, String email, String ruolo) {
        
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
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

    @Override
    public String toString() {
        return "Utente{" + "_id=" + _id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", ruolo=" + ruolo + '}';
    }
    
    
}
