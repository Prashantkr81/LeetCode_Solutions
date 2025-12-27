class Solution {
    int dp[][];
    int coinChange(int coins[],int i, int sum){
        if(sum < 0 ||i==coins.length) return 0;

        if(sum==0) return 1;

        if(dp[i][sum] != -1) return dp[i][sum];

        dp[i][sum] = coinChange(coins, i+1, sum) +//exclude coin
                coinChange(coins, i, sum-coins[i]); //include coin

        return dp[i][sum];
    }
    public int change(int amount, int[] coins) {
        dp= new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return coinChange(coins, 0, amount);
    }
}
