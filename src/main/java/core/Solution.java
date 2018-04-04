package core;

/**
 * Created by shuai on 2018/3/26.
 */

/**
 * java.lang
 * 1.object 类
 *
 * 2.数学类 (Math)
 *
 * 3.数据类型类
 *
 * 4.线程类
 *
 * 5.字符串类 (String 类和 StringBuffer 类 )
 *
 * 6.系统及运行类 (System 类和 Runtime 类 )
 *
 * 7.错误和异常处理类 (Throwable 、 Exception 、 Error)
 *
 * 8.过程类 (process)
 *
 * Appendable
 *
 * 用于追加字符串
 *
 * Cloneable
 *
 * 用于复制类对象
 *
 * Runnable
 *
 * 用于实现类对象具有线程功能
 *
 * Comparable
 *
 *  用于类对象的排序
 *
 * java.util
 * 1. 日期类、日历类（ Data 、 Calendar 、 GregorianCalendar ）
 *
 * 2. 随机数类（ Random ）
 *
 * 3. 位运算类（ BitSet ）
 *
 * 4. 矢量类（ Vector ）
 *
 * 5. 数据结构类（ Stack ）
 *
 * 6. 散列表类（ Hashtable ）
 *
 * 7. StringTokenizer类
 *  java.io
 *  java.sql
 *  java.security
 *  java.beans
 *  java.math
 *
 */
public class Solution {
    public static void main(String[] args) {
        String a = "tan";
        System.out.println(a);
        a = "shuai";
        System.out.println(a);
        change(a);
        System.out.println(a);
        StringBuilder sd = new StringBuilder("shuai");
        change(sd);
        System.out.println(sd);
        StringBuffer sb = new StringBuffer("shuai");
        change(sb);
        System.out.println(sb);
    }

    static void change(String s){
        s = "hello";
    }
    static void change(StringBuffer sb){
        // synchronized 线程安全
        sb.replace(0,sb.length(),"hello");
    }
    static void change(StringBuilder sd){
        // 单线程情况下 速度快
        sd.replace(0,sd.length(),"hello");
    }
}
