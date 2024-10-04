package it.polimi.other;

public class Prova {
    private int x;

    public Prova(int valore) {
        this.x = valore;
    }

    public Prova() {
        this.x = 0;
    }

    public int somma(int a, int b) {
        return a + b;
    }

    public double somma(int a, double b) {
        return a * 2;
    }
}
