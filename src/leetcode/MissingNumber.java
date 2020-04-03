class Solution {

    public int missingNumber(int[] nums) {
        boolean extend = false;
        for (int i=0; i<nums.length; ++i) {

            int idx = nums[i] < 0 ? (-nums[i]-1) : nums[i];
            if (idx == nums.length) {
                extend = true;
            } else {
                nums[idx] = -(nums[idx]+1);
            }
        }

        for (int i=0; i<nums.length; ++i) {
            if (nums[i] >= 0) {
                return i;
            }
        }

        if (!extend) {
            return nums.length;
        }

        return -1;
    }
}
