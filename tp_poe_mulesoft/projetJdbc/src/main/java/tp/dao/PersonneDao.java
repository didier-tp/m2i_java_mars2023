package tp.dao;

import java.util.List;

import tp.data.Personne;

/*
 * DAO = Data Access Object = objet de traitement spécialisé dans l'accès aux données
 * avec méthodes CRUD (Create , Rechercher  , Update , Delete)
 */
public interface PersonneDao {
    Personne saveNew(Personne p); //insert into et retourner la personne sauvegardcer avec id auto_incrémenté
    Personne getPersonneById(Integer id);
    List<Personne> getAllPersonnes();
    void updatePersonne(Personne p);
    void deletePersonne(Integer id); 
}
