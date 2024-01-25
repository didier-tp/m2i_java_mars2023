package com.m2i.tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public List<Double> lireFichier(String fileName){
		//hypothese: le fichier à lire comporte des valeurs numériques
		//sur chaque ligne
		List<Double> liste = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String ligne = br.readLine();
			while(ligne!=null) {
				double x = Double.parseDouble(ligne); 
				liste.add(x);
				ligne = br.readLine();
			}
			br.close(); fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return liste;
	}

}
