
CREATE DATABASE IF NOT EXISTS classevirtuelle;
USE classevirtuelle;

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS Eleve;
DROP TABLE IF EXISTS Parent;
DROP TABLE IF EXISTS Classe;
DROP TABLE IF EXISTS Utilisateur;
DROP TABLE IF EXISTS Devoir;
DROP TABLE IF EXISTS Matiere;
DROP TABLE IF EXISTS Jour;
DROP TABLE IF EXISTS Enseignant;
DROP TABLE IF EXISTS Cours;




######################## CREATE  TABLE ########################################

CREATE TABLE Parent(
   id INT auto_increment,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   adresse VARCHAR(50),
   email VARCHAR(50),
   num_tel VARCHAR(50),
   PRIMARY KEY(id)
);

CREATE TABLE Classe(
   id INT auto_increment,
   nom VARCHAR(50),
   annee_scolaire VARCHAR(10),
   PRIMARY KEY(id)
);

CREATE TABLE Utilisateur(
   id INT auto_increment,
   identifiant VARCHAR(50),
   mot_de_passe VARCHAR(1000),
   role VARCHAR(50),
   PRIMARY KEY(id)
);

CREATE TABLE Matiere(
   id INT auto_increment,
   intitule VARCHAR(50),
   PRIMARY KEY(id)
);

CREATE TABLE Devoir(
   id INT auto_increment,
   date_devoir DATE,
   matiere INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(matiere) REFERENCES Matiere(id)
);

CREATE TABLE Jour(
   id INT auto_increment,
   date DATE,
   PRIMARY KEY(id)
);

CREATE TABLE Enseignant(
   id INT auto_increment,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   email VARCHAR(50),
   num_tel VARCHAR(50),
   PRIMARY KEY(id)
);

CREATE TABLE Eleve(
   id INT auto_increment,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   date_naissance DATE,
   classe INT,
   parent INT,
   enseignant INT,
   PRIMARY KEY(id),
   FOREIGN KEY(classe) REFERENCES Classe(id),
   FOREIGN KEY(parent) REFERENCES Parent(id),
   FOREIGN KEY(enseignant) REFERENCES Enseignant(id)
);

CREATE TABLE Cours(
   id INT auto_increment,
   heure_debut TIME,
   heure_fin TIME,
   classe INT NOT NULL,
   jour INT NOT NULL,
   matiere INT NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(classe) REFERENCES Classe(id),
   FOREIGN KEY(jour) REFERENCES Jour(id),
   FOREIGN KEY(matiere) REFERENCES Matiere(id)
);

SET FOREIGN_KEY_CHECKS=1;
