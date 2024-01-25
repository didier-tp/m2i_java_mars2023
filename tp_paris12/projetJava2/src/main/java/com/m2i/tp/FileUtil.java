package com.m2i.tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public List<Double> lireFichierV1(String fileName){
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
	
	public List<Double> lireFichierV2(String fileName){
		//hypothese: le fichier à lire comporte des valeurs numériques
		//sur chaque ligne
		List<Double> liste = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String ligne = br.readLine();
			while(ligne!=null) {
				double x = Double.parseDouble(ligne); 
				liste.add(x);
				ligne = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
		}
		return liste;
	}
	
	public List<Double> lireFichierV3(String fileName){
		List<Double> liste = new ArrayList<>();
		try( FileInputStream fis = new FileInputStream(fileName);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis))
		    ){
			String ligne = br.readLine();
			while(ligne!=null) {
				double x = Double.parseDouble(ligne); 
				liste.add(x);
				ligne = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//automatic finally in try(withResources){....}catch(...){...}
		//with automatic .close() on AutoClosable resource like FileInputStream or BufferedReader
		return liste;
	}

	public List<Double> listeDesCarres(List<Double> listeValeurs) {
		// TODO Auto-generated method stub
		return null;
	}

	public void ecrireFichier(String string, List<Double> listeCarres) {
		// TODO Auto-generated method stub
		
	}

}
