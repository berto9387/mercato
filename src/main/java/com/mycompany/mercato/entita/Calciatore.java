/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato.entita;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author tony_
 */
public class Calciatore extends InformazioniPrincipali{
    private String _id;
    private String nome;
    private Date dataNascita;
    private String luogoNascita;
    private int altezza;
    private String nazionalita;
    private String piede;
    private String procuratore;
    private String squadra;
    private Date inRosaDa;
    private Date scadenza;
    private String ruoloPrincipale;
    private List<String> altriRuoli;
    private ArrayList<Statistica> statistiche;
    private ArrayList<Trasferimento> trasferimenti;
    private ArrayList<Infortunio> infortuni;
    
}
