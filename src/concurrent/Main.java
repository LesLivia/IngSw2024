package concurrent;

import java.util.concurrent.TimeUnit;

class A extends Thread {

    private BankAccount ba;

    public A(BankAccount ba) {
        this.ba = ba;
    }

    @Override
    public void run() {
        this.ba.deposit(50);
    }
}


public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("primo");
        MyThread t2 = new MyThread("secondo");

        // t1.start();
        // t2.start();

        BankAccount ba = new BankAccount(100);
        A ba1 = new A(ba), ba2 = new A(ba);

        ba1.start();
        ba2.start();

        while (ba1.isAlive() || ba2.isAlive())
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(ba.getAmount());

        Friend anna = new Friend("Anna");
        Friend giacomo = new Friend("Giacomo");

        new Thread(() -> anna.bow(giacomo)).start();

        new Thread(() -> giacomo.bow(anna)).start();
    }
}
