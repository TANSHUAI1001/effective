package niuke;

public class B
{
    /**
     * 类加载的时候，静态变量和静态块是同一优先级，执行顺序取决于声明的位置，
     * 所以类加载是执行顺序是： t1, t2, 静态块
     * 在执行t1, t2 时候就去执行构造块，忽略静态域（包括静态变量和静态块）
     */
    public static B t1 = new B();
    public static B t2 = new B();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        B t = new B();
        System.out.println(AccountType.CURRENT);
        //构造块
        //构造块
        //静态块
        //构造块
    }
}