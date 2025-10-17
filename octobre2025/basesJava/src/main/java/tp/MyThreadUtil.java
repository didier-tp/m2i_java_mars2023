package tp;

public class MyThreadUtil {
	
	public static void afficherMessage(String msg) {
		System.out.println(msg + " depuis le thread " + Thread.currentThread().getName());
	}

}
