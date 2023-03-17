package eu.luminess.indus;

import eu.luminess.indus.dao.DaoPersonne;
import eu.luminess.indus.dao.DaoPersonneJdbc;
import eu.luminess.indus.entity.Personne;

public class MyApp {

    public static void main(String[] args) {
        DaoPersonne daoPersonne = new DaoPersonneJdbc();
        daoPersonne.insert(new Personne("nouveau nom", 45, 77.7));
        daoPersonne.findAll().stream().forEach(p-> System.out.println(p));
        //...
    }
}
