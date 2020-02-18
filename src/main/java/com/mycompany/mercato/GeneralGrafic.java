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
    
    
    public static void setParameters(Scene scene, Stage stage)
    {
        mainScene=scene;
        mainStage=stage;
               
    }
}