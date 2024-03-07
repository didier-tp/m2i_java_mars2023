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
	
	public static void essaiLecture() {
		List<String> listeLignes = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String ligne = br.readLine();
			while(ligne!=null) {
				listeLignes.add(ligne);
				ligne = br.readLine(); //on tente de lire la ligne suivante
			}
			br.close(); fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("listeLignes="+listeLignes);
	}
	
	

}
