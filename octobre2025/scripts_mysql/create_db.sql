
CREATE DATABASE IF NOT EXISTS tpDB;
USE tpDB;

DROP TABLE IF EXISTS produit;

CREATE TABLE produit(
    numero integer auto_increment,
	label VARCHAR(64),
	categorie VARCHAR(64),
	prix double,
	poids double,
	PRIMARY KEY(numero));

#########################  INSERT INTO   #####################################

INSERT INTO produit(numero,label,categorie,prix,poids) VALUES (1,'pomme','nourriture',4.5, 1.2);
INSERT INTO produit(numero,label,categorie,prix,poids) VALUES (2,'cahier','papeterie',3.8, 0.36);
 
###################### VERIFICATIONS ###########################################
show tables;
SELECT * FROM produit;
	