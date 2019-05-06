package design.iterator;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("张无忌");
//        list.add("小龙女");
//        list.add("令狐冲");
//        list.add("韦小宝");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("张无忌");
        linkedList.add("小龙女");
        linkedList.add("令狐冲");
        linkedList.add("韦小宝");
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.nextIndex()+" "+listIterator.next());
        }
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previousIndex()+" "+listIterator.previous());
        }
    }
}
