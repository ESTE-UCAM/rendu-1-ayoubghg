package com.example;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

class DAOterrain {
    MongoCollection<Document> terrain;

    public DAOterrain(){
        MongoDatabase database=Connection.getbasedonnee();
        terrain=database.getCollection("terrains");

    }

  
    public void insert(Terrains terrain){
        Document doc=new Document("nom_terrain",terrain.getNom_terrain())
        .append("type",terrain.getType());
        this.terrain.insertOne(doc);
        
    }

  
    public void Delete(String id) {
        terrain.deleteOne(eq("_id",new ObjectId(id)));
    }

  
    public List<Terrains> findall(){
            List<Terrains> listterrains=new ArrayList<>();
            for(Document doc:terrain.find()){
                Terrains terrain=new Terrains();
                terrain.setNom_terrain(doc.getString("nom_terrain"));
                terrain.setType(doc.getString("type"));
                listterrains.add(terrain);
            }
            return listterrains;
    }

  
    public void update(String id, Evenments event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    

}