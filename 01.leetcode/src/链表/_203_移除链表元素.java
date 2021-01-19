package 链表;
/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 1->2->3->4->5
 * */
public class _203_移除链表元素 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(6);
//        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(4);
//        node.next.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next.next = new ListNode(6);
        System.out.println(node);
        System.out.println(removeElements(node, 1));
    }
    public static ListNode removeElements(ListNode head, int val) {
        // 虚拟头结点
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;
        ListNode preNode = tempNode;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (currentNode.val == val) {
                // 移除
                preNode.next = currentNode.next;
            } else {
                // 不移除
                preNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return tempNode.next;
    }
}
