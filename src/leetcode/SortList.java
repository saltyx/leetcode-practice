class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        int[] arr = new int[len];
        tmp = head;
        int idx = 0;
        while (tmp != null) {
            arr[idx++] = tmp.val;
            tmp = tmp.next;
        }

        sort(arr, 0, len-1);

        tmp = head;
        idx = 0;
        while (tmp != null) {
            tmp.val = arr[idx++];
            tmp = tmp.next;
        }

        return head;
    }

    public void sort(int[] a, int start, int end) {
        if (end <= start) {
            return;
        }

        int middleIndex = (start+end)/2;
        int middleValue = a[middleIndex];
        int left = start;
        int right = end-1;
        swap(a, middleIndex, end);

        while (left < right) {
            while (a[left] <= middleValue && left < right) left++;
            while (a[right] > middleValue && left < right) right--;
            swap(a, left, right);
        }

        if (a[left] > middleValue) {
            swap(a, left, end);
        } else if (a[left] < middleValue) {
            swap(a, ++left, end);
        }

        sort(a, start, left-1);
        sort(a, left+1, end);
    }

    public void swap(int[]a , int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
