package tp.pers;

public class Repertoire {
	
	Object listePersonnes = new String("temp");
	
	public void lireFichier(String fileName) {
		
	}
	
    public void afficherStatistiques() {
		System.out.println("listePersonnes=" + listePersonnes);
	}

	public static void main(String[] args) {
		Repertoire repertoire = new Repertoire();
		repertoire.lireFichier("personnes.csv");
        repertoire.afficherStatistiques();
	}

}
