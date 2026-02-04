class Solution {  //long used to handle edge case of large sum value
    public long calcValue(int grid[][], long sum, int i, int j, int m, int n){

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return 0;

        sum= grid[i][j];
        grid[i][j]= 0;  //mark cell as visited

        return sum+ calcValue(grid, sum, i, j+1, m, n)+
                    calcValue(grid, sum, i, j-1, m, n)+
                    calcValue(grid, sum, i+1, j, m, n)+
                    calcValue(grid, sum ,i-1, j, m, n);
    }
    public int countIslands(int[][] grid, int k) {
        
        int m= grid.length;
        int n= grid[0].length;

        int result=0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0){
                    if(calcValue(grid, 0, i, j, m, n) % k==0)
                        result++;
                }
            }
        }
        return result;
    }
}
