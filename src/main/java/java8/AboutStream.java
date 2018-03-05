package java8;

import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shuai on 2017/3/1.
 */
public class AboutStream {
    public static void main(String[] args) {
//        Stream.of("a,b,c,d").filter(String::isEmpty).toArray();
        AboutStream as = new AboutStream();
        as.predicateAndConsumer();
    }

    public void predicateAndConsumer(){
        int []x = {1,2,3,4,10,11,12};
        int y = 0;
        IntPredicate intPredicate = (int s) -> s <= 10;
        System.out.println(intPredicate.test(x[0]));

        Stream.of(y).filter(
                z -> z>=10
        );
        String s = "12";
        String []ss = {"12","132"};
        Stream<String> p = Stream.of(s)
//                .filter(
//                z->z.equals("12"))
                ;
        System.out.println(p.noneMatch(z->z.isEmpty()));
        Stream.of(ss).filter(
                zz -> !"12".equals(zz)
        ).collect(Collectors.toList());
//        s -> s.toLowerCase().matches("[abc]*");
    }
}
