package eu.luminess.indus;

import java.util.Objects;
//classe Java  avec attributs privés , get/set et contructeur par défaut = POJO = JavaBean
public class Personne implements Transportable{

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

    public void setAge(Integer age) {
        //this.age = age; //code généré par assistant
        if(age <0 )
            System.out.println("age négatif invalide"); //ou throw new RuntimeException("...");
        else
            this.age = age;
    }

    @Override
    public String getDesignation() {
        return this.toString();
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
