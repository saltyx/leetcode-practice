class Solution {
        public void nextPermutation(int[] nums) {

            if (nums == null || nums.length <= 1) {
                return;
            }

            for (int i=nums.length-2; i>=0; --i) {
                if (nums[i] < nums[i+1]) {
                    int j = nums.length-1;
                    for (j=nums.length-1; j>i; --j) {
                        if (nums[j] > nums[i]) {
                            break;
                        }
                    }
                    swap(nums, i, j);
                    reverse(nums, i+1, nums.length-1);
                    return;
                }
            }
            reverse(nums, 0, nums.length-1);
        }

        public void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
        public void reverse(int[] nums, int a, int b) {
            for (int i=a; i<=(a+b)/2; ++i) {
                swap(nums, i, a+b-i);
            }
        }
    }
