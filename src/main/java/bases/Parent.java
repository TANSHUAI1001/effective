package bases;

/**
 * Created by shuai on 2017/2/7.
 */
public class Parent {
    public static void main(String args[]){
        Parent c = new Child();
        System.out.println(c.getX()); // 5
        System.out.println(c.y);
        System.out.println(c.z);
        System.out.println(c.za);
        System.out.println(c.toString());

    }
    public Parent(){

    }
    private int x = 3;
    int y = 3;
    protected int z = 3;
    public int za = 3;
    public int getX(){
        return x;
    }

    public Parent foo(){
        return this;
    }
}
