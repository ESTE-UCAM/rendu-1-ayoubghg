package com.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Connection {
    static final String url="mongodb+srv://ayoub:bouaoud@cluster0.1o669.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    
    static final String database_name="gestion_evenement";
    static  MongoClient client;
    static{
        client=MongoClients.create(url);
    }

    public static MongoDatabase getbasedonnee(){
        return client.getDatabase(database_name);
}}
