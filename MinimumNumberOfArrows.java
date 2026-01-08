class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));

        int n= points.length;
        
        //find overlapping coordinates of x axis 
        // if end of first is > start of second then overlapping -> same Arrow works
        // if non overlapping count arrow+ 1.

        int arrow=1;
        int end= points[0][1];
        for(int i=1; i<n; i++){
            if(end < points[i][0]){
                arrow++;
                end= points[i][1];
            } 
        }
        return arrow;
    }
}
