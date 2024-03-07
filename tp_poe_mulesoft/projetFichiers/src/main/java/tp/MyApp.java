package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MyApp {

	public static void main(String[] args) {
		//List<String> couleurs = essaiLecture();
        //essaiEcriture(couleurs,"data2.txt");
		Catalogue catalogue = new Catalogue();
		catalogue.lireFichierProduits();
		catalogue.calculerStats();
		catalogue.ecrireFichierStats();
		catalogue.ecrireFichierProduitsJson();
		catalogue.ecrireFichierProduitsXml();
	}
	
	public static void essaiEcriture(List<String> listeValeurs , String fileName) {
		try (
			PrintStream ps = new PrintStream(new FileOutputStream(fileName))
			) {
			for(String ligne : listeValeurs) {
				ps.println(ligne.toUpperCase());
			}
			System.out.println("le fichier " + fileName + " a ete généré (à voir apres refresh eclipse)");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}//finally automatique qui déclenche .close() sur ps du try(ps=...)
	}
	
	public static List<String> essaiLecture() {
		List<String> listeLignes = new ArrayList<>();
		try( BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("data.txt")))
				) {
			String ligne = br.readLine();
			while(ligne!=null) {
				listeLignes.add(ligne);
				ligne = br.readLine(); //on tente de lire la ligne suivante
			}
		} catch (IOException e) {
			e.printStackTrace();
		} //finally automatique qui déclenche .close() sur le br qu'il y a 
		// dans les parenthèses du try "with resource"
		System.out.println("listeLignes="+listeLignes);
		return listeLignes;
	}
	
	/*
	public static void essaiLectureV1() {
		List<String> listeLignes = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(new FileInputStream("data.txt")));
			String ligne = br.readLine();
			while(ligne!=null) {
				listeLignes.add(ligne);
				ligne = br.readLine(); //on tente de lire la ligne suivante
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		System.out.println("listeLignes="+listeLignes);
	}
	*/
	
	

}
