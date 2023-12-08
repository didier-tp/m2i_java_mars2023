package tp.thread;

public class AppThread {

	public static void main(String[] args) {
		System.out.println("debut-main executé par " + Thread.currentThread().getName());
		ComportementThread c = new ComportementThread();
		for(int i=1;i<=3;i++) {
			Thread t = new Thread(c);
			t.start();
		}
		System.out.println("suite-main ");
	}

}
