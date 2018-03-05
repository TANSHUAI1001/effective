package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shuai on 2017/3/2.
 * 131. Palindrome Partitioning
 * Backtracking or DP
 */
public class partitionSolution {
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public static void main(String[] args) {
        String s = "12221";

        partitionSolution p = new partitionSolution();
        List<List<String>> res = p.partition(s);
        for (List<String> item:res) {
            System.out.println(Arrays.toString(item.toArray()));
        }

    }

    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }

    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
                && l>=s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int l,int r){
        if(s == null || s.length() == 0) return false;
        for (int i = l,j = r; i <= j; ++i,--j) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
