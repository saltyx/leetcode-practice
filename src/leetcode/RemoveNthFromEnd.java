package leetcode;

public class RemoveNthFromEnd {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || (head.next == null && n == 1))
                return null;
            ListNode tmp = head;
            ListNode prev = head;
            if (n == 1) {
                while (tmp.next != null) {
                    prev = tmp;
                    tmp = tmp.next;
                }
                prev.next = null;
                return head;
            }

            int len = 0;
            tmp = head;
            while (tmp != null) {
                len++;
                tmp = tmp.next;
            }

            if (len == n) {
                return head.next;
            }

            tmp = head;
            int idx = 1;
            while (idx < len-n) {
                idx++;
                tmp = tmp.next;
            }

            tmp.next = tmp.next.next;
            return head;
        }
    }
}
