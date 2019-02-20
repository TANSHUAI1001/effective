package concurrent;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by shuai on 2018/4/10.
 * CAS:Compare and Swap，AQS:AbstractQueuedSynchronizer
 */
public class CopyOnWrite {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> ca = new CopyOnWriteArrayList();
        CopyOnWriteArraySet<String> cs = new CopyOnWriteArraySet();
        ca.add("a");

    }
}
