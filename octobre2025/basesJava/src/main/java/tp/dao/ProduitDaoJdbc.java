package tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import tp.Produit;

public class ProduitDaoJdbc implements ProduitDAO {

	private Connection cn;

	public Connection initConnection() {
		try {
			ResourceBundle ressources = ResourceBundle.getBundle("db"); // db.properties
			String driver = ressources.getString("driver");
			String chUrl = ressources.getString("url");
			String username = ressources.getString("username");
			String password = ressources.getString("password");
			Class.forName(driver);
			this.cn = DriverManager.getConnection(chUrl, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("connexion etablie:" + this.cn);
		return this.cn;
	}

	Integer recupValeurAutoIncrPk(PreparedStatement pst) {
		Integer pk = null;
		try {
			ResultSet rsKeys = pst.getGeneratedKeys();
			if (rsKeys.next()) {
				pk = rsKeys.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk;
	}

	@Override
	public Produit createProduit(Produit p) {
		try (Connection cnx = this.initConnection()) {
			PreparedStatement pst = null;
			String reqSql = "insert into produit(label,categorie,prix,poids) values(?,?,?,?)";
			pst = cn.prepareStatement(reqSql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getLabel());
			pst.setString(2, p.getCategorie());
			pst.setDouble(3, p.getPrix());
			pst.setDouble(4, p.getPoids());
			pst.executeUpdate(); // avec auto_increment mysql sur colonne numCpt
			Integer pk = recupValeurAutoIncrPk(pst);
			p.setNumero(pk);
			pst.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} // fermeture automatique de cnx (cnx.close())
		return p;
	}

	@Override
	public Produit findById(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> listeProd = new ArrayList<>();

		try (Connection cnx = this.initConnection()) {
			Statement statement = cnx.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM produit");
			while (rs.next()) {
				// rs.getString("nomColonne") ou bien rs.getDouble("colonneNumerique")
				listeProd.add(new Produit(rs.getInt("numero"), rs.getString("label"), rs.getString("categorie"),
						rs.getDouble("prix"), rs.getDouble("poids")));
			}
			rs.close();
			statement.close(); // ou bien try() imbriqués
		} catch (SQLException ex) {
			ex.printStackTrace();
		} // fermeture automatique de cnx (cnx.close())

		return listeProd;
	}

	@Override
	public void updateProduit(Produit p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int numero) {
		// TODO Auto-generated method stub

	}

}
