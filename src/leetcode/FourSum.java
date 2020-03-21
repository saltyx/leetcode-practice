package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 4) return result;
            Arrays.sort(nums);
            int goal = target;
            for (int k = 0; k <nums.length-3; k++) {
                if (k>0 && nums[k] == nums[k-1]) continue;
                target = goal - nums[k];
                for (int i = k+1; i <nums.length-2; i++) {
                    // 防止搜索同样的target
                    if (i > k+1 && nums[i] == nums[i-1]) continue;
                    // 寻找nums[i]
                    int l = i+1;
                    int r = nums.length - 1;
                    while (l < r) {
                        if (nums[l] + nums[r] + nums[i] == target) {
                            result.add(Arrays.asList(nums[i], nums[l], nums[r], nums[k]));
                            // 过滤掉重复三元组
                            while (l < r && nums[l + 1] == nums[l]) l++;
                            while (l < r && nums[r - 1] == nums[r]) r--;
                            l++; r--;
                        } else if (nums[l] + nums[r] + nums[i] > target) {
                            r--;
                        } else {
                            l++;
                        }
                    }
                }
            }

            return result;

        }
    }
}
