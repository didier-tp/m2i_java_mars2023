package tp;

public class MyApp3 {

	public static void main(String[] args) {
		//lancement de MyApp3:
		//java ... -Daff.maj=true  tp.MyApp3 9 message1 (dans .bat de lancement)
		//ou bien dans onglet "arguments" de "run configuration" de eclipse
		//  9 message dans "program argument"
		// -Daff.maj=true dans VM arguments
		
		//resultat:  racineCarree=3 message=MESSAGE1
		double valeur = Double.parseDouble(args[0]);
		String message=args[1];
		boolean affMaj = Boolean.parseBoolean(System.getProperty("aff.maj"));
		double racineCarre= Math.sqrt(valeur);
		if(affMaj) message=message.toUpperCase();
		System.out.println("racineCarre="+racineCarre + " message="+message);
		
	}

}
