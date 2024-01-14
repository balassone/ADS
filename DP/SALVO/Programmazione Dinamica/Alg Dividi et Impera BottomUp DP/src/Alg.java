public class Alg {

    private int[][] dp;
    private int[] pivots;

    public void printMinCost(int[] p){

        this.pivots=p;
        dp=new int[p.length][p.length];

        buildDp(p.length-1);

        System.out.println(dp[0][p.length-1]);
    
    }

    public void buildDp(int nCuts){
    
        for(int lunghezza=2;lunghezza<=nCuts;lunghezza++){
        
            for(int i=0;i<=(nCuts-lunghezza);i++){
            
                int j=i+lunghezza;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]+(pivots[j]-pivots[i]));

                }

            }

            printMatrix(dp);

        }

    }

    public void printMatrix(int[][] m){
        System.out.println("--------------------------------------------");
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.printf("%5d",m[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) throws Exception {
        Alg alg=new Alg();
        int[] p={0,25,50,75,100};
        alg.printMinCost(p);
    }
}
