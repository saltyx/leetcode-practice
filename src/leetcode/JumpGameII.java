class Solution {
	final int MAX = 999999;
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;

        int[] dp = new int[nums.length+1];
        for (int i=0; i<dp.length; ++i) {
            dp[i] = MAX;
            if (i == nums.length-1) dp[i] = 0;
        }

        for (int i=nums.length-2; i>=0; --i) {
            int min = MAX;
            for (int j = 1; j<= nums[i]; ++j) {
                if (i+j < nums.length) {
                    min = Math.min(dp[i+j]+1, min);
                }
            }
            dp[i] = min;
        }

        return dp[0];
    }
}
