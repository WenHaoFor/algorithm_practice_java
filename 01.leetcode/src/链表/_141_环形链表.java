package 链表;
/*
* https://leetcode-cn.com/problems/linked-list-cycle/
* 输入：head = [3,2,0,-4], pos = 1
* 输出：true
* 解释：链表中有一个环，其尾部连接到第二个节点。
* pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环
* */
public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        /**
         * 思路：快慢指针
         * 1、慢指针指向head，一次走一步；快指针指向 head.next，一次走两步
         * 2、如果快慢指针相遇则有环，或者快指针先指向null则无环
         * */
        if (head == null || head.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) return true;
        }
        return false;
    }
}
