package mycollection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by shuai on 2017/1/22.
 */
public class MyDelay implements Delayed{
    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
