
CREATE DATABASE IF NOT EXISTS myLuminessDB;
USE myLuminessDB;

DROP TABLE IF EXISTS personne;


CREATE TABLE personne(
    id integer auto_increment,
	nom VARCHAR(64),
	age integer,
	poids double,
	PRIMARY KEY(id));

#########################  INSERT INTO   #####################################

INSERT INTO personne(id,nom,age,poids) VALUES (1,'jean_bon',45, 67.8);
INSERT INTO personne(id,nom,age,poids) VALUES (2,'axelle_aire',38, 82.56);
 
###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM personne;
	