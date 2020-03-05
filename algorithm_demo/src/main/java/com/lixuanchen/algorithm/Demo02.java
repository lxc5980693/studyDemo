package com.lixuanchen.algorithm;

/**
 * @ProjectName: algorithm_demo
 * @Package: com.lixuanchen.algorithm
 * @ClassName: Demo02
 * @Author: lixuanchen
 * @Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Date: 2020-02-05  18:53
 * @Version: 1.0
 */
public class Demo02 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        ListNode l2_1 = new ListNode(9);
        l2.next = l2_1;
        ListNode listNode = addTwoNumbers(l1, l2);
        StringBuffer stringBuffer = new StringBuffer();
        while(listNode != null){
            stringBuffer.append(listNode.val + "->");
            listNode = listNode.next;
        }
        stringBuffer.delete(stringBuffer.lastIndexOf("-"),stringBuffer.length());
        System.out.println(stringBuffer.toString());
    }

    /**
     * 循环ListNode中的val值，注意进位
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int needAddNum = 0;
        ListNode listNode = null;
        ListNode temp = null;
        while (l1 != null || l2 != null || needAddNum != 0){
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int newValue = v1 + v2 + needAddNum;
            int v3 = newValue % 10;
            needAddNum = newValue / 10;
            ListNode listNode1 = new ListNode(v3);
            if (listNode == null){
                listNode = listNode1;
            }else if (temp == null){
                listNode.next = listNode1;
                temp = listNode1;
            }else {
                temp.next = listNode1;
                temp = listNode1;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return listNode;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
