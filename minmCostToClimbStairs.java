//tabulation
/*
class minmCostToClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2; i<n; i++){
            dp[i]=cost[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}\*/

//memoization
class minmCostToClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return Math.min(helper(0, cost, memo), helper(1, cost, memo));
    }
    static int helper(int i, int[] cost, int[] memo){
        int n = cost.length;
        if(i>=n){
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        memo[i]=cost[i]+Math.min(helper(i+1, cost, memo), helper(i+2, cost, memo));
        return memo[i];
    }
}
