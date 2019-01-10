package bases.sortsearch;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/7.
 *
 */
public class MergeSort {
    public static void main(String []args){
        int []array = {2,4,5,6,7,95,43,23,12};
        int []copy = new int[array.length];
        mergeSort(array,copy,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int[]arrayCopy, int left, int right){
        if(left >= right)return;
        int mid = (left + right)/2;
        mergeSort(array,arrayCopy,left,mid);
        mergeSort(array,arrayCopy,mid + 1,right);
        for (int i = left; i <= right; i++) {
            arrayCopy[i] = array[i];
        }
        int l = left, r = mid + 1;
        for (int i = left; i <= right; i++) {
            if(l == mid + 1){
                array[i] = arrayCopy[r++];
            }else if(r == right + 1){
                array[i] = arrayCopy[l++];
            }else if(arrayCopy[l] > arrayCopy[r]){
                array[i] = arrayCopy[r++];
            }else
//            else if(arrayCopy[l] < arrayCopy[r])
            {
                array[i] = arrayCopy[l++];
            }
        }
    }
}
