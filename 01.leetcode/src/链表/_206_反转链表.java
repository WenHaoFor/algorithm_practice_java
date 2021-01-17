package 链表;
/*
* https://leetcode-cn.com/problems/reverse-linked-list/
* 输入: 1->2->3->4->5->NULL
* 输出: 5->4->3->2->1->NULL
* */
public class _206_反转链表 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = null;
        reverseList1(node.next.next.next.next);
        System.out.println(node);
        System.out.println(reverseList1(node));
        System.out.println(reverseList2(node));
    }

    // 递归
    public static ListNode reverseList1(ListNode head) {
        /**
         * 思路：
         * 1、如果原链表是：5 - 4 - 3 - 2 - 1 - null，传入的头结点是5
         * 2、那么调用了 reverseList1(head.next) 返回的是 1 - 2 - 3 - 4 - null
         * 3、所以只需要将 4 的 next 指向 5，5 的 next 指向 null
         * */
        if (head == null || head.next == null) return head;
        ListNode newNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    // 非递归
    public static ListNode reverseList2(ListNode head) {
        /**
         * 思路：
         * 1、先将新的头节点指向 null，然后将临时节点指向 head.next
         * 2、将原头结点的 next 指向新的头结点，再将原头结点赋值给新的头结点
         * 3、然后将临时节点赋值给原头结点
         * */
        if (head == null || head.next == null) return head;
        ListNode newNode = null;
        while (head != null) {
            ListNode tempNode = head.next;
            head.next = newNode;
            newNode = head;
            head = tempNode;
        }
        return newNode;
    }
}
