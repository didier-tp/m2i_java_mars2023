package eu.luminess.indus;

public class RacineCarreApp {

    //lancement prevu en mode texte:  java eu.luminess.indus.RacineCarreApp 81
    //lancement prévu depuis intelliJ : click droit Run , puis click droit "Modidy Run configuration"
    //on met 81 dans partie "Program argument" , puis click droit run

    public static void main(String[] args) {
        try {
            String sX= args[0]; //souleve ArrayIndexOutOfBoundsException
            double x = Double.parseDouble(sX); //souleve NumberFormatException
            double res = Math.sqrt(x);
            System.out.println("racine carree de " + x + "="+res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("il manque un argument , usage : RacineCarreApp 81");
        }
        catch (NumberFormatException e) {
            System.err.println("l'argument doit être numérique");
        }
        catch (Exception e) {
            System.err.println("autre erreur");
            e.printStackTrace();
        }
    }
}
