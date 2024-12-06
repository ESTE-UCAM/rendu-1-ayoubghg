package com.example;


import static com.mongodb.client.model.Filters.eq;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DAOUser {
    MongoCollection<Document> user;


    public DAOUser(){
        MongoDatabase database=Connection.getbasedonnee();
        this.user=database.getCollection("utilisateurs");
    }

    
    public void insert(Utilisateur user){
        Document document=new Document("nom",user.getNom())
        .append("prenom",user.getPrenom())
        .append("email",user.getEmail())
        .append("type",user.getType());

        this.user.insertOne(document);
    }

    
    public void Delete(String id){
        this.user.deleteOne(eq("_id",new ObjectId(id)));
    }

    
    public List<Utilisateur> findall(){
        List<Utilisateur> listusers=new ArrayList<>();
            for(Document Doc:user.find()){
                Utilisateur user=new Utilisateur();
                user.setNom(Doc.getString("nom"));
                user.setPrenom(Doc.getString("prenom"));
                user.setEmail(Doc.getString("email"));
                user.setId_user(Doc.getObjectId("_id"));
                user.setType(Doc.getString("type"));
                listusers.add(user);
            }
            return listusers;
    }

    
    
}
