package bases.sortsearch;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/7.
 */
public class QuickSort {
    public static void main(String args[]){
//        int []nums = {1,5,6,3,2,4};
        int []nums = {1,5,3,2,4,6,7,3,3,4};
//        swap(nums,0,1);
        standardQuickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int []nums){
        int len = nums.length;
        noSwapPartition(nums,0,len-1);
    }

    public static void noSwapPartition(int []nums,int left,int right){
        if (right <= left){
            return;
        }
        int low = left;
        int hight = right;
        int key = nums[low];

        while (low < hight){
            while ((low < hight)&&(key < nums[hight])){
                hight--;
            }
            nums[low] = nums[hight];
            while ((low < hight)&&(key > nums[low])){
                low++;
            }
            nums[hight] = nums[low];
        }
        nums[low] = key;
        noSwapPartition(nums,left,low - 1);
        noSwapPartition(nums,low + 1,right);

    }
    public static void partition(int []nums,int left,int right){
        if (right <= left){
            return;
        }
        int pivot = right;
        int pivotValue = nums[pivot];
        for (int i = left,j = right; i < j;) {
            if(pivot > i){
                if(nums[i] > pivotValue){
                    swap(nums,i,pivot);
                    pivot = i;
                    j--;
                }else {
                    i++;
                }
            }else if(pivot < j){
                if(nums[j] < pivotValue){
                    swap(nums,j,pivot);
                    pivot = j;
                    i++;
                }else{
                    j--;
                }
            } else{
                System.out.println("..");
            }
        }
        partition(nums,left,pivot - 1);
        partition(nums,pivot + 1,right);

    }

    public static void swap(int []nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * my cpp quick sort convert
     *
     */
    public static void standardQuickSort(int[] array, int l, int r){
        if(l == r) return;
        int index = standardPartition(array,l,r);
        if(index > l) standardQuickSort(array,l,index-1);
        if(index < r) standardQuickSort(array,index+1,r);
    }

    public static int standardPartition(int[] array, int left, int right){
        // 以最右边为基准
        int small = left - 1;
        for (int i = left; i < right; ++i) {
            if(array[i] < array[right]){
                ++small;
                if(small != i){
                    swap(array,i,small);
                }
            }
        }
        swap(array,++small,right);
        return small;
    }

}
