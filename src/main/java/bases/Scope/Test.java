package bases.Scope;

/**
 * Created by shuai on 2017/2/8.
 */
/**
 * 作用域      当前类       同包      子类      其他
 * public        √        √       √        √
 * protected     √        √       √        ×
 * default       √        √       ×        ×
 * private       √        ×        ×        ×
 * 类的成员不写访问修饰时默认为default。
 * 默认对于同一个包中的其他类相当于公开（public），对于不是同一个包中的其他类相当于私有（private）。
 * 受保护（protected）对子类相当于公开，对不是同一包中的没有父子关系的类相当于私有。
 */

public class Test {
    public static void main(String []args){
        DefaltChild dc = new DefaltChild();
        dc.x = 10;

    }
}
