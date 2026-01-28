class Solution {

    boolean helper(int grid[][], int i, int j, int exp){

        int n= grid.length;
        if(i<0 || i>=n || j<0 || j >= n || grid[i][j] !=exp ){
            return false;
        }

        if(grid[i][j]==(n*n)-1) return true;

        boolean ans1= helper(grid, i-1, j-2, exp+1);
        boolean ans2= helper(grid, i-2, j-1, exp+1);
        boolean ans3= helper(grid, i-1, j+2, exp+1);
        boolean ans4= helper(grid, i-2, j+1, exp+1);
        boolean ans5= helper(grid, i+1, j+2, exp+1);
        boolean ans6= helper(grid, i+2, j+1, exp+1);
        boolean ans7= helper(grid, i+1, j-2, exp+1);
        boolean ans8= helper(grid, i+2, j-1, exp+1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8 ;

    }
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        return helper(grid, 0, 0, 0);
    }
}
