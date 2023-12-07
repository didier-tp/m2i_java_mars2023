package tp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import tp.entity.Personne;

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
        try(Connection cn = this.getConnection();
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM personne")) {
            while (rs.next()){
                personnes.add(new Personne(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getInt("age"),
                        rs.getDouble("poids")
                ));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Automatic close via try(withResource)
        //NB: dans projet plus élaborer cn.close() libère la connexion dans un pool de connexions
        return personnes;
    }

    /*
    public List<Personne> findAllV1() {
        List<Personne> personnes = new ArrayList<>();
        try(Connection cn = this.getConnection()) {
            Statement statement = cn.createStatement();
            String reqSql = "SELECT * FROM personne";
            ResultSet rs = statement.executeQuery(reqSql);
            while (rs.next()){
                personnes.add(new Personne(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getInt("age"),
                        rs.getDouble("poids")
                ));
            }
            rs.close(); statement.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Automatic close via try(withResource)
        //NB: dans projet plus élaborer cn.close() libère la connexion dans un pool de connexions
        return personnes;
    }
    */

    @Override
    public Personne findById(int id) {
        return null;
    }

    Integer recupValeurAutoIncrPk(PreparedStatement pst){
        Integer pk=null;
        try {
            ResultSet rsKeys = pst.getGeneratedKeys();
            if(rsKeys.next()){ pk= rsKeys.getInt(1); }
        } catch (SQLException e) { e.printStackTrace(); }
        return pk;
    }

    @Override
    public Personne insert(Personne p) {
        try(Connection cn = this.getConnection();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO personne(nom,age,poids) VALUES(?,?,?)",
                                                          Statement.RETURN_GENERATED_KEYS ))
        {
            pst.setString(1, p.getNom());
            pst.setInt(2, p.getAge());
            pst.setDouble(3, p.getPoids());
            pst.executeUpdate(); //avec auto_increment mysql sur colonne id
            Integer pk = recupValeurAutoIncrPk(pst);
            p.setId(pk);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Automatic close via try(withResource)
        //NB: dans projet plus élaborer cn.close() libère la connexion dans un pool de connexions
        return p;
    }

    @Override
    public Personne update(Personne p) {
        try(Connection cn = this.getConnection();
            PreparedStatement pst = cn.prepareStatement("UPDATE personne SET nom=?,age=?,poids=? WHERE id=?"))
        {
            pst.setString(1, p.getNom());
            pst.setInt(2, p.getAge());
            pst.setDouble(3, p.getPoids());
            pst.setInt(4,p.getId());
            pst.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //Automatic close via try(withResource)
        //NB: dans projet plus élaborer cn.close() libère la connexion dans un pool de connexions
        return p;
    }

    @Override
    public void deleteById(int id) {
        try(Connection cn = this.getConnection();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM personne  WHERE id=?"))
        {
            pst.setInt(1,id);
            pst.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
