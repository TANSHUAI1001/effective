package bases;

/**
 * Created by shuai on 2017/2/8.
 */
public class Constructors {
    private int a;
    private int b;
    private int c;
    private int d;

    public Constructors(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Constructors(int a, int b, int c, int d) {
        /**
         * 这是构造函数，不是普通的函数，普通函数可以直接调用函数名
         */
//        Constructors(a,b); // wrong !!!
//        super(a,b); // 这是继承的方法！！！
        this(a,b);
//        this.a = a;
//        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void NormalFunction(int a,int b){
        this.a = a;
        this.b = b;
    }

    public int NormalFunction(int a,int b,int c){
//        this(a,b);
        NormalFunction(a,b);
//        this.a = a;
//        this.b = b;
        this.c = c;
        return 0;
    }
}
