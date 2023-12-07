package tp.avec_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadApp {

    public static void main(String[] args) {
        System.out.println("main ... " + Thread.currentThread().getName());
        Instructions instructions = new Instructions();
        /*
        Thread t1 = new Thread(instructions);
        Thread t2 = new Thread(instructions);
        t1.start();
        t2.start();
         */

        ExecutorService multiThreadExecutor = Executors.newFixedThreadPool(6);
        //exécutions multiples (en //) en background
        multiThreadExecutor.execute(instructions);
        multiThreadExecutor.execute(instructions);
        multiThreadExecutor.execute(instructions);
        multiThreadExecutor.execute(instructions);
        multiThreadExecutor.execute(instructions);
        multiThreadExecutor.execute(instructions);
        multiThreadExecutor.shutdown();//automatiquement différé , .shutdownNow() pour arrêt immédiat
    }
}
