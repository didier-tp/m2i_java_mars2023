package eu.luminess.indus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter @ToString
public class Bagage  implements Transportable{

    private String label;
    private Double poids;
    private Double volume;

    public String getDesignation(){
        return this.label;
    }

    public Bagage(String label, Double poids, Double volume) {
        this.label = label;
        this.poids = poids;
        this.volume = volume;
    }
}
