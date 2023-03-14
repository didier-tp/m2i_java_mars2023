package eu.luminess.indus;

public class AvionV1 {
    private int nbElements;
    private Personne[] tabElements;

    public AvionV1(){
        this.tabElements = new Personne[50];
        this.nbElements=0;
    }

    public void initialiser(){
       this.addElement(new Personne("Pilote" , 40 , 81.34));
       this.addElement(new Personne("Hotesse" , 30 , 61.34));
       this.addElement(new Personne("jean" , 50 , 61.34));
    }

    public void addElement(Personne p){
        if(this.nbElements==50){
            System.out.println("tableau plein , plus de place !!!");
        }
        else {
            this.tabElements[this.nbElements] = p;
            this.nbElements++;
        }
    }

    public void afficher(){
        System.out.println("Avion avec nbElements="+this.nbElements);
        System.out.println("Elements de l'avion:");
       for(int i=0;i<this.nbElements;i++){
           System.out.println("\t"+this.tabElements[i]);
           //System.out.println("\t"+this.tabElements[i].toString());
       }
    }

}
