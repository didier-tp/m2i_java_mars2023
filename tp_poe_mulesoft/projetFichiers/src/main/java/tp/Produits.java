package tp;
/* juste pour les besoins XML et JAXB */


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "produits")
@XmlAccessorType(XmlAccessType.FIELD)
public class Produits {
	
	@XmlElement(name="produit")
    private List<Produit> listeProduits =null;

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	
}
