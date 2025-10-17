package tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import tp.Produit;

public class ProduitDaoJdbc implements ProduitDAO {
	
	private Connection cn;
	
	public Connection initConnection(){
		 try {
			ResourceBundle ressources = ResourceBundle.getBundle("db") ; // db.properties
			 String driver = ressources.getString("driver"); 
			 String chUrl = ressources.getString("url");
			 String username = ressources.getString("username");
			 String password = ressources.getString("password");
			 Class.forName(driver);   
			 this.cn = DriverManager.getConnection(chUrl,username,password) ;
		 } catch (ClassNotFoundException e) {
			e.printStackTrace();
		 } catch (SQLException e) {
			e.printStackTrace();
		 } 
		 System.out.println("connexion etablie:" + this.cn);
		 return this.cn;
	}

	@Override
	public Produit createProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit findById(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
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
