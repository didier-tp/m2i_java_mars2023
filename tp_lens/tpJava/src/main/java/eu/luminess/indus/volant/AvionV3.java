package eu.luminess.indus.volant;

import eu.luminess.indus.Bagage;
import eu.luminess.indus.Transportable;
import eu.luminess.indus.pers.Employe;
import eu.luminess.indus.pers.Personne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvionV3 extends ObjetVolant {

    private List<Transportable> listElements = new ArrayList<>();

    public AvionV3(){
    }

    public void initialiser(){
       this.addElement(new Employe("Pilote" , 40 , 30.0 , 4000.0));
       this.addElement(new Employe("Hotesse" , 30 , 60.0 , 2200.0));
       this.addElement(new Personne("Passager du vent" , 40 , 50.0));
       this.addElement(new Bagage("Valise en carton" , 20.0 , 32.0));
    }

    public void trier(){

        /*
        new Comparator<Transportable>() { ...}
        signifie nouvelle instance d'une classe anonyme imbriquée
        qui implémente l'interface Comparator<Transportable>
        avec le code entre { }
         */
        /*
        Collections.sort(this.listElements, new Comparator<Transportable>() {
            @Override
            public int compare(Transportable o1, Transportable o2) {
                if(o1.getDesignation()!=null && o2.getDesignation() != null)
                    return o1.getDesignation().compareTo(o2.getDesignation());
                else return 0;
            }
        });
         */
        /*
        //tri par désignation via lambda:
        Collections.sort(this.listElements, (o1,o2) -> {
            if(o1.getDesignation()!=null && o2.getDesignation() != null)
                return o1.getDesignation().compareTo(o2.getDesignation());
            else return 0;
        } );
        */
        //tri par poids via lambda:
        //Collections.sort(this.listElements, (o1,o2) -> (int)(o1.getPoids() - o2.getPoids()) );
        Collections.sort(this.listElements, (o1,o2) -> (int)( (o1.getPoids()!=null && o2.getPoids()!=null) ? ( o1.getPoids() - o2.getPoids()) : 0) );




    }

    public void addElement(Transportable t){
        listElements.add(t);
    }

    public void afficher(){
        System.out.println("Avion avec nbElements="+this.listElements.size());
        System.out.println("Elements de l'avion:");
        double chargeUtileTotale = 0.0;
        this.trier();
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
