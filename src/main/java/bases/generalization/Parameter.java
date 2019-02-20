package bases.generalization;

import javafx.util.Pair;

/**
 * Created by shuai on 2017/2/9.
 */
public class Parameter {

    public static void main(String[] args) {
        Pair<String,String> pair = new Pair<>("key","value");
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}
