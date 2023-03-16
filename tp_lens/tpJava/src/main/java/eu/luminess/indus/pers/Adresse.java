package eu.luminess.indus.pers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Adresse {
    private String numEtRue;
    private String codePostal;
    private String ville;

    public Adresse(String numEtRue, String codePostal, String ville) {
        this.numEtRue = numEtRue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}

/*

à l'intérieur de la classe Personne:
private Optional<Adresse> adresseOptionnelle;
 */
