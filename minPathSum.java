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

// Alternative

class Solution {
    public int minPathSum(int[][] grid) {
        
        int m= grid.length;
        int n= grid[0].length;

        for(int i=1; i<m; i++)
            grid[i][0] += grid[i-1][0];

        for(int i=1; i<n; i++)
            grid[0][i] += grid[0][i-1];

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
