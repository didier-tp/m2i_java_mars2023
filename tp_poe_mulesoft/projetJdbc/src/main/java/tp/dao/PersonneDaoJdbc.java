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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne getPersonneById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void updatePersonne(Personne p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePersonne(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
