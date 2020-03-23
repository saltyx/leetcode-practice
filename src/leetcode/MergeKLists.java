public class MergeKLists {

	public static void main(String[] args) {
		Solution s = new Solution();


	}

	static public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	static class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
	    	if (lists == null || lists.length == 0)
	    		return null;
	    	if (lists.length == 1)
	    		return lists[0];
	    	if (lists.length == 2)
	    		return mergeTwoLists(lists[0], lists[1]);
	    	List<ListNode>list = new ArrayList<>();
	    	list.addAll(Arrays.asList(lists));
	    	return merge(list);
	    	
	    }
	    
	    public ListNode merge(List<ListNode> lists) {
	    	int len = lists.size();
	    	int l = 0;
	    	int r = len / 2;
	    	if (len == 1) {
	    		return lists.get(0);
	    	}
	    	if (len == 2) 
	    		return mergeTwoLists(lists.get(0), lists.get(1));
	    	ListNode llist = merge(lists.subList(l, r));
	    	ListNode rlist = merge(lists.subList(r, len));
	    	
	    	return mergeTwoLists(llist, rlist);
	    }
	    
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        	if (l1 == null) {
				return l2;
			} 
			if (l2 == null) {
				return l1;
			}
			
			ListNode head = null;
			
			if (l1.val < l2.val) {
				head = l1;
				l1 = l1.next;
			} else {
				head = l2;
				l2 = l2.next;
			}
			
			ListNode tmp = head;
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					tmp.next = l1;
					tmp = l1;
					l1 = l1.next;
				} else {
					tmp.next = l2;
					tmp = l2;
					l2 = l2.next;
				}
			}
			
			if (l1 == null) {
				tmp.next = l2;
			} else {
				tmp.next = l1;
			}
			
			return head;
		}
	}
}
