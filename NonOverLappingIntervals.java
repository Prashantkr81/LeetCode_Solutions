class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));

        int n= intervals.length;

      //if next task starts after the current ends then not overlaps else overlapping
      // so finishTIme <= starting of curr then non overlapping
      // total - overlapping gives nonOverlapping
        int ans=1;
        int finishTime= intervals[0][1];
        for(int i=1; i<n; i++){
            if(finishTime <=intervals[i][0]){
                ans++;
                finishTime= intervals[i][1];
            } 
        }
        return n-ans;
    }
}
