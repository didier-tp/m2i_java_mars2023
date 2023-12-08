package tp.thread;

public class ComportementThread implements Runnable{

	@Override
	public void run() {
		for(int i=1 ; i<=10;i++) {
			System.out.println("i="+i);
			try {
				Thread.sleep(4000);//4000ms = 4s
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}

}
