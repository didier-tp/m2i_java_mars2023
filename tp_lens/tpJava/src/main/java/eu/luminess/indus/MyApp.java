package eu.luminess.indus;

//import javax.swing.*;

import eu.luminess.indus.exception.AgeInvalideException;
import eu.luminess.indus.pers.Adresse;
import eu.luminess.indus.pers.Personne;
import eu.luminess.indus.volant.AvionV2;
import eu.luminess.indus.volant.AvionV3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;


public class MyApp {

    private static Logger logger = LoggerFactory.getLogger(MyApp.class);

        public static void main(String args[]) // fonction principale d'une application Java
        {
            logger.debug("debut du main");
            //javax.swing.JOptionPane.showMessageDialog(null,"Bienvenue MyApp");

            //System.out.println("Hello World\n");
            testPersonne();
            //testCompte();

            //testTypeElementaire();
            //testConversion();
            //testTableau();
            //testString();
            //testAvion();
            //System.out.println("racine carree de 81="+
            //testStream();
        }// Fin du main

    private static void testStream(){
            List<Personne> listeP = Personne.initDataSet();
            listeP.stream().forEach((p)-> System.out.println("### " + p));
            List<Personne> listeP2 = Personne.enchainerOperations((listeP));
            listeP.stream().forEach((p)-> System.out.println(">>> " + p));
            listeP2.stream().forEach((p)-> System.out.println("*** " + p));
    }

    private static void testAvion() {
            //AvionV1 a1 = new AvionV1();
            //AvionV2 a1 = new AvionV2();
            AvionV3 a1 = new AvionV3();
            a1.initialiser();
            a1.addElement(new Personne("Axelle_Aire" , 35, 50.0));
            a1.afficher();
            System.out.println("altitude_max="+a1.getPlafond());
    }

    public static void testCompte(){
            Compte c1 = new Compte();
            c1.setNumero(1L);
           System.out.println(c1.toString());
       }
       public static void testPersonne(){
            System.out.println("age de majorité des personnes = " + Personne.getAgeMajorite());
            Personne.setAgeMajorite(18); //pour la France
            System.out.println("nouvel age de majorité des personnes = " + Personne.getAgeMajorite());


            Personne p1 = null;
            p1 = new Personne();
            p1.setAge(50); p1.setNom("didier"); p1.setPoids(80.0);
            p1.incrementerAge();
            p1.afficher();

            Personne p1Bis = new Personne();
            p1Bis.setAge(51); p1Bis.setNom("didier"); p1Bis.setPoids(80.0);

            if(p1 == p1Bis)
                System.out.println("p1 et p1Bis referencent la même instance");
            else
                System.out.println("p1 et p1Bis ne referencent pas la même instance");

           if(p1.equals(p1Bis)) //OK si .equals() est codé sur la classe Personne
               System.out.println("p1 et p1Bis ont mêmes valeurs");
           else
               System.out.println("p1 et p1Bis n'ont pas les mêmes valeurs");


            Personne p2 = new Personne();
           p2.afficher();
           try {
               p2.setAge(-5); //valeur invalide pas prise en compte (exception)
               p2.afficher();
           }
            catch(Exception ex){
                //System.err.println(ex.getMessage());
                logger.error("echec setAge" , ex);
               // ex.printStackTrace();
            }

           p2.setAge(5); //valeur valide prise en compte
           p2.afficher();

           Personne p3 = new Personne("jeanBon" , 40 , 75.75);
           p3.afficher();
           afficherAdresseDePersonne(p3);
           p3.setAdresseOptionnelle(Optional.of(new Adresse("12 rue X" , "75001" , "Paris")));
           afficherAdresseDePersonne(p3);

       }

