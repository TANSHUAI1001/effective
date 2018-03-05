package bases.SortAndSearch;

import leetcode.ListNode;

/**
 * Created by shuai on 2017/2/7.
 */
public class InsertSort {
    /**
     * Definition for singly-linked list.
     * 147. Insertion Sort List
     */

    public static void main(String []args){
//        int[] array = {46,79,56,38,40,84};
//        insertSort(array);
//        System.out.println(Arrays.toString(array));
        Test();

    }
    public static void Test(){
        ListNode head = new ListNode(29);
        ListNode one = new ListNode(25);
        head.next = one;

        ListNode two = new ListNode(23);
        one.next = two;

        two.next = new ListNode(26);
//        ListNode three = new ListNode(21);
//        two.next = three;
//        ListNode four = new ListNode(33);
//        three.next = four;

        ListNode node = insertionSortList(head);
        ListNode curr = node;
        while (curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }


    }
    public static ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0 ; j--) {
                if(array[j] > temp){
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
