package extend;

/**
 * Created by shuai on 2017/3/14.
 */
public class Mine<K> {
    private static int id = 0;
    private K val;

    public Mine(K val) {
        id++;
        this.val = val;
    }
    public K getVal(){
        return val;
    }

    public int getId(){
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mine<?> mine = (Mine<?>) o;

        return val.equals(mine.val);
    }

    @Override
    public int hashCode() {
        return val.hashCode();
    }

    public static void main(String[] args) {
        Mine<String> m = new Mine<>("shuai");
        Mine<String> m1 = new Mine<>("shuai1");

        System.out.println(m.getVal()+" "+m.getId()+" "+m1.getId()+" "+m.equals(m1));
        Mine<Integer> mi = new Mine<>(10);
        System.out.println(mi.getVal()+" "+m.getId());
    }
}
