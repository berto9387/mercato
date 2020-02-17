/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato.entita;

import java.util.Date;



/**
 *
 * @author tony_
 */
public class InformazioniPrincipali {
    private String _id;
    private String nome;
    private String ruoloPrincipale;
    private String squadra;
    private Date dataNascita;
    private String valoreMercato;
    private String nazionalita;
    private int giudizioDirigenza;
    private int giudizioAllenatore;
    
    //COMMENTATE PER FARE LE PROVE PER IL LOGIN!!!
//    private Report report;
//    private UtenteSocieta aggiuntoDa;

    public InformazioniPrincipali(String _id, String nome, String ruoloPrincipale, String squadra, Date dataNascita, String valoreMercato, String nazionalita, int giudizioDirigenza, int giudizioAllenatore) {
        this._id = _id;
        this.nome = nome;
        this.ruoloPrincipale = ruoloPrincipale;
        this.squadra = squadra;
        this.dataNascita = dataNascita;
        this.valoreMercato = valoreMercato;
        this.nazionalita = nazionalita;
        this.giudizioDirigenza = giudizioDirigenza;
        this.giudizioAllenatore = giudizioAllenatore;
    }
    
    
}
