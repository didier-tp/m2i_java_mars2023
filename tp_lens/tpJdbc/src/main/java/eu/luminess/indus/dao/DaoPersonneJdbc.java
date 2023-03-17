package eu.luminess.indus.dao;

import eu.luminess.indus.entity.Personne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DaoPersonneJdbc implements DaoPersonne{

    private Connection getConnection(){
        Connection cn = null;
        try {
            ResourceBundle ressources = ResourceBundle.getBundle("db") ; // db.properties
            String driver = ressources.getString("driver");
            String chUrl = ressources.getString("url");
            String username = ressources.getString("username");
            String password = ressources.getString("password");
            Class.forName(driver); //charger en mémoire classe principale du driver/pilote JDBC
            cn = DriverManager.getConnection(chUrl,username,password) ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //driver indisponible (oubli dans pom.xml)
        } catch (SQLException e) {
            e.printStackTrace(); //erreur de connexion (serveur pas démarré , pb username/password)
        }
        return cn;
    }

    @Override
    public List<Personne> findAll() {
        List<Personne> personnes = new ArrayList<>();
        try(Connection cn = this.getConnection()) {

        }catch(SQLException ex){

        }
        //Automatic close via try(withResource)
        //NB: dans projet plus élaborer cn.close() libère la connexion dans un pool de connexions
        return personnes;
    }

    @Override
    public Personne findById(int id) {
        return null;
    }

    @Override
    public Personne insert(Personne p) {
        return null;
    }

    @Override
    public Personne update(Personne p) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
