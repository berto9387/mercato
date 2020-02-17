package com.mycompany.mercato;

import com.mycompany.mercato.entita.*;
import javafx.scene.*;
import javafx.stage.*;


public class GeneralGrafic{
    protected static Scene mainScene;
    protected static Stage mainStage;
    
    protected static AmministratoreSistema admin;
    protected static AmministratoreSquadra adminSquadra;
    protected static Allenatore allenatore;
    protected static AmministratoreDelegato ad;
    protected static Osservatore osservatore;
    
    
    protected static Thread popolaLevelDb;
    public static void setParameters(Scene scene, Stage stage)
    {
        mainScene=scene;
        mainStage=stage;
        admin=new AmministratoreSistema();
        adminSquadra=new AmministratoreSquadra();
        allenatore=new Allenatore();
        ad=new AmministratoreDelegato();
        osservatore=new Osservatore();
               
    }
}
/*
------------------------COMMENTI DI GIANLUCA-----------------------------------
La classe general grafic serve per rendere i parametri membro condivisi da 
tutte le classi che implementano le varie interfacce grafiche
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!NOTA BENE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
*/