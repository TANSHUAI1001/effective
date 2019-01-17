package core;

import java.io.IOException;

/**
 * 1. 如果在try或者catch语句内有return语句，则return语句在finally语句执行结束后才执行，但finally并不能改变返回值
 * 2. 如果在finally中也有return语句，try和catch内的return会丢失，实际会返回finally中的返回值。
 * 3. finally中有return不仅会覆盖try和catch内的返回值，还会掩盖try和catch内的异常，就像异常没有发生一样
 * 4. 如果finally中抛出了异常，则原异常就会被掩盖
 */
public class TryFinallyDemo {
    private int val = 0;
    public int rule1(){
        try{
            val = 2;
            return val;
        }finally {
            val = 1;
        }
    }
    public int rule2try(){
        try{
            val = 2;
            return val;
        }finally {
            val = 1;
            return val;
        }
    }
    public int rule2catch(){
        try{
            val = 20 / 0;
            return val;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 2;
        }finally {
            val = 1;
            return val;
        }
    }
    public int rule2NoFinally(){
        try{
            val = 2 / 0;
            return val;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 2;
        }
    }
    public int rule3(){
        try{
            val = 2 / 0;
            return val;
        }finally {
            return 0;
        }// 没catch但不会往main抛异常
    }
    public int rule4() throws IOException {
        try{
            val = 20 / 0;
        }finally {
            throw new IOException("finally io");
        }
    }
    public static void main(String[] args) {
//        System.out.println(new TryFinallyDemo().rule1());
//        System.out.println(new TryFinallyDemo().rule2try());
//        System.out.println(new TryFinallyDemo().rule2catch());
//        System.out.println(new TryFinallyDemo().rule2NoFinally());
//        System.out.println(new TryFinallyDemo().rule3());
        try {
            System.out.println(new TryFinallyDemo().rule4());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
