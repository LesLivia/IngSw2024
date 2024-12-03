package concurrent;

public class MyThread extends Thread {

    private String msg;

    public MyThread(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++)
            System.out.println(this.msg);
    }
}
