package tp.dao;

import java.util.List;

import tp.entity.Personne;

/*
 * DAO = Data Access Object
 * avec methodes CRUD (Create : INSERT INTO
 *                    Rechercher : SELECT
 *                    Update,
 *                    Delete )
 */

public interface DaoPersonne {
    public Personne findById(int id);

    public List<Personne> findAll();

    public Personne insert(Personne p); //en retour Personne avec id auto incrémenté

    public Personne update(Personne p);

    public void deleteById(int id);  //throws RuntimeException
}
