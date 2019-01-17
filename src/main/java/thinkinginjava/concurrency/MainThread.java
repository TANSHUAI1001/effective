package thinkinginjava.concurrency;

public class MainThread {
    public volatile int name;
    public native void Test(); //本地方法
    public synchronized String common(){
        return "";
    }
}
