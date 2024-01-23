package tp2;

public class Chat extends Animal {
   private Integer nbHeureSommeil;
   
   //+constructeur par défaut sans parametre
   public Chat() {
		super();
	}
   
  
   public Chat(String couleur,Double poids,Integer nbHeureSommeil) {
	super(couleur,poids);//on repasse les valeurs des paramètres couleur et poids
	                    //au constructeur hérité (ici de la classe Animal)
	this.nbHeureSommeil = nbHeureSommeil;
   }



private void miauler() {
	   System.out.println("miaou miaou");
   }
   
   public void parler() {
	   miauler();
   }
   
   
   //on redéfini une méthode héritée (avec un meilleur code spécifique au chat) 
   @Override
   public void afficher() {
	   super.afficher(); //super.afficher() réappelle la méthode afficher()
	                     //de la classe dont on hérite (ici Animal)
	   System.out.println("   Animal de type Chat avec nbHeureSommeil=" 
	                   + this.nbHeureSommeil);
   }
 
   
   
   
   //+get/set
	public Integer getNbHeureSommeil() {
		return nbHeureSommeil;
	}
	
	
    /*
	@Override
	public String toString() {
		return "Chat " + super.toString() 
		+ " nbHeureSommeil=" + this.nbHeureSommeil;
	}
    */

	public void setNbHeureSommeil(Integer nbHeureSommeil) {
		this.nbHeureSommeil = nbHeureSommeil;
	}
}
