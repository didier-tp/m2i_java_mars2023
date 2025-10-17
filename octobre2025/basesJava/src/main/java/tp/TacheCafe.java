package tp;

public class TacheCafe implements Runnable {
	
	private boolean estLong =false;
	private int compteur=0;
	
	TacheCafe(boolean estLong){
		this.estLong=estLong;
	}
	
	TacheCafe(){
		this(false);
	}

	@Override
	public void run() {
		MyThreadUtil.afficherMessage("café en préparation");
		synchronized(this) {
		    this.compteur++;
		    MyThreadUtil.afficherMessage("compteur="+this.compteur + " avec estLong=" + this.estLong);
		}
		
		//NB: PAS BESOIN de synchronized si manipulation de variables locales (ex: i  ou input ou en return)
		for(int i=0;i<5;i++) {
			System.out.print(" " + i); 
		}
		try {
			Thread.sleep(this.estLong?3000:1000); //3000ms de pause pour cefe long, 1000 pour café court
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MyThreadUtil.afficherMessage("café prêt");
	}

}
