class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][]= new int[n +1][amount+1];
        int inf= Integer.MAX_VALUE-1;

        for(int j=1; j<=amount; j++) dp[0][j]= inf;

        for(int i=1; i<=n; i++){
            int currentCoin= coins[i-1];  //i-1 referring to current coin
            for(int j=1; j<=amount; j++){
                if(j >= currentCoin){
                    dp[i][j]= Math.min(
                            dp[i-1][j], 
                            1 + dp[i][j- currentCoin]);  // here subtracting curr amt - current coin...so we can replace that amt with just 1 coin...that why +1
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==inf? -1: dp[n][amount] ;
    }
}
