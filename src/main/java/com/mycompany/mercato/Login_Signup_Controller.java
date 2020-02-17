package com.mycompany.mercato;

import com.mycompany.mercato.entita.Utente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Login_Signup_Controller implements Initializable {
    
    private LoginModel model;
    private Utente utente;
    ObservableList<String> ruoli=FXCollections.observableArrayList("Allenatore","Osservatore","Amministratore delegato","Amministratore di squadra","Admin");
    
    @FXML
    private Button pageRegistrati;

    @FXML
    private Button pageLogin;

    @FXML
    private VBox loginVBox;

    @FXML
    private TextField emailField;
    
    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private VBox registratiVBox;

    @FXML
    private TextField nomeRegistazione;

    @FXML
    private TextField cognomeRegistrazione;

    @FXML
    private TextField emailRegistrazione;

    @FXML
    private PasswordField passwordRegistrazione;

    @FXML
    private  ChoiceBox<String> scegliRuoloRegistrazione;
    @FXML
    private ChoiceBox<String> scegliRuoloLogin;
    

    @FXML
    private Button registratiButton;

    @FXML
    void formLogin(ActionEvent event) {
        registratiVBox.setVisible(false);
        loginVBox.setVisible(true);
        pageRegistrati.getStyleClass().remove("active");
        pageLogin.getStyleClass().add("active");
       
        
    }

    @FXML
    void formRegistrati(ActionEvent event) {
        loginVBox.setVisible(false);
        registratiVBox.setVisible(true);
        pageLogin.getStyleClass().remove("active");
        pageRegistrati.getStyleClass().add("active");
        
    }
    @FXML
    void registrazione(ActionEvent event) {
        String nome=nomeRegistazione.getText().toLowerCase();
        String cognome=cognomeRegistrazione.getText().toLowerCase();
        String email=emailRegistrazione.getText().toLowerCase();
        String password=passwordRegistrazione.getText().toLowerCase();
        String ruolo=scegliRuoloRegistrazione.getValue().toLowerCase();
        int creazioneUtente=model.registraUtente(nome,cognome,email,password,ruolo);
        System.err.println(creazioneUtente);
    }
    @FXML
    void login(ActionEvent event) {
        String email=emailField.getText().toLowerCase();
        String password=passwordField.getText().toLowerCase();
        String ruolo=scegliRuoloLogin.getValue().toLowerCase();
        model.login(email, password,ruolo);
        
        
    }
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        scegliRuoloLogin.setItems(ruoli);
        scegliRuoloLogin.setValue("Allenatore");
        scegliRuoloRegistrazione.setItems(ruoli);
        scegliRuoloRegistrazione.setValue("Allenatore");
        model=new LoginModel();
    }    
}
