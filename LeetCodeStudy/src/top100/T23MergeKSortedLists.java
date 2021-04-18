package top100;

// 合并k个升序链表
public class T23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i=0;i<lists.length;i++) {
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }

    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1==null ? l2:l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        // 合并剩下的链表
        pre.next = (l1 == null) ? l2:l1;
        return dummy.next;
    }
}
