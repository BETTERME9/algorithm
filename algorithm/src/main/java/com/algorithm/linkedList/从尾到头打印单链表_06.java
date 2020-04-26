package com.algorithm.linkedList;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description : //从尾到头打印单链表
 * @Author : BETTERME
 */
public class 从尾到头打印单链表_06 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int[] reversePrint(ListNode head) {

        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);;
        for (int i = 0; i < 10; i++) {
            node.next  = new ListNode(i+1);
        }
        System.out.println(node);
    }
}
