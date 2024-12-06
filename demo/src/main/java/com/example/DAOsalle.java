package com.example;


import static com.mongodb.client.model.Filters.eq;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class DAOsalle {
    MongoCollection<Document> salles;

    public DAOsalle(){
        MongoDatabase database=Connection.getbasedonnee();
        salles=database.getCollection("salles");
    
    }

    
    public void insert(Salles salle) {
       Document doc=new Document("nom_salle",salle.getNom_salle())
       .append("capacite", salle.getCapacite());

       salles.insertOne(doc);
    }

    
    public void Delete(String id) {

        salles.deleteOne(eq("id",new ObjectId(id)));
    }

    
    public List<Salles> findall() {
        List<Salles> listsalles=new ArrayList<>();
        for(Document doc:salles.find()){
            Salles sale=new Salles();
            sale.setCapacite(doc.getInteger("capacite"));
            sale.setNom_salle(doc.getString("nom_salle"));
            listsalles.add(sale);
        }
        return listsalles;
    }

    
    public void update(String id, Evenments event) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
    
}
