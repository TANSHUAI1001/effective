package bases.sortsearch;

import java.text.Collator;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

/**
 * Comparator该类本身不支持排序
 * Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
 * 1.8之后的thenComparing reversed更加灵活
 * Created by shuai on 2017/3/8.
 */
public class ComparatorChineseCharacter{
    String name;
    int age;
    long holds;
    double shares;

    public ComparatorChineseCharacter(){

    }
    public ComparatorChineseCharacter(String name,int age,long holds,double shares){
        this.name = name;
        this.age = age;
        this.holds = holds;
        this.shares = shares;
    }


    @Override
    public String toString() {
        return "ComparatorChineseCharacter{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", holds=" + holds +
                ", shares=" + shares +
                '}';
    }

    public static void test(){
        String [] array = {"安徽","湖南","湖北","广东","广西",""};

        List<String> sortList = Arrays.stream(array).filter(x -> !x.isEmpty()).sorted((o1, o2) -> {
            Collator collator = Collator.getInstance(Locale.CHINA);
            return collator.compare(o1,o2);
        }).collect(Collectors.toList());

        System.out.println(sortList);
    }
    public static void main(String[] args) {
        ComparatorChineseCharacter character0 = new ComparatorChineseCharacter("安徽",88,1000L,0.96);
        ComparatorChineseCharacter character1 = new ComparatorChineseCharacter("湖南",87,2000L,0.92);
        ComparatorChineseCharacter character2 = new ComparatorChineseCharacter("广东",83,3000L,0.97);
        ComparatorChineseCharacter character3 = new ComparatorChineseCharacter("广东",88,4000L,0.99);
        ComparatorChineseCharacter character4 = new ComparatorChineseCharacter("广西",88,5000L,0.86);
        ComparatorChineseCharacter character5 = new ComparatorChineseCharacter("广西",99,1_000_000L,0.99);


        ComparatorChineseCharacter[] array = {character0,character1,character2,character3,character4,character5};
        ArrayList<ComparatorChineseCharacter> list = new ArrayList<>();
        Collections.addAll(list, array);

        Comparator<ComparatorChineseCharacter> nameComparator = new Comparator<ComparatorChineseCharacter>() {
            @Override
            public int compare(ComparatorChineseCharacter o1, ComparatorChineseCharacter o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        Comparator<ComparatorChineseCharacter> ageComparator = new Comparator<ComparatorChineseCharacter>() {
            @Override
            public int compare(ComparatorChineseCharacter o1, ComparatorChineseCharacter o2) {
                return o1.age - o2.age;
            }
        };

        list.sort(nameComparator);
        System.out.println(list);
        list.sort(nameComparator.thenComparing(ageComparator.reversed()));
        System.out.println(list);

    }
}
