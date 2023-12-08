package tp.thread;

public class ComportementThread implements Runnable{
	
	private int compteur = 0;

	@Override
	public void run() {
		for(int i=1 ; i<=4;i++) {
			
			synchronized(this) {
				compteur=compteur+1;
				System.out.println("i="+i + " compteur=" + compteur 
						           + " executé par " + Thread.currentThread().getName());
			}
			try {
				Thread.sleep(500);//500ms = 0.5s
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
		}
		
	}

}
