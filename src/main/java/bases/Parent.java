package bases;

/**
 * Created by shuai on 2017/2/7.
 */
public class Parent {
    public static void main(String args[]){
        Child c = new Child();
        System.out.println(c.getX()); // 5
    }
    private int x = 3;
    public int getX(){
        return x;
    }
}
