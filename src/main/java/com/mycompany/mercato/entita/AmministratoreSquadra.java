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
public class AmministratoreSquadra extends UtenteSocieta{
    private String allenatoreId;
    private String osservatoreId;
    private String adId;

    public AmministratoreSquadra() {
    }

    public AmministratoreSquadra(String allenatoreId, String osservatoreId, String adId, Societa societa, String _id, String nome, String cognome, String email, String ruolo) {
        super(societa, _id, nome, cognome, email, ruolo);
        this.allenatoreId = allenatoreId;
        this.osservatoreId = osservatoreId;
        this.adId = adId;
    }

    public String getAllenatoreId() {
        return allenatoreId;
    }

    public void setAllenatoreId(String allenatoreId) {
        this.allenatoreId = allenatoreId;
    }

    public String getOsservatoreId() {
        return osservatoreId;
    }

    public void setOsservatoreId(String osservatoreId) {
        this.osservatoreId = osservatoreId;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    

    
    
    


    
    

    
    
}
