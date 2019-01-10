package thinkinginjava.concurrency;

public class Practice1 implements Runnable{
    private String startMsg = "startMsg";
    private String endMsg = "endMsg";
    private int id;

    public Practice1() {
    }

    public Practice1(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(startMsg+this.id);
        System.out.println("first");
        Thread.yield(); // 让出CPU，防止过度使用CPU，实际项目很少用
        System.out.println("second");
        Thread.yield();
        System.out.println("third");
        Thread.yield();
        System.out.println(endMsg+this.id);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Practice1(i)).start();
        }
    }
}
