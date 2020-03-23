	class Solution {
	
	    public boolean isMatch(String s, String p) {
	        
	    	if (p.equals(".*")) {
	    		return true;
	    	}
	    	
	    	if (p.equals("")){
	    		return s.equals("");
	    	}
	    	
    		return match((s + "#").toCharArray(), 0, p.toCharArray(), 0);
	
	    }
	    
	    public boolean match(char[] s, int sIdx, char[] p, int pIdx, boolean... needReadNextP) {
	    	if (sIdx < s.length && s[sIdx] == '#') {
	    		// 匹配结束
	    		if (pIdx == p.length) return needReadNextP.length == 0;
	    		
	    		if (p[pIdx] == '*' && pIdx == p.length-1) return true;
	    	}
	    	
	    	if (sIdx >= s.length) {
	    		return pIdx >= p.length;
	    	}
	    	
	    	if (pIdx >= p.length) {
	    		return s[sIdx] == '#';
	    	} 
	    	
	    	if (needReadNextP.length > 0 && needReadNextP[0]) {
	    		if (p[pIdx] == '*') {
    				return match(s, sIdx, p, pIdx+1);
	    		}
	    		
	    		return false;
	    	}
	    	
	    	if (s[sIdx] == p[pIdx] || (p[pIdx] == '.' && s[sIdx] != '#')) {
	    		return !match(s, sIdx+1, p, pIdx+1) ? match(s, sIdx, p, pIdx+1, true) : true;
	    	} else {
	    		if (p[pIdx] == '*') {
	    			if (s[sIdx] != p[pIdx-1] && (p[pIdx-1] != '.' || s[sIdx] == '#'))
	    				return match(s, sIdx, p, pIdx+1);
	    			else 
	    				return !match(s, sIdx+1, p, pIdx+1) ? (!match(s, sIdx+1, p, pIdx) ? match(s, sIdx, p, pIdx+1) : true)
	    						: true;
	    		} else {
	    			return match(s, sIdx, p, pIdx+1, true);
	    		}
	    	}
	    }
	}
