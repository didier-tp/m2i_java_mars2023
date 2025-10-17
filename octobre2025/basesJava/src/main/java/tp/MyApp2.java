package tp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import tp.dao.ProduitDAO;
import tp.dao.ProduitDaoJdbc;
import tp.pers.Personne;
import tp.pers.Personne.Genre;

public class MyApp2 {
	
	public static void main(String[] args) {
		//testListe();
		//testerCollectionPersonne();
		//testerStream();
		//testerProduitDao();
		//testerDates();
		/*
		MyApp2 myApp2 = new MyApp2();
		myApp2.testPasStatic();
		*/
		testSwitchAvecLambda();
	}
	
	public static void testSwitchAvecLambda(){
		List<Personne> listePers = new ArrayList<>(); //possible depuis java 1.7

		listePers.add(new Personne("toto" , 30 , 77.6 , Genre.HOMME)); //new Personne(nom,age,poids)
		listePers.add(new Personne("dupond" , 36 , 78.6));
		listePers.add(new Personne("julie" , 6 , 38.6 , Genre.FEMME));
		for(Personne p : listePers) {
			
			String message = 
					switch(p.getGenre()) {
			           case  HOMME -> { String msg = "Bonjour monsieur " + p.getNom(); yield msg; } 
			           case  FEMME -> { String msg = "Bonjour madame " + p.getNom();; yield msg; } 
			           default -> "?";
			       };
			System.out.println(message);
		 }
	}
	
