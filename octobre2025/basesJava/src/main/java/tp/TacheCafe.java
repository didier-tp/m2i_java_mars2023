package tp;

public class TacheCafe implements Runnable {

	@Override
	public void run() {
		MyThreadUtil.afficherMessage("café en préparation");
		try {
			Thread.sleep(5000); //5000ms de pause
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MyThreadUtil.afficherMessage("café prêt");
	}

}
