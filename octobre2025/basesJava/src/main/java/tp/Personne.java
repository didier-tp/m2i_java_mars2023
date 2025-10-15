package tp;

import java.util.Objects;

public class Personne /* extends Object */ implements Transportable{
	
	public static final int AGE_MAJORITE=18;
	
	private static double esperanceVie=78.2; //+get/set static
	
	private String nom;
	private Integer age;
	private Double poids;
	
	
	public static double getEsperanceVie() {
		return esperanceVie;
	}

	public static void setEsperanceVie(double esperanceVie) {
		Personne.esperanceVie = esperanceVie;
	}

	public boolean estMajeur() {
		if(this.getAge()==null) return false;
		else {
			return (this.getAge()>=Personne.AGE_MAJORITE);
		}
	}

	public Personne(String nom, Integer age, Double poids) {
		super();
		this.nom = nom;
		this.age = age;
		this.poids = poids;
	}
	
    //constructeur par défaut (avec zéro paramètre)
	public Personne() {
		super();
	}


	public void afficher(){
		//System.out.println("Personne avec nom=" + this.nom +  " et age=" + this.age + " et poids=" + this.poids);
		System.out.println(this.toString());
	}

    @Override
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age + ", poids=" + poids + "]";
	}


	//get..., set...() générés par assistants de eclipse ou intelliJ:
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		//this.age = age;// code généré par assistant
		if(age>=0)
			this.age = age;
		else {
			System.out.println("age négatif invalide");
			//throw new RuntimeException("age négatif invalide")
		}
	}

	public Double getPoids() {
		return poids;
	}

	public void setPoids(Double poids) {
		this.poids = poids;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, nom, poids);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return Objects.equals(age, other.age) && Objects.equals(nom, other.nom) && Objects.equals(poids, other.poids);
	}

	@Override
	public String getDesignation() {
		return this.toString();
	}

	
	
	

}
