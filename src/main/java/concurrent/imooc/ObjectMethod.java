package concurrent.imooc;

public class ObjectMethod implements Runnable {
    static ObjectMethod instance = new ObjectMethod();
    static int n = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            addition();
        }
    }

    public synchronized void addition(){
        n++;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive());
        System.out.println(n);
    }
}
