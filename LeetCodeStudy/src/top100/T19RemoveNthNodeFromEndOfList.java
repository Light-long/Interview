package top100;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//

// 删除链表的倒数第n个节点
// two points
public class T19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy节点的next指向head
        ListNode dummy = new ListNode(0,head);
        // two points
        ListNode first = head;
        // 慢指针指向dummy节点
        ListNode second = dummy;
        // 快指针先走n步，然后一起走（有可能只有一个节点所以不能走n+1步）
        // 当快指针为null时，慢指针指向的是倒数第n的前一个节点
        for (int i=0;i<n;i++) first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // remove
        second.next = second.next.next;
        return dummy.next;
    }
}
