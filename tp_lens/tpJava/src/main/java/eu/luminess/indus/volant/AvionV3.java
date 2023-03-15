package eu.luminess.indus.volant;

import eu.luminess.indus.Bagage;
import eu.luminess.indus.Transportable;
import eu.luminess.indus.pers.Employe;
import eu.luminess.indus.pers.Personne;

import java.util.ArrayList;
import java.util.List;

public class AvionV3 extends ObjetVolant {

    private List<Transportable> listElements = new ArrayList<>();

    public AvionV3(){
    }

    public void initialiser(){
       this.addElement(new Employe("Pilote" , 40 , 50.0 , 4000.0));
       this.addElement(new Employe("Hotesse" , 30 , 50.0 , 2200.0));
       this.addElement(new Personne("passager du vent" , 50 , 50.0));
       this.addElement(new Bagage("valise en carton" , 20.0 , 32.0));
    }

    public void addElement(Transportable t){
        listElements.add(t);
    }

    public void afficher(){
        System.out.println("Avion avec nbElements="+this.listElements.size());
        System.out.println("Elements de l'avion:");
        double chargeUtileTotale = 0.0;
       for(Transportable element : this.listElements){
           System.out.println("\t"+element);
          chargeUtileTotale += element.getPoids();
          if(element instanceof Employe) {
              System.out.println("salaire d'un employe transportable="  + ((Employe) element).getSalaire() );
          }
       }
        System.out.println("chargeUtileTotale (personne et bagages) = " + chargeUtileTotale);
    }

    @Override
    public int getPlafond() {
        return 10000; //10000 metres
    }
}
