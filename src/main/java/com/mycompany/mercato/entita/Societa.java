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
public class Societa {
    
    private String id;
    private String nomeSocieta;
    private String nazione;
    private ArrayList<UtenteSocieta> teamSocieta;
    private ArrayList<ProfiloInteresse> profiliInteresse;
    private ArrayList<GiocatorePreferito> giocatoriPreferiti;

    public Societa(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeSocieta() {
        return nomeSocieta;
    }

    public void setNomeSocieta(String nomeSocieta) {
        this.nomeSocieta = nomeSocieta;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public ArrayList<UtenteSocieta> getTeamSocieta() {
        return teamSocieta;
    }

    public void setTeamSocieta(ArrayList<UtenteSocieta> teamSocieta) {
        this.teamSocieta = teamSocieta;
    }

    public ArrayList<ProfiloInteresse> getProfiliInteresse() {
        return profiliInteresse;
    }

    public void setProfiliInteresse(ArrayList<ProfiloInteresse> profiliInteresse) {
        this.profiliInteresse = profiliInteresse;
    }

    public ArrayList<GiocatorePreferito> getGiocatoriPreferiti() {
        return giocatoriPreferiti;
    }

    public void setGiocatoriPreferiti(ArrayList<GiocatorePreferito> giocatoriPreferiti) {
        this.giocatoriPreferiti = giocatoriPreferiti;
    }
    
    
}
