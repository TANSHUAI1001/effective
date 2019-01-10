package bases.sortsearch;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/7.
 */
public class HeapSort {
    public static void main(String []args){
        int[] array = {46,79,56,38,40,84};
        heapSort(array);
//        popRoot(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] arrays){
        buildHeap(arrays,arrays.length);
        for (int right = arrays.length; right > 0; right--) {
            /**
             * 建堆的时间复杂度为O(n)
             * 若是如此循环buildHeap(arrays,right)则为O(n^2)
             * maxHeapify的时间复杂度为O(log2 n)
             * 则此循环的时间复杂度为O(n log2 n)
             * 加上外层builHeap的O(n),总的时间复杂度为O(n log2 n)
             */
            swap(arrays,0,right - 1);
            maxHeapify(arrays,0,right - 1);
        }
    }

    public static void maxHeapify(int []arrays, int index, int len){
        if(len <= 1) return;
        int l = left(index);
        int r = right(index);
        int largest = index;
        while (true){
            if(l < len && arrays[l] > arrays[largest]){
                largest = l;
            }
            if(r < len && arrays[r] > arrays[largest]){
                largest = r;
            }
            if( largest != index){
                swap(arrays,index,largest);
            }else {
                break;
            }
            index = largest;
            l = left(index);
            r = right(index);
        }
    }
    public static void buildHeap(int[] arrays,int len){
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeapify(arrays,i,len);

//            int l = left(i);
//            int r = right(i);
//            int largest = i;
//            while (true){
//                if(l < len && arrays[l] > arrays[largest]){
//                    largest = l;
//                }
//                if(r < len && arrays[r] > arrays[largest]){
//                    largest = r;
//                }
//                if( largest != i){
//                    swap(arrays,i,largest);
//                }else {
//                    break;
//                }
//                i = largest;
//                l = left(i);
//                r = right(i);
//            }
        }
    }

    public static void popRoot(int[] arrays){
        for (int right = arrays.length; right > 0; right--) {
            /**
             * 建堆的时间复杂度为O(n)
             * 若是如此循环则为O(n^2)
             */
            buildHeap(arrays,right);
            swap(arrays,0,right - 1);
        }


    }

    public static int left(int i){
        return 2 * i + 1;
    }

    public static int right(int i){
        return 2 * i + 2;
    }

    public static void swap(int []nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
