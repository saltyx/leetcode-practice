package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeSum {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) return result;
            Arrays.sort(nums);
            // 从剩下中寻找nums[i]
            for (int i = 0; i <nums.length-2; i++) {
                // 防止搜索同样的target
                if (i > 0 && nums[i] == nums[i-1]) continue;
                // 寻找nums[i]
                int l = i+1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] + nums[i] == 0) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // 过滤掉重复三元组
                        while (l < r && nums[l + 1] == nums[l]) l++;
                        while (l < r && nums[r - 1] == nums[r]) r--;
                        l++; r--;
                    } else if (nums[l] + nums[r] + nums[i] > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return result;

        }
    }
}
