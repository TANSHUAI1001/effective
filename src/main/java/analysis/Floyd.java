package analysis;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/22.
 * 计算全部最短路径的Floyd算法
 */
public class Floyd {
    public static void main(String[] args) {

        int [][]A = {
                {0,1,0,0},
                {0,0,0,1},
                {0,0,0,0},
                {1,0,1,0}
        };
        transferClosure(A);
        traversal(A);


        int  infinity = Integer.MAX_VALUE/2;
        int [][] W = {
                {0,infinity,3,infinity},
                {2,0,infinity,infinity},
                {infinity,7,0,1},
                {6,infinity,infinity,0}
        };
        completelyShortestPath(W);
        traversal(W);

    }

    public static void traversal(int [][]array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println("\n");
    }
    public static void transferClosure(int [][]A){
        for (int k = 0; k < A.length; ++k) {
            for (int i = 0; i < A.length; ++i) {
                for (int j = 0; j < A.length; ++j) {
                   A[i][j] = A[i][j] | (A[i][k] & A[k][j]);
                }
            }
        }
    }

    public static void completelyShortestPath(int [][]W){
        for (int k = 0; k < W.length; ++k) {
            for (int i = 0; i < W.length; ++i) {
                for (int j = 0; j < W.length; ++j) {
                    W[i][j] = Math.min(W[i][j], W[i][k] + W[k][j]);
                }
            }
        }
    }
}
