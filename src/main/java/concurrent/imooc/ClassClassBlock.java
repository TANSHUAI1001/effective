package concurrent.imooc;

public class ClassClassBlock implements Runnable{

    static ClassClassBlock instance1 = new ClassClassBlock();
    static ClassClassBlock instance2 = new ClassClassBlock();
    static int n = 0;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            addition();
        }
    }

    static void addition(){
        synchronized(ClassClassBlock.class){
            n++;
        }

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive());
        System.out.println(n);
    }
}
