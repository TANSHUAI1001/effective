package analysis;

/**
 * Created by shuai on 2017/2/22.
 * 计算二项式系数
 */
public class Binomial {
    public static void main(String[] args) {
        System.out.println(c(5,3));
    }

    /**
     * 输入非负整数 n >= k >= 0，
     * 当 n > k > 0时，C(n,k) = C(n-1,k-1) + C(n-1,k),
     * C(n,0) = C(n,n) = 1
     * @param n
     * @param k
     * @return C(n,k)
     */
    public static int c(int n, int k){
        int [][] array = new int[n+1][k+1];
//        int [][] array = new int[n+1][n+1]; //生成完全表的定义数组大小
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= Math.min(i,k); ++j) { //优化，不继续计算超过k的系数
//            for (int j = 0; j <= i; ++j) { //生成完全表
                if(j == i || j == 0){
                    array[i][j] = 1;
                }else {
                    array[i][j] = array[i-1][j-1] + array[i-1][j];
                }
            }
        }
        return array[n][k];
    }
}
