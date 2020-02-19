/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercato.amministratoreSistema;

import com.mycompany.mercato.GeneralGrafic;
import com.mycompany.mercato.GeneralGrafic.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author tony_
 */
public class AmministratoreSistemaController extends GeneralGrafic implements Initializable{
    
    private AmministratoreSistemaModel model;
//    private AmministratoreSistema utente;
    
    @FXML
    private ImageView imgAdmin;
    @FXML
    private Label nomeAdmin;
    @FXML
    private Label emailAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nomeAdmin.setText(utente.getNome() + " " + utente.getCognome());
        emailAdmin.setText(utente.getEmail());
       
    }    
    
}
