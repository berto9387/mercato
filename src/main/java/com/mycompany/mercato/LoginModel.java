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
    private Utente utente;
    public LoginModel(){
        db=new MongoDataAccess();
    }
    public int registraUtente(String nome,String cognome,String email,String password,String ruolo){
        
        return db.registraUtente(nome,cognome,email,password,ruolo);
    }
    
    public Utente login(String email, String password,String ruolo){
        
        if(ruolo.equals("admin")){
            
        } else if(ruolo.equals("amministratore delegato")){
            
        } else if(ruolo.equals("amministratore di squadra")){
            
        } else if(ruolo.equals("allenatore")){
            
        } else {
            
        }
            
            
        db.login(email, password,ruolo);
        
        return null;
        
        
    }
    
}
