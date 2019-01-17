package core;

/**
 * 1. interface中定义的方法和成员变量，默认为public访问权限，且仅能为public
 * 2. interface中的成员变量默认为public static final类型，可通过接口名或者实现类名或在实现类中直接调用。
 * 3. 一个定义接口的java文件中，interface最多只有一个public，可包含多个不含访问权限修饰词的接口，这些接口的访问权限为包内访问。不能用protected以及private修饰。
 * 4. 类中可以嵌套定义接口，访问权限修饰词随意，在对应作用域内，通过类名.接口名继承。
 * 5. 接口中可以嵌套定义接口，但遵循第一条规则，即默认（且只能为）public
 * 6. 接口中可以定义内部类，但默认（且只能）为public static
 */
public interface InterfaceClass {
    // method can neither be private nor default
    // 默认为public访问权限，且仅能为public
    int defaultInterfaceMethod();
    public int publicInterfaceMethod();
}
