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

    public UtenteSocieta(Societa societa, ArrayList<GiocatorePreferito> giocatoriPreferitiAggiunti, String id, String nome, String cognome, String email, String ruolo) {
        super(id, nome, cognome, email, ruolo);
        this.societa = societa;
        this.giocatoriPreferitiAggiunti = giocatoriPreferitiAggiunti;
    }

    
}
