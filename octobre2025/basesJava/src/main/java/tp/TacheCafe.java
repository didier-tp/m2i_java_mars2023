package tp;

public class TacheCafe implements Runnable {
	
	private boolean estLong =false;
	
	TacheCafe(boolean estLong){
		this.estLong=estLong;
	}
	
	TacheCafe(){
		this(false);
	}

	@Override
	public void run() {
		MyThreadUtil.afficherMessage("café en préparation");
		try {
			Thread.sleep(this.estLong?3000:1000); //3000ms de pause pour cefe long, 1000 pour café court
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MyThreadUtil.afficherMessage("café prêt");
	}

}
