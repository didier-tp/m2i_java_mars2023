package tp;

import java.util.Objects;

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

public class Cercle {
	public double xc,yc;
	public double rayon;
	
	
	@Override
	public String toString() {
		return "Cercle [xc=" + xc + ", yc=" + yc + ", rayon=" + rayon + "]";
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
    
	
	
}