	public static void testerDates(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.format( DateTimeFormatter.ofPattern("dd/MM/yyyy",Locale.FRENCH)));
		Personne p = new Personne("toto" , 30 , 77.6);
		System.out.println(p.myToString());
		System.out.println(p.toXmlString());
	}
	
	public static void testerStream(){
		List<Personne> listePers = new ArrayList<>(); //possible depuis java 1.7

		listePers.add(new Personne("toto" , 30 , 77.6)); //new Personne(nom,age,poids)
		listePers.add(new Personne("dupond" , 36 , 78.6));
		listePers.add(new Personne("titi" , 6 , 38.6));
		listePers.add(new Personne("luc" , 25 , 76.6 , Genre.HOMME));
		listePers.add(new Personne("jeanne" , 16 , 58.6 , Genre.FEMME));
		
		//En Tp :
		//construire une liste filtrée , triée et transformée
		//personnes majeures seulement
		//tri par nom
		//nom en majuscule
		List<Personne> listePers2 = 
				listePers.stream()
				          .filter(p->p.estMajeur())
				          .sorted((p1,p2)->p1.getNom().compareTo(p2.getNom()))
				          //.map((p)->{ p.setNom(p.getNom().toUpperCase()); return p; })
				          .map((p)->new Personne(p.getNom().toUpperCase(),p.getAge(),p.getPoids()))
				          //.collect(Collectors.toList()) //depuis java 8
				          .toList();//depuis java 17
		
		System.out.println("listePers2="+listePers2);
		System.out.println("listePers (d'origine)="+listePers);
		
		List<Double> listeDouble = Arrays.asList( 1.0 ,6.8 , 9.5 , 2.2 , 9.1 , 3.3  );
		//en tp , calculer et afficher la somme , puis la moyenne 
		double somme = listeDouble.stream().reduce(0.0,(x,y)->(x+y));
		double moyenne = somme / listeDouble.size();
		System.out.println("moyenne="+moyenne);
		
	}
	
	public static void testerProduitDao(){
		/*
		ProduitDaoJdbc produitDao = new ProduitDaoJdbc();
		produitDao.initConnection();
		*/
		ProduitDAO produitDao = new ProduitDaoJdbc();
		produitDao.createProduit(new Produit(null,"tomate","nourriture",3.2,1.0));
		List<Produit> tousLesProduits = produitDao.findAll();
		System.out.println("tousLesProduits="+tousLesProduits);
		
		/*
		ProduitDAO produitDao = new ProduitDaoMap();
		//ProduitDAO produitDao = new ProduitDaoJdbc();
		produitDao.createProduit(new Produit(null,"pomme","nourriture",2.2,1.0));
		produitDao.createProduit(new Produit(null,"tomate","nourriture",3.2,1.0));
		List<Produit> tousLesProduits = produitDao.findAll();
		System.out.println("tousLesProduits="+tousLesProduits);
		Produit p1 = produitDao.findById(1);
		System.out.println("p1="+p1);
		produitDao.updateProduit(new Produit(2,"tomate cottelée","nourriture",4.2,1.0));
		System.out.println("p2="+produitDao.findById(2));
		produitDao.deleteById(2);
		System.out.println("tousLesProduits qui restent="+produitDao.findAll());
		
		int numP = 1 ; // ou 2 ou 3
		Optional<Produit> opProd = produitDao.findByIdOptional(numP);
		System.out.println("opProd="+opProd);
		Produit pOuNull = opProd.orElse(null);
		System.out.println("pOuNull="+pOuNull);
		Produit p = opProd.get();//java.util.NoSuchElementException: No value present si Optional.empty
		System.out.println("p="+p);
	    */
		
	}
	
	
	
	public static void testerCollectionPersonne(){
		//créer une liste de Personne , y ajouter quelques valeurs
		//List<Personne> listePers = new ArrayList<Personne>();
		List<Personne> listePers = new ArrayList<>(); //possible depuis java 1.7
		//var listePers = new ArrayList<Personne>(); //possible depuis java 10 (souvent 11 ou 17)
		
		listePers.add(new Personne("toto" , 30 , 77.6)); //new Personne(nom,age,poids)
		listePers.add(new Personne("dupond" , 36 , 78.6));
		listePers.add(new Personne("luc" , 25 , 76.6));
		
		/*
		//trier cette liste par noms croissants 
		//avec ComparatorPersonneNom puis afficher cette liste modifiée
		Collections.sort(listePers,new ComparatorPersonneNom());
		System.out.println("liste triée selon noms croissants:" + listePers);
		*/
		//trier cette liste par noms croissants avec une lambda expression (plus besoin du ComparatorPersonneNom):
		//Collections.sort(listePers, (Personne p1,Personne p2)-> { return p1.getNom().compareTo(p2.getNom()) ; });
		Collections.sort(listePers, (p1,p2)->p1.getNom().compareTo(p2.getNom()) );
		System.out.println("liste triée selon noms croissants:" + listePers);
		
		/*
		//trier une nouvelle fois cette liste par ages décroissants 
		//avec ComparatorPersonneAgeDesc puis afficher cette liste modifiée
		Collections.sort(listePers,new ComparatorPersonneAgeDesc());
		System.out.println("liste triée selon ages décroissants:" + listePers);
		*/
		
		//trier une nouvelle fois cette liste par ages décroissants  (plus besoin du ComparatorPersonneAgeDesc):
		//Collections.sort(listePers,(Personne p1,Personne p2)->{ return p2.getAge()-p1.getAge(); });
		//Collections.sort(listePers,(p1,p2)->p2.getAge()-p1.getAge());
		Collections.sort(listePers,(p1,p2)->Integer.compare(p2.getAge(),p1.getAge()));
		System.out.println("liste triée selon ages décroissants:" + listePers);
		
		//Ancien code avec classe imbriquée anonyme
		Collections.sort(listePers, new /* classe anonyme imbriquée et qui implements */
				Comparator<Personne>() {
					@Override
					public int compare(Personne o1, Personne o2) {
						return o2.getAge() - o1.getAge();
					}
		   }
		);
		
		System.out.println("liste triée selon ages décroissants:" + listePers);
		
	}
	
	public static void testListe() {
		System.out.println("testListe");
		List<String> liste1 = new ArrayList<>();
		liste1.add("janvier"); liste1.add("fevrier"); liste1.add("mars");
		
		for(String s : liste1)
			System.out.println("s="+s);
		
		System.out.println("liste initiale=" + liste1.toString());
		
		List<String> listeMaj = new ArrayList<>();
		for(String s : liste1) {
			String sMaj = s.toUpperCase();
			listeMaj.add(sMaj);
		}
		liste1 = listeMaj;
			
		System.out.println("liste en majuscule=" + liste1.toString());
		System.out.println("taille de la liste=" + liste1.size());
		liste1.remove("JANVIER");
		System.out.println("nouvelle taille de la liste=" + liste1.size());
		System.out.println("liste apres suppression=" + liste1.toString());
		
		List<Integer> liste2 = new ArrayList<>();
		liste2.add(5); //liste2.add(new Integer(5));
		
	}
	
	/*
	public void testPasStatic() {
		//...
	}*/

}
