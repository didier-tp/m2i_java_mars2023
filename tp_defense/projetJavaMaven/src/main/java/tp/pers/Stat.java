package tp.pers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @NoArgsConstructor @ToString
public class Stat {
		private int n;
		private double moyenneAge;
		private double moyennePoids;

        //+constructeur par defaut (zero param) ici via lombok
		//+toString ici via lombok
		
		public Stat(int n, double moyenneAge, double moyennePoids) {
			super();
			this.n = n;
			this.moyenneAge = moyenneAge;
			this.moyennePoids = moyennePoids;
		}
		
		//+get/set (ici via lombok)
}
