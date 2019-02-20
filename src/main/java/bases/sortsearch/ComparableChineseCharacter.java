package bases.sortsearch;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Comparable可以和同类比较，该类支持排序
 * Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
 * 实现了Comparable接口的类的对象的列表或数组可以通过Collections.sort或Arrays.sort进行自动排序。
 * Created by shuai on 2017/3/8.
 */
public class ComparableChineseCharacter implements Comparable<ComparableChineseCharacter>{
    // sort方法已经默认实现按拼音排序
    String chinese;
    Collator collator = Collator.getInstance(Locale.CHINA);

    public ComparableChineseCharacter(String chinese) {
        this.chinese = chinese;
    }

    @Override
    public int compareTo(ComparableChineseCharacter o) {
        return collator.compare(this.chinese, o.chinese);
    }

    @Override
    public String toString() {
        return this.chinese;
    }

    public static void test(String[] array){
        ArrayList<ComparableChineseCharacter> list = new ArrayList<>();
        ComparableChineseCharacter[] cArray = new ComparableChineseCharacter[array.length];
        for (int i = 0; i < array.length; i++) {
            ComparableChineseCharacter character = new ComparableChineseCharacter(array[i]);
            list.add(character);
            cArray[i] = character;
        }
        Collections.sort(list);
        System.out.println(list);

        Arrays.sort(cArray);
        System.out.println(Arrays.toString(cArray));
    }

    public static void main(String[] args) {
        String [] array = {"安徽","湖南","湖北","广东","广西"};
        test(array);
    }

}
