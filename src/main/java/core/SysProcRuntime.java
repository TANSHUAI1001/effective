package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by shuai on 2018/3/26.
 */
public class SysProcRuntime {
    public static void main(String[] args) {
//        sys();
        proc();

    }

    static void proc(){
        // 使用Runtime.getRuntime().exec()方法可以在java程序里运行外部程序。
        String s;
        StringBuilder sb = new StringBuilder();
        InputStream fis = null;
        try {
            Process process = Runtime.getRuntime().exec("ping www.baidu.com");
            fis = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis,"GBK"));
            while((s=bufferedReader.readLine()) != null) {
                sb.append(s);
            }
            System.out.println(sb.toString());
            process.waitFor();
            System.out.println(process.exitValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static void sys(){
        int array[] = {1,3,5,7,8,90};
        int ac[] = new int[5];
        // ArrayIndexOutOfBoundsException
        // ArrayStoreException
        // NullPointerException
        // native
        System.arraycopy(array,1,ac,0,5);
        System.out.println(Arrays.toString(ac));
        System.out.println(System.currentTimeMillis());
        System.out.println(System.getenv());
        System.out.println(System.getProperties());
    }
}
