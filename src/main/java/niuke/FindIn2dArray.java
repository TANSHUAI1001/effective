package niuke;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

/**
 * Created by shuai on 2018/4/3.
 */
public class FindIn2dArray {
    public static void main(String[] args) {
//        int [][] array = {
//                {1,2,8,9},
//                {2,4,9,12},
//                {4,7,10,13},
//                {6,8,11,15}
//        };
//        int target = 7;
//        System.out.println(Find1(target,array));
        System.out.println(~9);
    }

    static boolean  Find(int target, int [][]array){
        int i = 0,j = 0;
        for(;i < array.length - 1;){
            if(array[i][0] < target && array[i+1][0] > target){
                break;
            }else if(array[i][0] == target || array[i+1][0] == target){
                return true;
            }else{
                i++;
            }
        }
        for(;i > 0 && j < array[i].length - 1;){
            if(array[i][j] < target && array[i][j+1] > target){
                i--;
            }else if (array[i][j] == target || array[i][j+1] == target){
                return true;
            }else{
                j++;
            }
        }
        return false;
    }
    /* 思路
    * * 矩阵是有序的，从左下角来看，向上数字递减，向右数字递增，
    * * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
    * * 要查找数字比左下角数字小时，上移
    * */
    static boolean Find1(int target, int [][]array){

        for (int i = array.length - 1, j = 0; i >= 0 && j < array[0].length ;) {
            if(array[i][j] == target){
                return true;
            }else if (array[i][j] < target){
                j++;
            }else if (array[i][j] > target){
                i--;
            }
        }
        
        return false;
    }
}
