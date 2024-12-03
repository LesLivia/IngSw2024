package concurrent;

public class BankAccount {

    private int amount;

    public BankAccount(int a) {
        this.amount = a;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int x) {
        this.amount = x;
    }

    public void deposit(int x) {
        synchronized (this) {
            this.setAmount(this.getAmount() + x);
        }
    }

}
