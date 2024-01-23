package tp;

public class MyApp {
	
    public static void main(String[] args) {
	   testPersonne();
	   //testAdresse();
	   //testString();
	   //testTableau1();
	   //testTableau2();
    	//testSplit();
    	//testMath();
    }
    
    public static void testMath() {
    	//soit un cercle de rayon=60.0
    	//on va calculer le périmètre et l'aire
    	double rayon=60.0;
    	//il exite Math.PI , Math.pow( ... , 2) 
    	
    	double perimetre = 2 * rayon * Math.PI; // 2 * rayon * PI (dans classe Math)
    	double aire= Math.pow(rayon, 2) * Math.PI; // rayon * rayon * PI ou bien PI * rayon au carré
    	
    	//afficher
    	System.out.println("perimetre du cercle="+perimetre);
    	System.out.println("aire/surface du cercle="+aire);
    }
    
    public static void testSplit() {
    	//chValeurs="nomProduit;montantHT;tauxTva"
    	String chValeurs="produitA;120;5.5";
    	//en tp :
    	//phase 1 extraire les valeurs montantHt et tauxTva  - méthode split() page 36
    	String[] parties = chValeurs.split(";"); //decoupage via le séparateur ";"
    	//parties[0] vaut "produitA" , parties[1] vaut "120" , parties[2] vaut "5.5"
    	//phase 2 : conversions éventuelles page 19
    	double montantHT = Double.parseDouble(parties[1]);
    	double tauxTva = Double.parseDouble(parties[2]);
    	//phase 3 : calculer et afficher le montant ttc
    	double montantTtc = montantHT * (1+tauxTva/100);
    	System.out.println("montantTtc="+montantTtc);
    }
    
    public static void testTableau2() {
    	double[] tab2 = { 12.0, 345.0 , 3.0 , 43.0 , 4.0 };
    	//en tp : calculer et afficher la moyenne des valeurs de tab2
    	double somme=0.0;
    	for(int i=0;i<tab2.length;i++) {
    		somme=somme+tab2[i];
    		//somme+=tab2[i];
    	}
    	double moyenne=somme/tab2.length;
    	System.out.println("moyenne=" + moyenne);
    }
    
    //Solutions des principaux Tps:
    //https://github.com/didier-tp/m2i_java_mars2023
    //partie tp_defense et projet projetJavaMaven
    
    
    public static void testTableau1() {
    	/*
    	int[] tab1 = new int[5];
    	tab1[0]=12;
    	tab1[1]=345;
    	tab1[2]=3;
    	tab1[3]=34;
    	tab1[4]=5;
    	*/
    	int[] tab1 = { 12, 345 , 3 , 43 , 4 };

    	//en tp : trouver et afficher la plus grande valeur.
    	int lePlusGrand=0; //valeur provisoire
    	for(int i=0;i<tab1.length;i++) {
    		if(tab1[i]>=lePlusGrand)
    			lePlusGrand=tab1[i];
    	}
    	System.out.println("lePlusGrand="+lePlusGrand);
    }
    
    public static void testString() {
    	String ch1="lundi c'est ravioli";
    	//vérifier oui ou non si ch1 comporte le caractère c 
    	//on peut par exemple effectuer une boucle 
    	//sur les positions possibles des caracères (i allant de 0 à .length() -1 )
    	int n= ch1.length();
    	System.out.println("n="+n);
    	for(int i=0;i<n;i++) {
    		if(ch1.charAt(i)=='c')
    			System.out.println("ch1 comporte le caractère c");
    	}
    	
    	//partie2 du TP:
    	String ch2="OuI";
    	String ch2Bis; 
    	//construire ch2Bis avec tous les caractères en minuscules
    	ch2Bis=ch2.toLowerCase();
    	System.out.println("ch2Bis="+ch2Bis);
    	//vérifier si ch2Bis vaut "oui"
    	if(ch2Bis.equals("oui"))
    		System.out.println("ch2Bis vaut oui");
    	else
    		System.out.println("non");
    	
    }
    
    
    
    public static void testAdresse() {
    	Adresse ad1 = new Adresse();
    	ad1.setRue("rue xy");
    	ad1.setCodePostal(75001);
    	ad1.setVille("Paris");
    	System.out.println("ad1"+ad1.toString());
    	
    	if(ad1 instanceof Adresse) {
    		System.out.println("ad1 est de type Adresse");
    	}
    	else {
    		System.out.println("ad1 n'est pas de type Adresse");
    	}
    	
    	Adresse ad2 = new Adresse("16 rue zz" , 76000 , "Rouen");
    	System.out.println("ad2"+ad2.toString());
    	ad2.setCodePostal(-12345); //sera refuser/ignorer par setter
    	
    	Integer codePostalDeAd2 = ad2.getCodePostal();
    	System.out.println("codePostalDeAd2="+codePostalDeAd2);
    	
    }
    
    public static void testPersonne() {
    	Personne p1 = new Personne();
    	System.out.println("p1=" + p1.toString());
    	p1.setPrenom("jean");
    	p1.setNom(null);
    	p1.setNom("");
    	p1.setNom("Bon");
    	p1.setAge(-30); //age négatif refusé/pas pris en compte
    	Integer ageDeP1 = p1.getAge();
    	System.out.println("agedeP1=" + ageDeP1);
    	p1.setAge(30);
    	ageDeP1 = p1.getAge();
    	System.out.println("agedeP1=" + ageDeP1);
    	p1.incrementerAge();//nouvel age = 31
    	//System.out.println("p1=" + p1.toString());
    	System.out.println("p1=" + p1); //..toString() appelé automatiquement sur les objets
    	
    	Personne p2 = new Personne("Aire","axelle");
    	System.out.println("p2=" + p2.toString());
    	
    	//appels possibles mais pas conseillés:
    	p1.setEsperanceDeVie(84.0);
    	System.out.println("espérance de vie (la même pour p1 et p2)="
    	                 + p2.getEsperanceDeVie());
    	
    	//appels conseillés de méthodes "static"
    	//préfixés par un nom de classe:
    	Personne.setEsperanceDeVie(85.0);
    	System.out.println("espérance de vie (commune à toutes les Personnes)="
    	                 + Personne.getEsperanceDeVie());
    	
    	System.out.println("AGE_MAJORITE=" + Personne.AGE_MAJORITE);
    	p1.setAge(17);
    	//p1.setAge(27);
    	if(p1.estMajeur())
    		System.out.println("p1 est majeur");
    	else
    		System.out.println("p1 est mineur");
    	
    	Personne p=null;
    	//new Employe(nom,prenom,fonction,salaire)
    	Employe e1 =new Employe("Therieur","alain","developpeur",2000.0);
    	e1.setAge(25); e1.setPoids(66.66);
    	
    	p1.setPoids(70.3);
    	p=p1;
    	p.afficher();
    	System.out.println("pour p=p1, occupations=" + p.listeOccupations());
    	
    	p=e1;
    	p.afficher();
    	System.out.println("pour p=e1, occupations=" + p.listeOccupations());
    }
    
    public static void test2() {
    }
}
