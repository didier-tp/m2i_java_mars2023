package tp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tp.ConnexionUtil;
import tp.data.Personne;

/*
 * PersonneDaoJdbc va coder les méthodes de l'interface PersonneDao avec l'api JDBC (beaucoup de lignes de code)
 * PersonneDaoJpa que l'on pourrait coder avec JPA/Hibernate (moins de lignes de code)
 */

public class PersonneDaoJdbc implements PersonneDao {
	
	@Override
	public List<Personne> getAllPersonnes() {
		List<Personne> personnes = new ArrayList<Personne>();
		try( Connection cn = ConnexionUtil.etablirConnexion() ) {
			Statement st = cn.createStatement();
			String reqSql="SELECT * FROM personne";
			ResultSet rs = st.executeQuery(reqSql);
			while(rs.next()) {
				Personne p = new Personne(rs.getInt("id"),rs.getString("nom"),rs.getInt("age"),rs.getDouble("poids"));
				personnes.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} //finally automatique avec cn.close() déclenché automatiquement
		return personnes;
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
	public Personne saveNew(Personne p) {
		//en entrée , la personne à un id null (pas encore connu)
		try( Connection cn = ConnexionUtil.etablirConnexion() ) {
			String reqSql="INSERT INTO personne(nom,age,poids) VALUES(?,?,?)";
			PreparedStatement pst = cn.prepareStatement(reqSql,Statement.RETURN_GENERATED_KEYS);
			//pst.setTypeColonne(numero_du_ieme_? , valeur_de_remplacement)
			pst.setString(1, p.getNom());
			pst.setInt(2, p.getAge());
			pst.setDouble(3, p.getPoids());
			pst.executeUpdate(); //declencher l'ordre SQL dans la base de données	
			Integer idAutoIncremente = recupValeurAutoIncrPk(pst);
			p.setId(idAutoIncremente);
		} catch (SQLException e) {
			e.printStackTrace();
		} //finally automatique avec cn.close() déclenché automatiquement
		return p; //on retourne une personne avec l'id auto incrémenté
	}

	@Override
	public Personne getPersonneById(Integer id) {
		Personne personne = null;
		try( Connection cn = ConnexionUtil.etablirConnexion() ) {
			String reqSql="SELECT * FROM personne WHERE id=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
            pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				personne = new Personne(rs.getInt("id"),rs.getString("nom"),rs.getInt("age"),rs.getDouble("poids"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} //finally automatique avec cn.close() déclenché automatiquement
		return personne;
	}

	

	@Override
	public void updatePersonne(Personne p) {
		try( Connection cn = ConnexionUtil.etablirConnexion() ) {
			String reqSql="UPDATE personne SET nom=? , age=? , poids=? WHERE id=?";
			//String reqSql="UPDATE personne SET  poids=? WHERE id=?"; possible si besoin de changer le poids seulement
			PreparedStatement pst = cn.prepareStatement(reqSql);
			//pst.setTypeColonne(numero_du_ieme_? , valeur_de_remplacement)
			pst.setString(1, p.getNom());
			pst.setInt(2, p.getAge());
			pst.setDouble(3, p.getPoids());
			pst.setInt(4, p.getId());
			pst.executeUpdate(); //declencher l'ordre SQL dans la base de données
			                     //pour tout sauf le select 
		} catch (SQLException e) {
			e.printStackTrace();
		} //finally automatique avec cn.close() déclenché automatiquement
		
	}

	@Override
	public void deletePersonne(Integer id) {
		try( Connection cn = ConnexionUtil.etablirConnexion() ) {
			String reqSql="DELETE FROM personne WHERE id=?";
			PreparedStatement pst = cn.prepareStatement(reqSql);
			//pst.setTypeColonne(numero_du_ieme_? , valeur_de_remplacement)
			pst.setInt(1, id);
			pst.executeUpdate(); //declencher l'ordre SQL dans la base de données
		} catch (SQLException e) {
			e.printStackTrace();
		} //finally automatique avec cn.close() déclenché automatiquement
	}

}
