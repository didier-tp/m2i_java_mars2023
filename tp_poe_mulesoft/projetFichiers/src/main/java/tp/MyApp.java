package tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyApp {

	public static void main(String[] args) {
		essaiLecture();

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
