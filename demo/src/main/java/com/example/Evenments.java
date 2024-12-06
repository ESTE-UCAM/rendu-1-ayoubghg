package com.example;

import org.bson.types.ObjectId;

public class Evenments {
    String nom_event,date_event,description;
    String id_user;

    public String getDate_event(){
        return date_event;
    }
    public String getDescription(){
        return description;
    }
    public String getId_user(){
        return id_user;
    }
    public String getNom_event(){
        return nom_event;
    }
    public void setDate_event(String date_event) {
        this.date_event=date_event;
    }
    public void setDescription(String description) {
        this.description=description;
    }
    public void setId_user(String id_user) {
        this.id_user=id_user;
    }
    public void setNom_event(String nom_event) {
        this.nom_event=nom_event;
    }

    @Override
    public String toString(){
        return "Evenments{"+"nom_event="+nom_event+", date_event:'"+date_event+'\''+",description:'"+description+'\''+"id_user='"+id_user+'\''+'}';
    }

}
