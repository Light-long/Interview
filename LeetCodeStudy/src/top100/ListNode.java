package top100;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val,ListNode node) {
        this.val = val;
        this.next = node;
    }
}
