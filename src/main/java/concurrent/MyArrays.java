package concurrent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shuai on 2018/3/8.
 */
public class MyArrays {
    /**
     * Arrays.asList()
     * 将一个数组转化为一个List对象，这个方法会返回一个ArrayList类型的对象，
     * 这个ArrayList类并非java.util.ArrayList类，而是Arrays类的静态内部类！
     * 用这个对象对列表进行添加删除更新操作，就会报UnsupportedOperationException异常。
     */

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(list.toString());
    }

}
