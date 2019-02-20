package bases;

import java.util.*;

public class ListIteratorTest {
    static void testIterator(List<String> staff){
        Iterator<String> iterator = staff.iterator();

//        iterator.next();
        iterator.remove();
        System.out.println(staff);

    }

    static void testListIterator(List<String> staff){
        ListIterator<String> liter = staff.listIterator();

//        liter.previous(); // NoSuchElementException
//        liter.remove(); // IllegalStateException

        liter.add("first");
        liter.next();
        liter.add("second"); // when add, current between this and next, can not call remove()
        System.out.println("pre-index: "+liter.previousIndex()+" next-index: "+liter.nextIndex());
        liter.previous();
        liter.remove(); // remove second

        liter.add("third"); // when add, current between this and next, can not call remove()
        System.out.println("pre-index: "+liter.previousIndex()+" next-index: "+liter.nextIndex());
        liter.next();
        liter.remove(); // remove third's next element
        System.out.println(staff);
        liter.next();
        liter.set("fourth");
        System.out.println(staff);
    }

    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("zhuwei");
        staff.add("xuezhangbin");
        staff.add("taozhiwei");

//        testIterator(staff);
        testListIterator(staff);
    }
}
