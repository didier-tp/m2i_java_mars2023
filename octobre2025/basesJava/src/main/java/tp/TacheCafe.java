package tp;

public class TacheCafe implements Runnable {

	@Override
	public void run() {
		System.out.println("café en préparation");
		try {
			Thread.sleep(5000); //5000ms de pause
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("café prêt");
	}

}
