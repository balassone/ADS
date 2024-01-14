public class LIS {

    private int[] sequence;
    private int[] dp;

    public void printLIS(int[] s){
        
        //alloco dp
        dp=new int[s.length];

        this.sequence=s;

        longestIncreasingSubsequence();

        System.out.println(dp[dp.length-1]+1);

    }

    public void longestIncreasingSubsequence(){
    
        //interpretiamo dp[i] come la soluzione ottima che finisce all'indice i
        //ex i=3, dp[3]=lunghezza maggiore sequenza di numeri crescenti fino a indice 3
        
        //caso base, al nodo zero la lunghezza massimo è zero
        dp[0]=0;

        for(int i=1;i<sequence.length;i++){

            int max=dp[i-1];
        
            for(int k=i-1;k>=0;k--){
                
                //includo nel calcolo del massimo solo quelli con valore minore nel nodo
                if(sequence[k]<=sequence[i]){
                
                    //aggiorno il massimo
                    max=Math.max(max, dp[k]+1);

                }

            }

            dp[i]=max;

        }

    }
    
    public static void main(String[] args) throws Exception {
        LIS lis=new LIS();
        int[] s={3,1,8,2,5};

        lis.printLIS(s);

    }
}
