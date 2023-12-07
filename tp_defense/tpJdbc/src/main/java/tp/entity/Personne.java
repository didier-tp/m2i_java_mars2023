package tp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter @Setter @ToString
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
}
