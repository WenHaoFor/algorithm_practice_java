package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 输入: 1->1->2->3->3
 * 1->2->3
 * */
public class _83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(1);
        System.out.println(node);
        System.out.println(deleteDuplicates(node));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }
}
