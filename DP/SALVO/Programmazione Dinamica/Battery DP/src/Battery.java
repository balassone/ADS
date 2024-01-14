public class Battery {

    private int[] dp;
    private int[] stations;
    private int[] costs;
    private int autonomy;

    public void printMinCost(int[] s, int[] c, int R){
    
        //alloco dp
        dp=new int[s.length];

        this.stations=s;
        this.costs=c;
        this.autonomy=R;

        minCost(stations.length-1);

        System.out.println(dp[0]);

    }

    public void minCost(int n){
    
        //caso base l'ultima stazione è quella di arrivo
        dp[n]=0;

        for(int i=n-1;i>=0;i--){
        
            int j=i+1;
            int min=Integer.MAX_VALUE;
            int minJ=-1;

            while(j<=n && stations[j] <= stations[i]+autonomy){
                
                if(dp[j]<min){
                    min=dp[j];
                    minJ=j;
                }

                j++;
            }

            dp[i]=costs[i]+dp[minJ];

        }

    }

    public static void main(String[] args) throws Exception {

        Battery bat=new Battery();

        int[] s={5,12,21,37,50,56,60};
        int[] c={9,4,17,11,7,15,0};
        int R=20;

        bat.printMinCost(s, c, R);

    }
}
