package thinkinginjava.concurrency;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id+"("+(countDown > 0 ? countDown : "Lift Off !")+").";
    }
    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        System.out.println("waiting for lift off");
        for (int i = 0; i < 5; i++)
            new Thread(new LiftOff()).start();

    }
}
