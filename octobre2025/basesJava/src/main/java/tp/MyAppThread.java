package tp;

public class MyAppThread {
	

	public static void main(String[] args) {
		MyThreadUtil.afficherMessage("debut de main");
		
		TacheCafe tacheCafeCourt = new TacheCafe(); //code qui sera exécuté par un ou plusieur thread
		TacheCafe tacheCafeLong = new TacheCafe(true);
		
		Thread thread_a = new Thread(tacheCafeLong); //préparer un nouveau Thread qui va executer la tâche (en // vis à vis du Thread principal)
		thread_a.start(); //démarrer le nouveau thread , celui ci s'arrêtera tout seul quand le .run() aura fini son travail
		
		Thread thread_b = new Thread(tacheCafeLong); //préparer un nouveau Thread qui va executer la tâche (en // vis à vis du Thread principal)
		thread_b.start();
		
		Thread thread_c = new Thread(tacheCafeCourt); //préparer un nouveau Thread qui va executer la tâche (en // vis à vis du Thread principal)
		thread_c.start();
		
		MyThreadUtil.afficherMessage("suite du main");
	}
	
}
