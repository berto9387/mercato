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
    private ArrayList<UtenteSocieta> teamSocieta;

    public AmministratoreSquadra(ArrayList<UtenteSocieta> teamSocieta, String _id, String nome, String cognome, String email, String ruolo) {
        super(_id, nome, cognome, email, ruolo);
        this.teamSocieta = teamSocieta;
    }


    
    

    public ArrayList<UtenteSocieta> getTeamSocieta() {
        return teamSocieta;
    }

    public void setTeamSocieta(ArrayList<UtenteSocieta> teamSocieta) {
        this.teamSocieta = teamSocieta;
    }
    
}
