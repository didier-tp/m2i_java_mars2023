package eu.luminess.indus;

import eu.luminess.indus.dao.DaoPersonne;
import eu.luminess.indus.dao.DaoPersonneJdbc;
import eu.luminess.indus.entity.Personne;

public class MyApp {

    public static void main(String[] args) {
        DaoPersonne daoPersonne = new DaoPersonneJdbc();
        Personne pers = daoPersonne.insert(new Personne("nouveau nom", 45, 77.7));
        pers.setAge(pers.getAge()+1);
        pers.setPoids(pers.getPoids()+1);
        daoPersonne.update(pers);
        //daoPersonne.deleteById(1);
        daoPersonne.findAll().stream().forEach(p-> System.out.println(p));

    }
}
