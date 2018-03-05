package bases;

/**
 * Created by shuai on 2018/3/1.
 */
public class MultiClassInOneFile {
    MultiClassInOneFile(){
        System.out.println("only this class can be visited by outside class");
        one co = new one();
    }

    public static void main(String[] args) {
        MultiClassInOneFile test = new MultiClassInOneFile();
    }
}

class one{
    one(){
        System.out.println("can not use private or protected before class!\n" +
                "can be visited by this file's classes");
    }
}
