package tp.data;

public class Personne {
	private Integer id; //clef primaire qui doit être un objet (null ou pas)
	private String nom;
	private Integer age;
	private Double poids;
	
	
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", age=" + age + ", poids=" + poids + "]";
	}


	public Personne() {
		super();
	}


	public Personne(Integer id, String nom, Integer age, Double poids) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
		this.poids = poids;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
		this.age = age;
	}
	public Double getPoids() {
		return poids;
	}
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	
	
}
