/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato;

import com.mycompany.mercato.db.MongoDataAccess;

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
    
    public int login(String email, String password){            
        int err=db.login(email, password);
        return err;
        
    }
    
}
