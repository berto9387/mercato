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
public class AmministratoreDelegato extends UtenteSocieta{

    public AmministratoreDelegato(Societa societa, ArrayList<GiocatorePreferito> giocatoriPreferitiAggiunti, String id, String nome, String cognome, String email, String ruolo) {
        super(societa, giocatoriPreferitiAggiunti, id, nome, cognome, email, ruolo);
    }
    
}
