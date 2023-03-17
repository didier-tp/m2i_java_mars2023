package eu.luminess.indus.avec_thread;

public class ThreadApp {

    public static void main(String[] args) {
        System.out.println("main ... " + Thread.currentThread().getName());
        Instructions instructions = new Instructions();
        Thread t1 = new Thread(instructions);
        Thread t2 = new Thread(instructions);
        t1.start();
        t2.start();
    }
}
