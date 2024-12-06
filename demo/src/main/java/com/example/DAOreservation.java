
package com.example;


import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DAOreservation {
    MongoCollection<Document> reservation;
    public DAOreservation(){
        MongoDatabase database=Connection.getbasedonnee();
        reservation=database.getCollection("reservations");
    }

  
    public void insert(Reservations reservation) {
       Document doc=new Document("id_user",reservation.getId_user())
       .append("id_event",reservation.getId_event())
       .append("id_terrain",reservation.getId_terrain())
       .append("id_salle", reservation.getId_salle())
       .append("date_reservation",reservation.getDate_reservation());
       this.reservation.insertOne(doc);
    }

  
    public void Delete(String id) {
        reservation.deleteOne(eq("_id",new ObjectId(id)));
    }

    public List<Reservations> findall(){
       List<Reservations> listreservation=new ArrayList<>();
       for(Document doc:reservation.find()){
        Reservations res=new Reservations();
        res.setDate_reservation(doc.getDate("date_reservation"));
        res.setId_event(doc.getString("id_event"));
        res.setId_user(doc.getString("id_user"));
        res.setId_terrain(doc.getString("id_terrain"));
        res.setId_salle(doc.getString("id_salle"));
        listreservation.add(res);
       }
       return listreservation;
    }

   
    public void updateReservation(String id,Reservations reservation){
        Document doc=new Document("id_user",reservation.getId_user())
        .append("id_event",reservation.getId_event())
        .append("id_terrain",reservation.getId_terrain())
        .append("id_salle", reservation.getId_salle())
        .append("date_reservation",reservation.getDate_reservation());

        Document docOperation=new Document("$set",doc);

        this.reservation.updateOne(new Document("_id",new ObjectId(id)),docOperation);
    }

    public int disponibilite(String id_event,String nom_salle){
        long count=reservation.countDocuments(new Document("id_event",id_event));
        MongoDatabase datebase=Connection.getbasedonnee();
        MongoCollection<Document> events=datebase.getCollection("salles");
        Document event=events.find(new Document("nom_salle",nom_salle)).first();
        if(event.getInteger("capacite")>count){
            return 1;
        }
        return 0;
    }
}
