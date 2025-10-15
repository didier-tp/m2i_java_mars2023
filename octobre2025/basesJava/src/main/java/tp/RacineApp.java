package tp;

public class RacineApp {
	
	public static void main(String[] args) {
		// java tp.RacineApp 81 
		//ou  java tp.RacineApp 64
		//ou  java tp.RacineApp 6a (par erreur)
		//ou java tp.RacineApp (par erreur)
		try {
			String sVal=args[0];// java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
			double val = Double.parseDouble(sVal); //java.lang.NumberFormatException: For input string: "6a
			double r = Math.sqrt(val);
			System.out.println("racine carree="+r);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.err.println("il faut passer au moins un argument au programme");
			System.err.println("usage: java tp.RacineApp <valeur numerique>");
			System.err.println("exemple: java tp.RacineApp 81");
		}
		catch (NumberFormatException e) {
			//e.printStackTrace();
			System.err.println("l'argument doit être numerique !!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/*
 avec eclipse, premier lancement ordinaire (Run as / java application)
 puis menu "Run / Run configuration" et onglets "arguments"
 avec dans "programm argument" 81 ou 64 ou rien ou 6a ou ...
 */
