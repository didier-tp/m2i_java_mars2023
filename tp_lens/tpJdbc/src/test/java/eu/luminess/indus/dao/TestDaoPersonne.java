package eu.luminess.indus.dao;

import eu.luminess.indus.entity.Personne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDaoPersonne {

    private DaoPersonne daoPersonne; //à tester

    @BeforeEach
    public void init(){
        daoPersonne = new DaoPersonneJdbc();
    }

    @Test
    public void testCRUD(){
        //insertion
        Personne pers = daoPersonne.insert(new Personne("nouveau nom", 45, 77.7));
        Integer pk = pers.getId();
        //verif insertion
        Assertions.assertTrue( pk != null);

        //update , verif update , ...

        //delete
        daoPersonne.deleteById(pk);
        //verif delete
        //...
    }

}
