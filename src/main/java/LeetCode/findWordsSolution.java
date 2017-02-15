package LeetCode;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Stream;
//import java.util.stream.Stream;

/**
 * Created by shuai on 2017/2/8.
 * 500. Keyboard Row
 */
public class findWordsSolution {
    public static void main(String []args){
//        String []words = {"Hello", "Alaska", "Dad", "Peace"};
//        String []f = findWordsByOneLine(words);
//        System.out.println(Arrays.toString(f));
        Test();

    }
    public static void Test(){
        IntFunction<String []> test = String[]::new;
        String[] arr = test.apply(10);
        String[] arr2 = new String[10];
        System.out.println(Arrays.toString(arr)+"\n"+Arrays.toString(arr2));
    }
    public static String[] findWordsByOneLine(String []words){

        return Stream.of(words).filter(
                s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")
        ).toArray(String[]::new);

    }

    public static boolean exists(char []arrays, char a){
        for (char x:arrays) {
            if(x == a) return true;
        }
        return false;
    }
    public static  String[] findWords(String[] words) { // this is more effective !
        char []first = {'q','w','e','r','t','y','u','i','o','p'};
        char []second = {'a','s','d','f','g','h','j','k','l'};
        char []third = {'z','x','c','v','b','n','m'};

        List<Integer> index = new LinkedList<>();
        for (int m = 0; m < words.length; m++){
            String word = words[m].toLowerCase();
            int one = 0,two = 0,three = 0;
            for (int i = 0; i < word.length();i++){
                if(exists(first,word.charAt(i)))
                    one++;
                else if(exists(second,word.charAt(i)))
                    two++;
                else if(exists(third,word.charAt(i)))
                    three++;
                if(one * two != 0 || one * three != 0 || two * three != 0 ){
                    index.add(m);
                    break;
                }
            }
        }
        String []accept = new String[words.length - index.size()];
        int id = 0;
        for (int i = 0; i < words.length; i++) {
            if(index.contains(i)) continue;
            accept[id++] = words[i];
        }
        return accept;
    }

    public static  String[] findWords2(String[] words) {
        char []first = {'q','w','e','r','t','y','u','i','o','p'};
        char []second = {'a','s','d','f','g','h','j','k','l'};
        char []third = {'z','x','c','v','b','n','m'};

        int []acceptIndex = new int[words.length];
        int index = 0;
        for (int m = 0; m < words.length; m++){
            acceptIndex[m] = -1;
            String word = words[m].toLowerCase();
            int one = 0,two = 0,three = 0;
            for (int i = 0; i < word.length();i++){
                if(exists(first,word.charAt(i)))
                    one++;
                else if(exists(second,word.charAt(i)))
                    two++;
                else if(exists(third,word.charAt(i)))
                    three++;
                if(one * two != 0 || one * three != 0 || two * three != 0 ){
                    break;
                }
                if(i == word.length()- 1){
                    acceptIndex[index++] = m;
                }
            }
        }
        String []accept = new String[index];
        int id = 0;
        for (int i = 0; i < words.length; i++) {
            if(acceptIndex[i] == -1) continue;
            accept[id++] = words[acceptIndex[i]];
        }
        return accept;
    }
}
