// Solved using 4 methods - brute force, memoization, tabulation and space optimized approach.
//recursive - brute force - TLE error
/*
class climbingStairs {
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
*/

//memoization
/*
class climbingStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return memoize(n, memo);
    }
    static int memoize(int n, int[] memo){
        if(n<0){
            return 0;
        }
        if(n<=1){
            return 1;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        memo[n]=memoize(n-1, memo) + memoize(n-2, memo);
        return memo[n];
    }
}
*/

//tabulation
/*
class climbingStairs {
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(n<=1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
*/

//space optimized
class climbingStairs {
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(n<=1){
            return 1;
        }
        int curr, prev, prevPrev;
        prevPrev=1;
        prev=1;
        curr=1;
        for(int i=2; i<=n; i++){
            curr=prevPrev+prev;
            prevPrev=prev;
            prev=curr;
        }
        return curr;
    }
}
