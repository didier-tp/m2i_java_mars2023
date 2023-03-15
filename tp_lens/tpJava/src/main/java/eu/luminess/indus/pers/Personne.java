package eu.luminess.indus.pers;

import eu.luminess.indus.Transportable;
import eu.luminess.indus.exception.AgeInvalideException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

//classe Java  avec attributs privés , get/set et contructeur par défaut = POJO = JavaBean
public class Personne implements Transportable {

    private static int nbInstances = 0;

    private  String nom;
    private  Integer age; //null possible (et par défaut ici sur attribut , variable d'instance)
    private Double poids;

    private static int ageMajorite = 21; //pourra changer si pas final

    public static int getAgeMajorite() {
        return ageMajorite;
    }

    public static void setAgeMajorite(int ageMajorite) {
        Personne.ageMajorite = ageMajorite;
    }

    public Personne(String nom, Integer age, Double poids) {
        this.nom = nom;
        this.age = age;
        this.poids = poids;
        nbInstances++;
    }

    public static List<Personne> initDataSet(){
        List<Personne> listePers = new ArrayList<>();
        listePers.add(new Personne("Dupond",45,67.8));
        listePers.add(new Personne("Jean",15,57.8));
        listePers.add(new Personne("Alfred",12,87.8));
        listePers.add(new Personne("Didier",35,80.8));
        return listePers;
    }

    public static List<Personne> enchainerOperations(List<Personne> listePers){
           return      listePers.stream()
                        .filter( (p)->p.getAge()>=18 )
                        .sorted( (p1,p2)->Integer.compare(p1.getAge(), p2.getAge()))
                        //.map( (p) -> { p.setNom(p.getNom().toUpperCase()); return p; } )
                        .map( (p) ->  new Personne(p.nom.toUpperCase(), p.getAge() , p.getPoids()) )
                        //.collect(Collectors.toList()); //à partir de java 8
                        .toList(); //avec java 17
    }

    protected void finalize() throws Throwable{
        nbInstances--;
    }

    public Personne() {
        this(null,null,null);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    /*
    //V1 sans exception
    public void setAge(Integer age) {
        //this.age = age; //code généré par assistant
        if(age <0 )
            System.out.println("age négatif invalide"); //ou throw new RuntimeException("...");
        else
            this.age = age;
    }
    */

    public void setAge(Integer age) throws AgeInvalideException{
        if(age <0 )
            //throw new RuntimeException("age négatif invalide");
            //throw new IllegalArgumentException("age négatif invalide");
           throw new AgeInvalideException("age négatif invalide");
        else
            this.age = age;
    }


    @Override
    public String getDesignation() {
        //return this.toString();
        return this.nom;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public void incrementerAge(){
        if(age != null)
           this.age++; //age = age + 1;
                       //age++;
    }


    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", poids=" + poids +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(age, personne.age) && Objects.equals(poids, personne.poids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, age, poids);
    }

    public void afficher(){
        System.out.println(this.toString());
    }
}
