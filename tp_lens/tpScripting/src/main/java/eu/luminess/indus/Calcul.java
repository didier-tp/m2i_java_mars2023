package eu.luminess.indus;

public class Calcul {
    private double x;
    private double res;

    public Calcul() {
    }

    public Calcul(double x) {
        this.x = x;
    }

    public void calculerRacineCarree(){
        this.res = Math.sqrt(x);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }
}
