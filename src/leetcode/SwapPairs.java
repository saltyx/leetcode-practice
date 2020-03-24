class Solution {

    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextStart = head;
        ListNode prevEnd = head;
        int t = 1;
        while (t <= k) {
            prevEnd = nextStart;
            nextStart = nextStart.next;
            ++t;
        }

        prevEnd.next = null;
        List<ListNode> result = reverse(head);
        head = result.get(0);
        prevEnd = result.get(1);

        while(nextStart != null) {
            ListNode curEd = nextStart;
            ListNode nextSt = nextStart;
            t = 1;
            while (t<=k && nextSt != null) {
                curEd = nextSt;
                nextSt = nextSt.next;
                ++t;
            }
            if (t > k) {
                curEd.next = null;
                result = reverse(nextStart);
                prevEnd.next = result.get(0);
                prevEnd = result.get(1);
            } else {
                // last
                prevEnd.next = nextStart;
            }
            nextStart = nextSt;
        }

        return head;
    }

    List<ListNode> reverse(ListNode head) {

        ListNode tmp = head;
        ListNode next = tmp.next;
        ListNode prev = head;
        while(tmp != null) {
            tmp.next = prev;
            prev = tmp;
            tmp = next;
            if (next != null) {
                next = next.next;
            }
        }

        head.next = null;

        return Arrays.asList(prev, head);
    }
}
