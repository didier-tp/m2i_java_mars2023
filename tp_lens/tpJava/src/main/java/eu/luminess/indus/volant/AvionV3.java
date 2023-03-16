package eu.luminess.indus.volant;

import eu.luminess.indus.Bagage;
import eu.luminess.indus.Transportable;
import eu.luminess.indus.pers.Employe;
import eu.luminess.indus.pers.Personne;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AvionV3 extends ObjetVolant {

    private List<Transportable> listElements = new ArrayList<>();

    public AvionV3(){
    }

    public void initialiser(){
       this.addElement(new Employe("Pilote" , 40 , 30.0 , 4000.0));
       this.addElement(new Employe("Hotesse" , 30 , 60.0 , 2200.0));
       this.addElement(new Personne("Passager du vent" , 40 , 50.0));
       this.addElement(new Bagage("Valise en carton" , 20.0 , 32.0));
       this.addElement(new Bagage("Sac null" , null , 32.0));
       this.addElement(new Bagage(null , null , null));
    }

    public void ecrireFichierCsv(String fileName){

        try (PrintWriter ps = new PrintWriter(new File(fileName)) ){
            ps.println("nom;age;poids");
            for(Transportable t : this.listElements){
                if(t instanceof Personne){
                    Personne p = (Personne) t;
                    ps.printf("%s;%d;%s\n", p.getNom() , p.getAge() , String.valueOf(p.getPoids()));
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        //finaly et close automatique car try with resource

    }

    public void lireDepuisFichierCsv(String fileName){

        try (Scanner scanner = new Scanner(Path.of(fileName)) ){
            scanner.nextLine(); //lecture premiere ligne entete
            while(scanner.hasNext()) {
                String ligne = scanner.nextLine();
                //System.out.println(ligne) ;
                String[] tab = ligne.split(";");
                Personne p = new Personne(tab[0],
                        Integer.parseInt(tab[1]),
                        Double.parseDouble(tab[2]));
                this.listElements.add(p);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        //finaly et close automatique car try with resource

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

        //tri par désignation via lambda:
        /*
        Collections.sort(this.listElements, (o1,o2) -> {
            if(o1.getDesignation()!=null && o2.getDesignation() != null)
                return o1.getDesignation().compareTo(o2.getDesignation());
            else return 0;
        } );
       */

        //tri par poids via lambda:
        //Collections.sort(this.listElements, (o1,o2) -> (int)(o1.getPoids() - o2.getPoids()) );
        //Collections.sort(this.listElements, (o1,o2) -> (int)( (o1.getPoids()!=null && o2.getPoids()!=null) ? ( o1.getPoids() - o2.getPoids()) : 0) );
        Collections.sort(this.listElements, (o1,o2) -> nullSafeDoubleComparator(o1.getPoids() , o2.getPoids()) );




    }

    public static int nullSafeStringComparator(final String one, final String two) {
        if (one == null ^ two == null) {
            return (one == null) ? -1 : 1;
        }

        if (one == null && two == null) {
            return 0;
        }

        return one.compareToIgnoreCase(two);
    }

    public static int nullSafeDoubleComparator(final Double one, final Double two) {
        if (one == null ^ two == null) {
            return (one == null) ? -1 : 1;
        }

        if (one == null && two == null) {
            return 0;
        }

        return (int)(one - two);
    }

    public void addElement(Transportable t){
        listElements.add(t);
    }

    public void afficherV1(){
        System.out.println("Avion avec nbElements="+this.listElements.size());
        System.out.println("Elements de l'avion:");
        double chargeUtileTotale = 0.0;
        this.trier();
       for(Transportable element : this.listElements){
           System.out.println("\t"+element);
          chargeUtileTotale += (element.getPoids()!=null)?element.getPoids():0;
          if(element instanceof Employe) {
              System.out.println("salaire d'un employe transportable="  + ((Employe) element).getSalaire() );
          }
       }
        System.out.println("chargeUtileTotale (personne et bagages) = " + chargeUtileTotale);
    }

    public void afficher(){
        System.out.println("Avion avec nbElements="+this.listElements.size());

        this.listElements.stream()
                .filter((t)-> t.getDesignation()!=null && t.getPoids()!=null)
                .sorted( (t1,t2)-> t1.getDesignation().compareToIgnoreCase(t2.getDesignation()))
                .forEach((t)-> System.out.println( "\t" + t));

    }

    @Override
    public int getPlafond() {
        return 10000; //10000 metres
    }
}
