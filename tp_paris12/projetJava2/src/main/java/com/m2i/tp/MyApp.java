package com.m2i.tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApp {
	public static void main(String[] args) {
		//testListe();
		//testListe2();
		testFichier();
	}
	
	public static void testFichier() {
		FileUtil fileUtil = new FileUtil();
		List<Double> listeValeurs = fileUtil.lireFichierV3("data.txt");
		System.out.println("listeValeurs="+listeValeurs);
		
		List<Double> listeCarres = fileUtil.listeDesCarres(listeValeurs);
		
		fileUtil.ecrireFichier("carres.txt" , listeCarres);
		
	}
	
	public static void testListe2() {
	    // construire liste1 comme une liste de <Double>
		List<Double> liste1 = new ArrayList<>();
		// ajouter 5 valeurs (ex: 5.0 , 18.0 , 56.0, 7.0 , 33.0 )
		liste1.add(5.0); liste1.add(18.0); liste1.add(56.0); liste1.add(7.0); liste1.add(33.0);
		
		//List<Double> liste1 = Arrays.asList(5.0 , 18.0 , 56.0 , 7.0 , 33.0);
		
		//constuire une seconde liste vide au début (liste2)
		List<Double> liste2 = new ArrayList<>();
		//parcourir liste1 et pour chaque itération
		for(Double valeur : liste1) {
			// calculer la valeur au carré 
			double carre = valeur*valeur;
			//et ajouter le resultat dans liste2
			liste2.add(carre);
		}
		
		//afficher taille de liste2
		System.out.println("taille liste2=" + liste2.size());
		//afficher toutes les valeurs de liste2
		System.out.println("liste2=" + liste2);
		/*
		for(Double v : liste2) {
			System.out.println(v);
		}
		*/
		
		//calculer et afficher moyenne de liste1
		double somme=0;
		for(Double valeur : liste1) {
			somme=somme+valeur;
		}
		System.out.println("moyenne liste1=" + somme / liste1.size());
	}
	
	public static void testListe() {
		List<String> liste = new ArrayList<>();
		liste.add("janvier");
		liste.add("fevrier");
		//liste.add(5); //erreur détectée (pas String)
		liste.add("mars");
		//parcours avec code proche d'un parcours de tableau ordinaire:
		int n = liste.size();
		System.out.println("n="+n);
		for(int i=0;i<n;i++) {
			//Object s = liste.get(i);
			String s = liste.get(i);
			System.out.println("s="+s.toUpperCase());
		}
		
		//nouvelle variante du for() au sens forEach()
		for(String chaine : liste) {
			System.out.println("chaine="+chaine);
		}
	}
}