     public static void afficherAdresseDePersonne(Personne p){
            /*
            //V1
            if(p.getAdresseOptionnelle().isPresent())
                System.out.println(p.getAdresseOptionnelle().get());
            else System.out.println("sans adresse");
             */
         /*
        // V2 :
         Adresse adresse = p.getAdresseOptionnelle().orElse(null);
         String adresseAsString = (adresse!=null)?adresse.toString() : "sans_adresse";
         System.out.println("adresseAsString="+adresseAsString);
         */

         String adresseAsString = p.getAdresseOptionnelle().map((notNullAdresse)-> notNullAdresse.toString())
                                                           .orElse("sans_adresse");
         System.out.println("adresseAsString="+adresseAsString);
     }

    public static void testTypeElementaire() {
        String sDate = "lundi 16 janvier 2023";
        //char ca = 'a';
        sDate=sDate.toUpperCase();
        System.out.println(sDate);

        int a=5;
        int b=6;
        int c=a+b;
        System.out.println("c="+c);

        double x=2 , y=3.3;
        double z = x+y;
        System.out.println("z="+z);
    }

    public static void testConversion() {
        String sA="5"; //sA est de type String (souvent apres une saisie au clavier dans formulaire HTML)
        int a = Integer.parseInt(sA);
        String sB="6";
        int b = Integer.parseInt(sB);
        System.out.println("sA+sB="+ (sA + sB));
        System.out.println("a+b="+ (a + b));

        double x = Double.parseDouble(sA); // x vaut 5.0 ou 5
        double y ;
        y= a / b ;
        System.out.println("y=a/b="+ y); //0 ou 0.0
        y = x / b ;
        System.out.println("y=x/b="+ y);

        //déclarer les variables z1 et z2 de type double.
        //convertir "2.6" en numérique et stocker a dans z1;
        //convertir la valeur 2 en double et stocker a dans z2
        //afficher le résultat de la multiplication de z1 par z2
        double z1,z2;
        z1=Double.parseDouble("2.6");
        z2 = (double) 2; //ou bien z2 = 2;
        double res= z1*z2;
        System.out.println("res=z1*z2=" + res);
        int resAsInt = (int) res;
        System.out.println("res (en int)=" + resAsInt);
    }

    public static void testClasseEnveloppe() {
        int age1 = 25;
        //age1 = null; //null = valeur impossible sur int
        Integer age2 ;
        age2=25; //equivalent à écrire age2 = new Integer(25);
        age2=26; //équivalent à écrire age2 = new Integer(26);
        age2 = null; //null = valeur possible (et quelquefois par défaut) d'un Integer
        //la valeur null est pratique (et utile) : a provient d'un null SQL
        //ou d'une zone de saisie laissée à vide.
    }

    public static final int TAILLE_TAB = 6;

    public static void testTableau() {
        //tab doit être un tableau de 6 cases de type double
        //double[] tab = { 2.0 , 7 , 9 , 3 , 6 , 1 };

        double[] tab = null;
        tab = new double[TAILLE_TAB];
        tab[0]=2.0;
        tab[1]=7;
        tab[2]=9;
        tab[3]=3;
        tab[4]=6;
        tab[5]=1;

        //calculer et afficher la moyenne
        double somme = 0;
        for(int i=0;i<tab.length;i++) {
            somme += tab[i]; //somme = somme + tab[i];
        }
        double moyenne  = somme / tab.length;
        System.out.println("moyenne=" + moyenne);
    }

    public static void testString() {
        String s1 = "2023-01-17";
        //String sMois = s1.split("-")[1];
        String sMois = s1.substring(5,7);
        System.out.println("sMois="+sMois);

        String s2="CBA";
        int n = s2.length();
        StringBuilder buffer = new StringBuilder();
		/*for(int i=0;i<s2.length();i++){
			buffer.append(s2.charAt(n-i-1));
			}*/
        for(int i=s2.length()-1;i>=0;i--){
            buffer.append(s2.charAt(i));
        }
        String s2Inverse=buffer.toString();

        System.out.println("s2Inverse="+s2Inverse);
    }

}
