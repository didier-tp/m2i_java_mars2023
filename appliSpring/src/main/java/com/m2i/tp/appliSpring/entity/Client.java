package com.m2i.tp.appliSpring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
@NamedQuery(name="Client.findByIdWithComptes", 
           query="SELECT cli FROM Client cli LEFT JOIN FETCH cli.comptes WHERE cli.id = ?1")
//NB: le mot clef FETCH de Hibernate demande à remonter tout de suite les comptes rattachés au client
//même si on est par défaut en mode lazy
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 64)
	private String prenom;
	
	@Column(length = 64)
	private String nom;
	
	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
	  //mappedBy = "client" car au dessus de Compte.client il y a @ManyToOne
	private List<Compte> comptes;
	
	@Transient //en mémoire seulement (jamais sctocké en base)
	private String commentaireUltraSecret;
	
	//email , telephone , ...
	

	public Client(Integer id, String prenom, String nom) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", commentaireUltraSecret="
				+ commentaireUltraSecret + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public String getCommentaireUltraSecret() {
		return commentaireUltraSecret;
	}

	public void setCommentaireUltraSecret(String commentaireUltraSecret) {
		this.commentaireUltraSecret = commentaireUltraSecret;
	}

	

	

}
