package tp.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import tp.data.Town;

public class MyCsvUtil {
	

	public static List<Town> readTownsFile(String inputFileName){
		List<Town> listeTowns = new ArrayList<>();
		
		try( FileInputStream fis = new FileInputStream(inputFileName);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fis))
		    ){
			br.readLine();//lecture ligne d'entête
			String ligne = br.readLine(); //lecture première ligne de valeurs
			while(ligne!=null) {
				String p[] = ligne.split(";");
		        Town town = new Town(
		        		p[0],
		        		p[1],
		        		(p[2]!=null && !p[2].equals("null"))?Double.parseDouble(p[2]):null,
		        		(p[3]!=null && !p[3].equals("null"))?Double.parseDouble(p[3]):null,
		        		(p[4]!=null && !p[4].equals("null"))?Integer.parseInt(p[4]):null);
		        listeTowns.add(town);
				ligne = br.readLine(); //lecture prochaine ligne de valeurs
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//automatic finally in try(withResources){....}catch(...){...}
		//with automatic .close() on AutoClosable resource like FileInputStream or BufferedReader
			
		return listeTowns;
	}
	
	

	public static void writeTownsFile(List<Town> listeTowns,String outputFileName) {
		try(
				FileOutputStream fos = new FileOutputStream(outputFileName);
				PrintStream ps = new PrintStream(fos)){
			    ps.println("codePostal;nomVille;longitude;latitude;population") ;
			    for(Town town : listeTowns) {
				ps.printf("%s;%s;%s;%s;%d\n",
						town.getCodePostal(),
						town.getNomVille(),
						String.valueOf(town.getLongitute()),
						String.valueOf(town.getLatitude()),
						town.getPopulation()
						);
			    }
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			//automatic finally in try(withResources){....}catch(...){...}
			//with automatic .close() on AutoClosable resource like FileOutputStream or PrintStream
			System.out.println("le fichier " + outputFileName + " a été généré");
	}

}
