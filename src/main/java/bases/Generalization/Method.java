package bases.Generalization;

import java.util.List;

/**
 * Created by shuai on 2017/2/9.
 */
public class Method {

    public static int count(List<?> data){
        return 0;
    }
    public static <T> T getNumbers(T data){
        return data;
    }
    public static <T> void leave(Class<T> c){

    }
}
