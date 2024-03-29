package tp;
/* juste pour les besoins XML et JAXB */


import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "produits")   //nom de la balise (racine, de premier niveau)
@XmlAccessorType(XmlAccessType.FIELD) //pour tenir compte de @XmlElement sur le "field" en private
public class Produits {
	
	@XmlElement(name="produit") //nom de la sous-balise pour chaque element de la liste
    private List<Produit> listeProduits =null;

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	
}
