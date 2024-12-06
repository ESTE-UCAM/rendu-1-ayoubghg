Application de Gestion des Événements et Réservations
Description
Cette application est conçue pour automatiser la gestion des événements, des réservations de salles et de terrains, ainsi que des utilisateurs (étudiants et professeurs). Elle utilise Java avec MongoDB pour stocker et gérer les données.

Fonctionnalités
1. Gestion des Utilisateurs
Ajouter un utilisateur (étudiant ou professeur).
Afficher la liste des utilisateurs.
Supprimer un utilisateur.
2. Gestion des Événements
Ajouter un événement.
Modifier les détails d’un événement.
Supprimer un événement.
Afficher les événements.
3. Gestion des Salles et Terrains
Ajouter une salle ou un terrain.
Afficher la liste des salles et terrains.
Supprimer une salle ou un terrain.
4. Gestion des Réservations
Réserver une salle ou un terrain.
Vérifier la disponibilité avant réservation.
Modifier ou supprimer une réservation.
Afficher les réservations.
Prérequis
Java 8 ou version supérieure installé.
MongoDB installé et configuré localement ou sur MongoDB Atlas.
MongoDB Java Driver :
Téléchargez depuis MongoDB Driver Downloads ou ajoutez la dépendance via Maven.
Installation et Exécution
Étape 1: Configurer MongoDB
Assurez-vous que votre instance MongoDB est en cours d’exécution.
Configurez une base de données nommée gestion_evenement et les collections nécessaires.
Étape 2: Configurer l’Application
Modifiez la classe Connection pour adapter les informations de connexion :
java
Copier le code
static final String url = "mongodb+srv://<username>:<password>@cluster0.mongodb.net/?retryWrites=true&w=majority";
static final String database_name = "gestion_evenement";
Étape 3: Compiler et Exécuter
Compilez le projet 

Structure du Projet
src/com/example/Connection.java : Gère la connexion à MongoDB.
src/com/example/Main.java : Point d’entrée principal de l’application.
src/com/example/dao/ : Classes DAO pour interagir avec MongoDB.
Contributeurs
Développeur : Ayoub Bouaoud
