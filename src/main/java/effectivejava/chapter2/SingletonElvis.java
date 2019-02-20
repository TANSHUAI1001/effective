package effectivejava.chapter2;

/**
 * Created by shuai on 2017/2/8.
 */
public enum SingletonElvis {
    INSTANCE;
    public int leave(){
        System.out.println("elvis leaving...");
        return 1;
    }
}
