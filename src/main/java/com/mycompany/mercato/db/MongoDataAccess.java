package com.mycompany.mercato.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.exclude;
import com.mycompany.mercato.allenatore.AllenatoreInterface;
import com.mycompany.mercato.amministratoreDelegato.AmministratoreDelegatoInterface;
import com.mycompany.mercato.amministratoreSquadra.AmministratoreSquadraInterface;
import com.mycompany.mercato.amministratoresSistema.AmministratoreSistemaInterface;
import com.mycompany.mercato.entita.*;
import com.mycompany.mercato.osservatore.OsservatoreInterface;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author tony_
 */
public class MongoDataAccess implements AmministratoreSistemaInterface, AmministratoreDelegatoInterface, AmministratoreSquadraInterface,
                                        AllenatoreInterface, OsservatoreInterface{

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private final String ip="localhost";
    private final int porta=27017;
    private final String dbName="mercato";
    private final String nomeCollectionUtenti="utenti";
    
    /**
     * Instaura la connessione con il database
     * prende come parametro il nome della collection
     * @param collection
     * @throws Exception 
     */
    private void apriConnessione(String collection) throws Exception{
        System.err.println("mongodb://"+this.ip+":"+this.porta);
        mongoClient=MongoClients.create("mongodb://"+this.ip+":"+this.porta);
        database=mongoClient.getDatabase(dbName);
        this.collection=database.getCollection(collection);
        
        
    }
    /**
     * Chiude la connessione col database
     */
    private void chiudiConnessione(){
        mongoClient.close();
    }
    /**
     * La funzione verifica l'esistenza dell'email nel database
     * @param email
     * @return 0 se l'email non esiste;1 se l'email esiste;2 se ci sono altri errori
     */
    public int controllaEsistenzaUtente(String email){
        Document trovaUtente;
        try {
            trovaUtente=(Document) this.collection.find(eq("email",email)).first();
        } catch (Exception e) {
            return 2;
        }
       
       if(trovaUtente!=null)
           return 1;
       return 0;
    }
    /**
     * La funzione è utilizzata per registrare l'utente nel database
     * @param nome
     * @param cognome
     * @param email
     * @param password
     * @param ruolo
     * @return 0 se utente è inserito correttamente;1 email esistente;2 altri errori
     */
    public int registraUtente(String nome,String cognome,String email,String password,String ruolo){
        try {
            apriConnessione(nomeCollectionUtenti);
        } catch (Exception e) {
            return 2;
        }
        int giaEsiste=controllaEsistenzaUtente(email);;
        
        if(giaEsiste!=0){
            chiudiConnessione();
            return  giaEsiste;
        } 
        
        try {
            Document document=new Document("nome",nome).append("cognome", cognome)
                    .append("email", email).append("password", password).append("ruolo", ruolo);
            this.collection.insertOne(document);
            
        } catch (Exception e1) {
            chiudiConnessione();
            return 2;
        } finally{
            chiudiConnessione();
        }
        
        return 0;
    }
    
    public Utente login(String email,String password){
        Utente utente=null;
        Document utenteDoc;
        ObjectMapper objectMapper = new ObjectMapper();
       
        try {
            apriConnessione(nomeCollectionUtenti);
        } catch (Exception e) {
            return null;
        }
        try{
            utenteDoc = collection.find(and(eq("email", email), eq("password", password))).projection(exclude("password")).first();
            
        } catch(Exception e){
            return null;
        }finally{
            chiudiConnessione();
            
        }
        if(utenteDoc.getString("ruolo").equals(("admin"))){
            System.err.println("Trovato");
            try {
                utente=objectMapper.readValue(utenteDoc.toJson(), Utente.class);
            } catch (IOException ex) {
                Logger.getLogger(MongoDataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        System.out.println(utente.toString());
        return null;
    }
    
    
}
