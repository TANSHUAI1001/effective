package extend;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/**
 * Created by shuai on 2017/3/14.
 */
public class SuperAndExtends {
    public static void main(String[] args) {

        List<? super Number>  s = new ArrayList<>();
        List<? extends Number> e = new ArrayList<>();
        boolean bs = s instanceof RandomAccess;
        boolean be = e instanceof RandomAccess;
    }
}
