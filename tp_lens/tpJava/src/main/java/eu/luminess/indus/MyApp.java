package eu.luminess.indus;

public class MyApp {

        public static void main(String args[]) // fonction principale d'une application Java
        {
            System.out.println("Hello World\n");
            testPersonne();
            testCompte();
        }// Fin du main

       public static void testCompte(){
            Compte c1 = new Compte();
            c1.setNumero(1L);
           System.out.println(c1.toString());
       }
       public static void testPersonne(){
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
            p2.setAge(-5); //valeur invalide pas prise en compte
            p2.afficher();
            p2.setAge(5); //valeur valide prise en compte
            p2.afficher();

           Personne p3 = new Personne("jeanBon" , 40 , 75.75);
           p3.afficher();

       }

}
