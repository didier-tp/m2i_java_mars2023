package eu.luminess.indus;

import eu.luminess.indus.dao.DaoPersonne;
import eu.luminess.indus.dao.DaoPersonneJdbc;

public class MyApp {

    public static void main(String[] args) {
        DaoPersonne daoPersonne = new DaoPersonneJdbc();
        daoPersonne.findAll().stream().forEach(p-> System.out.println(p));
        //...
    }
}
