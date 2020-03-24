	class Solution {
	
	    public boolean isMatch(String s, String p) {
	    	if (p.equals("")) {
	    		return s.equals("");
	    	}
	    	
	    	return match(s.toCharArray(), s.length(), p.toCharArray(), p.length());
	    }
	    
	    public boolean match(char[] s, int i, char[] p, int j) {
	    	boolean[][] dp = new boolean[i+1][j+1];
	    	dp[i][j] = true;
	    	for (int jj = j-1; jj>=0; --jj) {
	    		if (p[jj] == '*') {
	    			dp[i][jj] = dp[i][jj+1];
	    		}
	    	}
	    	
	    	for (int k=i-1; k>=0; --k) { // i
	    		for (int t=j-1; t>=0; --t) { // j
	    			if (s[k]== p[t] || p[t] == '?') {
	    				dp[k][t] = dp[k+1][t+1];
	    			} else {
	    				if (p[t] == '*') {
	    					dp[k][t] = dp[k+1][t+1] || dp[k][t+1] || dp[k+1][t];
	    				} else {
	    					dp[k][t] = false;
	    				}
	    			}
	    		}
	    	}
	    	
	    	return dp[0][0];
	    }
	}
