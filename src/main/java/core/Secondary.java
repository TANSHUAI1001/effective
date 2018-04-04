package core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * Created by shuai on 2018/3/26.
 */
public class Secondary {
    /**
     *  java.io
     *  java.sql
     *  java.security
     *  java.beans
     *  java.math
     *
     */
    public static void main(String[] args) {
        java.io.File file = new File("./test");
        synchronized (file) {
            System.out.println(file.getName());
        }

        java.beans.Transient t = null;
    }
}
