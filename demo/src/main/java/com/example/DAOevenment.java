package com.example;
import java.util.ArrayList;

import java.util.List;

import javax.print.Doc;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;



public class DAOevenment{

    MongoCollection<Document> Event;



    public DAOevenment(){
        MongoDatabase database=Connection.getbasedonnee();
        this.Event=database.getCollection("evenements");
    }

       public void insert(Evenments event){
        Document doc=new Document("nom_event",event.getNom_event())
                .append("date_event",event.getDate_event())
                .append("description",event.getDescription())
                .append("id_user",event.getId_user());
       Event.insertOne(doc);
    }

   
    public void Delete(String id) {
       Event.deleteOne(eq("_id",new ObjectId(id)));
       
    }

    
    public List<Evenments> findall(){

        List<Evenments> listEvents=new ArrayList<>();
        for(Document doc:Event.find()){
            Evenments event=new Evenments();
            event.setDate_event(doc.getString("date_event"));
            event.setDescription(doc.getString("description"));
            event.setNom_event(doc.getString("nom_event"));
            event.setId_user(doc.getString("id_user"));
            listEvents.add(event);
        }
        return listEvents;
    }

    
    public void update(String id,Evenments event){

        Document doc=new Document("nom_event",event.getNom_event())
        .append("date_event",event.getDate_event())
        .append("description",event.getDescription())
        .append("id_user",event.getId_user());

        Document docOperation=new Document("$set",doc);
        this.Event.updateOne(new Document("_id",new ObjectId(id)),docOperation);
    }

    
    
}
