/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato;

import com.mycompany.mercato.db.MongoDataAccess;
import com.mycompany.mercato.entita.Societa;
import com.mycompany.mercato.entita.Utente;
import com.mycompany.mercato.entita.UtenteSocieta;
import org.bson.Document;

/**
 *
 * @author tony_
 */
public class LoginModel {
    
    private MongoDataAccess db;
    public LoginModel(){
        db=new MongoDataAccess();
    }
    public int registraUtente(String nome,String cognome,String email,String password,String ruolo){
        
        return db.registraUtente(nome,cognome,email,password,ruolo);
    }
    
    public Utente login(String email, String password){
        Utente utente = null;
        Document utenteDoc = db.login(email, password);
        
        if(utenteDoc.getString("ruolo").equals(("admin"))){
            utente = new Utente(utenteDoc.getObjectId("_id").toString(), utenteDoc.getString("nome"), 
                                 utenteDoc.getString("cognome"),  utenteDoc.getString("email"),  utenteDoc.getString("ruolo"));
        } else{
            String idSquadra = utenteDoc.getString("societa");
            
            Societa societa = new Societa(idSquadra);
            
            
            utente = new UtenteSocieta(societa, null, utenteDoc.getObjectId("_id").toString(), utenteDoc.getString("nome"), 
                                 utenteDoc.getString("cognome"),  utenteDoc.getString("email"),  utenteDoc.getString("ruolo"));
        
            //CONTROLLARE SE E' ADMIN SQUADRA (CAMPO TEAM)
            //CON
        }
        
        return utente;
    }
    
}
