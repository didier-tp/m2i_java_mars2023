package eu.luminess.indus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employe  extends Personne{
    private Double salaire;

    public Employe(String nom, Integer age, Double poids, Double salaire) {
        super(nom, age, poids);
        this.salaire = salaire;
    }

    public Employe(String nom, Integer age, Double poids){
        this(nom,age,poids,null);
    }

    @Override
    public String toString() {
        return "Employe{" +
                "salaire=" + salaire +
                '}' + "héritant de " + super.toString();
    }
}
