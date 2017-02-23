package analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuai on 2017/2/22.
 */
public class MFKnapsack {
    private int [][]v;
    private int []weights;
    private int []values;
    private List<Integer> index = new ArrayList<>();

    public MFKnapsack(int []weights, int []values, int n, int w){
        this.weights = weights;
        this.values = values;
        this.v = new int[n+1][w+1];
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                if(i == 0 || j == 0) v[i][j] = 0;
                else v[i][j] = -1;
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int w = 7;
        int []weights = {2,1,3,2};
        int []values = {12,10,20,15};
        MFKnapsack mfKnapsack = new MFKnapsack(weights,values,n,w);

        //自顶向下的解法导致不止一次地解公共子问题，时间效率低
        //经典解法：自底向上的解法，将子问题的解记录在表中
        int maxValue = mfKnapsack.knapsack(n,w);

        //TODO 记忆功能
        //记忆功能法相比于自底向上，空间效率低

        System.out.println(maxValue);
        System.out.println(Arrays.toString(mfKnapsack.getIndex().toArray()));

    }

    public List<Integer> getIndex(){
        if(v.length < 1) return this.index;
        int i = v.length - 1,j = v[0].length - 1;
        while (i > 0 && j > 0){
            if(v[i][j] != v[i-1][j] && j >= weights[i-1]){
                index.add(i);
                j -= weights[i-1];
            }
            --i;
        }
        return this.index;
    }

    public int knapsack( int n, int w){
        int value;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= w; ++j) {
                if(v[i][j] < 0){
                    if (j < weights[i-1])
                        value = knapsack(i-1,j);
                    else {
                        value = Math.max(knapsack(i-1,j),
                                values[i-1]+knapsack(i-1,j-weights[i-1]));
                    }
                    v[i][j] = value;
                }
            }
        }
        return v[n][w];
    }

    public int knapsackMemory(){
        //TODO i don't know how to do yet !
        return 0;
    }

}
