/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato.entita;

/**
 *
 * @author tony_
 */
public class ProfiloInteresse {
    private String _id;
    private String nomeLista;
    private String descrizioneCaratteristiche;

    public ProfiloInteresse(String _id, String nomeLista, String descrizioneCaratteristiche) {
        this._id = _id;
        this.nomeLista = nomeLista;
        this.descrizioneCaratteristiche = descrizioneCaratteristiche;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getDescrizioneCaratteristiche() {
        return descrizioneCaratteristiche;
    }

    public void setDescrizioneCaratteristiche(String descrizioneCaratteristiche) {
        this.descrizioneCaratteristiche = descrizioneCaratteristiche;
    }
    
    
}
