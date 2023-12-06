package tp;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/*
 * Un cercle comporte un centre  (xc,yc) en int ou double
 *                  et un rayon en int ou double
 *                  
 *          methodes
 *             .perimetre() retournant une valeur de type double
 *             .surface()
 *             
 *          perimetre=2*Math.PI*rayon
 *          surface/aire=Math.PI*rayon*rayon
 */

@Getter @Setter
public class Cercle extends Surface2D /* héritage */{
	private double xc,yc;
	private double rayon;
	
	

	@Override
	public void afficher() {
		System.out.println(this.toString());
		/*
		super.afficher();
		System.out.println("....");
		*/
	}
	
	public Cercle(double xc, double yc, double rayon,String couleur) {
		super(couleur);//on repasse le parametre couleur au constructeur
		               //de la classe dont on hérite (ici Surface2D)
		this.xc = xc;
		this.yc = yc;
		this.rayon = rayon;
	}
	
	public Cercle(double xc, double yc, double rayon) {
		super(); //ça déclenche le constructeur de Surface2D
		         //par défaut (avec 0 parametre) qui met la couleur à "black"
		this.xc = xc;
		this.yc = yc;
		this.rayon = rayon;
	}
	
	public Cercle() {
		this(0,0,0);
	}


	
	//d = c1.distance(c2);
	public double distance(Cercle autreCercle) {
		return Math.sqrt(Math.pow(autreCercle.xc - this.xc , 2)
				         +Math.pow(autreCercle.yc - this.yc , 2) );
	}

	
	


	

	@Override
	public String toString() {
		//return "Cercle [xc=" + xc + ", yc=" + yc + ", rayon=" + rayon + "]";
		return "Cercle [xc=" + xc + ", yc=" + yc + ", rayon=" + rayon + "]" 
				 + " heritant de " + super.toString();
	}

	public double perimetre() {
		return this.rayon * 2 * Math.PI;
	}
	
	public double surface() {
		return this.rayon * this.rayon * Math.PI;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rayon, xc, yc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cercle other = (Cercle) obj;
		return Double.doubleToLongBits(rayon) == Double.doubleToLongBits(other.rayon)
				&& Double.doubleToLongBits(xc) == Double.doubleToLongBits(other.xc)
				&& Double.doubleToLongBits(yc) == Double.doubleToLongBits(other.yc);
	}




	public void setRayon(double rayon) {
		if(rayon >= 0)
		   this.rayon = rayon;
		else
			System.err.println("rayon négatif interdit");
		    //throw new RuntimeException("rayon négatif interdit")
	}


	
	
}
