package top100;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例 1：
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//

// 合并两个有序链表
public class T21MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        // 遍历两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                // pre指向l1
                pre.next = l1;
                // l1指向下一个节点比较
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            // pre指向连接到的新节点
            pre = pre.next;
        }
        // 判断那一个为空，另一个直接连接到pre节点
        pre.next = (l1 == null) ? l2:l1;
        return dummy.next;
    }
}
