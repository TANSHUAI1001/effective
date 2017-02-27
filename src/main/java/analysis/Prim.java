package analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuai on 2017/2/23.
 * 最小生成树
 */
public class Prim {
    public static void main(String[] args) {
        int  infinity = Integer.MAX_VALUE/2;
//        int [][]matrix = {
//                //a,b,c,d
//                {0,1,5,2},//a
//                {1,0,infinity,infinity},//b
//                {5,infinity,0,3},//c
//                {2,infinity,3,0}//d
//        };
        int [][]matrix = {
                //a,b,c,d,e,f
                {0,3,infinity,infinity,6,5},
                {3,0,1,infinity,infinity,4},
                {infinity,1,0,6,infinity,4},
                {infinity,infinity,6,8,5},
                {6,infinity,infinity,8,2},
                {5,4,4,5,2,0}
        };

        Prim prim = new Prim();
        matrix = prim.prim(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public int[][] prim(int [][]G){
        ArrayList<Integer> tree = new ArrayList<>();
        ArrayList<Integer> rest = new ArrayList<>();
        int [][]matrix = new int[G.length][G.length];
        for (int i = 0; i < G.length; i++) {
            rest.add(i);
        }
        while (!rest.isEmpty()){
            if(tree.isEmpty()){
                int item = rest.get(0);
                tree.add(item);
                rest.remove(item);
            }
            int adjacentX = -1;
            int adjacentY = -1;
            int min = Integer.MAX_VALUE/2;
            for (int x:tree) {
                for (int y:rest) {
                    if(G[x][y] < min){
                        min = G[x][y];
                        adjacentX = x;
                        adjacentY = y;
                    }
                    //min = G[x][y] < min ? G[x][y] : min;
                }
            }
            if(adjacentX != -1 && adjacentY != -1){
                tree.add(adjacentY);
                rest.remove((Integer) adjacentY);
                //注意将int封装成Integer（Object）类型，否则可能数组越界
                //remove 有两个方法,E remove(Object o),boolean remove(int index)
                if(adjacentX > adjacentY){
                    matrix[adjacentY][adjacentX] = min;
                }else {
                    matrix[adjacentX][adjacentY] = min;
                }

            }
        }

        return matrix;
    }
}
