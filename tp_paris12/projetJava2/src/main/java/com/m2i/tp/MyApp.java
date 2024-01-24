package com.m2i.tp;

import java.util.ArrayList;
import java.util.List;

public class MyApp {
	public static void main(String[] args) {
		testListe();
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
