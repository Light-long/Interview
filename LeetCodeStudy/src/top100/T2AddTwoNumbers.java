package top100;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.

// 两数相加
public class T2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建两个节点head,tail
        ListNode head = null;
        ListNode tail = null;
        // 进位
        int carry = 0;
        // 遍历两个链表,只要一个不为空就继续
        while (l1 != null || l2 != null) {
            int x = l1==null? 0:l1.val;
            int y = l2==null? 0:l2.val;
            int sum = x+y+carry;
            // 如果头结点为空，则新建一个头结点，尾结点也指向头结点
            if (head == null) {
                // 节点值为个位数
                head = new ListNode(sum%10);
                tail = head;
            } else {
                // 创建节点，移动尾结点
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            // 保存进位
            carry = sum/10;
            // 移动l1指针
            if (l1 != null) l1 = l1.next;
            // 移动l2指针
            if (l2 != null) l2 = l2.next;
        }
        // 如果进位不为0，则创建一个节点保存进位
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        // 返回头结点
        return head;
    }
}
