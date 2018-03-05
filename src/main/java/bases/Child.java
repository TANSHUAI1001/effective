package bases;

/**
 * Created by shuai on 2017/2/7.
 */

/**
 * 继承，子类方法覆盖父类方法，向上转型，子类非继承方法丢失。
 */
public class Child extends Parent {
    public Child(){
//        x = 10;
        super();
        //super must be first statement in constructor body
        this.x = 10;

    }

    public Child(int x){
//        int y = 10;
        this();
        //this must be first statement in constructor body
//        x = 100;
    }

    private int x = 5;
    int y = 5;
    protected int z = 5;
    public int za = 5;
//    public int getX(){
//        return x;
//    }
    public int getY(){
        return y;
    }
    public void test(){
        System.out.println(this.y == this.getY());
    }

    public int foo(Parent p){
        return 1;
    }

    public static void main(String[] args) {
        Child c = new Child();
    }

}
