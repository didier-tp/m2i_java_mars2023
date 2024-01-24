package animaux;

public class Chien extends Animal {
   private String role; //ex: animal_de_compagnie , gardien_de_troupeau, guide_aveugle
   
   //+constructeur par défaut sans parametre
   public Chien() {
		super();
	}
   
  
   public Chien(String couleur,Double poids,String role) {
	super(couleur,poids);//on repasse les valeurs des paramètres couleur et poids
	                    //au constructeur hérité (ici de la classe Animal)
	this.role = role;
   }



public void aboyer() {
	   System.out.println("whouf whouf");
   }
   
   public void parler() {
	   aboyer();
   }
   
   
   //on redéfini une méthode héritée (avec un meilleur code spécifique au chat) 
   @Override
   public void afficher() {
	   super.afficher(); //super.afficher() réappelle la méthode afficher()
	                     //de la classe dont on hérite (ici Animal)
	   System.out.println("   Animal de type Chien avec role=" 
	                   + this.role);
   }


public String getRole() {
	return role;
}


public void setRole(String role) {
	this.role = role;
}
 
   
   
   
  
}
