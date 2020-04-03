	class Solution {
		
	     public int firstMissingPositive(int[] nums) {
	         int min = 1;
	         int len = nums.length;
	         
	         for(int i = 0; i < len; i++) {
	             if(nums[i] <= 0)
	                 nums[i] = len + 1;
	         }
	         
	         log.info("=====>{}", nums);
	         
	         for(int i = 0; i < len; i++) {
	             int num = Math.abs(nums[i]);
	             if(num >= 1 && num <= len) {
	                 if(nums[num - 1] > 0)
	                     nums[num - 1] *= -1;
	             }
	             log.info("=>{}", nums);
	         }
	         
	         log.info("=====>{}", nums);
	        
	         for(; min <= len; min++) {
	             if(nums[min - 1] > 0)
	                 break;
	         }
	         
	         return min;
	     }
		
	}
