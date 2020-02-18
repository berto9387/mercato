package com.mycompany.mercato.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.exclude;
import com.mycompany.mercato.GeneralGrafic;
import com.mycompany.mercato.allenatore.AllenatoreInterface;
import com.mycompany.mercato.amministratoreDelegato.AmministratoreDelegatoInterface;
import com.mycompany.mercato.amministratoreSquadra.AmministratoreSquadraInterface;
import com.mycompany.mercato.amministratoresSistema.AmministratoreSistemaInterface;
import com.mycompany.mercato.entita.*;
import com.mycompany.mercato.osservatore.OsservatoreInterface;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author tony_
 */
public class MongoDataAccess extends GeneralGrafic implements AmministratoreSistemaInterface, AmministratoreDelegatoInterface, AmministratoreSquadraInterface,
                                        AllenatoreInterface, OsservatoreInterface{

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private final String ip="localhost";
    private final int porta=27017;
    private final String dbName="mercato";
    private final String nomeCollectionUtenti="utenti";
    private final String nomeCollectionSocieta="societa";
    
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
    private int controllaEsistenzaUtente(String email){
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
     * La funzione restituisce l'utente se la password è corretta
     * @param email
     * @param password
     * @return il Document bson dell'utente 
     */
    private Document ricercaUtente(String email,String password){
        Document utenteDoc=null;
       
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
        return utenteDoc;
        
    }
    /**
     * La funzione restituisce la societa dato il suo ObjectId
     * @param idSocieta
     * @return null se ci sono stati errori
     */
    private Document ricercaSocieta(ObjectId idSocieta){
        Document societaDoc=null;
       
        try {
            apriConnessione(nomeCollectionSocieta);
        } catch (Exception e) {
            return null;
        }
        try{
            societaDoc = collection.find(eq("_id", idSocieta)).first();
            
        } catch(Exception e){
            return null;
        }finally{
            chiudiConnessione();            
        }
        return societaDoc;
        
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
    /**
     * La funzione è usato per loggare l'utente
     * @param email
     * @param password
     * @return 0:login è andato a buon fine; 1:email o password errate;2:altri errori
     */
    public int login(String email,String password){
        
        Document utenteDoc=ricercaUtente(email, password);
        if(utenteDoc==null){
            return 1;
        }
        
        if(utenteDoc.getString("ruolo").equals(("admin"))){
            admin=new AmministratoreSistema(utenteDoc.getObjectId("_id").toString(), utenteDoc.getString("nome"),
                    utenteDoc.getString("cognome"), utenteDoc.getString("email"), utenteDoc.getString("ruolo"));
            return 0;
        } else {
            Document societaDoc=ricercaSocieta(utenteDoc.getObjectId("societa"));
            Societa soc=new Societa();
       
            if(societaDoc!=null){
                if(societaDoc.getObjectId("_id")!=null){
                    soc.setId(societaDoc.getObjectId("_id").toString());
                } 
                if(societaDoc.getString("nomeSocieta")!=null){
                    soc.setNomeSocieta(societaDoc.getString("nomeSocieta"));
                }
                if(societaDoc.getString("nazione")!=null){
                    soc.setNazione(societaDoc.getString("nazione"));
                } 
                if(societaDoc.get("giocatoriPreferiti")!=null){
                    List<Document> list=(List<Document>)societaDoc.get("giocatoriPreferiti");
                    for(Document doc: list){
                        Report report=null;
                        if(doc.get("report")!=null){
                            Document reportDoc=(Document)doc.get("report");
                            report=new Report(reportDoc.getObjectId("_id").toString(), reportDoc.getString("commento"), reportDoc.getInteger("rating")); 
                        }
                        
                        InformazioniPrincipali aux=new InformazioniPrincipali(doc.getObjectId("idCalciatore").toString(), doc.getString("nome"), doc.getString("ruoloPrincipale"), 
                                                                                doc.getString("squadra"), new Date(doc.getLong("dataNascita")), doc.getString("valoreMercato"), 
                                                                                doc.getString("nazionalita"), doc.getInteger("giudizioDirigenza"), doc.getInteger("giudizioAllenatore"),doc.getString("propostoDa"),report);
                    
                       soc.addGiocatorePreferito(aux);
                    }
                }
            }
            
            if(utenteDoc.getString("ruolo").equals(("allenatore"))){
                allenatore=new Allenatore(soc,utenteDoc.getObjectId("_id").toString(), utenteDoc.getString("nome"),
                    utenteDoc.getString("cognome"), utenteDoc.getString("email"), utenteDoc.getString("ruolo"));
            } else if(utenteDoc.getString("ruolo").equals(("osservatore"))){
                osservatore=new Osservatore(soc, utenteDoc.getObjectId("_id").toString(), utenteDoc.getString("nome"),
                    utenteDoc.getString("cognome"), utenteDoc.getString("email"), utenteDoc.getString("ruolo"));
            }else if(utenteDoc.getString("ruolo").equals(("amministratore delegato"))){
                ad=new AmministratoreDelegato(soc,utenteDoc.getObjectId("_id").toString(), utenteDoc.getString("nome"),
                    utenteDoc.getString("cognome"), utenteDoc.getString("email"), utenteDoc.getString("ruolo"));
            } else{
                adminSquadra=new AmministratoreSquadra(societaDoc.getString("allenatore"),societaDoc.getString("osservatore"),societaDoc.getString("amministratoreDelegato"),soc, utenteDoc.getObjectId("_id").toString(), utenteDoc.getString("nome"),
                    utenteDoc.getString("cognome"), utenteDoc.getString("email"), utenteDoc.getString("ruolo"));
            } 
            System.out.println(societaDoc.toString());
            
        }
        return 0;
    }
    
    
}
