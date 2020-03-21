package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSumClosest {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{1,1,-1,-1, 3}, -1));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int result = Integer.MAX_VALUE;
            int diff = Integer.MAX_VALUE;
            if (nums == null) return 0;
            if (nums.length == 1) {
                return nums[0];
            }
            if (nums.length == 2) {
                return nums[0] + nums[1];
            }

            Arrays.sort(nums);
            for (int i = 0; i <nums.length-2; i++) {
                // 防止搜索同样的target
                if (i > 0 && nums[i] == nums[i-1]) continue;
                int l = i+1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[l] + nums[r] + nums[i];
                    if (sum == target) {
                        return sum;
                    }
                    if (sum> target) {
                        r--;
                    } else {
                        l++;
                    }
                    if (diff > Math.abs(sum - target)) {
                        diff = Math.abs(sum - target);
                        result = sum;
                    }
                }
            }
            return result;

        }
    }
}
