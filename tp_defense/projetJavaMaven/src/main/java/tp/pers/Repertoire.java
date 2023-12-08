package tp.pers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Repertoire {

	private Stat stat = new Stat();
	private List<Personne> listePersonnes = new ArrayList<>();
	
	public void afficherStatistiques() {
		//System.out.println("listePersonnes=" + listePersonnes);
		// afficher par exemple le nombre de personnes
		// et la moyenne des ages
		stat.setN(listePersonnes.size());
		double sommeAges = 0;
		for(Personne p : listePersonnes) {
			sommeAges += p.getAge();
		}
		stat.setMoyenneAge(sommeAges / stat.getN());
		System.out.println("nb de personnes=" + stat.getN());
		System.out.println("moyenne des ages=" + stat.getMoyenneAge());
	}
	
	/*
	 personnes.csv
	 prenom;nom;age;poids
     jean;Bon;44;77.7
     
     et Personne(String nom, String prenom, Integer age) 
        plus Personne.setPoids(double poids)
	 */

	public void lireFichier(String fileName) {
	   try (FileInputStream fis = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis))
		){
			br.readLine();// lecture de la première ligne du fichier .csv avec titres colonnes
			String ligne = br.readLine();
			while (ligne != null) {
				String[] t = ligne.split(";");
				String prenom=t[0];
				String nom=t[1];
				int age=Integer.parseInt(t[2]);
				double poids=Double.parseDouble(t[3]);
				Personne p = new Personne(nom,prenom,age);
				p.setPoids(poids);
				this.listePersonnes.add(p);
				ligne = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	   //automatic .close() via try with resources (try avec resources entre parentheses)
	}

	

	public static void main(String[] args) {
		Repertoire repertoire = new Repertoire();
		repertoire.lireFichier("personnes.csv");
		repertoire.afficherStatistiques();
	}

}
