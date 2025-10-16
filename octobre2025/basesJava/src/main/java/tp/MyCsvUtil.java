package tp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCsvUtil {
	
	public List<Produit> readFile(String	 fileName){
		List<Produit> listeProd = new ArrayList<>();
		  try (Scanner scanner = new Scanner(Path.of(fileName)) ){
			  scanner.nextLine();//première ligne à ignorer (titre des colonnes)
			  while(scanner.hasNext()) {
			    String ligne = scanner.nextLine();
			    System.out.println("ligne lue=" + ligne) ;
			    String[] t = ligne.split(";");
			    Produit p = new Produit(Integer.parseInt(t[0]),
			                    t[1],
			                    t[2],
			                    Double.parseDouble(t[3]), 
			                    Double.parseDouble(t[4]));
			    listeProd.add(p);
			    }
			  } catch (IOException e) {
			      e.printStackTrace();
			  }
			  //Automatic finally with call 
			  //of .close() of AutoCloseable interface implementation in Scanner class
		return listeProd;
	}
	
	public void writeStatFile(Stat stat,String fileName){
		try (FileOutputStream fos = new FileOutputStream(fileName);
			 PrintStream ps = new PrintStream(fos) ){
			      ps.println("nbProduits;moyennePrix;moyennePoids");
			      ps.println(MessageFormat.format("{0};{1};{2}", 
			    		  stat.getNbProduits(),
			    		  String.valueOf(stat.getMoyennePrix()),
			    		  String.valueOf(stat.getMoyennePoids())) );
			  } catch (IOException e) {
			      e.printStackTrace();
			  }
			  //Automatic finally with call 
			  //of .close() of AutoCloseable interface implementation in FileOutputStream class
	}

}
