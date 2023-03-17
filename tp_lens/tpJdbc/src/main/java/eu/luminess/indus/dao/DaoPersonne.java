package eu.luminess.indus.dao;

import eu.luminess.indus.entity.Personne;

import java.util.List;

public interface DaoPersonne {
    public Personne findById(int id);

    public List<Personne> findAll();

    public Personne insert(Personne p); //en retour Personne avec id auto incrémenté

    public Personne update(Personne p);

    public void deleteById(int id);  //throws RuntimeException
}
