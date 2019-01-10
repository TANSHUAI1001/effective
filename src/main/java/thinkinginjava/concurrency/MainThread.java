package thinkinginjava.concurrency;

public class MainThread {
    volatile int name;

    public native void Test();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();
        System.out.println("waiting for lift off");


    }
}
