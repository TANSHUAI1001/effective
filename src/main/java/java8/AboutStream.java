package java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
 * 毫秒 System.currentTimeMillis() 纳秒 System.nanoTime()
 * Created by shuai on 2017/3/1.
 */
public class AboutStream {
    public static void main(String[] args) {
        AboutStream as = new AboutStream();
//        as.predicateAndConsumer();
        as.runoob();
    }

    /**
     * <a href="http://www.runoob.com/java/java8-streams.html">Java 8 Stream</a>
     */
    public void runoob(){
        // 生成流 iostream() − 为集合创建串行流。parallelStream() − 为集合创建并行流。
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl"
                ,"abc", "", "bc", "efg", "abcd","", "jkl"
                ,"abc", "", "bc", "efg", "abcd","", "jkl"
                ,"abc", "", "bc", "efg", "abcd","", "jkl"
                ,"abc", "", "bc", "efg", "abcd","", "jkl"
                ,"abc", "", "bc", "efg", "abcd","", "jkl"
                ,"abc", "", "bc", "efg", "abcd","", "jkl"
        );
        List<String> filtered = strings.stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println("filtered: "+filtered);

        // forEach Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // map map方法用于映射每个元素到对应的结果
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println("squaresList"+squaresList);

        // filter filter 方法用于通过设置的条件过滤出元素。
//        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        // string -> string.isEmpty() ===> String::isEmpty
        System.out.println(System.nanoTime());
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println("count: "+count);
        System.out.println(System.nanoTime());

        // limit limit 方法用于获取指定数量的流。
        // @see forEach sorted

        // sorted sorted 方法用于对流进行排序。
        random.ints().limit(10).sorted().forEach(System.out::println);

        // 并行（parallel）程序 parallelStream 是流并行处理程序的代替方法。
        System.out.println(System.nanoTime());
        long count1 = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("count1: "+count1);
        System.out.println(System.nanoTime());

        // Collectors Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        // 统计 一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上
        // Stream通过mapToInt转为IntStream才能调用summaryStatistics
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x*x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    public void predicateAndConsumer(){
        int []x = {1,2,3,4,10,11,12};
        int y = 0;
        IntPredicate intPredicate = (int s) -> s <= 10;
        System.out.println("predicate: "+intPredicate.test(x[0]));

        Stream<Integer> si = Stream.of(y).filter(z -> z>=10);
        System.out.println("si: "+si.count());

        String s = "12";
        String []ss = {"12","132"};
        Stream<String> ps = Stream.of(s).filter(z->z.equals("12"));
        Stream<String> pss = Stream.of(ss).filter(z->z.equals("12"));
        System.out.println("ps: "+ps.noneMatch(String::isEmpty));
        System.out.println("pss: "+pss.noneMatch(String::isEmpty));

        List<String> arr = Stream.of(ss)
                .filter(zz -> !"12".equals(zz))
                .collect(Collectors.toList());
        System.out.println("arr: "+arr);

    }
}
