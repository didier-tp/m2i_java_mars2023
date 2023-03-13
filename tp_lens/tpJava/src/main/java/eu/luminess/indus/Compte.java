package eu.luminess.indus;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Compte {
    private Long numero;
    private String label;
    private Double solde;
}
