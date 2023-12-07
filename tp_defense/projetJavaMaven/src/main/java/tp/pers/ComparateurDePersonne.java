package tp.pers;

public class ComparateurDePersonne implements java.util.Comparator<Personne> {
	@Override
	public int compare(Personne o1, Personne o2) {
     //return o1.getAge() - o2.getAge();
		
		if (o1.getNom() != null)
			return o1.getNom().compareTo(o2.getNom());
		else
			return -1;
			
	}
}
