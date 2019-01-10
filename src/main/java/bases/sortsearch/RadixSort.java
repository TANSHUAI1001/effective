package bases.sortsearch;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/7.
 */
public class RadixSort {
    public static void main(String []args){
//        int []array = {135,242,192,93,345,11,24,19};
        int []array = {1,2,9,3,4,1,4,9};
        radixSort(array,1);
        System.out.println(Arrays.toString(array));
    }

    public static void radixSort(int []array, int radix){
        int [][]temp = new int[10][array.length];
        int []len = new int[10];
        for(int item:array){
            temp[(item/radix)%10][len[(item/radix)%10]++] = item;
        }

        if(len[0] < array.length){
            int index = 0;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < len[i]; j++) {
                    array[index++] = temp[i][j];
                }
                if(index >= array.length){
                    break;
                }
            }

            radix *= 10;
            radixSort(array, radix);
        }

    }
}
