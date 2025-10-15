package tp.pers;

import java.util.Comparator;

public class ComparatorPersonneAgeDesc implements Comparator<Personne>{

	@Override
	public int compare(Personne o1, Personne o2) {
		 if(o1.getAge()==null || o2.getAge()==null) return 0;
		 else 
			 return o2.getAge() - o1.getAge();    //par ordre décroissant
		     //return o1.getAge() - o2.getAge();  //par ordre croissant
	}

}
