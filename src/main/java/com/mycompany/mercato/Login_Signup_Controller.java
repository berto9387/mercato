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
    private Label err_reg_label;
    
    @FXML
    private Label err_log_label;
    
    @FXML
    private Button registratiButton;

    @FXML
    void formLogin(ActionEvent event) {
        registratiVBox.setVisible(false);
        loginVBox.setVisible(true);
        if(pageRegistrati.getStyleClass().contains("active") && !pageLogin.getStyleClass().contains("active")){
            pageRegistrati.getStyleClass().remove("active");
            pageLogin.getStyleClass().add("active");
        }
    }

    @FXML
    void formRegistrati(ActionEvent event) {
        loginVBox.setVisible(false);
        registratiVBox.setVisible(true);
        if(!pageRegistrati.getStyleClass().contains("active") && pageLogin.getStyleClass().contains("active")){
            pageRegistrati.getStyleClass().add("active");
            pageLogin.getStyleClass().remove("active");
        }
    }
    
    @FXML
    void registrazione(ActionEvent event) {
        String nome=nomeRegistazione.getText().toLowerCase();
        String cognome=cognomeRegistrazione.getText().toLowerCase();
        String email=emailRegistrazione.getText().toLowerCase();
        String password=passwordRegistrazione.getText().toLowerCase();
        String ruolo=scegliRuoloRegistrazione.getValue().toLowerCase();
        int creazioneUtente=model.registraUtente(nome,cognome,email,password,ruolo);
        if(creazioneUtente == 1){
            err_reg_label.setText("Email già presente !");
            err_reg_label.setVisible(true);
        } else if (creazioneUtente == 0){
            err_reg_label.setText("Registrazione andata a buon fine");
            err_reg_label.setVisible(true);
            nomeRegistazione.clear();
            cognomeRegistrazione.clear();
            emailRegistrazione.clear();
            passwordRegistrazione.clear();
            scegliRuoloRegistrazione.setValue("Allenatore");
        }
        System.err.println(creazioneUtente);
    }
    @FXML
    void login(ActionEvent event) {
        String email=emailField.getText().toLowerCase();
        String password=passwordField.getText().toLowerCase();
        int login = model.login(email, password);
        if ( model.login(email, password) == 1){
            err_log_label.setText("Email o password errate !");
            err_log_label.setVisible(true);
        }else if (login == 0){
            err_log_label.setVisible(false);
        }
    }
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        scegliRuoloRegistrazione.setItems(ruoli);
        scegliRuoloRegistrazione.setValue("Allenatore");
        model=new LoginModel();
        err_reg_label.setVisible(false);
        err_log_label.setVisible(false);
    }    
    
}
