class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        return mergeSort(head, len);
    }

    public ListNode mergeSort(ListNode head, int len) {
        if (len == 1) return head;

        int middleIndex = len/2;
        ListNode tmp = head;
        int idx = 0;
        ListNode prev = head;
        while (idx < middleIndex) {
            prev = tmp;
            tmp = tmp.next;
            idx++;
        }

        ListNode head2 = tmp;
        prev.next = null;

        ListNode l1 = mergeSort(head, middleIndex);
        ListNode l2 = mergeSort(head2, len-middleIndex);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head;
        if (l1.val > l2.val) {
            head = l2; 
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }
        ListNode iterator = head;
        while (true) {
            if (l1 == null) {
                iterator.next = l2;
                break;
            } else if (l2 == null) {
                iterator.next = l1;
                break;
            }

            if (l1.val > l2.val) {
                iterator.next = l2;
                l2 = l2.next;
            } else {
                iterator.next = l1;
                l1 = l1.next;
            }

            iterator = iterator.next;
        }
        return head;
    }

}
