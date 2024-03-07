package tp;
/* juste pour les besoins XML et JAXB */


import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "produits")
public class Produits {
	
	@XmlElement(name="produit")
    private List<Produit> listeProduits =null;

	public List<Produit> getProduits() {
		return listeProduits;
	}
	
	public void setProduits(List<Produit> produits) {
		this.listeProduits = produits;
	}
}
