package tp.dao;

import java.sql.Connection;
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

	@Override
	public Personne saveNew(Personne p) {
		// en fin d'après ensemble car auto_increment compliqué en java/jdbc
		return null;
	}

	@Override
	public Personne getPersonneById(Integer id) {
		// A faire en TP de groupe , SELECT * FROM personne WHERE id=?
		return null;
	}

	

	@Override
	public void updatePersonne(Personne p) {
		try( Connection cn = ConnexionUtil.etablirConnexion() ) {
			Statement st = cn.createStatement();
			String reqSql="UPDATE personne SET nom=? , age=? , poids=? WHERE id=?";
			
		} catch (SQLException e) {
			e.printStackTrace();
		} //finally automatique avec cn.close() déclenché automatiquement
		
	}

	@Override
	public void deletePersonne(Integer id) {
		// A faire en TP de groupe , DELETE * FROM personne WHERE id=?
		
	}

}
