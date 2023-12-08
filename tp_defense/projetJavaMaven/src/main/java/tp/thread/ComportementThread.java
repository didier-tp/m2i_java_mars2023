package tp.thread;

public class ComportementThread implements Runnable{

	@Override
	public void run() {
		for(int i=1 ; i<=4;i++) {
			System.out.println("i="+i + " executé par " + Thread.currentThread().getName());
			try {
				Thread.sleep(500);//500ms = 0.5s
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}

}
