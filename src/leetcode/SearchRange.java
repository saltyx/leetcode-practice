class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        }

        int idx = biSearch(nums, 0, nums.length-1, target);
        if (idx == -1) {
            return new int[]{-1,-1};
        }
        int st = idx;
        int ed = idx;
        while (st > 0 && nums[--st] == target);
        while (ed < nums.length-1 && nums[++ed] == target);
        // 边界，当最后一个值不相等的时候也可同时满足ed >= nums.length-1
        st = st > 0 ? st+1 : nums[0] == target ? 0 : 1;
        ed = ed < nums.length-1 ? ed-1 :nums[nums.length-1] == target ? nums.length-1 : nums.length-2;
        return new int[]{st, ed};

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
}
