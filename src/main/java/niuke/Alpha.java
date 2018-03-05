package niuke;

class Base{
    Base(){
        System.out.println("BASE");
    }
}
public class Alpha extends Base{

    public void Alpha(){

    }
    public static void main(String[] args) {
        new Alpha(); // BASE, 继承构造函数

        new Base(); // BASE

        Object o = new Object();
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
