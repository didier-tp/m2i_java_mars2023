package eu.luminess.indus.volant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class  ObjetVolant {
    private String couleur="black";

    public abstract int getPlafond(); //altitude maximum
}
