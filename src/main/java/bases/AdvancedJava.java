package bases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by shuai on 2017/3/13.
 */
public class AdvancedJava {
    public static void main(String[] args) {
//        exit0();
//        exit1();
        securityExit();
//        Collections.sort(null);
//        Collections.copy(null,null);
//        List f = new ArrayList();
//
//        String s = "";
//        boolean isMatch = s.equalsIgnoreCase(null);
//        System.out.println(isMatch);
//        Boolean a = new Boolean("trues");
//        System.out.println(a);

    }

    public static void securityExit(){
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkExit(int status) {
//                throw new ThreadDeath();
                throw new RuntimeException();
            }
        });
        try {
            System.exit(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("In the finally block");
        }

        int sum = 1 + 1;
        System.out.println(sum);
    }
    public static void exit0(){
        try {
            System.exit(0);
        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
        }finally {
            System.out.println("In the finally block");
        }
        int sum = 1 + 1;
        System.out.println(sum);
    }
    public static void exit1(){
        try {
            System.exit(1);
        }catch (Exception e){
            System.out.println("error: "+e.getMessage());
        }finally {
            System.out.println("In the finally block");
        }
    }



}
