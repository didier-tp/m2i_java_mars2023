package tp.thread;

public class AppThread {

	public static void main(String[] args) {
		System.out.println("debut-main executé par " + Thread.currentThread().getName());
		for(int i=1;i<=3;i++) {
			ComportementThread c = new ComportementThread();
			Thread t = new Thread(c);
			t.start();
		}
		System.out.println("suite-main ");
	}

}
