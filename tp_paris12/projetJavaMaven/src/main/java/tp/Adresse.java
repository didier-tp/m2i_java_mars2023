package tp;

public class Adresse {
	private String rue;
	private Integer codePostal;
	private String Ville;
	
	
	public Adresse() {
		super();
	}


	public Adresse(String rue, Integer codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		Ville = ville;
	}
	
	
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", Ville=" + Ville + "]";
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	
	

	public void setCodePostal(Integer codePostal) {
		if(codePostal<0)
			 System.out.println("codePostal negatif invalide");
		else
     		this.codePostal = codePostal;
	}
	
	
	
}

