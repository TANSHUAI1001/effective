package bases.generalization;

import java.io.Serializable;
import java.util.*;

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

    /**
     * Core Java chapter 12.4 类型变量的限定
     * @param arr T类型数组
     * @param <T> 限定类型可以多个限定，使用&分隔，而? extends则不行
     * @return 任意
     */
    public static <T extends Comparable & Serializable> T min(T[] arr){
        return arr[0];
    }

    public static void main(String[] args) {

        General general = new General();
        SubGeneral subGeneral = new SubGeneral();
        SubSubGeneral subSubGeneral = new SubSubGeneral();

        ArrayList<General> arrayList = new ArrayList<>();

        arrayList.add(general);
        arrayList.add(subGeneral);
        arrayList.add(subSubGeneral);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            General it = (General) iterator.next();
            it.print();
        }

        /**
         * 向下限定[E,?)至少是E及其子类，无法确定并限定类型,所以不能添加任何元素，最高级是E所以肯定可以用E来get
         * < ? extends E >
         *     add： 不允许加入 任何 元素！
         *     get： 可以获取元素，但是必须使用 E 来接受元素！
         *
         * 向上(?,E]至少是E及其父类，此类声明就可以添加E及其子类，无法确定并限定类型，所以只能是get最高级Object
         * < ? super E >
         *     add: 允许添加 E和E的子类 元素！
         *     get: 可以获取元素，但是类的信息丢失了，所以返回只能使用Object引用来接受！如果需要自己的类型需要强制类型转换！
         */
        ArrayList<? extends SubGeneral> arrayList1 = new ArrayList<SubSubGeneral>();
//        arrayList1.add(general);
//        arrayList1.add(subGeneral);
//        arrayList1.add(subSubGeneral);

        ArrayList<? extends GenericInterface> arrayList2 =  new ArrayList<>();

//        arrayList2.add(subSubGeneral);

        ArrayList< ? super SubGeneral> arrayList3 = new ArrayList<General>();

//        arrayList3.add(general);
        arrayList3.add(subGeneral);
        arrayList3.add(subSubGeneral);

        for (Object it:arrayList3) {
            General git = (General) it;
            git.print();
        }

    }
}
