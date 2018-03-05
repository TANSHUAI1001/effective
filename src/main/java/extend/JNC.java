package extend;

/**
 * Created by shuai on 2017/3/14.
 */
public class JNC extends Wine{
    public void func(){
        System.out.println("JNC func");
    }

    public int func(int i){
        System.out.println("JNC func");
        return 0;
    }

    public void func(String s){
        System.out.println("JNC func "+s);
    }

    public void func2(){
        System.out.println("JNC func2");
    }

    public static void main(String[] args) {
        Wine w = new JNC();
        JNC j = new JNC();
        w.func();
//        w.func("1001");
        j.func("1001");

    }
}
