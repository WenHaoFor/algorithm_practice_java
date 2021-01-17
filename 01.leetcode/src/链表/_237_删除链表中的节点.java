package 链表;
/*
* https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
* 输入：head = [4,5,1,9], node = 5
* 输出：[4,1,9]
* 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
* */
public class _237_删除链表中的节点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        deleteNode(node.next);
        System.out.println(node);
    }
    public static void deleteNode(ListNode node) {
        /**
         * 思路：
         * 1、将当前节点的下一个节点的值赋给当前节点
         * 2、将当前节点的next指向下个节点的下个节点
         * */
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
