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
public class Osservatore extends UtenteSocieta{
    //il report viene usato esclusivamente come cache nella sessione corrente
    private ArrayList<Report> report;

    public Osservatore() {
    }

    public Osservatore(Societa societa, String _id, String nome, String cognome, String email, String ruolo) {
        super(societa, _id, nome, cognome, email, ruolo);
    }

    public ArrayList<Report> getReport() {
        return report;
    }

    public void setReport(ArrayList<Report> report) {
        this.report = report;
    }
    
    
    
    
    
}
