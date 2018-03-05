package poj;

import java.util.Arrays;

/**
 * Created by shuai on 2017/3/8.
 * http://poj.org/problem?id=1166
 * 多元多次方程的求解,线性代数,高斯消元法
 */
public class TheClocks {
    private static final char [][]moveClocksChar = {
            {'A','B','D','E'},
            {'A','B','C'},
            {'B','C','E','F'},
            {'A','D','G'},
            {'B','D','E','F','H'},
            {'C','F','I'},
            {'D','E','G','H'},
            {'G','H','I'},
            {'E','F','H','I'}
    };
    private static final String []moveClocksString = {
            "ABDE",
            "ABC",
            "BCEF",
            "ADG",
            "BDEFH",
            "CFI",
            "DEGH",
            "GHI",
            "EFHI"
    };
    private static final int [][]matrix = {
           //A,B,C,D,E,F,G,H,I
            {1,1,0,1,1,0,0,0,0}, //1
            {1,1,1,0,0,0,0,0,0}, //2
            {0,1,1,0,1,1,0,0,0}, //3
            {1,0,0,1,0,0,1,0,0}, //4
            {0,1,0,1,1,1,0,1,0}, //5
            {0,0,1,0,0,1,0,0,1}, //6
            {0,0,0,1,1,0,1,1,0}, //7
            {0,0,0,1,1,0,1,1,1}, //8
            {0,0,0,0,1,1,0,1,1}  //9
    };
    public static void main(String[] args) {
        int [][]input = {
                {3, 3, 0},
                {2, 2, 2},
                {2, 1, 2}
        };
        int []rdInput = new int[input.length * input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                rdInput[i*input[i].length+j] = input[i][j];
            }
        }
        System.out.println(Arrays.toString(rdInput));
    }
}
