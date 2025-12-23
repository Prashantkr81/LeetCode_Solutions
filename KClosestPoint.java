class Solution {
    private int dist(int point[]){
        int y= point[1];
        int x= point[0];
        return (x*x) + (y*y);
    }
    public int[][] kClosest(int[][] points, int k) {
        int n= points.length;
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b)-> a[1]-b[1]);

        int i=0;
        for(int[] point: points){
            pq.add(new int[]{i, dist(point)});
            i++;
        }
        
        int ans[][]= new int[k][2];
    
        for(i=0; i<k; i++){
            int curr[]= pq.poll();
            int idx= curr[0];
            ans[i]= points[idx];
        }
        return ans;
    }
}
