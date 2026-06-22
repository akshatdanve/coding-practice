class combinations(nCk) {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(1, n, k, current, result);
        return result;
    }

    void helper(int start, int n, int k, List<Integer> current, List<List<Integer>> result){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start; i<=n; i++){
            current.add(i);
            helper(i+1, n, k, current, result);
            current.remove(current.size()-1);
        }
    }
}
