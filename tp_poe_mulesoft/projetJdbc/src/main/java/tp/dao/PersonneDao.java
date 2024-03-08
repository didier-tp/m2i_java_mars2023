package tp.dao;
/*
 * DAO = Data Access Object = objet de traitement spécialisé dans l'accès aux données
 * avec méthodes CRUD (Create , Rechercher  , Update , Delete)
 */
public interface PersonneDao {
    Personne saveNew(Personne p); //insert into et retourner la personne sauvegardcer avec id auto_incrémenté
}
