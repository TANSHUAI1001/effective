package thinking.chapter15;

/**
 * Created by shuai on 2017/2/3.
 */
public class LinkedStack<T> {
    private class Node{
        T item;
        Node next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end(){
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T item){
        top = new Node(item,top);
    }

    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    @Override
    public String toString() {
        return "LinkedStack{" +
                "top=" + top +
                '}'+
                " "+
                getClass().getSimpleName();
    }

    public static void main(String args[]){
        LinkedStack<String> ls = new LinkedStack<String>();
        for (String s: "phasers on stun !".split(" ")
             ) {
            ls.push(s);
        }
        String s;
        while ((s = ls.pop()) != null){
            System.out.println(s);
        }

    }

}
