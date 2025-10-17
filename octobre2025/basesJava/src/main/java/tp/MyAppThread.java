package tp;

public class MyAppThread {
	

	public static void main(String[] args) {
		MyThreadUtil.afficherMessage("debut de main");
		
		TacheCafe tacheCafe = new TacheCafe(); //code qui sera exécuté par un ou plusieur thread
		
		Thread thread_a = new Thread(tacheCafe); //préparer un nouveau Thread qui va executer la tâche (en // vis à vis du Thread principal)
		
		thread_a.start(); //démarrer le nouveau thread , celui ci s'arrêtera tout seul quand le .run() aura fini son travail
		MyThreadUtil.afficherMessage("suite du main");
	}
	
}
