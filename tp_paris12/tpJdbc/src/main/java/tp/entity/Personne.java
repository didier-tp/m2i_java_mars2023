package tp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@Getter @Setter @ToString
//@Entity
public class Personne {

    //@Id
    //@GeneratedValue(stategy=IDENIITY)
    private Integer id; //clef primaire auto_inctrementée

    private String nom;
    private Integer age;
    private Double poids;


    public Personne(Integer id, String nom, Integer age, Double poids) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.poids = poids;
    }

    public Personne(String nom, Integer age, Double poids) {
        this(null,nom,age,poids);
    }
    
    

	public Personne() {
		super();
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", age=" + age + ", poids=" + poids + "]";
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
