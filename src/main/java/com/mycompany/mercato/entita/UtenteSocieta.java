/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato.entita;

import java.util.ArrayList;

/**
 *
 * @author tony_
 */
public class UtenteSocieta extends Utente{
    
    private Societa societa;

    public UtenteSocieta() {
    }

    public UtenteSocieta(Societa societa, String _id, String nome, String cognome, String email, String ruolo) {
        super(_id, nome, cognome, email, ruolo);
        this.societa = societa;
    }
    
    public Societa getSocieta() {
        return societa;
    }

    public void setSocieta(Societa societa) {
        this.societa = societa;
    }

    @Override
    public String toString() {
        return "UtenteSocieta{" + "societa=" + societa + '}';
    }

}
