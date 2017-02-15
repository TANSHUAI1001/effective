package LeetCode;

import java.util.Stack;

/**
 * Created by shuai on 2017/2/5.
 * 84. Largest Rectangle in Histogram
 */
public class largestRectangleAreaSolution {
    public static void main(String args[]){
//        int []heights = {2,1,5,6,2,3};
//        int []heights = {6,2,5,4,5,1,6};
        int []heights = {9,11,12,10};
        int result = largestRectangleAreaCorrect(heights);
        System.out.println("largest : "+result);
    }
    public static int largestRectangleAreaCorrect(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                int area = height[tp] * (s.isEmpty() ? i : i - 1 - s.peek());
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
        int largest = 0;
        int size = heights.length;
        for (int i = 0; i < size; i++) {
            int minHeight = heights[i];
            int area = minHeight;
            largest = largest > area ? largest : area;
            for (int j = i - 1; j >= 0; j--) {
                minHeight = minHeight > heights[j] ? heights[j]:minHeight;
                area = (i - j + 1) * minHeight;
                largest = largest > area ? largest : area;
            }
        }
        return largest;
    }
}
