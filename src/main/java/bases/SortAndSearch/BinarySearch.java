package bases.SortAndSearch;

/**
 * Created by shuai on 2017/2/7.
 */
public class BinarySearch {
    public static void main(String []args){
        int []orderedArray = {1,3,5,7,9,10,12,13,15};
        int low = 0;
        int high = orderedArray.length - 1;
        System.out.println(binarySearch(0,orderedArray,low,high));
    }
    public static int binarySearch(int target, int []orderedArray,int low, int high){
        int mid = (low + high)/2;
        if(orderedArray[mid] == target){
            return mid;
        }else if(orderedArray[mid] > target && mid - 1 >=low){
            return binarySearch(target,orderedArray,low,mid-1);
        }else if(orderedArray[mid] < target && mid + 1 <= high){
            return binarySearch(target,orderedArray,mid+1,high);
        }else {
            return -1;
        }

    }
}
