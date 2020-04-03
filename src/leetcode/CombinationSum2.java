class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        find(0, candidates, target, 0, list, result);
        return result;
    }

    public void find(int start, int[] c, int target, int curSum, 
            List<Integer> list, List<List<Integer>> result) {

        for (int i=start; i<c.length; ++i) {
            if (curSum+c[i] < target) {
                List<Integer> reserved = new ArrayList<>(list);
                list.add(c[i]);
                find(i+1 ,c, target, curSum+c[i], list, result);
                list = reserved;
            } else if (curSum+c[i] == target) {
                list.add(c[i]);
                if (!result.contains(list)) {
                    result.add(new ArrayList<>(list));
                }
                return;
            } else {
                return;
            }
        }
    }
}
