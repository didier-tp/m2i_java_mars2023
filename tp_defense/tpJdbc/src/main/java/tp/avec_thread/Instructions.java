package tp.avec_thread;

public class Instructions implements Runnable{

    private int compteurPartage = 0;

    @Override
    public void run() {
        int n = 4;
        while(n>=0){
            this.affEtPause(n);
            n--;
        }
    }

    public  /*synchronized*/ void affEtPause(int n){
        System.out.println( "n="+n + " " + Thread.currentThread().getName());
        synchronized (this){
            this.compteurPartage++;
            System.out.println( "compteurPartage="+compteurPartage + " incrémenté par " + Thread.currentThread().getName());
        }
        try {
            Thread.sleep(2000); //2000 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
