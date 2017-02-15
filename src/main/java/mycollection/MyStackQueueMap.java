package mycollection;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by shuai on 2017/1/22.
 */
public class MyStackQueueMap {
    public static void main(String args[]){
//        testQueue();
        testMap();

    }
    public static void testStack(){
        Stack<String> st1 = new Stack<String>();
//        st1.push("first");
//        st1.push("second");
//        System.out.println("size:"+st1.size());
//        int size = st1.size();
//        for (int i = 0; i < st1.size(); i++) {
//            System.out.println(st1.peek());
//        }
//        for (int i = 0; i < size; i++) {
//            System.out.println(st1.pop());
//        }
//        for (int i = 0; i < st1.size(); i++) {
//            System.out.println(st1.pop());
//            System.out.println("size: "+st1.size());
//        }
//        System.out.println(st1.pop());
//        System.out.println(st1.pop());
    }
    public static void testQueue(){

        /**
         * PriorityQueue不允许插入null元素，还要对队列元素进行排序，两种排序方式：
         * 自然排序：集合中的元素必须实现Comparable接口，而且应该是同一个类的多个实例，
         * 否则可能导致ClassCastException异常。
         * 定制排序：创建队列时，传入一个Comparator对象，该对象负责对队列中的所有元素进行排序。
         * 采用定制排序时不需要元素实现Comparable接口。
         */
        Queue<String > q1 = new PriorityQueue<String>();
        q1.offer("a");
        q1.offer("c");
        q1.offer("b");
        while (!q1.isEmpty()){
            System.out.println(q1.poll());
        }
        System.out.println(q1.poll());
        // if it is empty then return null, it does not support offer null value

        /**
         * @Params:
         * 1:int
         * 2:int,boolean
         * 3:int,boolean,collection (capacity,fair,collection)
         */
        Queue<String > q2 = new ArrayBlockingQueue<String>(1);
        //创建之后，capacity不可变
        //fair表示平衡性，true则优先将等待时间最长的元素offer，但是性能会受到影响。
        Queue<String > q3 = new ConcurrentLinkedQueue<String>();

        Queue<String > q4 = new LinkedBlockingQueue<String>();
//        q4.offer(null);
        /**
         * 注意：poll和peek方法出错进返回null。因此，向队列中插入null值是不合法的。
         */
        System.out.println("linked blocking queue : "+q4.poll());

        Queue<String > q5 = new LinkedTransferQueue<String>();
        Queue<String > q6 = new PriorityBlockingQueue<String>();
        Queue<String > q7 = new SynchronousQueue<String>();
        Queue<MyDelay > q8 = new DelayQueue<MyDelay>();
        /**
         * Queue使用时要尽量避免Collection的add()和remove()方法，
         * 而是要使用offer()来加入元素，使用poll()来获取并移出元素。
         * 它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。
         * 如果要使用前端而不移出该元素，使用element()或者peek()方法。如果队列为空element()会抛出异常。
         */

    }

    public static void testMap(){
        Map<String ,String > map = new HashMap<>();
        Map<String ,String > map1 = new ConcurrentHashMap<>();
        Map map2 = Collections.synchronizedMap(map);
        map2.put("1","one");
        map.put("2","two");
        System.out.println(map.entrySet());
        for(Map.Entry<String,String> val:map.entrySet()){
            System.out.println(val.getKey()+" : "+val.getValue());
        }
    }
}
