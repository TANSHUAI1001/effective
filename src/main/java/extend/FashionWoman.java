package extend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by shuai on 2017/3/14.
 */
public class FashionWoman implements Woman,Disposition {
    @Override
    public void voice() {
        System.out.println("not normal");
    }

    @Override
    public void speak() {
        System.out.println("light");
    }

    @Override
    public void dressing() {
        System.out.println("well");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+""+i);
        }

        ListIterator iter = list.listIterator();
        System.out.println(iter.previousIndex());

        HashMap hm = new HashMap();
    }
}
