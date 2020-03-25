class Solution {


    Map<Integer, Boolean> flag = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        dfs(nums, result, tmp);

        return new ArrayList<List<Integer>>(result);
    }

    public void dfs(int[] nums, Set<List<Integer>> result,
            List<Integer> tmp) {
        if (tmp.size() >= nums.length) {
            result.add(tmp);
            return;
        }
        for (int i=0; i<nums.length; ++i) {
            if (flag.get(i) != null && flag.get(i)) {
                continue;
            }
            List<Integer> reserved = new ArrayList<>(tmp);
            tmp.add(nums[i]);
            flag.put(i, true);

            dfs(nums,  result, tmp);
            flag.put(i, false);
            tmp = reserved;
        }
    }

}
