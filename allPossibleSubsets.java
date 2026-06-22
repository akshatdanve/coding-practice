class allPossibleSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subarr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        return findSubsets(0, nums, subarr, res );
    }

    List<List<Integer>> findSubsets (int curr, int[] nums, List<Integer> subarr, List<List<Integer>> res){
        if(curr==nums.length){
            res.add(new ArrayList<>(subarr));
            return res;
        }
        subarr.add(nums[curr]);
        findSubsets(curr+1, nums, subarr, res);
        subarr.remove(subarr.size()-1);
        findSubsets(curr+1, nums, subarr, res);
        return res;
    }
}
