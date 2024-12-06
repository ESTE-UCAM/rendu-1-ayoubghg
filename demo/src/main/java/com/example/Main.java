package com.example;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.internal.client.model.Util;

import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

   
    public static void main(String[] args) {


        
        //test users
        DAOUser userDAO=new DAOUser();

        Utilisateur user=new Utilisateur();
        user.setNom("aaaaaa");
        user.setEmail("aaaaaaaaaa11@gmail.com");
        user.setPrenom("ccccc");
        user.setType("etudiant");
        userDAO.insert(user);

        List<Utilisateur> users=userDAO.findall();
        users.forEach(u->System.out.println("ID: "+u.getId_user()+", nom:"+u.getNom()+", prenom:"+u.getPrenom()+",Email: "+u.getEmail()));
        
        // userDAO.Delete("6751ddea7336e429bdffbfa2");



        // DAOevenment eventdao=new DAOevenment();
        // Evenments event=new Evenments();
        
        // event.setDescription("aaaaaaaaaaaaaaaaaaaaaaaaa");
        
        // List<Evenments> events=eventdao.findall();
        // events.forEach(e->System.out.println("Id: "+e.getId_user()+" event name: "+e.getNom_event()+" description: "+e.getDescription()+" date: "+e.getDate_event()));

        DAOsalle saledao=new DAOsalle();
        Salles salle=new Salles();
        salle.setCapacite(250);
        salle.setNom_salle("salle 20");
        saledao.insert(salle);
        List<Salles> salles=saledao.findall();
        salles.forEach(e->System.out.println("nom de la salle :"+e.getNom_salle()+"la capacite de la salle "+e.getCapacite()));


        DAOterrain terrainsdao=new DAOterrain();
        Terrains terrain=new Terrains();
        terrain.setNom_terrain("terrain est ");
        terrain.setType("football");
        terrainsdao.insert(terrain);
        List<Terrains> listterrains=terrainsdao.findall();
        listterrains.forEach(e->System.out.println("nom terrain :"+e.getNom_terrain()+"type de terrain :"+e.getType()));

        DAOreservation reservationdao=new DAOreservation();
        Reservations reservation=new Reservations();
        reservation.setDate_reservation(new Date());
        reservation.setId_event("6751fc839062fa693051a5d4");
        reservation.setId_terrain("67521bc844de6a67bc3b0084");
        reservation.setId_salle("675217254fe65c4998cef537");
        reservation.setId_user("6751b8df2140221b1b8306ff");
        reservationdao.insert(reservation);


        Reservations reresesrvation1=new Reservations();
        reresesrvation1.setId_event("6751fc839062fa693051a5d4");
                reresesrvation1.setId_terrain("67521bc844de6a67bc3b0084");
                reresesrvation1.setId_salle("675217254fe65c4998cef537");
        reresesrvation1.setDate_reservation(new Date());
        reresesrvation1.setId_user("6751b8df2140221b1b830700");
        reservationdao.insert(reresesrvation1);
        if(reservationdao.disponibilite("6751fc839062fa693051a5d4","salle 20")!=1){
            System.out.println("sold out");
        }
        else{
            System.out.println("reserver votre ticket");
        }

        List<Reservations> listreservation=reservationdao.findall();
        listreservation.forEach(e->System.out.println("id_user :"+e.getId_user()+"id_event= "+e.getId_event()+"id_terrain= "+e.getId_terrain()+"date: "+e.getDate_reservation()+"id_salle"+e.getId_salle()));
        

        // String uri="mongodb+srv://rachidaarag:rachidaarag@cluster0.k7ehw.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        // try (MongoClient mongoClient=MongoClients.create(uri)) {
        //     MongoDatabase database=mongoClient.getDatabase("mini-project-java");
        //     MongoCollection<Document> utilisateurs=database.getCollection("utilisateurs");
        //     MongoCollection<Document> evenements=database.getCollection("evenements");
        //     MongoCollection<Document> salles=database.getCollection("salles");
        //     MongoCollection<Document> terrains=database.getCollection("terrains");
        //     MongoCollection<Document> reservations=database.getCollection("reservations");


        //     Scanner scanner=new Scanner(System.in);
        //     System.out.println("donner le id de l'utilisateur ");
        //     int id_user=scanner.nextInt();

        //     System.out.println("donner le nom de l'utilisateur ");
        //     String nom=scanner.next();

        //     System.out.println("donner le prenom de l'utilisateur ");
        //    String prenom=scanner.next();

        //     System.out.println("donner l'email de l'utilisateur ");
        //     String email=scanner.next();


        //     System.out.println("donner le type de l'utilisateur ");
        //     String type=scanner.next();

        //     System.out.println("Insertion Utilisateur");
        //             Document utilisateur1=new Document("id_user",id_user)
        //             .append("nom", nom)
        //             .append("prenom",prenom)
        //             .append("email",email)
        //             .append("type",type);

                


//
            

                // System.out.println("Insertion Utilisateur");
                //     Document utilisateur1=new Document("id_user", 1)
                //     .append("nom", "rachid")
                //     .append("prenom","aarag")
                //     .append("email","rachidaraq108@gmail.com")
                //     .append("type","etudiant");

                // Document utilisateur2=new Document("id_user", 2)
                //     .append("nom", "karim")
                //     .append("prenom","aarag")
                //     .append("email","karimmmm108@gmail.com")
                //     .append("type","etudiant");

                // Document utilisateur3=new Document("id_user", 2)
                //     .append("nom", "ali")
                //     .append("prenom","aarag")
                //     .append("email","aliiii@gmail.com")
                //     .append("type","etudiant");

              
                //     utilisateurs.insertOne(utilisateur1);
                //     utilisateurs.insertOne(utilisateur2);
                //     utilisateurs.insertOne(utilisateur3);
                
                // System.out.println("successfully for all  utilisateurs ");




                // System.out.println("Insertion evenments");
                //     Document evenement1=new Document("id_event", 1)
                //     .append("nom_event", "concert")
                //     .append("date_event","2024-12-31")
                //     .append("description","nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn")
                //     .append("id_user","2");

                // Document evenement2=new Document("id_event", 2)
                //     .append("nom_event", "conference")
                //     .append("date_event","2024-01-15")
                //     .append("description","ccccccccccccccccccccccccccc")
                //     .append("id_user","3");

                // Document evenement3=new Document("id_event", 3)
                //     .append("nom_event", "festival")
                //     .append("date_event","2024-01-25")
                //     .append("description","vvvvvvvvvvvvvvvvvvvv")
                //     .append("id_user","2");

              
                //     evenements.insertOne(evenement1);
                //     evenements.insertOne(evenement2);
                //     evenements.insertOne(evenement3);
                
                // System.out.println("successfully for all evenements ");





                // System.out.println("Insertion salles");
                //     Document salle1=new Document("id_salle", 1)
                //     .append("nom_salle", "salle 2")
                //     .append("capacite","120");
                    

                // Document salle2=new Document("id_salle", 2)
                //     .append("nom_salle", "salle 5")
                //     .append("capacite","64");
                    

                // Document salle3=new Document("id_salle", 3)
                //     .append("nom_salle", "salle 19")
                //     .append("capacite","70");
                    

              
                //     salles.insertOne(salle1);
                //     salles.insertOne(salle2);
                //     salles.insertOne(salle3);
                
                // System.out.println("successfully for all salles ");





                // System.out.println("Insertion terrain");
                //     Document terrain1=new Document("id_terrain", 1)
                //     .append("nom_salle", "salle 2")
                //     .append("capacite","120");
                    

                // Document terrain2=new Document("id_terrain", 2)
                //     .append("nom_terrain", "terrain football")
                //     .append("type","64");
                    

                    

              
                //     terrains.insertOne(terrain1);
                //     terrains.insertOne(terrain2);
                
                // System.out.println("successfully for all terrains ");




                // System.out.println("Insertion reservation");
                //     Document reservation1=new Document("id_reservation", 1)
                //     .append("id_user", 1)
                //     .append("id_event",3)
                //     .append("id_terrain",1)
                //     .append("date_reservation",new Date());
                    

                // Document reservation2=new Document("id_reservation", 2)
                //     .append("id_user", 1)
                //     .append("id_event",3)
                //     .append("id_terrain",1)
                //     .append("date_reservation",new Date());
                    

                    

              
                //     reservations.insertOne(reservation1);
                //     reservations.insertOne(reservation2);
                
                // System.out.println("successfully for all reservations ");




                



                









            

           

        }
    }
