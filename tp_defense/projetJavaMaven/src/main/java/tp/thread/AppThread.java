package tp.thread;

public class AppThread {

	public static void main(String[] args) {
		System.out.println("debut-main");
		ComportementThread c = new ComportementThread();
		Thread t = new Thread(c);
		t.start();
		System.out.println("suite-main");
	}

}
