class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] source = text1.length() > text2.length() ? text1.toCharArray() : text2.toCharArray();
        char[] target = text1.length() > text2.length() ? text2.toCharArray() : text1.toCharArray();

        int[][] dp = new int[source.length+1][target.length+1];

        for (int i=source.length-1; i>=0; --i) {
            for (int j=target.length-1; j>=0; --j) {
                if (source[i] == target[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(Math.max(dp[i+1][j+1], dp[i][j+1]), dp[i+1][j]);
                }
            }
        }

        return dp[0][0];
    }
}