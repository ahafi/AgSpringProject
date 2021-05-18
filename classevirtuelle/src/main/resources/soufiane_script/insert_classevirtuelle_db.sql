

USE classevirtuelle;


#########################  INSERT INTO   #####################################
                     
INSERT INTO Parent (id,nom,prenom,adresse,email,num_tel) 
                       VALUES (1,'Talys','Alexi','2 rue kiko 93200','alexi@ici_ou_laba','014575896');
INSERT INTO Parent (id,nom,prenom,adresse,email,num_tel) 
                       VALUES (2,'Marco','Polo','125 rue kaki 75000','polo@ici_ou_laba','014777758');
INSERT INTO Parent (id,nom,prenom,adresse,email,num_tel) 
                       VALUES (3,'Max','Relou','458 rue lafrance 92200','relou@ici_ou','0155555555');

INSERT INTO utilisateur (id,identifiant,mot_de_passe)  VALUES (1,'didier','1234');

INSERT INTO classe (id,nom,annee_scolaire)  VALUES (1,'CP','2020/2021');
INSERT INTO classe (id,nom,annee_scolaire)  VALUES (2,'CM1','2020/2021');
INSERT INTO classe (id,nom,annee_scolaire)  VALUES (3,'CE1','2020/2021');


INSERT INTO matiere (id,intitule)  VALUES (1,'math');
INSERT INTO matiere (id,intitule)  VALUES (2,'francais');
INSERT INTO matiere (id,intitule)  VALUES (3,'espagnol');

INSERT INTO devoir (id,date_devoir,matiere) VALUES (1,'2020-12-08',1);
INSERT INTO devoir (id,date_devoir,matiere) VALUES (2,'2020-12-08',2);
INSERT INTO devoir (id,date_devoir,matiere) VALUES (3,'2020-12-08',3);

INSERT INTO jour (id,date) VALUES (1,'2020-12-08');
INSERT INTO jour (id,date) VALUES (2,'2020-10-08');
INSERT INTO jour (id,date) VALUES (3,'2021-01-08');

INSERT INTO enseignant (id,nom,prenom,email,num_tel) 
                       VALUES (1,'Tata','Allo','tatio@lolo.com','0124889652'); 
INSERT INTO enseignant (id,nom,prenom,email,num_tel) 
                       VALUES (2,'toto','mAllo','kali@loli.com','0254112325'); 
INSERT INTO enseignant (id,nom,prenom,email,num_tel) 
                       VALUES (3,'kache','koche','kiloli@kiki.com','066521222'); 

INSERT INTO eleve (id,nom,prenom,date_naissance,classe,enseignant,parent) 
                       VALUES (1,'klilich','bibich','2015-04-06',1,2,3);
INSERT INTO eleve (id,nom,prenom,date_naissance,classe,enseignant,parent) 
                       VALUES (2,'Cristo','mino','2014-05-06',3,1,2);
INSERT INTO eleve (id,nom,prenom,date_naissance,classe,enseignant,parent) 
                       VALUES (3,'coco','chanel','2013-05-06',2,3,3);

INSERT INTO cours (id,heure_debut,heure_fin, classe, jour, matiere) 
                       VALUES (1,'10:00','11:30',1,2,3);   
INSERT INTO cours (id,heure_debut,heure_fin,classe, jour, matiere) 
                       VALUES (2,'09:00','10:30',3,2,2);   
INSERT INTO cours (id,heure_debut,heure_fin,classe, jour, matiere) 
                       VALUES (3,'08:00','11:30',2,1,2); 



###################### VERIFICATIONS ###########################################

show tables;
SELECT * FROM Parent;
SELECT * FROM classe;
SELECT * FROM utilisateur;
SELECT * FROM matiere;
SELECT * FROM devoir;
SELECT * FROM jour;
SELECT * FROM enseignant;
SELECT * FROM eleve;
SELECT * FROM cours;






