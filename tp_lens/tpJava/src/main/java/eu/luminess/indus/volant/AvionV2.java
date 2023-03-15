package eu.luminess.indus.volant;

import eu.luminess.indus.Bagage;
import eu.luminess.indus.Transportable;
import eu.luminess.indus.pers.Employe;
import eu.luminess.indus.pers.Personne;
import eu.luminess.indus.volant.ObjetVolant;

public class AvionV2 extends ObjetVolant {
    private int nbElements;
    private Transportable[] tabElements;

    public static final int TAILLE_MAX = 150;

    public AvionV2(){
        this.tabElements = new Transportable[TAILLE_MAX];
        this.nbElements=0;
    }

    public void initialiser(){
       this.addElement(new Employe("Pilote" , 40 , 50.0 , 4000.0));
       this.addElement(new Employe("Hotesse" , 30 , 50.0 , 2200.0));
       this.addElement(new Personne("passager du vent" , 50 , 50.0));
       this.addElement(new Bagage("valise en carton" , 20.0 , 32.0));
    }

    public void addElement(Transportable t){
        if(this.nbElements==TAILLE_MAX){
            System.out.println("tableau plein , plus de place !!!");
        }
        else {
            this.tabElements[this.nbElements] = t;
            this.nbElements++;
        }
    }



    public void afficher(){
        System.out.println("Avion avec nbElements="+this.nbElements);
        System.out.println("Elements de l'avion:");
        double chargeUtileTotale = 0.0;
       for(int i=0;i<this.nbElements;i++){
           System.out.println("\t"+this.tabElements[i]);
           //System.out.println("\t"+this.tabElements[i].toString());
          chargeUtileTotale += this.tabElements[i].getPoids();
          if(this.tabElements[i] instanceof Employe) {
              System.out.println("salaire d'un employe transportable="  + ((Employe) this.tabElements[i]).getSalaire() );
          }
       }
        System.out.println("chargeUtileTotale (personne et bagages) = " + chargeUtileTotale);
    }

    @Override
    public int getPlafond() {
        return 10000; //10000 metres
    }
}
