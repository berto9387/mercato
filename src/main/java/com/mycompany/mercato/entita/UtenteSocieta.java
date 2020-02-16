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
    private ArrayList<GiocatorePreferito> giocatoriPreferitiAggiunti;

    public UtenteSocieta(String nome, String cognome, String email, String ruolo) {
        super(nome, cognome, email, ruolo);
    }

    public Societa getSocieta() {
        return societa;
    }

    public void setSocieta(Societa societa) {
        this.societa = societa;
    }

    public ArrayList<GiocatorePreferito> getGiocatoriPreferitiAggiunti() {
        return giocatoriPreferitiAggiunti;
    }

    public void setGiocatoriPreferitiAggiunti(ArrayList<GiocatorePreferito> giocatoriPreferitiAggiunti) {
        this.giocatoriPreferitiAggiunti = giocatoriPreferitiAggiunti;
    }

    
}
