package com.m2i.tp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<Double> listeDesCarresV2(List<Double> listeValeurs) {
		//V2 avec "lambda expression" et "stream" de java >=8
		return listeValeurs.stream().map(val->val*val).collect(Collectors.toList());
	}

	public List<Double> listeDesCarresV1(List<Double> listeValeurs) {
		List<Double> listeCarres = new ArrayList<>();
		for(Double val:listeValeurs ) {
			listeCarres.add(val*val);
		}
		return listeCarres;
	}

	public void ecrireFichier(String fileName, List<Double> listeCarres) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			PrintStream ps = new PrintStream(fos);
			for(Double valCarree :listeCarres ) {
				ps.println(valCarree);
			}
			ps.close(); fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("le fichier " + fileName + " a été généré");
	}

}
