package eu.luminess.indus.avec_thread;

public class Instructions implements Runnable{

    @Override
    public void run() {
        int n = 10;
        while(n>=0){
            System.out.println( "n="+n + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); //2000 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            n--;
        }
    }
}
