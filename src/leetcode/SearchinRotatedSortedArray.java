class Solution {

    public int search(int[] nums, int target) {
        int idx = findFlag(nums);
        if (idx == -1) {
            // 正常二分查找
            return biSearch(nums, 0, nums.length-1, target);
        } else {
            if (nums[idx] == target) {
                return idx;
            } else {
                // 分两个二分查找
                int l = biSearch(nums, 0, idx-1, target);
                int r = biSearch(nums, idx+1, nums.length-1, target);

                return l == -1 ? r : l;
            }
        }
    }

    public int biSearch(int[] nums, int l, int r, int target) {
        if (l > r){
            return -1;
        }

        if (l >= nums.length) {
            return -1;
        }

        if (l == r) {
            return nums[l] == target ? l : -1;
        }
        int k = (l+r)/2;
        if (nums[k] == target) {
            return k;
        }
        if (target < nums[k]) {
            int tmp = biSearch(nums, l, k-1, target);
            if (tmp != -1)
                return tmp;
        } else {
            int tmp = biSearch(nums, k+1, r, target);
            if (tmp != -1)
                return tmp;
        }
        return -1;
    }

    public int findFlag(int[] nums) {

        for (int i=1; i<nums.length; ++i) {
            if (nums[i] < nums[i-1]) {
                return i;	    		}
        }

        return -1;
    }

}
