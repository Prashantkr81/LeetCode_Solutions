class Solution {
    public int bestClosingTime(String customers) {
        int n= customers.length();
        int Y[] = new int[n+1];
        int N[] = new int[n+1];

        int cY=0;

        Y[0]=0;
        char cust[]= customers.toCharArray();
        for(int i=n-1; i>=0; i--){
            if(cust[i]=='Y') cY++;
            Y[i]= cY;
        }
        int cN=0;

        N[0]= 0;
        for(int i=0; i<n; i++){
            if(cust[i]=='N') cN++;
            N[i+1]= cN;
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for(int i=0; i<=n; i++){
            int currentPenalty = N[i] + Y[i];
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                bestHour = i;
            }
        }
        return bestHour;
    }
}
