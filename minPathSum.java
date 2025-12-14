class Solution {
    int dp[][];
    int helper(int grid[][], int i, int j){
        if(i>= grid.length || j>= grid[0].length) return Integer.MAX_VALUE;

        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];

        if(dp[i][j]!=-1) return dp[i][j];
        
        int right= helper(grid, i, j+1);
        int down = helper(grid, i+1, j);

        dp[i][j]= grid[i][j]+ Math.min(right, down);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
                dp[i][j]= -1;
        }
        return helper(grid, 0 ,0);
    }
}
